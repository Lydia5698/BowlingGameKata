import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

public class GameTest {
    private Game g;

    @Before
    public void setUp(){
        g = new Game();
    }
    private void rollMany(int pinsDown, int n) {
        for (int i = 0; i < n; i++){
            g.roll(pinsDown);
        }
    }

    @Test
    public void playGutterGame(){
        rollMany(0, 20);
        assertThat(g.score(), is(0));
    }

    @Test
    public void scoreGameOfOnes(){
        rollMany(1, 20);
        assertThat(g.score(), is(20));
    }

    @Test
    public void scoreOneSpare(){
        rollSpare();
        g.roll(4);
        rollMany(0,17);
        assertThat(g.score(), is(18));
    }

    @Test
    public void scoreOneStrike(){
        g.roll(10); // strike
        g.roll(3);
        g.roll(4);
        rollMany(0, 16);
        assertThat(g.score(), is(24));
    }

    @Test
    public void testPerfectGame(){
        rollMany(10,12);
        assertThat(g.score(), is(300));
    }

    private void rollSpare(){
        g.roll(3);
        g.roll(7);
    }
}
