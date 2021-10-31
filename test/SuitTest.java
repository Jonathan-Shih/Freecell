import static org.junit.Assert.assertEquals;

import cs3500.freecell.model.hw02.Suit;
import java.awt.Color;
import org.junit.Test;

/**
 * Tests for {@link Suit}.
 */
public class SuitTest {

  /*
    CLUBS("♣", Color.BLACK), DIAMONDS("♦", Color.RED),
    HEARTS("♥", Color.RED), SPADES("♠", Color.BLACK);
   */
  @Test
  public void testToString() {
    assertEquals("♣", Suit.CLUBS.toString());
    assertEquals("♦", Suit.DIAMONDS.toString());
    assertEquals("♥", Suit.HEARTS.toString());
    assertEquals("♠", Suit.SPADES.toString());
  }

  @Test
  public void getColor() {
    assertEquals(Color.BLACK, Suit.CLUBS.getColor());
    assertEquals(Color.RED, Suit.DIAMONDS.getColor());
    assertEquals(Color.RED, Suit.HEARTS.getColor());
    assertEquals(Color.BLACK, Suit.SPADES.getColor());
  }

}