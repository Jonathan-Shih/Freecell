import static org.junit.Assert.assertEquals;

import cs3500.freecell.model.FreecellModel;
import cs3500.freecell.model.FreecellModelCreator;
import cs3500.freecell.model.FreecellModelCreator.GameType;
import cs3500.freecell.model.hw02.SimpleFreecellModel;
import cs3500.freecell.model.hw04.MultiMoveFreecellModel;
import org.junit.Test;

/**
 * Tests for {@link FreecellModelCreator}.
 */
public class FreecellModelCreatorTest {

  @Test
  public void createMultiMove() {
    FreecellModel multi = new FreecellModelCreator().create(GameType.MULTIMOVE);
    assertEquals(multi.getClass(), MultiMoveFreecellModel.class);
  }

  @Test
  public void createSimpleMove() {
    FreecellModel simple = new FreecellModelCreator().create(GameType.SINGLEMOVE);
    assertEquals(simple.getClass(), SimpleFreecellModel.class);
  }

  @Test(expected = IllegalArgumentException.class)
  public void createNull() {
    FreecellModel invalid = new FreecellModelCreator().create(null);
  }
}