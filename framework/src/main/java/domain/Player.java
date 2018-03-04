package domain;

public class Player {

    private double bets;
    private double wins;

    public Player(){
    }
    public void addWins(int wins){
        this.wins += wins;
    }
    public void addBets(int bets){
        this.bets += bets;
    }
    public double getBets() {
        return this.bets;
    }

    public double getWins() {
        return this.wins;
    }
}
