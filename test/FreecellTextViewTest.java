import static org.junit.Assert.assertEquals;

import cs3500.freecell.model.PileType;
import cs3500.freecell.model.hw02.Card;
import cs3500.freecell.model.hw02.SimpleFreecellModel;
import cs3500.freecell.model.hw02.Suit;
import cs3500.freecell.model.hw02.Value;
import cs3500.freecell.view.FaultyAppendable;
import cs3500.freecell.view.FreecellTextView;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for {@link FreecellTextView}.
 */
public class FreecellTextViewTest {

  SimpleFreecellModel model1;
  List<Card> deck;
  Card acC;
  Card twC;
  Card thC;
  Card foC;
  Card fiC;
  Card siC;
  Card seC;
  Card eiC;
  Card niC;
  Card teC;
  Card jaC;
  Card quC;
  Card kiC;
  Card acD;
  Card twD;
  Card thD;
  Card foD;
  Card fiD;
  Card siD;
  Card seD;
  Card eiD;
  Card niD;
  Card teD;
  Card jaD;
  Card quD;
  Card kiD;
  Card acH;
  Card twH;
  Card thH;
  Card foH;
  Card fiH;
  Card siH;
  Card seH;
  Card eiH;
  Card niH;
  Card teH;
  Card jaH;
  Card quH;
  Card kiH;
  Card acS;
  Card twS;
  Card thS;
  Card foS;
  Card fiS;
  Card siS;
  Card seS;
  Card eiS;
  Card niS;
  Card teS;
  Card jaS;
  Card quS;
  Card kiS;

  @Before
  public void setup() {
    model1 = new SimpleFreecellModel();
    acC = new Card(Value.ACE, Suit.CLUBS);
    twC = new Card(Value.TWO, Suit.CLUBS);
    thC = new Card(Value.THREE, Suit.CLUBS);
    foC = new Card(Value.FOUR, Suit.CLUBS);
    fiC = new Card(Value.FIVE, Suit.CLUBS);
    siC = new Card(Value.SIX, Suit.CLUBS);
    seC = new Card(Value.SEVEN, Suit.CLUBS);
    eiC = new Card(Value.EIGHT, Suit.CLUBS);
    niC = new Card(Value.NINE, Suit.CLUBS);
    teC = new Card(Value.TEN, Suit.CLUBS);
    jaC = new Card(Value.JACK, Suit.CLUBS);
    quC = new Card(Value.QUEEN, Suit.CLUBS);
    kiC = new Card(Value.KING, Suit.CLUBS);

    acD = new Card(Value.ACE, Suit.DIAMONDS);
    twD = new Card(Value.TWO, Suit.DIAMONDS);
    thD = new Card(Value.THREE, Suit.DIAMONDS);
    foD = new Card(Value.FOUR, Suit.DIAMONDS);
    fiD = new Card(Value.FIVE, Suit.DIAMONDS);
    siD = new Card(Value.SIX, Suit.DIAMONDS);
    seD = new Card(Value.SEVEN, Suit.DIAMONDS);
    eiD = new Card(Value.EIGHT, Suit.DIAMONDS);
    niD = new Card(Value.NINE, Suit.DIAMONDS);
    teD = new Card(Value.TEN, Suit.DIAMONDS);
    jaD = new Card(Value.JACK, Suit.DIAMONDS);
    quD = new Card(Value.QUEEN, Suit.DIAMONDS);
    kiD = new Card(Value.KING, Suit.DIAMONDS);

    acH = new Card(Value.ACE, Suit.HEARTS);
    twH = new Card(Value.TWO, Suit.HEARTS);
    thH = new Card(Value.THREE, Suit.HEARTS);
    foH = new Card(Value.FOUR, Suit.HEARTS);
    fiH = new Card(Value.FIVE, Suit.HEARTS);
    siH = new Card(Value.SIX, Suit.HEARTS);
    seH = new Card(Value.SEVEN, Suit.HEARTS);
    eiH = new Card(Value.EIGHT, Suit.HEARTS);
    niH = new Card(Value.NINE, Suit.HEARTS);
    teH = new Card(Value.TEN, Suit.HEARTS);
    jaH = new Card(Value.JACK, Suit.HEARTS);
    quH = new Card(Value.QUEEN, Suit.HEARTS);
    kiH = new Card(Value.KING, Suit.HEARTS);

    acS = new Card(Value.ACE, Suit.SPADES);
    twS = new Card(Value.TWO, Suit.SPADES);
    thS = new Card(Value.THREE, Suit.SPADES);
    foS = new Card(Value.FOUR, Suit.SPADES);
    fiS = new Card(Value.FIVE, Suit.SPADES);
    siS = new Card(Value.SIX, Suit.SPADES);
    seS = new Card(Value.SEVEN, Suit.SPADES);
    eiS = new Card(Value.EIGHT, Suit.SPADES);
    niS = new Card(Value.NINE, Suit.SPADES);
    teS = new Card(Value.TEN, Suit.SPADES);
    jaS = new Card(Value.JACK, Suit.SPADES);
    quS = new Card(Value.QUEEN, Suit.SPADES);
    kiS = new Card(Value.KING, Suit.SPADES);

    deck = Arrays
        .asList(kiC, kiD, kiH, kiS, quC, quD, quH, quS, jaC, jaD, jaH, jaS, teC, teD, teH, teS, niC,
            niD, niH, niS, eiC, eiD, eiH, eiS, seC, seD, seH, seS, siC, siD, siH, siS, fiC, fiD,
            fiH, fiS, foC, foD, foH, foS, thC, thD, thH, thS, twC, twD, twH, twS, acC, acD, acH,
            acS);
  }

  @Test
  public void testToString() {
    model1.startGame(deck, 4, 4, false);
    FreecellTextView state = new FreecellTextView(model1);
    assertEquals("F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "C2: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠", state.toString());
  }

  @Test
  public void testToStringMove() {
    model1.startGame(deck, 4, 4, false);
    model1.move(PileType.CASCADE, 0, 12, PileType.OPEN, 2);
    model1.move(PileType.CASCADE, 1, 12, PileType.FOUNDATION, 0);
    FreecellTextView state = new FreecellTextView(model1);
    assertEquals("F1: A♦\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3: A♣\n"
        + "O4:\n"
        + "C1: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣\n"
        + "C2: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠", state.toString());
  }

  @Test
  public void testToStringGameNotStarted() {
    FreecellTextView state = new FreecellTextView(model1);
    assertEquals("", state.toString());
  }

  @Test
  public void renderBoard() {
    StringBuilder gameLog = new StringBuilder();
    model1.startGame(deck, 4, 4, false);
    FreecellTextView state = new FreecellTextView(model1, gameLog);
    try {
      state.renderBoard();
    } catch (IOException e) {
      e.printStackTrace();
    }
    assertEquals("F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "C2: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n", gameLog.toString());
    model1.move(PileType.CASCADE, 0, 12, PileType.OPEN, 2);
    try {
      state.renderBoard();
    } catch (IOException e) {
      e.printStackTrace();
    }
    assertEquals("F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "C2: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3: A♣\n"
        + "O4:\n"
        + "C1: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣\n"
        + "C2: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n", gameLog.toString());
  }

  @Test
  public void renderMessage() {
    StringBuilder gameLog = new StringBuilder();
    model1.startGame(deck, 4, 4, false);
    FreecellTextView state = new FreecellTextView(model1, gameLog);
    try {
      state.renderBoard();
    } catch (IOException e) {
      e.printStackTrace();
    }
    assertEquals("F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "C2: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n", gameLog.toString());
    model1.move(PileType.CASCADE, 0, 12, PileType.OPEN, 2);
    try {
      state.renderMessage("Hi");
    } catch (IOException e) {
      e.printStackTrace();
    }

    assertEquals("F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n"
        + "C2: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n"
        + "C3: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n"
        + "C4: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n"
        + "Hi", gameLog.toString());
  }

  @Test(expected = IOException.class)
  public void renderBoardFail() throws IOException {
    Appendable gameLog = new FaultyAppendable();
    model1.startGame(deck, 4, 4, false);
    FreecellTextView state = new FreecellTextView(model1, gameLog);
    state.renderBoard();
  }

  @Test(expected = IOException.class)
  public void renderMessageFail() throws IOException {
    Appendable gameLog = new FaultyAppendable();
    model1.startGame(deck, 4, 4, false);
    FreecellTextView state = new FreecellTextView(model1, gameLog);
    state.renderMessage("test");
  }
}