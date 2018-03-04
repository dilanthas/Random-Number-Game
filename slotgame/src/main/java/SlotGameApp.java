import domain.Player;

public class SlotGameApp {

    private static final int SIMULATION_COUNT = 1000000;
    private static final int BET_AMOUNT = 10;
    private static final int WIN_AMOUNT = 20;

    public static void main(String args[]){
        Player player = new Player();
        GamblingGame app = new SlotGame(player,BET_AMOUNT,WIN_AMOUNT);
        for(int i =0; i < SIMULATION_COUNT;i++){
            app.run();
        }
        app.printStats();
    }


}
