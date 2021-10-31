import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import cs3500.freecell.model.hw02.Value;
import org.junit.Test;

/**
 * Tests for {@link Value}.
 */
public class ValueTest {

  @Test
  public void testToString() {
    assertEquals("A", Value.ACE.toString());
    assertEquals("5", Value.FIVE.toString());
    assertEquals("K", Value.KING.toString());
  }

  @Test
  public void after() {
    assertFalse(Value.ACE.after(Value.KING));
    assertFalse(Value.JACK.after(Value.FIVE));
    assertFalse(Value.JACK.after(Value.QUEEN));
    assertTrue(Value.JACK.after(Value.TEN));
    assertFalse(Value.KING.before(Value.KING));
  }

  @Test
  public void before() {
    assertFalse(Value.KING.before(Value.ACE));
    assertFalse(Value.JACK.before(Value.FIVE));
    assertTrue(Value.JACK.before(Value.QUEEN));
    assertFalse(Value.JACK.before(Value.TEN));
    assertFalse(Value.KING.before(Value.KING));
  }
}