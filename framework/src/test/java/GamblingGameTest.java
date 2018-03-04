import domain.Player;
import domain.State;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

public class GamblingGameTest {

    @BeforeClass
    public static void init(){

    }
    @Test
    public void shouldInitStatesToNormal(){
        //given
        GamblingGame sut = Mockito.spy(GamblingGame.class);
        //when
        sut.init();
        //then
        Assert.assertTrue(sut.getCurrent() == State.NORMAL);
        Assert.assertTrue(sut.getNext()  == State.NORMAL);
    }

    @Test
    public void shouldCallFreeRound(){
        //given
        GamblingGame sut = Mockito.spy(GamblingGame.class);
        Mockito.when(sut.getNext()).thenReturn(State.FREE);
        //when
        sut.run();
        //then
        Mockito.verify(sut,Mockito.times(1)).freeRound();
    }
    @Test
    public void shouldCallNormalRound(){
        //given
        GamblingGame sut = Mockito.spy(GamblingGame.class);
        Mockito.when(sut.getNext()).thenReturn(State.NORMAL);
        Mockito.when(sut.getPlayer()).thenReturn(new Player());
        //when
        sut.run();
        //then
        Mockito.verify(sut,Mockito.times(1)).normalRound();
    }
    @Test
    public void shouldIncreaseBets(){
        //given
        Player p = new Player();
        GamblingGame sut = Mockito.spy(GamblingGame.class);
        Mockito.when(sut.getPlayer()).thenReturn(p);

        //when
        sut.bet(10);
        //then
        Assert.assertTrue(p.getBets() == 10);

    }
    @Test
    public void shouldIncreaseWins(){
        //given
        Player p = new Player();
        GamblingGame sut = Mockito.spy(GamblingGame.class);
        Mockito.when(sut.getPlayer()).thenReturn(p);

        //when
        sut.claim(20);
        //then
        Assert.assertTrue(p.getWins() == 20);

    }
}
