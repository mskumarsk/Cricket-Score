package Cricket_Score;

import java.util.HashMap;

public class MatchDetails {
    String playerName = "";
    int four = 0;
    int runs = 0;
    int six = 0;
    int extra = 0;
    int playingBall = 0;
    int teamTotalRun = 0;
    int datBal = 0;
    int playerOutBall = 0;
    int playerPlayBall = 0;
    int totRun = 0;

    int matchFormat = 1;
    String team1 = "";
    String team2 = "";
    HashMap<Integer, String> group1 = new HashMap<>(12);
    HashMap<Integer, String> group2 = new HashMap<>(12);
    HashMap<Integer, MatchDetails> teamOneRun = new HashMap<>();
    HashMap<Integer, MatchDetails> teamTwoRun = new HashMap<>();

    public int getTotRun() {
        return totRun;
    }

    public void setTotRun(int totRun) {
        this.totRun = this.totRun + totRun;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = this.runs + runs;
    }

    public int getSix() {
        return six;
    }

    public void setSix(int six) {
        this.six = this.six + six;
    }

    public int getExtra() {
        return extra;
    }

    public void setExtra(int extra) {
        this.extra = this.extra + extra;
    }

    public int getPlayingBall() {
        return playingBall;
    }

    public void setPlayingBall(int playingBall) {
        this.playingBall = this.playingBall + playingBall;
    }

    public int getTeamTotalRun() {
        return teamTotalRun;
    }

    public void setTeamTotalRun(int teamTotalRun) {
        this.teamTotalRun = this.teamTotalRun + teamTotalRun;
    }

    public int getDatBal() {
        return datBal;
    }

    public void setDatBal(int datBal) {
        this.datBal = this.datBal + datBal;
    }

    public int getPlayerOutBall() {
        return playerOutBall;
    }

    public void setPlayerOutBall(int playerOutBall) {
        this.playerOutBall = this.playerOutBall + playerOutBall;
    }

    public int getPlayerPlayBall() {
        return playerPlayBall;
    }

    public void setPlayerPlayBall(int playerPlayBall) {
        this.playerPlayBall = this.playerPlayBall + playerPlayBall;
    }

    public int getMatchFormat() {
        return matchFormat;
    }

    public void setMatchFormat(int matchFormat) {
        this.matchFormat = matchFormat;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public int getFour() {
        return four;
    }

    public MatchDetails setFour(int four) {
        this.four = this.four + four;
        return null;
    }
}
