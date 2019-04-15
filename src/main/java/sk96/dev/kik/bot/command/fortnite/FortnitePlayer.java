package sk96.dev.kik.bot.command.fortnite;

public class FortnitePlayer {
    public String username;
    public String platformName;
    public int soloWins;
    public int soloKills;
    public double soloKdr;
    public int duoWins;
    public int duoKills;
    public double duoKdr;
    public int squadWins;
    public int squadKills;
    public double squadKdr;
    public int soloMatches, duoMatches, squadMatches;
    public int rank;
    public String overallKdr;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public int getSoloWins() {
        return soloWins;
    }

    public void setSoloWins(int soloWins) {
        this.soloWins = soloWins;
    }

    public int getSoloKills() {
        return soloKills;
    }

    public void setSoloKills(int soloKills) {
        this.soloKills = soloKills;
    }

    public double getSoloKdr() {
        return soloKdr;
    }

    public void setSoloKdr(double soloKdr) {
        this.soloKdr = soloKdr;
    }

    public int getDuoWins() {
        return duoWins;
    }

    public void setDuoWins(int duoWins) {
        this.duoWins = duoWins;
    }

    public int getDuoKills() {
        return duoKills;
    }

    public void setDuoKills(int duoKills) {
        this.duoKills = duoKills;
    }

    public double getDuoKdr() {
        return duoKdr;
    }

    public void setDuoKdr(double duoKdr) {
        this.duoKdr = duoKdr;
    }

    public int getSquadWins() {
        return squadWins;
    }

    public void setSquadWins(int squadWins) {
        this.squadWins = squadWins;
    }

    public int getSquadKills() {
        return squadKills;
    }

    public void setSquadKills(int squadKills) {
        this.squadKills = squadKills;
    }

    public double getSquadKdr() {
        return squadKdr;
    }

    public void setSquadKdr(double squadKdr) {
        this.squadKdr = squadKdr;
    }
}