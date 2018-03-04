import domain.Player;
import domain.State;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import util.NumberGenerator;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@RunWith(PowerMockRunner.class)
@PrepareForTest(NumberGenerator.class)
public class SlotGameTest {

    @Test
    public void shouldWinCoins(){
        //given
        SlotGame game = Mockito.spy(SlotGame.class)    ;
        PowerMockito.mockStatic(NumberGenerator.class);
        when(NumberGenerator.getRandomNumber(1,100)).thenReturn(15);
        when(game.getPlayer()).thenReturn(new Player());

        //when
        game.play();

        //then
        Mockito.verify(game,Mockito.times(1)).claim(any(Integer.class));
    }
}
