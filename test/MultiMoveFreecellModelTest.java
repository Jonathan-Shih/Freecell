import static org.junit.Assert.assertEquals;

import cs3500.freecell.model.FreecellModel;
import cs3500.freecell.model.FreecellModelCreator;
import cs3500.freecell.model.FreecellModelCreator.GameType;
import cs3500.freecell.model.PileType;
import cs3500.freecell.model.hw04.MultiMoveFreecellModel;
import cs3500.freecell.view.FreecellTextView;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for {@link MultiMoveFreecellModel}.
 */
public class MultiMoveFreecellModelTest {

  private FreecellModel model1;
  private FreecellModel model2;

  @Before
  public void init() {
    model1 = new FreecellModelCreator().create(GameType.MULTIMOVE);
    model2 = new FreecellModelCreator().create(GameType.SINGLEMOVE);
  }

  @Test
  public void testMultiMoveCascadeToCascade() {
    model1.startGame(model1.getDeck(), 4, 4, false);
    FreecellTextView state = new FreecellTextView(model1);
    // C1 13 F1
    model1.move(PileType.CASCADE, 0, 12, PileType.FOUNDATION, 0);
    // C1 12 F1
    model1.move(PileType.CASCADE, 0, 11, PileType.FOUNDATION, 0);
    // C2 13 F2
    model1.move(PileType.CASCADE, 1, 12, PileType.FOUNDATION, 1);
    // C4 13 C2
    model1.move(PileType.CASCADE, 3, 12, PileType.CASCADE, 1);
    assertEquals("F1: A♣, 2♣\n"
        + "F2: A♦\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣\n"
        + "C2: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠", state.toString());

    // move two of diamonds and ace of spades from C2 to C1 with multimove
    model1.move(PileType.CASCADE, 1, 11, PileType.CASCADE, 0);
    assertEquals("F1: A♣, 2♣\n"
        + "F2: A♦\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♦, A♠\n"
        + "C2: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠", state.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void multiMoveCascadeToOpen() {
    model1.startGame(model1.getDeck(), 4, 4, false);
    FreecellTextView state = new FreecellTextView(model1);
    // C1 13 F1
    model1.move(PileType.CASCADE, 0, 12, PileType.FOUNDATION, 0);
    // C1 12 F1
    model1.move(PileType.CASCADE, 0, 11, PileType.FOUNDATION, 0);
    // C2 13 F2
    model1.move(PileType.CASCADE, 1, 12, PileType.FOUNDATION, 1);
    // C4 13 C2
    model1.move(PileType.CASCADE, 3, 12, PileType.CASCADE, 1);
    assertEquals("F1: A♣, 2♣\n"
        + "F2: A♦\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣\n"
        + "C2: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠", state.toString());

    // move two of diamonds and ace of spades from C2 to O1 with multimove
    model1.move(PileType.CASCADE, 1, 11, PileType.OPEN, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void multiMoveCascadeToFoundation() {
    model1.startGame(model1.getDeck(), 4, 4, false);
    FreecellTextView state = new FreecellTextView(model1);
    // C1 13 F1
    model1.move(PileType.CASCADE, 0, 12, PileType.FOUNDATION, 0);
    // C1 12 F1
    model1.move(PileType.CASCADE, 0, 11, PileType.FOUNDATION, 0);
    // C2 13 F2
    model1.move(PileType.CASCADE, 1, 12, PileType.FOUNDATION, 1);
    // C4 13 C2
    model1.move(PileType.CASCADE, 3, 12, PileType.CASCADE, 1);
    assertEquals("F1: A♣, 2♣\n"
        + "F2: A♦\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣\n"
        + "C2: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠", state.toString());

    // move two of diamonds and ace of spades from C2 to F3 with multimove
    model1.move(PileType.CASCADE, 1, 11, PileType.FOUNDATION, 3);
  }

  @Test
  public void moveFromCasToEmptyCas() {
    model1.startGame(model1.getDeck(), 4, 4, false);
    FreecellTextView state = new FreecellTextView(model1);
    // all cards from C3 to F1
    model1.move(PileType.CASCADE, 2, 12, PileType.FOUNDATION, 0);
    model1.move(PileType.CASCADE, 2, 11, PileType.FOUNDATION, 0);
    model1.move(PileType.CASCADE, 2, 10, PileType.FOUNDATION, 0);
    model1.move(PileType.CASCADE, 2, 9, PileType.FOUNDATION, 0);
    model1.move(PileType.CASCADE, 2, 8, PileType.FOUNDATION, 0);
    model1.move(PileType.CASCADE, 2, 7, PileType.FOUNDATION, 0);
    model1.move(PileType.CASCADE, 2, 6, PileType.FOUNDATION, 0);
    model1.move(PileType.CASCADE, 2, 5, PileType.FOUNDATION, 0);
    model1.move(PileType.CASCADE, 2, 4, PileType.FOUNDATION, 0);
    model1.move(PileType.CASCADE, 2, 3, PileType.FOUNDATION, 0);
    model1.move(PileType.CASCADE, 2, 2, PileType.FOUNDATION, 0);
    model1.move(PileType.CASCADE, 2, 1, PileType.FOUNDATION, 0);
    model1.move(PileType.CASCADE, 2, 0, PileType.FOUNDATION, 0);

    model1.move(PileType.CASCADE, 1, 12, PileType.OPEN, 0);
    model1.move(PileType.CASCADE, 3, 12, PileType.CASCADE, 1);

    assertEquals("F1: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1: A♦\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "C2: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♠\n"
        + "C3:\n"
        + "C4: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠", state.toString());

    model1.move(PileType.CASCADE, 1, 11, PileType.CASCADE, 2);

    assertEquals("F1: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1: A♦\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "C2: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦\n"
        + "C3: 2♦, A♠\n"
        + "C4: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠", state.toString());
  }

  @Test
  public void moveFromOpen() {
    model1.startGame(model1.getDeck(), 4, 4, false);
    FreecellTextView state = new FreecellTextView(model1);
    // C1 13 F1
    model1.move(PileType.CASCADE, 0, 12, PileType.OPEN, 0);
    model1.move(PileType.OPEN, 0, 0, PileType.OPEN, 1);

    assertEquals("F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2: A♣\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣\n"
        + "C2: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠", state.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void moveFromFoundation() {
    model1.startGame(model1.getDeck(), 4, 4, false);
    FreecellTextView state = new FreecellTextView(model1);
    // C1 13 F1
    model1.move(PileType.CASCADE, 0, 12, PileType.FOUNDATION, 0);
    // C1 12 F1
    model1.move(PileType.CASCADE, 0, 11, PileType.FOUNDATION, 0);
    // C2 13 F2
    model1.move(PileType.CASCADE, 1, 12, PileType.FOUNDATION, 1);
    // C4 13 C2
    assertEquals("F1: A♣, 2♣\n"
        + "F2: A♦\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣\n"
        + "C2: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠", state.toString());
    model1.move(PileType.FOUNDATION, 1, 0, PileType.CASCADE, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void multiMoveNotEnoughSlots() {
    model1.startGame(model1.getDeck(), 4, 4, false);
    FreecellTextView state = new FreecellTextView(model1);
    // C1 13 F1
    model1.move(PileType.CASCADE, 0, 12, PileType.FOUNDATION, 0);
    // C1 12 F1
    model1.move(PileType.CASCADE, 0, 11, PileType.OPEN, 1);
    // C2 13 F2
    model1.move(PileType.CASCADE, 1, 12, PileType.OPEN, 2);
    // C4 13 C2
    model1.move(PileType.CASCADE, 3, 12, PileType.CASCADE, 1);
    // move two of diamonds and ace of spades from C2 to C1 with multimove
    model1.move(PileType.CASCADE, 1, 11, PileType.CASCADE, 0);

    model1.move(PileType.CASCADE, 1, 10, PileType.OPEN, 0);
    assertEquals("F1: A♣\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1: 3♦\n"
        + "O2: 2♣\n"
        + "O3: A♦\n"
        + "O4:\n"
        + "C1: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♦, A♠\n"
        + "C2: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠", state.toString());

    // trying to move 3clubs, 2diamonds and aceSpades at the same time, not enough slots avaliable
    model1.move(PileType.CASCADE, 0, 10, PileType.OPEN, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void multiMoveInvalidBuild() {
    model1.startGame(model1.getDeck(), 4, 4, false);
    FreecellTextView state = new FreecellTextView(model1);
    // C1 13 F1
    model1.move(PileType.CASCADE, 0, 12, PileType.FOUNDATION, 0);
    // C1 12 F1
    model1.move(PileType.CASCADE, 0, 11, PileType.FOUNDATION, 0);
    assertEquals("F1: A♣, 2♣\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣\n"
        + "C2: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠", state.toString());
    // try to move two of diamonds and ace of diamonds at the same time, but illegal build
    model1.move(PileType.CASCADE, 1, 11, PileType.FOUNDATION, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void multiMoveSameColor() {
    model1.startGame(model1.getDeck(), 4, 4, false);
    FreecellTextView state = new FreecellTextView(model1);
    // C1 13 F1
    model1.move(PileType.CASCADE, 0, 12, PileType.FOUNDATION, 0);
    // C1 12 F1
    model1.move(PileType.CASCADE, 0, 11, PileType.FOUNDATION, 0);
    // C2 13 F2
    model1.move(PileType.CASCADE, 3, 12, PileType.FOUNDATION, 1);
    // C3 13 C4
    model1.move(PileType.CASCADE, 2, 12, PileType.CASCADE, 3);

    assertEquals("F1: A♣, 2♣\n"
        + "F2: A♠\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣\n"
        + "C2: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥\n"
        + "C4: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♥", state.toString());

    // try to move two of spades and ace of hearts to C1
    model1.move(PileType.CASCADE, 3, 11, PileType.CASCADE, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void multiMoveWrongValue() {
    model1.startGame(model1.getDeck(), 4, 4, false);
    FreecellTextView state = new FreecellTextView(model1);
    // C1 13 F1
    model1.move(PileType.CASCADE, 0, 12, PileType.FOUNDATION, 0);
    // C1 12 F1
    model1.move(PileType.CASCADE, 0, 11, PileType.FOUNDATION, 0);
    // C1 11 F1
    model1.move(PileType.CASCADE, 0, 10, PileType.FOUNDATION, 0);
    // C2 13 F2
    model1.move(PileType.CASCADE, 1, 12, PileType.FOUNDATION, 1);
    // C4 13 C2
    model1.move(PileType.CASCADE, 3, 12, PileType.CASCADE, 1);
    assertEquals("F1: A♣, 2♣, 3♣\n"
        + "F2: A♦\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣\n"
        + "C2: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♠\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠", state.toString());

    // move two of diamonds and ace of spades from C2 to C1 with multimove
    model1.move(PileType.CASCADE, 1, 11, PileType.CASCADE, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void multiMoveNullSource() {
    model1.startGame(model1.getDeck(), 4, 4, false);
    model1.move(null, 0, 12, PileType.FOUNDATION, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void multiMoveNullDest() {
    model1.startGame(model1.getDeck(), 4, 4, false);
    model1.move(PileType.CASCADE, 0, 12, null, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void multiMoveNullSourceAndDest() {
    model1.startGame(model1.getDeck(), 4, 4, false);
    model1.move(null, 0, 12, null, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void singleModelMultiMove() {
    model2.startGame(model2.getDeck(), 4, 4, false);
    // C1 13 F1
    model2.move(PileType.CASCADE, 0, 12, PileType.FOUNDATION, 0);
    // C1 12 F1
    model2.move(PileType.CASCADE, 0, 11, PileType.FOUNDATION, 0);
    // C2 13 F2
    model2.move(PileType.CASCADE, 1, 12, PileType.FOUNDATION, 1);
    // C4 13 C2
    model2.move(PileType.CASCADE, 3, 12, PileType.CASCADE, 1);
    // move two of diamonds and ace of spades from C2 to C1 with multimove
    model2.move(PileType.CASCADE, 1, 11, PileType.CASCADE, 0);
  }

}