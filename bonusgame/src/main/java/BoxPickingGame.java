import domain.Box;
import domain.Player;
import util.NumberGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BoxPickingGame extends GamblingGame {
    private int boxNo;
    private List<Box> boxes ;
    public BoxPickingGame(Player player, int betAmount, int winAmount,int boxNo) {
        super(player, betAmount, winAmount);
        this.boxNo = boxNo;

    }

    public void initBoxes(){
        this.boxes = getBoxes(NumberGenerator.getRandomNumber(0,boxNo - 1) , boxNo,winAmount);
    }
    private List<Box> getBoxes(int oddBox, int numberOfBoxes, int winAmount) {
        List<Box> boxes = new ArrayList<Box>();
        for(int i = 0; i < numberOfBoxes ;i++){
            int coins = winAmount;
            if(i == oddBox){
                coins = 0;
            }
            boxes.add(new Box(coins));
        }
        return boxes;
    }

    public void play() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (boxes.size() >0 ){
            try {
                int noOfBoxes = boxes.size();
                int input = getInput(br,noOfBoxes);
                if(input != -1){
                    if(isValidInput(input,noOfBoxes)){
                        if(checkCoins(input,boxes)){
                            System.out.println("Excellent.You won "+winAmount+" coins");
                            claim(winAmount);
                            boxes.remove(input -1);
                        }else{
                            System.out.println("Bad luck.No coins found ");
                            break;
                        }
                    }
                }else{
                    System.out.println("Something went wrong");
                }

            }catch (NumberFormatException ex){
                System.out.println("Invalid input ");
            }
        }
    }

    private int getInput(BufferedReader br , int noOfBoxes){
        try {
            System.out.println("Enter a number between "+1 +" - "+noOfBoxes);
            return Integer.parseInt(br.readLine());
        }catch (NumberFormatException ex){
            System.out.println("Invalid input ");
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        return -1;
    }
    private boolean checkCoins(int input , List<Box> boxes){
        Box box = boxes.get(input -1);
        if(box.getCoins() == 0){
            return false;
        }
        return true;
    }
    private boolean isValidInput(int input,int noOfBoxes){
        if(input > noOfBoxes || input < 1){
            System.out.println("Invalid input");
            return false;
        }
        return true;
    }
    public void freeRound() {

    }

    @Override
    public void normalRound() {
        play();
    }
}
