import org.junit.*;
import static org.junit.Assert.*;

public class YatzyTest {

    @Test
    public void change() {
        assertEquals(15, new Yatzy(2,3,4,5,1).chance());
        assertEquals(16, new Yatzy(3,3,4,5,1).chance());
        assertEquals(14, new Yatzy(1,1,3,3,6).chance());
        assertEquals(21, new Yatzy(4,5,5,6,1).chance());

    }

    @Test public void yatzy() {
        assertEquals(50, new Yatzy(4,4,4,4,4).yatzy());
        assertEquals(50, new Yatzy(6,6,6,6,6).yatzy());
        assertEquals(0, new Yatzy(6,6,6,6,3).yatzy());
        assertEquals(50, new Yatzy(1,1,1,1,1).yatzy());
        assertEquals(0, new Yatzy(1,1,1,2,1).yatzy());
    }

    @Test public void ones() {
        assertEquals (1, new Yatzy(1,2,3,4,5).ones());
        assertEquals(2, new Yatzy(1,2,1,4,5).ones());
        assertEquals(0,  new Yatzy(6,2,2,4,5).ones());
        assertEquals(4, new Yatzy(1,2,1,1,1).ones());
        assertEquals(0, new Yatzy(3,3,3,4,5).ones());
    }

    @Test
    public void twos() {
        assertEquals(4, new Yatzy(1,2,3,2,6).twos());
        assertEquals(10, new Yatzy(2,2,2,2,2).twos());
        assertEquals(4, new Yatzy(2,3,2,5,1).twos());

    }

    @Test
    public void threes() {
        assertEquals(6, new Yatzy(1,2,3,2,3).threes());
        assertEquals(12, new Yatzy(2,3,3,3,3).threes());
    }

    @Test
    public void fours()
    {
        assertEquals(12, new Yatzy(4,4,4,5,5).fours());
        assertEquals(8, new Yatzy(4,4,5,5,5).fours());
        assertEquals(4, new Yatzy(4,5,5,5,5).fours());
        assertEquals(8, new Yatzy(1,1,2,4,4).fours());

    }

    @Test
    public void fives() {
        assertEquals(10,  new Yatzy(4,4,4,5,5).fives());
        assertEquals(15,  new Yatzy(4,4,5,5,5).fives());
        assertEquals(20,  new Yatzy(4,5,5,5,5).fives());
    }

    @Test
    public void sixes() {
        assertEquals(0, new Yatzy(4,4,4,5,5).sixes());
        assertEquals(6, new Yatzy(4,4,6,5,5).sixes());
        assertEquals(18, new Yatzy(6,5,6,6,5).sixes());
    }

    @Test
    public void pair() {
        assertEquals(6, new Yatzy(3,4,3,5,6).pair());
        assertEquals(10, new Yatzy(5,3,3,3,5).pair());
        assertEquals(12, new Yatzy(5,3,6,6,5).pair());

        assertEquals(0, new Yatzy(1,2,3,4,5).pair());
        assertEquals(8, new Yatzy(3,3,3,4,4).pair());
        assertEquals(12,new Yatzy(1,1,6,2,6).pair());
        assertEquals(6, new Yatzy(3,3,3,4,1).pair());
        assertEquals(6, new Yatzy(3,3,3,3,1).pair());

    }

    @Test
    public void twoPairs() {
        assertEquals(16, new Yatzy(3,3,5,4,5).twoPairs());
        assertEquals(16, new Yatzy(3,3,5,5,5).twoPairs());

        assertEquals(8, new Yatzy(1,1,2,3,3).twoPairs());
        assertEquals(0, new Yatzy(1,1,2,3,4).twoPairs());
        assertEquals(6, new Yatzy(1,1,2,2,2).twoPairs());
        assertEquals(0, new Yatzy(3,3,3,3,1).twoPairs());

    }

    @Test
    public void threeOfAKind()
    {
        assertEquals(9, new Yatzy(3,3,3,4,5).threeOfAKind());
        assertEquals(15, new Yatzy(5,3,5,4,5).threeOfAKind());
        assertEquals(9, new Yatzy(3,3,3,3,5).threeOfAKind());
        assertEquals(9, new Yatzy(3,3,3,3,3).threeOfAKind());

        assertEquals(0, new Yatzy(3,3,4,5,6).threeOfAKind());
        assertEquals(9, new Yatzy(3,3,3,3,1).threeOfAKind());

    }

    @Test
    public void fourOfAKind() {
        assertEquals(12, new Yatzy(3,3,3,3,5).fourOfAKind());
        assertEquals(20, new Yatzy(5,5,5,4,5).fourOfAKind());

        assertEquals(8, new Yatzy(2,2,2,2,5).fourOfAKind());
        assertEquals(0, new Yatzy(2,2,2,5,5).fourOfAKind());
        assertEquals(8, new Yatzy(2,2,2,2,2).fourOfAKind());

    }

    @Test
    public void smallStraight() {
        assertEquals(15, new Yatzy(1,2,3,4,5).smallStraight());
        assertEquals(15, new Yatzy(2,3,4,5,1).smallStraight());
        assertEquals(0, new Yatzy(1,2,2,4,5).smallStraight());

    }

    @Test
    public void largeStraight() {
        assertEquals(20, new Yatzy(6,2,3,4,5).largeStraight());
        assertEquals(20, new Yatzy(2,3,4,5,6).largeStraight());
        assertEquals(0, new Yatzy(1,2,2,4,5).largeStraight());
    }

    @Test
    public void fullHouse() {
        assertEquals(18, new Yatzy(6,2,2,2,6).fullHouse());
        assertEquals(0, new Yatzy(2,3,4,5,6).fullHouse());

        assertEquals(8, new Yatzy(1,1,2,2,2).fullHouse());
        assertEquals(0, new Yatzy(2,2,3,3,4).fullHouse());
        assertEquals(0, new Yatzy(4,4,4,4,4).fullHouse());
    }
}