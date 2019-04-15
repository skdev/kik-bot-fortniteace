package sk96.dev.kik.bot.command.fortnite;

import com.jayway.restassured.path.json.JsonPath;
import sk96.dev.kik.bot.Main;
import sk96.dev.kik.bot.command.Command;
import sk96.dev.kik.bot.message.*;
import sk96.dev.kik.bot.utils.JsonSearch;
import sk96.dev.kik.bot.utils.logging.Logger;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FortniteLookupCommand extends Command<Message, TextMessage> {
    private static final Logger L = Logger.getTextFileLogger("FortniteLookupCommand");
    private static final String LOOKUP_SYNTAX_ERROR = "Close, but not toast!\\nThe syntax is: lookup <username>";
    private static final String PLAYER_NOT_FOUND = "Player not found.";

    @Override
    public Message run(TextMessage message) {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        String received = message.body.toLowerCase().trim();
        if (received.startsWith("lookup")) {
            received = received.replaceFirst("lookup", "").trim();
        }
        String[] parts = received.split(" ", 2);
        if (parts.length < 1) {
            return new MultiTextMessage(message.chatId, message.to,LOOKUP_SYNTAX_ERROR);
        }

        String platform = "";
        if (received.contains(",") && (parts[0].toLowerCase().contains("xbl") || parts[0].toLowerCase().contains("psn") || parts[0].toLowerCase().contains("pc") || parts[0].toLowerCase().contains("ps4") )) {
            parts = received.split(",");
            platform = parts[0].replace(",", "").trim();
        }
        String username = "";
        for (int i = 0; i < parts.length; i++) {
            String s = parts[i];
            if (platform != null && platform.length() > 0) {
                s = s.replace(",", "").trim();
                if (i == 0) {
                    continue;
                }
            }
            username += s;
            if (i != (parts.length - 1)) {
                username += " ";
            }
        }
        username = username.replaceAll(" ", "%20");
        if (username.length() <= 0) {
            return new MultiTextMessage(message.chatId, message.to, "To lookup a player just enter: lookup <username>");
        }

        if (username.equalsIgnoreCase("suraj")) {
            username = "surajjj_";
        }
        if (username.equalsIgnoreCase("jamil")) {
            username = "hey_get_gud";
        }
        if (username.equalsIgnoreCase("sara")) {
            username = "x_saraaaa_x";
        }
        if (username.equalsIgnoreCase("cid")) {
            username = "cid_03-xD";
        }

        if (username.equalsIgnoreCase("ashi")) {
            return new MultiTextMessage(message.chatId, message.to, "You thought...!");
        }

        FortnitePlayer player = null;

        if (username.equalsIgnoreCase("vicky") || username.equalsIgnoreCase("victoriajconnelly")) {
            player = new FortnitePlayer();
            player.setUsername("victoriajconnelly");
            player.setPlatformName("PlayStation 4");
            player.setSoloKills(987);
            player.setDuoKills(1347);
            player.setSquadKills(5);
            player.setSoloWins(5);
            player.setDuoWins(15);
            player.setSquadWins(2);
            player.setSoloKdr(1.34);
            player.setDuoKdr(0.80);
            player.setSquadKdr(1.0);
            player.soloMatches = 457;
            player.duoMatches = 745;
            player.squadMatches = 5;
            player.overallKdr = JsonSearch.getKdr("1.03");
        }

        int attempts = 0;

        if (platform.length() > 0 && null == player) {
            if (platform.equalsIgnoreCase("ps4")) {
                platform = "psn";
            }
            player = lookup(platform, username);
        } else {
            while (null == player && attempts < 6) {
                try {
                    if (attempts == 0) {
                        player = lookup("xbl", username);
                    } else if (attempts == 1) {
                        player = lookup("psn", username);
                    } else if (attempts == 3) {
                        player = lookup("pc", username);
                    } else if (attempts == 4) {
                        player = lookup("psn", "psn(" + username + ")");
                    } else if (attempts == 5) {
                        player = lookup("xbl", "xbl(" + username + ")");
                    }
                } catch (Exception e) {
                    /* Ignore */
                }
                attempts++;
            }
        }

        if(null == player) {
            return new MultiTextMessage(message.chatId, message.to, PLAYER_NOT_FOUND);
        }

        if (player.getUsername().contains("psn(")) {
            player.setUsername(player.getUsername().replace("psn(", "").replace(")", ""));
        }

        String folderPath = "users/" + username.toLowerCase();
        File f = new File(folderPath.replace("%20", " "));
        if(!f.exists()) {
            f.mkdir();
        }
        String path = (folderPath + "//" + timestamp + ".jpg");
        try {
            final ImageCreator c = new ImageCreator();
            c.write(player.getUsername(), 40, 70, 40F);
            c.write(player.getPlatformName(), 40, 100, 15F);

            c.write("" + player.getSoloWins(), 107, 195, 15F); //solo kills
            c.write("" + player.getSoloKills(), 107, 245, 15F); //solo wins
            c.write("" + player.getSoloKdr(), 107, 295, 15F); //solo kdr
            c.write("" + player.soloMatches, 107, 340, 15F); //solo matches

            c.write("" + player.getDuoWins(), 217, 195, 15F); //duo kills
            c.write("" + player.getDuoKills(), 217, 245, 15F); //duo wins
            c.write("" + player.getDuoKdr(), 217, 295, 15F); //duo kdr
            c.write("" + player.duoMatches, 217, 340, 15F); //duo matches

            c.write("" + player.getSquadWins(), 337, 195, 15F); //squad kills
            c.write("" + player.getSquadKills(), 337, 245, 15F); //squad wins
            c.write("" + player.getSquadKdr(), 337, 295, 15F); //squad kdr
            c.write("" + player.squadMatches, 337, 340, 15F); //squad matches

            c.write("Total Wins: " + (player.getSquadWins() + player.getSoloWins() + player.getDuoWins()), 25, 385, 15F); //total wins
            c.write("Total Kills: " + (player.getSoloKills() + player.getSquadKills() + player.getDuoKills()), 25, 410, 15F); //total Kills
            c.write("Kdr: " + player.overallKdr, 25, 433, 15F); //total Kills

            final DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
            final Date date = new Date();

            c.write("Server time: " + dateFormat.format(date), 25, 485, 12F); //current date
            c.save(path);
        } catch (IOException e) {
            L.error(e.getMessage());
            return new MultiTextMessage(message.chatId, message.to, "An internal error occurred. Please try again later.");
        }

        final String localAddress = Main.configuration.host + ":" + Main.configuration.port;
        final String url = localAddress + "/" + path.replaceAll(" ", "%20");
        L.trace("Finished looking up player, image URL: " + url);
        return new PictureMessage(message.chatId, message.to, url, MediaAttribute.GALLERY, MessageChatType.PRIVATE);
    }

    public static FortnitePlayer lookup(String platform, String u) {
        L.info("Looking up " + u + ", " + platform);

        final FortnitePlayer player = new FortnitePlayer();
        try {
            final FortniteTracker tracker = new FortniteTracker(platform, u);
            final String json = tracker.getUser();

            String platformName = JsonPath.from(json).get("platformNameLong");
            String username = JsonPath.from(json).get("epicUserHandle");
            player.setUsername(username);
            player.setPlatformName(platformName);

            int soloKills = Integer.parseInt(JsonPath.from(json).get("stats.p2.kills.value"));
            int duoKills = Integer.parseInt(JsonPath.from(json).get("stats.p10.kills.value"));
            int squadKills = Integer.parseInt(JsonPath.from(json).get("stats.p9.kills.value"));
            player.setSoloKills(soloKills);
            player.setDuoKills(duoKills);
            player.setSquadKills(squadKills);

            int soloWins = Integer.parseInt(JsonPath.from(json).get("stats.p2.top1.value"));
            int duoWins = Integer.parseInt(JsonPath.from(json).get("stats.p10.top1.value"));
            int squadWins = Integer.parseInt(JsonPath.from(json).get("stats.p9.top1.value"));
            player.setSoloWins(soloWins);
            player.setDuoWins(duoWins);
            player.setSquadWins(squadWins);

            double soloKdr = Double.parseDouble(JsonPath.from(json).get("stats.p2.kd.value"));
            double duoKdr = Double.parseDouble(JsonPath.from(json).get("stats.p10.kd.value"));
            double squadKdr = Double.parseDouble(JsonPath.from(json).get("stats.p9.kd.value"));
            player.setSoloKdr(soloKdr);
            player.setDuoKdr(duoKdr);
            player.setSquadKdr(squadKdr);

            int soloMatches = Integer.parseInt(JsonPath.from(json).get("stats.p2.matches.value")); //looks fine
            int duoMatches = Integer.parseInt(JsonPath.from(json).get("stats.p10.matches.value"));
            int squadMatches = Integer.parseInt(JsonPath.from(json).get("stats.p9.matches.value"));
            player.soloMatches = soloMatches;
            player.duoMatches = duoMatches;
            player.squadMatches = squadMatches;

            player.overallKdr = JsonSearch.getKdr(json);
            return player;
        } catch (Exception e) {
            L.error("Couldn't find user " + u + " on platform " + platform + " with error: " + e.getMessage());
        }
        return null;
    }
}
