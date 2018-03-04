import domain.Player;
import domain.State;
import util.NumberGenerator;

public class SlotGame extends GamblingGame {

    private final int FREE_PERCENTAGE = 10;
    private final int WIN_PERCENTAGE = 30;

    public SlotGame(){

    }
    public SlotGame(Player player, int betAmount, int winAmount) {
        super(player, betAmount, winAmount);
    }

    public void freeRound(){
        this.play();
    }
    public void play(){
        double number = NumberGenerator.getRandomNumber(1,100);
        if(number <= FREE_PERCENTAGE ){
            next = State.FREE;
            System.out.println("Congratulations. You won a free round...");
        }
        if(number <= WIN_PERCENTAGE ){
            claim(winAmount);
            System.out.println("Congratulations. You won "+winAmount+" coins");
        }
        if(this.next == State.FREE){
            run();
        }
    }

}
