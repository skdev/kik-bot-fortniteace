package sk96.dev.kik.bot.command.fortnite;

import com.jayway.restassured.path.json.JsonPath;
import sk96.dev.kik.bot.command.Command;
import sk96.dev.kik.bot.message.MultiTextMessage;
import sk96.dev.kik.bot.message.TextMessage;

public class FortniteCompareCommand extends Command<MultiTextMessage, TextMessage> {

    @Override
    public MultiTextMessage run(TextMessage message) {
        String received = message.body.toLowerCase().trim();

        if (received.startsWith("compare")) {
            received = received.replaceFirst("compare", "").trim();
        }

        String[] parts = received.split(",");

        if (parts.length < 2) {
            return new MultiTextMessage(message.chatId, message.to, "Usage: compare <user>, <user>", "Here's an example: compare ninja, tsm_myth");
        }

        String userA = parts[0].trim();
        String userB = parts[1].trim();

        userA = userA.replaceAll(" ", "%20");
        userB = userB.replaceAll(" ", "%20");

        if (userA.equalsIgnoreCase("suraj")) {
            userA = "surajjj_";
        }
        if (userA.equalsIgnoreCase("jamil")) {
            userA = "hey_get_gud";
        }
        if (userA.equalsIgnoreCase("sara")) {
            userA = "x_saraaaa_x";
        }
        if (userA.equalsIgnoreCase("cid")) {
            userA = "cid_03-xD";
        }

        if (userB.equalsIgnoreCase("suraj")) {
            userB = "surajjj_";
        }
        if (userB.equalsIgnoreCase("jamil")) {
            userB = "hey_get_gud";
        }
        if (userB.equalsIgnoreCase("sara")) {
            userB = "x_saraaaa_x";
        }
        if (userB.equalsIgnoreCase("cid")) {
            userB = "cid_03-xD";
        }

        FortnitePlayer user1 = null;
        int attempts = 0;

        while (null == user1 && attempts < 5) {

            try {

                if (attempts == 0) {
                    user1 = lookup("psn", userA);
                } else if (attempts == 1) {
                    user1 = lookup("pc", userA);
                } else if (attempts == 3) {
                    user1 = lookup("xbl", userA);
                } else if (attempts == 4) {
                    user1 = lookup("psn", "psn(" + userA + ")");
                }

            } catch (Exception e) {
                /* Ignore */
            }

            attempts++;
        }


        FortnitePlayer user2 = null;
        attempts = 0;

        while (null == user2 && attempts < 5) {

            try {

                if (attempts == 0) {
                    user2 = lookup("psn", userB);
                } else if (attempts == 1) {
                    user2 = lookup("pc", userB);
                } else if (attempts == 3) {
                    user2 = lookup("xbl", userB);
                } else if (attempts == 4) {
                    user2 = lookup("psn", "psn(" + userB + ")");
                }

            } catch (Exception e) {
                /* Ignore */
            }

            attempts++;
        }

        if (null == user1 && null == user2) {
            return new MultiTextMessage(message.chatId, message.to, "Both players not found.");
        }

        if (null == user1) {
            if (user2.getUsername().contains("psn(")) {
                user2.setUsername(user2.getUsername().replace("psn(", "").replace(")", ""));
            }
            return new MultiTextMessage(message.chatId, message.to, user2.getUsername() + " is better because I can't find the other player.");
        }

        if (null == user2) {
            if (user1.getUsername().contains("psn(")) {
                user1.setUsername(user1.getUsername().replace("psn(", "").replace(")", ""));
            }
            return new MultiTextMessage(message.chatId, message.to, user1.getUsername() + " is better because I can't find the other player.");
        }

        if (user1.getUsername().contains("psn(")) {
            user1.setUsername(user1.getUsername().replace("psn(", "").replace(")", ""));
        }

        if (user2.getUsername().contains("psn(")) {
            user2.setUsername(user2.getUsername().replace("psn(", "").replace(")", ""));
        }

        String compare = "";

        boolean user1BetterSoloWins = false;
        boolean user1BetterSoloKills = false;

        int user1SoloDifference = (user1.getSoloKills() - user2.getSoloKills()) * 10;
        int user2SoloDifference = (user2.getSoloKills() - user1.getSoloKills()) * 10;

        if (user1SoloDifference > user2SoloDifference) {
            user1BetterSoloKills = true;
        }

        if (user1.getSoloWins() > user2.getSoloWins()) {
            user1BetterSoloWins = true;
        }

        compare += "- " + (user1BetterSoloWins ? user1.getUsername() : user2.getUsername()) + " has more solo wins +1\\n";
        compare += "- " + (user1BetterSoloKills ? user1.getUsername() : user2.getUsername()) + " has more solo kills +1\\n";

        boolean user1BetterDuoWins = false;
        boolean user1BetterDuoKills = false;

        int user1DuoDifference = (user1.getDuoKills() - user2.getDuoKills()) * 10;
        int user2DuoDifference = (user2.getDuoKills() - user1.getDuoKills()) * 10;
        if (user1DuoDifference > user2DuoDifference) {
            user1BetterDuoKills = true;
        }

        if (user1.getDuoWins() > user2.getDuoWins()) {
            user1BetterDuoWins = true;
        }

        compare += "- " + (user1BetterDuoWins ? user1.getUsername() : user2.getUsername()) + " has more duo wins +1\\n";
        compare += "- " + (user1BetterDuoKills ? user1.getUsername() : user2.getUsername()) + " has more duo kills +1\\n";

        boolean user1BetterSquadWins = false;
        boolean user1BetterSquadKills = false;

        int user1SquadDifference = (user1.getSquadKills() - user2.getSquadKills()) * 10;
        int user2SquadDifference = (user2.getSquadKills() - user1.getSquadKills()) * 10;
        if (user1SquadDifference > user2SquadDifference) {
            user1BetterSquadKills = true;
        }

        int user1Count = 0;
        int user2Count = 0;

        if (user1.getSquadWins() > user2.getSquadWins()) {
            user1BetterSquadWins = true;
        }

        compare += "- " + (user1BetterSquadWins ? user1.getUsername() : user2.getUsername()) + " has more squad wins +1\\n";
        compare += "- " + (user1BetterSquadKills ? user1.getUsername() : user2.getUsername()) + " has more squad kills. +1\\n";

        if (user1BetterSoloKills) {
            user1Count++;
        } else {
            user2Count++;
        }

        if (user1BetterSoloWins) {
            user1Count++;
        } else {
            user2Count++;
        }

        if (user1BetterDuoWins) {
            user1Count++;
        } else {
            user2Count++;
        }

        if (user1BetterDuoKills) {
            user1Count++;
        } else {
            user2Count++;
        }

        if (user1BetterSquadWins) {
            user1Count++;
        } else {
            user2Count++;
        }

        if (user1BetterSquadKills) {
            user1Count++;
        } else {
            user2Count++;
        }

        int user1TotalWins = user1.getSoloWins() + user1.getDuoWins() + user1.getSquadWins();
        int user2TotalWins = user2.getSoloWins() + user2.getDuoWins() + user2.getSquadWins();

        if (user1TotalWins > user2TotalWins) {
            user1Count++;
            compare += "- " + user1.getUsername() + " has more total wins +1\\n";
        } else {
            user2Count++;
            compare += "- " + user2.getUsername() + " has more total wins +1\\n";
        }

        int user1TotalKills = user1.getSoloKills() + user1.getDuoKills() + user1.getSquadKills();
        int user2TotalKills = user2.getSoloKills() + user2.getDuoKills() + user2.getSquadKills();

        if (user1TotalKills > user2TotalKills) {
            user1Count++;
            compare += "- " + user1.getUsername() + " has more total kills +1\\n";
        } else {
            user2Count++;
            compare += "- " + user2.getUsername() + " has more total kills +1\\n";
        }

        double user1SoloKdr = user1.getSoloKdr();
        double user2SoloKdr = user2.getSoloKdr();

        if (user1SoloKdr > user2SoloKdr) {
            user1Count++;
            compare += "- " + user1.getUsername() + " has a higher solo KDR +1\\n";
        } else {
            user2Count++;
            compare += "- " + user2.getUsername() + " has a higher solo KDR +1\\n";
        }

        double user1DuoKdr = user1.getDuoKdr();
        double user2DuoKdr = user2.getDuoKdr();

        if (user1DuoKdr > user2DuoKdr) {
            user1Count++;
            compare += "- " + user1.getUsername() + " has a higher duo KDR +1\\n";
        } else {
            user2Count++;
            compare += "- " + user2.getUsername() + " has a higher duo KDR +1\\n";
        }

        double user1SquadKdr = user1.getSquadKdr();
        double user2SquadKdr = user2.getSquadKdr();

        if (user1SquadKdr > user2SquadKdr) {
            user1Count++;
            compare += "- " + user1.getUsername() + " has a higher squad KDR +1\\n";
        } else {
            user2Count++;
            compare += "- " + user2.getUsername() + " has a higher squad KDR +1\\n";
        }

        String say;
        if (user1Count >= user2Count) {
            say = "Based on their stats; " + user1.getUsername() + " is better than " + user2.getUsername() + "\\n\\nHere's why:\\n\\n";
        } else {
            say = "Based on their stats; " + user2.getUsername() + " is better than " + user1.getUsername() + "\\n\\nHere's why:\\n\\n";
        }
        say += "We score each individual stat as points e.g. Player1 has more solo wins then Player2 then Player1 gets 1 point.\\n\\nThe higher number of points you have after comparing everything, you are then judged the better player.\\n\\n";
        say += "Here is the complete breakdown:\\n";
        say += compare;
        say += "\\nThere for...\\n\\n";
        say += user1.getUsername() + " has " + user1Count + " points.\\n";
        say += user2.getUsername() + " has " + user2Count + " points.\\n";
        return new MultiTextMessage(message.chatId, message.to, say);
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

            if (user.getUsername().equalsIgnoreCase("aclyice")) {
                user.setUsername("surajjj_");
            }

            return user;

        } catch (Exception e) {
            System.err.println("[INFO][Lookup] Couldn't find user " + u + " with error: " + e.getMessage());
        }

        return null;
    }
}
