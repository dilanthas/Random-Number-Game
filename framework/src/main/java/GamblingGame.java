import domain.Player;
import domain.State;
import util.PlayerUtil;

public abstract class GamblingGame {

    protected State current;
    protected State next;

    protected Player player;
    protected int betAmount;
    protected int winAmount;

    //only for testing
    public GamblingGame(){

    }
    public GamblingGame(Player player, int betAmount, int winAmount){
        this.player = player;
        this.betAmount = betAmount;
        this.winAmount = winAmount;
        init();
    }

    public void init(){
        this.current = State.NORMAL;
        this.next = State.NORMAL;
    }

    public void run(){
        this.current = this.getNext();
        this.next = State.NORMAL;
        if(this.current == State.FREE){
            // free round
            System.out.println("Free round...");
            this.freeRound();
        }else{
            //normal round
            System.out.println("Normal round...");
            this.normalRound();
        }
    }
    protected abstract void play();
    public abstract void freeRound();
    public  void normalRound(){
        bet(this.betAmount);
        play();
    }

    protected void bet(int betAmount){
        this.getPlayer().addBets(betAmount);

    }
    protected void claim(int winAmount){
        this.getPlayer().addWins(winAmount);
    }

    protected void printStats(){
        System.out.println("Bets at the end :"+player.getBets());
        System.out.println("Wins at the end :"+player.getWins());
        System.out.println("RPT :"+ PlayerUtil.getRPT(player));
    }

    public State getCurrent() {
        return current;
    }

    public State getNext() {
        return next;
    }

    public Player getPlayer() {
        return player;
    }
}
