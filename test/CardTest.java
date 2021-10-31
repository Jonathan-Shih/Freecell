import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import cs3500.freecell.model.hw02.Card;
import cs3500.freecell.model.hw02.Suit;
import cs3500.freecell.model.hw02.Value;
import org.junit.Test;

/**
 * Tests for {@link Card}.
 */
public class CardTest {

  Card aceSpades = new Card(Value.ACE, Suit.SPADES);
  Card eightClubs = new Card(Value.EIGHT, Suit.CLUBS);
  Card queenHearts = new Card(Value.QUEEN, Suit.HEARTS);
  Card kingDiamonds = new Card(Value.KING, Suit.DIAMONDS);
  Card aceSpades2 = new Card(Value.ACE, Suit.SPADES);

  @Test
  public void testToString() {
    assertEquals("8♣", eightClubs.toString());
    assertEquals("A♠", aceSpades.toString());
    assertEquals("Q♥", queenHearts.toString());
    assertEquals("K♦", kingDiamonds.toString());
  }

  @Test
  public void testEquals() {
    assertTrue(aceSpades.equals(aceSpades2));
    assertFalse(aceSpades.equals(kingDiamonds));
    assertFalse(aceSpades == null);
    assertFalse(aceSpades.equals(Suit.SPADES));
  }

  @Test
  public void testHashCode() {
    assertTrue(aceSpades.hashCode() == aceSpades2.hashCode());
    assertFalse(aceSpades.hashCode() == queenHearts.hashCode());
  }

  @Test
  public void getSuit() {
    assertEquals(Suit.SPADES, aceSpades.getSuit());
    assertEquals(Suit.HEARTS, queenHearts.getSuit());
  }

  @Test
  public void getValue() {
    assertEquals(Value.ACE, aceSpades.getValue());
    assertEquals(Value.QUEEN, queenHearts.getValue());
  }
}