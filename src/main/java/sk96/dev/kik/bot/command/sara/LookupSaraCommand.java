package sk96.dev.kik.bot.command.sara;

import com.jayway.restassured.path.json.JsonPath;
import sk96.dev.kik.bot.command.Command;
import sk96.dev.kik.bot.command.fortnite.FortnitePlayer;
import sk96.dev.kik.bot.command.fortnite.FortniteTracker;
import sk96.dev.kik.bot.message.MultiTextMessage;
import sk96.dev.kik.bot.message.TextMessage;

import java.util.ArrayList;
import java.util.List;

public class LookupSaraCommand extends Command<MultiTextMessage, TextMessage> {

    @Override
    public MultiTextMessage run(TextMessage message) {
        final List<String> sayArr = new ArrayList<>();
        final FortnitePlayer user = lookup("psn", "x_saraaaa_x");

        sayArr.add("Here are the stats for '" + user.getUsername() + "' who plays on " + user.getPlatformName());

        String soloStats = "╰☆☆ Solo ☆☆╮\\n";
        soloStats += "Wins = " + user.getSoloWins() + "\\n";
        soloStats += "Kills = " + user.getSoloKills() + "\\n";
        soloStats += "Kdr = " + user.getSoloKdr() + "\\n";
        soloStats += "Matches = " + user.soloMatches + "\\n";

        soloStats += "\\n";

        soloStats += "·.¸¸.·♩♪♫ Duo ♫♪♩·.¸¸.·\\n";
        soloStats += "Wins = " + user.getDuoWins() + "\\n";
        soloStats += "Kills = " + user.getDuoKills() + "\\n";
        soloStats += "Kdr = " + user.getDuoKdr() + "\\n";
        soloStats += "Matches = " + user.duoMatches + "\\n";

        soloStats += "\\n";

        soloStats += "➶➶➶➶ Squad ➷➷➷➷\\n";
        soloStats += "Wins = " + user.getSquadWins() + "\\n";
        soloStats += "Kills = " + user.getSquadKills() + "\\n";
        soloStats += "Kdr = " + user.getSquadKdr() + "\\n";
        soloStats += "Matches = " + user.squadMatches + "\\n";
        soloStats += "\\n\\n";

        int totalWins7 = user.getSoloWins() + user.getDuoWins() + user.getSquadWins();
        sayArr.add(soloStats);
        sayArr.add("Total Wins = " + totalWins7);
        return new MultiTextMessage(message.chatId, message.to, sayArr.toArray(new String[sayArr.size()]));
    }
    private FortnitePlayer lookup(String platform, String u) {
        final FortnitePlayer user = new FortnitePlayer();
        try {
            final FortniteTracker tracker = new FortniteTracker(platform, u);
            final String json = tracker.getUser();

            String platformName = JsonPath.from(json).get("platformNameLong");
            String username = JsonPath.from(json).get("epicUserHandle");
            user.setUsername(username);
            user.setPlatformName(platformName);

            int soloKills = Integer.parseInt(JsonPath.from(json).get("stats.p2.kills.value"));
            int duoKills = Integer.parseInt(JsonPath.from(json).get("stats.p10.kills.value"));
            int squadKills = Integer.parseInt(JsonPath.from(json).get("stats.p9.kills.value"));
            user.setSoloKills(soloKills);
            user.setDuoKills(duoKills);
            user.setSquadKills(squadKills);

            int soloWins = Integer.parseInt(JsonPath.from(json).get("stats.p2.top1.value"));
            int duoWins = Integer.parseInt(JsonPath.from(json).get("stats.p10.top1.value"));
            int squadWins = Integer.parseInt(JsonPath.from(json).get("stats.p9.top1.value"));
            user.setSoloWins(soloWins);
            user.setDuoWins(duoWins);
            user.setSquadWins(squadWins);

            double soloKdr = Double.parseDouble(JsonPath.from(json).get("stats.p2.kd.value"));
            double duoKdr = Double.parseDouble(JsonPath.from(json).get("stats.p10.kd.value"));
            double squadKdr = Double.parseDouble(JsonPath.from(json).get("stats.p9.kd.value"));
            user.setSoloKdr(soloKdr);
            user.setDuoKdr(duoKdr);
            user.setSquadKdr(squadKdr);

            int soloMatches = Integer.parseInt(JsonPath.from(json).get("stats.curr_p2.matches.value"));
            int duoMatches = Integer.parseInt(JsonPath.from(json).get("stats.curr_p10.matches.value"));
            int squadMatches = Integer.parseInt(JsonPath.from(json).get("stats.curr_p9.matches.value"));

            user.soloMatches = soloMatches;
            user.duoMatches = duoMatches;
            user.squadMatches = squadMatches;
            return user;
        } catch (Exception e) {
            System.err.println("[INFO][Lookup] Couldn't find user " + u + " on platform " + platform + " with error: " + e.getMessage());
        }
        return null;
    }

}