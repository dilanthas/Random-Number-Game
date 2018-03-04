import domain.Player;

public class BonusGameApp {

    private static final int SIMULATION_COUNT = 1000000;
    private static final int BET_AMOUNT = 10;
    private static final int WIN_AMOUNT = 5;


    public static void main(String args[]){
        BonusGame game = new BonusGame(new Player(),BET_AMOUNT,WIN_AMOUNT);
        for(int i =0; i < SIMULATION_COUNT;i++){
            game.run();
        }
        game.printStats();
    }
}
