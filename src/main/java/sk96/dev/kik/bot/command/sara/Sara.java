package sk96.dev.kik.bot.command.sara;

import sk96.dev.kik.bot.command.fortnite.FortnitePlayer;

public class Sara {
    public static final FortnitePlayer SEASON_1 = new FortnitePlayer();
    public static final FortnitePlayer SEASON_2 = new FortnitePlayer();
    public static final FortnitePlayer SEASON_3 = new FortnitePlayer();
    public static final FortnitePlayer SEASON_4 = new FortnitePlayer();
    public static final FortnitePlayer SEASON_5 = new FortnitePlayer();
    public static final FortnitePlayer SEASON_6 = new FortnitePlayer();
    public static final FortnitePlayer SEASON_7 = new FortnitePlayer();

    static {
        setupSeason1();
        setupSeason2();
        setupSeason3();
        setupSeason4();
        setupSeason5();
        setupSeason6();
        setupSeason7();
    }

    public static void setupSeason1() {
        int season_1_solo_matches = 0;
        int season_1_solo_wins = 0;
        int season_1_solo_kills = 0;
        double season_1_solo_win_kdr = 0.00;

        int season_1_duo_matches = 0;
        int season_1_duo_wins = 0;
        int season_1_duo_kills = 0;
        double season_1_duo_win_kdr = 0.00;

        int season_1_squad_matches = 0;
        int season_1_squad_wins = 0;
        int season_1_squad_kills = 0;
        double season_1_squad_win_kdr = 0.00;

        SEASON_1.soloMatches = season_1_solo_matches;
        SEASON_1.setSoloWins(season_1_solo_wins);
        SEASON_1.setSoloKills(season_1_solo_kills);
        SEASON_1.setSoloKdr(season_1_solo_win_kdr);

        SEASON_1.duoMatches = season_1_duo_matches;
        SEASON_1.setDuoWins(season_1_duo_wins);
        SEASON_1.setDuoKills(season_1_duo_kills);
        SEASON_1.setDuoKdr(season_1_duo_win_kdr);

        SEASON_1.squadMatches = season_1_squad_matches;
        SEASON_1.setSquadWins(season_1_squad_wins);
        SEASON_1.setSquadKills(season_1_squad_kills);
        SEASON_1.setSquadKdr(season_1_squad_win_kdr);
    }

    public static void setupSeason2() {
        int season_2_solo_matches = 0;
        int season_2_solo_wins = 0;
        int season_2_solo_kills = 0;
        double season_2_solo_win_kdr = 0.00;

        int season_2_duo_matches = 0;
        int season_2_duo_wins = 0;
        int season_2_duo_kills = 0;
        double season_2_duo_win_kdr = 0.00;

        int season_2_squad_matches = 0;
        int season_2_squad_wins = 0;
        int season_2_squad_kills = 0;
        double season_2_squad_win_kdr = 0.00;

        SEASON_2.soloMatches = season_2_solo_matches;
        SEASON_2.setSoloWins(season_2_solo_wins);
        SEASON_2.setSoloKills(season_2_solo_kills);
        SEASON_2.setSoloKdr(season_2_solo_win_kdr);

        SEASON_2.duoMatches = season_2_duo_matches;
        SEASON_2.setDuoWins(season_2_duo_wins);
        SEASON_2.setDuoKills(season_2_duo_kills);
        SEASON_2.setDuoKdr(season_2_duo_win_kdr);

        SEASON_2.squadMatches = season_2_squad_matches;
        SEASON_2.setSquadWins(season_2_squad_wins);
        SEASON_2.setSquadKills(season_2_squad_kills);
        SEASON_2.setSquadKdr(season_2_squad_win_kdr);
    }

    public static void setupSeason3() {
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

        SEASON_3.soloMatches = season_3_solo_matches;
        SEASON_3.setSoloWins(season_3_solo_wins);
        SEASON_3.setSoloKills(season_3_solo_kills);
        SEASON_3.setSoloKdr(season_3_solo_win_kdr);

        SEASON_3.duoMatches = season_3_duo_matches;
        SEASON_3.setDuoWins(season_3_duo_wins);
        SEASON_3.setDuoKills(season_3_duo_kills);
        SEASON_3.setDuoKdr(season_3_duo_win_kdr);

        SEASON_3.squadMatches = season_3_squad_matches;
        SEASON_3.setSquadWins(season_3_squad_wins);
        SEASON_3.setSquadKills(season_3_squad_kills);
        SEASON_3.setSquadKdr(season_3_squad_win_kdr);
    }

    public static void setupSeason7() {
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

        SEASON_7.soloMatches = season_7_solo_matches;
        SEASON_7.setSoloWins(season_7_solo_wins);
        SEASON_7.setSoloKills(season_7_solo_kills);
        SEASON_7.setSoloKdr(season_7_solo_win_kdr);

        SEASON_7.duoMatches = season_7_duo_matches;
        SEASON_7.setDuoWins(season_7_duo_wins);
        SEASON_7.setDuoKills(season_7_duo_kills);
        SEASON_7.setDuoKdr(season_7_duo_win_kdr);

        SEASON_7.squadMatches = season_7_squad_matches;
        SEASON_7.setSquadWins(season_7_squad_wins);
        SEASON_7.setSquadKills(season_7_squad_kills);
        SEASON_7.setSquadKdr(season_7_squad_win_kdr);
    }

    public static void setupSeason6() {
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

        SEASON_6.soloMatches = season_6_solo_matches;
        SEASON_6.setSoloWins(season_6_solo_wins);
        SEASON_6.setSoloKills(season_6_solo_kills);
        SEASON_6.setSoloKdr(season_6_solo_win_kdr);

        SEASON_6.duoMatches = season_6_duo_matches;
        SEASON_6.setDuoWins(season_6_duo_wins);
        SEASON_6.setDuoKills(season_6_duo_kills);
        SEASON_6.setDuoKdr(season_6_duo_win_kdr);

        SEASON_6.squadMatches = season_6_squad_matches;
        SEASON_6.setSquadWins(season_6_squad_wins);
        SEASON_6.setSquadKills(season_6_squad_kills);
        SEASON_6.setSquadKdr(season_6_squad_win_kdr);
    }

    private static void setupSeason5() {
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

        SEASON_5.soloMatches = season_5_solo_matches;
        SEASON_5.setSoloWins(season_5_solo_wins);
        SEASON_5.setSoloKills(season_5_solo_kills);
        SEASON_5.setSoloKdr(season_5_solo_win_kdr);

        SEASON_5.duoMatches = season_5_duo_matches;
        SEASON_5.setDuoWins(season_5_duo_wins);
        SEASON_5.setDuoKills(season_5_duo_kills);
        SEASON_5.setDuoKdr(season_5_duo_win_kdr);

        SEASON_5.squadMatches = season_5_squad_matches;
        SEASON_5.setSquadWins(season_5_squad_wins);
        SEASON_5.setSquadKills(season_5_squad_kills);
        SEASON_5.setSquadKdr(season_5_squad_win_kdr);
    }


    private static void setupSeason4() {
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

        SEASON_4.soloMatches = season_4_solo_matches;
        SEASON_4.setSoloWins(season_4_solo_wins);
        SEASON_4.setSoloKills(season_4_solo_kills);
        SEASON_4.setSoloKdr(season_4_solo_win_kdr);

        SEASON_4.duoMatches = season_4_duo_matches;
        SEASON_4.setDuoWins(season_4_duo_wins);
        SEASON_4.setDuoKills(season_4_duo_kills);
        SEASON_4.setDuoKdr(season_4_duo_win_kdr);

        SEASON_4.squadMatches = season_4_squad_matches;
        SEASON_4.setSquadWins(season_4_squad_wins);
        SEASON_4.setSquadKills(season_4_squad_kills);
        SEASON_4.setSquadKdr(season_4_squad_win_kdr);
    }
}