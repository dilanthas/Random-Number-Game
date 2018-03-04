import domain.Box;
import domain.Player;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.powermock.reflect.Whitebox;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;


public class BoxPickingGameTest {

    private static Player player;
    private static BoxPickingGame game;
    private static ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeClass
    public static void init(){
        player = new Player();
        game = new BoxPickingGame(player,0,5,5);
        System.setOut(new PrintStream(outContent));

    }
    @Test
    public void shouldInitCorrectNumberOfBoxes() throws Exception{
        //given
        int noOfBoxes = 5;
        int oddBox = 2;
        //when
        List<Box> boxes = Whitebox.invokeMethod(game,"getBoxes",oddBox,noOfBoxes,5);
        //then
        Assert.assertThat(boxes.size() , CoreMatchers.is(noOfBoxes));
    }
    @Test
    public void shouldHaveZeroCoins() throws Exception{
        //given
        int noOfBoxes = 5;
        int oddBox = 2;
        //when
        List<Box> boxes = Whitebox.invokeMethod(game,"getBoxes",oddBox,noOfBoxes,5);
        //then
        Assert.assertTrue(boxes.get(oddBox ).getCoins() == 0 );
    }

    @Test
    public void shouldInvalidateInput() throws Exception{
        //given
        int input = 6;
        int noOfBoxes = 5;
        //when
        boolean valid = Whitebox.invokeMethod(game,"isValidInput",input,noOfBoxes);
        //then
        Assert.assertFalse(valid);

    }
    @Test
    public void shouldReturnFalseWhenNoCoins() throws Exception{
        //given
        List<Box> boxes = new ArrayList<Box>();
        Box box1 = new Box(5);
        Box box2 = new Box(0);
        Box box3 = new Box(5);
        boxes.add(box1);
        boxes.add(box2);
        boxes.add(box3);
        //when
        boolean valid = Whitebox.invokeMethod(game,"checkCoins",2,boxes);
        //then
        Assert.assertFalse(valid);


    }

    public static void main(String args[]){

        Player player = new Player();
        BoxPickingGame game = new BoxPickingGame(player,0,5,5);
        game.initBoxes();
        game.run();
        game.printStats();
    }
}
