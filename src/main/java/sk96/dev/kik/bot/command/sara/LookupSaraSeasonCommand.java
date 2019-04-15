package sk96.dev.kik.bot.command.sara;

import com.jayway.restassured.path.json.JsonPath;
import sk96.dev.kik.bot.command.Command;
import sk96.dev.kik.bot.command.fortnite.FortnitePlayer;
import sk96.dev.kik.bot.command.fortnite.FortniteTracker;
import sk96.dev.kik.bot.message.MultiTextMessage;
import sk96.dev.kik.bot.message.TextMessage;

import java.util.ArrayList;
import java.util.List;

public class LookupSaraSeasonCommand extends Command<MultiTextMessage, TextMessage> {
    //Season 3
    int season_3_solo_matches = 104;
    int season_3_solo_wins = 2;
    int season_3_solo_kills = 37;
    double season_3_solo_win_kdr = 0.36;

    int season_3_duo_matches = 23;
    int season_3_duo_wins = 1;
    int season_3_duo_kills = 1;
    double season_3_duo_win_kdr = 0.05;

    int season_3_squad_matches = 144;
    int season_3_squad_wins = 3;
    int season_3_squad_kills = 27;
    double season_3_squad_win_kdr = 0.19;


    //Season 4
    int season_4_solo_matches = 495;
    int season_4_solo_wins = 3;
    int season_4_solo_kills = 206;
    double season_4_solo_win_kdr = 0.42;

    int season_4_duo_matches = 169;
    int season_4_duo_wins = 3;
    int season_4_duo_kills = 42;
    double season_4_duo_win_kdr = 0.25;

    int season_4_squad_matches = 608;
    int season_4_squad_wins = 24;
    int season_4_squad_kills = 231;
    double season_4_squad_win_kdr = 0.40;

    //Season 5

    int season_5_solo_matches = 165;
    int season_5_solo_wins = 1;
    int season_5_solo_kills = 142;
    double season_5_solo_win_kdr = 0.87;

    int season_5_duo_matches = 349;
    int season_5_duo_wins = 20;
    int season_5_duo_kills = 211;
    double season_5_duo_win_kdr = 0.64;

    int season_5_squad_matches = 1113;
    int season_5_squad_wins = 101;
    int season_5_squad_kills = 814;
    double season_5_squad_win_kdr = 0.80;



    //Season 6

    int season_6_solo_matches = 366;
    int season_6_solo_wins = 2;
    int season_6_solo_kills = 296;
    double season_6_solo_win_kdr = 0.81;

    int season_6_duo_matches = 453;
    int season_6_duo_wins = 15;
    int season_6_duo_kills = 311;
    double season_6_duo_win_kdr = 0.71;

    int season_6_squad_matches = 674;
    int season_6_squad_wins = 49;
    int season_6_squad_kills = 504;
    double season_6_squad_win_kdr = 0.81;

    //Season 7

    int season_7_solo_matches = 334;
    int season_7_solo_wins = 7;
    int season_7_solo_kills = 339;
    double season_7_solo_win_kdr = 1.04;

    int season_7_duo_matches = 618;
    int season_7_duo_wins = 23;
    int season_7_duo_kills = 558;
    double season_7_duo_win_kdr = 0.94;

    int season_7_squad_matches = 931;
    int season_7_squad_wins = 75;
    int season_7_squad_kills = 859;
    double season_7_squad_win_kdr = 1.00;

    @Override
    public MultiTextMessage run(TextMessage message) {
        String received = message.body.toLowerCase().trim();

        if (received.startsWith("season")) {
            received = received.replaceFirst("season", "").trim();
        }

        String[] parts = received.split(",");

        if (parts.length < 1) {
            return new MultiTextMessage(message.chatId, message.to, "Usage: season <seasonNumber>", "Here's an example: season 3");
        }

        int seasonNumber = 0;
        try {
            seasonNumber = Integer.parseInt(parts[0]);
        } catch (Exception e) {
            return new MultiTextMessage(message.chatId, message.to, "I had an issue with that season number. Please try again. It has to be from Season 3 to Current");
        }

        List<String> sayArr = new ArrayList<>();
        sayArr.add("Here are the season " + seasonNumber + " stats for 'x_Saraaaa_x' who plays on Playstation 4");

        switch(seasonNumber) {
            case 3:

                String season3 = "╰☆☆ Solo ☆☆╮\\n";
                season3 += "Wins = " + season_3_solo_wins + "\\n";
                season3 += "Kills = " + season_3_solo_kills + "\\n";
                season3 += "Kdr = " + season_3_solo_win_kdr + "\\n";
                season3 += "Matches Played = " + season_3_solo_matches;

                season3 += "\\n\\n";

                season3 += "·.¸¸.·♩♪♫ Duo ♫♪♩·.¸¸.·\\n";
                season3 += "Wins = " + season_3_duo_wins + "\\n";
                season3 += "Kills = " + season_3_duo_kills + "\\n";
                season3 += "Kdr = " + season_3_duo_win_kdr + "\\n";
                season3 += "Matches Played = " + season_3_duo_matches;

                season3 += "\\n\\n";

                season3 += "➶➶➶➶ Squad ➷➷➷➷\\n";
                season3 += "Wins = " + season_3_squad_wins + "\\n";
                season3 += "Kills = " + season_3_squad_kills + "\\n";
                season3 += "Kdr = " + season_3_squad_win_kdr + "\\n";
                season3 += "Matches Played = " + season_3_squad_matches;

                season3 += "\\n\\n";

                int totalWins3 = season_4_solo_wins + season_3_duo_wins + season_3_squad_wins;
                int totalMatchesPlayed3 = season_3_solo_matches + season_3_duo_matches + season_3_squad_matches;


                sayArr.add(season3);
                sayArr.add("Total Wins = " + totalWins3 + "\\n" + "Total Matches Played = " + totalMatchesPlayed3);

                break;

            case 4:

                String season4 = "╰☆☆ Solo ☆☆╮\\n";
                season4 += "Wins = " + season_4_solo_wins + "\\n";
                season4 += "Kills = " + season_4_solo_kills + "\\n";
                season4 += "Kdr = " + season_4_solo_win_kdr + "\\n";
                season4 += "Matches Played = " + season_4_solo_matches;

                season4 += "\\n\\n";

                season4 += "·.¸¸.·♩♪♫ Duo ♫♪♩·.¸¸.·\\n";
                season4 += "Wins = " + season_4_duo_wins + "\\n";
                season4 += "Kills = " + season_4_duo_kills + "\\n";
                season4 += "Kdr = " + season_4_duo_win_kdr + "\\n";
                season4 += "Matches Played = " + season_4_duo_matches;

                season4 += "\\n\\n";

                season4 += "➶➶➶➶ Squad ➷➷➷➷\\n";
                season4 += "Wins = " + season_4_squad_wins + "\\n";
                season4 += "Kills = " + season_4_squad_kills + "\\n";
                season4 += "Kdr = " + season_4_squad_win_kdr + "\\n";
                season4 += "Matches Played = " + season_4_squad_matches;

                season4 += "\\n\\n";

                int totalWins = season_4_solo_wins + season_4_duo_wins + season_4_squad_wins;
                int totalMatchesPlayed4 = season_4_solo_matches + season_4_duo_matches + season_4_squad_matches;


                sayArr.add(season4);
                sayArr.add("Total Wins = " + totalWins + "\\n" + "Total Matches Played = " + totalMatchesPlayed4);

                break;
            case 5:
                String season5 = "╰☆☆ Solo ☆☆╮\\n";
                season5 += "Wins = " + season_5_solo_wins + "\\n";
                season5 += "Kills = " + season_5_solo_kills + "\\n";
                season5 += "Kdr = " + season_5_solo_win_kdr + "\\n";
                season5 += "Matches Played = " + season_5_solo_matches;

                season5 += "\\n\\n";

                season5 += "·.¸¸.·♩♪♫ Duo ♫♪♩·.¸¸.·\\n";
                season5 += "Wins = " + season_5_duo_wins + "\\n";
                season5 += "Kills = " + season_5_duo_kills + "\\n";
                season5 += "Kdr = " + season_5_duo_win_kdr + "\\n";
                season5 += "Matches Played = " + season_5_duo_matches;

                season5 += "\\n\\n";

                season5 += "➶➶➶➶ Squad ➷➷➷➷\\n";
                season5 += "Wins = " + season_5_squad_wins + "\\n";
                season5 += "Kills = " + season_5_squad_kills + "\\n";
                season5 += "Kdr = " + season_5_squad_win_kdr + "\\n";
                season5 += "Matches Played = " + season_5_squad_matches;

                season5 += "\\n\\n";

                int totalWins5 = season_5_solo_wins + season_5_duo_wins + season_5_squad_wins;


                int totalMatchesPlayed5 = season_5_solo_matches + season_5_duo_matches + season_5_squad_matches;

                //season5 += "Total Wins = " + totalWins5;

                sayArr.add(season5);
                sayArr.add("Total Wins = " + totalWins5 + "\\n" + "Total Matches Played = " + totalMatchesPlayed5);

                break;
            case 6:

                String season6 = "╰☆☆ Solo ☆☆╮\\n";
                season6 += "Wins = " + season_6_solo_wins + "\\n";
                season6 += "Kills = " + season_6_solo_kills + "\\n";
                season6 += "Kdr = " + season_6_solo_win_kdr + "\\n";
                season6 += "Matches Played = " + season_6_solo_matches;

                season6 += "\\n\\n";

                season6 += "·.¸¸.·♩♪♫ Duo ♫♪♩·.¸¸.·\\n";
                season6 += "Wins = " + season_6_duo_wins + "\\n";
                season6 += "Kills = " + season_6_duo_kills + "\\n";
                season6 += "Kdr = " + season_6_duo_win_kdr + "\\n";
                season6 += "Matches Played = " + season_6_duo_matches;

                season6 += "\\n\\n";

                season6 += "➶➶➶➶ Squad ➷➷➷➷\\n";
                season6 += "Wins = " + season_6_squad_wins + "\\n";
                season6 += "Kills = " + season_6_squad_kills + "\\n";
                season6 += "Kdr = " + season_6_squad_win_kdr + "\\n";
                season6 += "Matches Played = " + season_6_squad_matches;

                season6 += "\\n\\n";

                int totalWins6 = season_6_solo_wins + season_6_duo_wins + season_6_squad_wins;
                int totalMatchesPlayed6 = season_6_solo_matches + season_6_duo_matches + season_6_squad_matches;

                sayArr.add(season6);
                sayArr.add("Total Wins = " + totalWins6 + "\\n" + "Total Matches Played = " + totalMatchesPlayed6);
                break;

            case 7:
                String season7 = "╰☆☆ Solo ☆☆╮\\n";
                season7 += "Wins = " + season_7_solo_wins + "\\n";
                season7 += "Kills = " + season_7_solo_kills + "\\n";
                season7 += "Kdr = " + season_7_solo_win_kdr + "\\n";
                season7 += "Matches Played = " + season_7_solo_matches;

                season7 += "\\n\\n";

                season7 += "·.¸¸.·♩♪♫ Duo ♫♪♩·.¸¸.·\\n";
                season7 += "Wins = " + season_7_duo_wins + "\\n";
                season7 += "Kills = " + season_7_duo_kills + "\\n";
                season7 += "Kdr = " + season_7_duo_win_kdr + "\\n";
                season7 += "Matches Played = " + season_7_duo_matches;

                season7 += "\\n\\n";

                season7 += "➶➶➶➶ Squad ➷➷➷➷\\n";
                season7 += "Wins = " + season_7_squad_wins + "\\n";
                season7 += "Kills = " + season_7_squad_kills + "\\n";
                season7 += "Kdr = " + season_7_squad_win_kdr + "\\n";
                season7 += "Matches Played = " + season_7_squad_matches;

                season7 += "\\n\\n";

                int totalWins7 = season_7_solo_wins + season_7_duo_wins + season_7_squad_wins;
                int totalMatchesPlayed7 = season_7_solo_matches + season_7_duo_matches + season_7_squad_matches;

                sayArr.add(season7);
                sayArr.add("Total Wins = " + totalWins7 + "\\n" + "Total Matches Played = " + totalMatchesPlayed7);
                break;

            case 8:

                FortnitePlayer user = lookupCurrentSeason("psn", "x_Saraaaa_x");
                String soloStats = "╰☆☆ Solo ☆☆╮\\n";
                soloStats += "Wins = " + user.getSoloWins() + "\\n";
                soloStats += "Kills = " + user.getSoloKills() + "\\n";
                soloStats += "Kdr = " + user.getSoloKdr() + "\\n";
                soloStats += "Matches Played = " + user.soloMatches + "\\n";

                soloStats += "\\n";

                soloStats += "·.¸¸.·♩♪♫ Duo ♫♪♩·.¸¸.·\\n";
                soloStats += "Wins = " + user.getDuoWins() + "\\n";
                soloStats += "Kills = " + user.getDuoKills() + "\\n";
                soloStats += "Kdr = " + user.getDuoKdr() + "\\n";
                soloStats += "Matches Played = " + user.duoMatches + "\\n";

                soloStats += "\\n";

                soloStats += "➶➶➶➶ Squad ➷➷➷➷\\n";
                soloStats += "Wins = " + user.getSquadWins() + "\\n";
                soloStats += "Kills = " + user.getSquadKills() + "\\n";
                soloStats += "Kdr = " + user.getSquadKdr() + "\\n";
                soloStats += "Matches Played = " + user.squadMatches;

                soloStats += "\\n";

                int totalWins8 = user.getSoloWins() + user.getDuoWins() + user.getSquadWins();
                int totalMatchesPlayed8 = user.soloMatches + user.duoMatches + user.squadMatches;

                sayArr.add(soloStats);
                sayArr.add("Total Wins = " + totalWins8 + "\\n" + "Total Matches Played = " + totalMatchesPlayed8);
                break;

            default:
                String[] ss = {
                        "I'm sorry " + "💔\\n" +
                                "I only have Season 3 to Current"
                };
                if (message.to.equalsIgnoreCase("x_sarra_x") || message.to.equalsIgnoreCase("sur.aj")) {
                    return new MultiTextMessage(message.chatId, message.to, ss);
                }
        }
        return new MultiTextMessage(message.chatId, message.to, sayArr.toArray(new String[sayArr.size()]));
    }

    private FortnitePlayer lookupCurrentSeason(String platform, String u) {
        final FortnitePlayer user = new FortnitePlayer();
        try {
            final FortniteTracker tracker = new FortniteTracker(platform, u);
            final String json = tracker.getUser();

            String platformName = JsonPath.from(json).get("platformNameLong");
            String username = JsonPath.from(json).get("epicUserHandle");
            user.setUsername(username);
            user.setPlatformName(platformName);

            int soloKills = Integer.parseInt(JsonPath.from(json).get("stats.curr_p2.kills.value"));
            int duoKills = Integer.parseInt(JsonPath.from(json).get("stats.curr_p10.kills.value"));
            int squadKills = Integer.parseInt(JsonPath.from(json).get("stats.curr_p9.kills.value"));
            user.setSoloKills(soloKills);
            user.setDuoKills(duoKills);
            user.setSquadKills(squadKills);

            int soloWins = Integer.parseInt(JsonPath.from(json).get("stats.curr_p2.top1.value"));
            int duoWins = Integer.parseInt(JsonPath.from(json).get("stats.curr_p10.top1.value"));
            int squadWins = Integer.parseInt(JsonPath.from(json).get("stats.curr_p9.top1.value"));
            user.setSoloWins(soloWins);
            user.setDuoWins(duoWins);
            user.setSquadWins(squadWins);

            double soloKdr = Double.parseDouble(JsonPath.from(json).get("stats.curr_p2.kd.value"));
            double duoKdr = Double.parseDouble(JsonPath.from(json).get("stats.curr_p10.kd.value"));
            double squadKdr = Double.parseDouble(JsonPath.from(json).get("stats.curr_p9.kd.value"));
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
