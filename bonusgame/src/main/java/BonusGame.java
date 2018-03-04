import domain.Player;
import domain.State;
import util.NumberGenerator;

public class BonusGame extends GamblingGame {
    private final int FREE_PERCENTAGE = 10;
    private final int BOX_GAME_BET_AMOUNT = 0;
    private final int NO_OF_BOXES = 5;
    public BonusGame(Player player, int betAmount, int winAmount) {
        super(player, betAmount, winAmount);
    }

    protected void play() {
        double number = NumberGenerator.getRandomNumber(1,100);
        if(number <= FREE_PERCENTAGE){
            this.next = State.FREE;
            this.run();
        }

    }

    public void freeRound() {
        System.out.println("Congratulations..You are now entering to the box game.All the boxes have coins execept one. Guess the number correctly");
        BoxPickingGame game = new BoxPickingGame(player,BOX_GAME_BET_AMOUNT,winAmount,NO_OF_BOXES);
        game.initBoxes();
        game.run();
    }

}
