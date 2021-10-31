
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import cs3500.freecell.model.FreecellModel;
import cs3500.freecell.model.FreecellModelCreator;
import cs3500.freecell.model.FreecellModelCreator.GameType;
import cs3500.freecell.model.PileType;
import cs3500.freecell.model.hw02.Card;
import cs3500.freecell.model.hw02.SimpleFreecellModel;
import cs3500.freecell.model.hw02.Suit;
import cs3500.freecell.model.hw02.Value;
import cs3500.freecell.model.hw04.MultiMoveFreecellModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

/**
 * Test cases for both {@link SimpleFreecellModel} and {@link MultiMoveFreecellModel}.
 */
public abstract class AbstractModelTest {

  protected abstract FreecellModel model();

  /**
   * Class to create a {@link MultiMoveFreecellModel}.
   */
  public static final class MultiMove extends AbstractModelTest {

    @Override
    protected FreecellModel model() {
      return new FreecellModelCreator().create(GameType.MULTIMOVE);
    }
  }

  /**
   * Class to create a {@link SimpleFreecellModel}.
   */
  public static final class Simple extends AbstractModelTest {

    @Override
    protected FreecellModel model() {
      return new FreecellModelCreator().create(GameType.SINGLEMOVE);
    }
  }

  FreecellModel model1 = model();
  FreecellModel model2 = model();
  List<Card> deck;
  List<Card> deck2;
  List<Card> deck3;
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
    model2 = new SimpleFreecellModel();
    deck = model1.getDeck();
    deck2 = model1.getDeck();
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

    deck3 = Arrays
        .asList(kiC, kiD, kiH, kiS, quC, quD, quH, quS, jaC, jaD, jaH, jaS, teC, teD, teH, teS, niC,
            niD, niH, niS, eiC, eiD, eiH, eiS, seC, seD, seH, seS, siC, siD, siH, siS, fiC, fiD,
            fiH, fiS, foC, foD, foH, foS, thC, thD, thH, thS, twC, twD, twH, twS, acC, acD, acH,
            acS);
  }

  @Test
  public void getDeck() {
    List<Card> deck = model1.getDeck();
    Card kingClubs = new Card(Value.KING, Suit.CLUBS);
    Card aceSpades = new Card(Value.ACE, Suit.SPADES);
    assertEquals(52, deck.size());
    assertEquals(kingClubs, deck.get(0));
    assertEquals(aceSpades, deck.get(deck.size() - 1));
  }

  @Test
  public void startGame() {
    model1.startGame(deck, 4, 1, false);
    // test the "dealing" of cards into cascade piles
    assertEquals(deck.get(0), model1.getCascadeCardAt(0, 0));
    assertEquals(deck.get(1), model1.getCascadeCardAt(1, 0));
    assertEquals(deck.get(2), model1.getCascadeCardAt(2, 0));
    assertEquals(deck.get(3), model1.getCascadeCardAt(3, 0));
    assertEquals(deck.get(4), model1.getCascadeCardAt(0, 1));

    assertEquals(13, model1.getNumCardsInCascadePile(0));
    assertEquals(13, model1.getNumCardsInCascadePile(1));
    assertEquals(13, model1.getNumCardsInCascadePile(2));
    assertEquals(13, model1.getNumCardsInCascadePile(3));

    model1.startGame(deck2, 4, 1, true);
    assertNotEquals(deck.get(0), model1.getCascadeCardAt(0, 0));
  }

  @Test
  public void startGameNoShuffle() {
    model1.startGame(deck3, 4, 1, false);
    assertEquals(acC, model1.getCascadeCardAt(0, 12));
    assertEquals(acS, model1.getCascadeCardAt(3, 12));
  }

  @Test
  public void startGameShuffle() {
    model1.startGame(deck3, 4, 1, false);
    model2.startGame(deck3, 4, 1, true);
    ArrayList<Card> deckUnShuffled = new ArrayList<Card>();
    ArrayList<Card> deckShuffled = new ArrayList<Card>();
    deckUnShuffled = startDeck(model1);
    deckShuffled = startDeck(model2);
    assertFalse(deckShuffled.equals(deckUnShuffled));
  }

  // simple test method for the start deck helper method used in the test above
  @Test
  public void testStartDeck() {
    // cards from deck3 dealt into cascade piles
    // added all cards in each cascade pile, from index 0 -> 12 from cascade piles 0 -> 3
    // assuming there are 4 cascade piles
    deck2 = Arrays
        .asList(kiC, quC, jaC, teC, niC, eiC, seC, siC, fiC, foC, thC, twC, acC, kiD, quD, jaD, teD,
            niD, eiD, seD, siD, fiD, foD, thD, twD, acD, kiH, quH, jaH, teH, niH, eiH, seH, siH,
            fiH, foH, thH, twH, acH, kiS, quS, jaS, teS, niS, eiS, seS, siS, fiS, foS, thS, twS,
            acS);
    model1.startGame(deck3, 4, 1, false);
    assertTrue(deck2.equals(startDeck(model1)));
  }

  // adds all cascade cards into an arraylist
  // pile by pile starting from index 0 of cascade pile 0ßœ
  private ArrayList<Card> startDeck(FreecellModel<Card> model) {
    ArrayList<Card> deck = new ArrayList<Card>();
    int cascadePiles = model.getNumCascadePiles();
    for (int i = 0; i < cascadePiles; i++) {
      int numCards = model.getNumCardsInCascadePile(i);
      for (int j = 0; j < numCards; j++) {
        deck.add(model.getCascadeCardAt(i, j));
      }
    }
    return deck;
  }

  @Test
  public void startGameCasSize() {
    model1.startGame(deck, 5, 1, false);
    assertEquals(5, model1.getNumCascadePiles());
  }

  @Test
  public void startGameOpenSize() {
    model1.startGame(deck, 5, 3, false);
    assertEquals(3, model1.getNumOpenPiles());
  }

  @Test(expected = IllegalArgumentException.class)
  public void startGameErrOpen() {
    model1.startGame(model1.getDeck(), 5, 0, false);
  }

  @Test(expected = IllegalArgumentException.class)
  public void startGameErrCas() {
    model1.startGame(model1.getDeck(), 3, 2, false);
  }

  @Test(expected = IllegalArgumentException.class)
  public void startGameErrMtDeck() {
    List<Card> emptyDeck = new ArrayList<Card>(52);
    model1.startGame(emptyDeck, 5, 0, false);
  }

  @Test(expected = IllegalArgumentException.class)
  public void startGameErrNullDeck() {
    model1.startGame(null, 4, 1, false);
  }


  @Test(expected = IllegalArgumentException.class)
  public void startGameErrDeckSize() {
    deck.remove(1);
    model1.startGame(deck, 5, 0, false);
  }

  @Test(expected = IllegalArgumentException.class)
  public void startGameErrDeckDupe() {
    deck.add(new Card(Value.ACE, Suit.CLUBS));
    model1.startGame(deck, 5, 0, false);
  }

  @Test(expected = IllegalStateException.class)
  public void moveGameNotStarted() {
    model1.move(PileType.CASCADE, 3, 12, PileType.OPEN, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void moveNullSource() {
    model1.startGame(deck, 4, 4, false);
    model1.move(null, 3, 12, PileType.OPEN, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void moveNullDest() {
    model1.startGame(deck, 4, 4, false);
    model1.move(PileType.CASCADE, 3, 12, null, 3);
  }

  @Test
  public void moveToOpen() {
    model1.startGame(deck3, 4, 4, false);
    model1.move(PileType.CASCADE, 3, 12, PileType.OPEN, 0);
    assertEquals(1, model1.getNumCardsInOpenPile(0));
    assertEquals(new Card(Value.ACE, Suit.SPADES), model1.getOpenCardAt(0));
    assertEquals(12, model1.getNumCardsInCascadePile(3));
  }

  @Test(expected = IllegalArgumentException.class)
  public void moveToOpenx2() {
    model1.startGame(deck3, 4, 4, false);
    model1.move(PileType.CASCADE, 3, 12, PileType.OPEN, 0);
    // move another card to the same open pile, should return error as open piles can only hold one
    model1.move(PileType.CASCADE, 3, 11, PileType.OPEN, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void moveToOpenInvalidPileIndexOvr() {
    model1.startGame(deck, 4, 4, false);
    model1.move(PileType.CASCADE, 3, 12, PileType.OPEN, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void moveToOpenInvalidPileIndexUndr() {
    model1.startGame(deck, 4, 4, false);
    model1.move(PileType.CASCADE, 3, 12, PileType.OPEN, -1);
  }

  @Test
  public void moveToCascade() {
    model1.startGame(deck3, 4, 4, false);
    // moves AceSpades into open pile
    model1.move(PileType.CASCADE, 3, 12, PileType.OPEN, 0);
    assertEquals(12, model1.getNumCardsInCascadePile(3));
    // move AceHearts after 2Spades
    model1.move(PileType.CASCADE, 2, 12, PileType.CASCADE, 3);
    assertEquals(12, model1.getNumCardsInCascadePile(2));
    assertEquals(new Card(Value.ACE, Suit.HEARTS),
        model1.getCascadeCardAt(3, 12));
  }

  @Test(expected = IllegalArgumentException.class)
  public void moveToCascadeSameColor() {
    model1.startGame(deck, 4, 4, false);
    model1.move(PileType.CASCADE, 3, 12, PileType.OPEN, 0);
    // AceClub moved to the slot after 2Spades
    model1.move(PileType.CASCADE, 0, 12, PileType.CASCADE, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void moveToCascadeSmallerValue() {
    model1.startGame(deck, 4, 4, false);
    model1.move(PileType.CASCADE, 3, 12, PileType.OPEN, 0);
    model1.move(PileType.CASCADE, 3, 11, PileType.OPEN, 1);
    // AceHearts moved to the slot after 3Spades
    model1.move(PileType.CASCADE, 2, 12, PileType.CASCADE, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void moveToCascadeBiggerValue() {
    model1.startGame(deck, 4, 4, false);
    model1.move(PileType.CASCADE, 3, 12, PileType.OPEN, 0);
    // 2Spades moved after AceHearts
    model1.move(PileType.OPEN, 3, 11, PileType.CASCADE, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void moveToCascadeInvalidPileIndexOvr() {
    model1.startGame(deck, 4, 4, false);
    model1.move(PileType.CASCADE, 3, 12, PileType.OPEN, 0);
    model1.move(PileType.CASCADE, 2, 12, PileType.CASCADE, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void moveToCascadeInvalidPileIndexUndr() {
    model1.startGame(deck, 4, 4, false);
    model1.move(PileType.CASCADE, 3, 12, PileType.OPEN, 0);
    model1.move(PileType.CASCADE, 2, 12, PileType.CASCADE, -1);
  }

  @Test
  public void moveToFoundation() {
    model1.startGame(deck3, 4, 4, false);
    // move AceClubs to first foundation pile
    model1.move(PileType.CASCADE, 0, 12, PileType.FOUNDATION, 0);
    assertEquals(12, model1.getNumCardsInCascadePile(0));
    assertEquals(new Card(Value.ACE, Suit.CLUBS), model1.getFoundationCardAt(0, 0));

    // move 2Clubs to first foundation pile
    model1.move(PileType.CASCADE, 0, 11, PileType.FOUNDATION, 0);
    assertEquals(11, model1.getNumCardsInCascadePile(0));

    assertEquals(2, model1.getNumCardsInFoundationPile(0));
    assertEquals(new Card(Value.TWO, Suit.CLUBS), model1.getFoundationCardAt(0, 1));
  }

  @Test(expected = IllegalArgumentException.class)
  public void moveToFoundationErrDiffSuit() {
    model1.startGame(deck3, 4, 4, false);
    // move AceClubs to first foundation pile
    model1.move(PileType.CASCADE, 0, 12, PileType.FOUNDATION, 0);
    model1.move(PileType.CASCADE, 1, 12, PileType.OPEN, 0);
    // move 2Diamonds to first foundation pile
    model1.move(PileType.CASCADE, 1, 11, PileType.FOUNDATION, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void moveToFoundationWrongStartCard() {
    model1.startGame(deck3, 4, 4, false);
    model1.move(PileType.CASCADE, 0, 12, PileType.OPEN, 0);
    // move 2Clubs to first foundation pile
    model1.move(PileType.CASCADE, 0, 11, PileType.FOUNDATION, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void moveToFoundationWrongNextCard() {
    model1.startGame(deck3, 4, 4, false);
    // move AceClubs to first foundation pile
    model1.move(PileType.CASCADE, 0, 12, PileType.FOUNDATION, 0);
    model1.move(PileType.CASCADE, 0, 11, PileType.OPEN, 0);
    // move 3Clubs to first foundation pile
    model1.move(PileType.CASCADE, 0, 10, PileType.FOUNDATION, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void moveToFoundationInvalidPileIndexOvr() {
    model1.startGame(deck, 4, 4, false);
    model1.move(PileType.CASCADE, 3, 12, PileType.FOUNDATION, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void moveFromFoundationInvalidPileIndexUndr() {
    model1.startGame(deck, 4, 4, false);
    model1.move(PileType.CASCADE, 3, 12, PileType.FOUNDATION, -1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void moveFromCascadeErrNotTop() {
    model1.startGame(deck3, 4, 4, false);
    model1.move(PileType.CASCADE, 0, 11, PileType.OPEN, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void moveFromCascadeErrNoCard() {
    model1.startGame(deck3, 4, 4, false);
    model1.move(PileType.CASCADE, 0, 12, PileType.OPEN, 0);
    model1.move(PileType.CASCADE, 0, 11, PileType.OPEN, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void moveFromCascadeInvalidCardIndexOvr() {
    model1.startGame(deck, 4, 4, false);
    model1.move(PileType.CASCADE, 3, 12, PileType.OPEN, 0);
    model1.move(PileType.CASCADE, 2, 15, PileType.CASCADE, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void moveFromCascadeInvalidCardIndexUndr() {
    model1.startGame(deck, 4, 4, false);
    model1.move(PileType.CASCADE, 3, 12, PileType.OPEN, 0);
    model1.move(PileType.CASCADE, 2, -1, PileType.CASCADE, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void moveFromOpenNoCard() {
    model1.startGame(deck, 4, 4, false);
    model1.move(PileType.OPEN, 0, 0, PileType.OPEN, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void moveFromOpenInvalidPileIndexOvr() {
    model1.startGame(deck3, 4, 4, false);
    model1.move(PileType.CASCADE, 0, 12, PileType.OPEN, 0);
    model1.move(PileType.OPEN, 5, 0, PileType.OPEN, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void moveFromOpenInvalidPileIndexUndr() {
    model1.startGame(deck3, 4, 4, false);
    model1.move(PileType.CASCADE, 0, 12, PileType.OPEN, 0);
    model1.move(PileType.OPEN, -1, 0, PileType.OPEN, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void moveFromFoundation() {
    model1.startGame(deck3, 4, 4, false);
    model1.move(PileType.CASCADE, 0, 12, PileType.FOUNDATION, 0);
    model1.move(PileType.FOUNDATION, 0, 0, PileType.OPEN, 0);
  }

  @Test
  public void isGameOver() {
    model1.startGame(deck3, 4, 4, false);
    assertFalse(model1.isGameOver());
    // All clubs cards to first foundation pile
    model1.move(PileType.CASCADE, 0, 12, PileType.FOUNDATION, 0);
    model1.move(PileType.CASCADE, 0, 11, PileType.FOUNDATION, 0);
    model1.move(PileType.CASCADE, 0, 10, PileType.FOUNDATION, 0);
    model1.move(PileType.CASCADE, 0, 9, PileType.FOUNDATION, 0);
    model1.move(PileType.CASCADE, 0, 8, PileType.FOUNDATION, 0);
    model1.move(PileType.CASCADE, 0, 7, PileType.FOUNDATION, 0);
    model1.move(PileType.CASCADE, 0, 6, PileType.FOUNDATION, 0);
    model1.move(PileType.CASCADE, 0, 5, PileType.FOUNDATION, 0);
    model1.move(PileType.CASCADE, 0, 4, PileType.FOUNDATION, 0);
    model1.move(PileType.CASCADE, 0, 3, PileType.FOUNDATION, 0);
    model1.move(PileType.CASCADE, 0, 2, PileType.FOUNDATION, 0);
    model1.move(PileType.CASCADE, 0, 1, PileType.FOUNDATION, 0);
    model1.move(PileType.CASCADE, 0, 0, PileType.FOUNDATION, 0);

    assertFalse(model1.isGameOver());

    // All diamond cards to second foundation pile
    model1.move(PileType.CASCADE, 1, 12, PileType.FOUNDATION, 1);
    model1.move(PileType.CASCADE, 1, 11, PileType.FOUNDATION, 1);
    model1.move(PileType.CASCADE, 1, 10, PileType.FOUNDATION, 1);
    model1.move(PileType.CASCADE, 1, 9, PileType.FOUNDATION, 1);
    model1.move(PileType.CASCADE, 1, 8, PileType.FOUNDATION, 1);
    model1.move(PileType.CASCADE, 1, 7, PileType.FOUNDATION, 1);
    model1.move(PileType.CASCADE, 1, 6, PileType.FOUNDATION, 1);
    model1.move(PileType.CASCADE, 1, 5, PileType.FOUNDATION, 1);
    model1.move(PileType.CASCADE, 1, 4, PileType.FOUNDATION, 1);
    model1.move(PileType.CASCADE, 1, 3, PileType.FOUNDATION, 1);
    model1.move(PileType.CASCADE, 1, 2, PileType.FOUNDATION, 1);
    model1.move(PileType.CASCADE, 1, 1, PileType.FOUNDATION, 1);
    model1.move(PileType.CASCADE, 1, 0, PileType.FOUNDATION, 1);

    assertFalse(model1.isGameOver());

    // All hearts cards to third foundation pile
    model1.move(PileType.CASCADE, 2, 12, PileType.FOUNDATION, 2);
    model1.move(PileType.CASCADE, 2, 11, PileType.FOUNDATION, 2);
    model1.move(PileType.CASCADE, 2, 10, PileType.FOUNDATION, 2);
    model1.move(PileType.CASCADE, 2, 9, PileType.FOUNDATION, 2);
    model1.move(PileType.CASCADE, 2, 8, PileType.FOUNDATION, 2);
    model1.move(PileType.CASCADE, 2, 7, PileType.FOUNDATION, 2);
    model1.move(PileType.CASCADE, 2, 6, PileType.FOUNDATION, 2);
    model1.move(PileType.CASCADE, 2, 5, PileType.FOUNDATION, 2);
    model1.move(PileType.CASCADE, 2, 4, PileType.FOUNDATION, 2);
    model1.move(PileType.CASCADE, 2, 3, PileType.FOUNDATION, 2);
    model1.move(PileType.CASCADE, 2, 2, PileType.FOUNDATION, 2);
    model1.move(PileType.CASCADE, 2, 1, PileType.FOUNDATION, 2);
    model1.move(PileType.CASCADE, 2, 0, PileType.FOUNDATION, 2);

    assertFalse(model1.isGameOver());

    // All spades cards to third foundation pile
    model1.move(PileType.CASCADE, 3, 12, PileType.FOUNDATION, 3);
    model1.move(PileType.CASCADE, 3, 11, PileType.FOUNDATION, 3);
    model1.move(PileType.CASCADE, 3, 10, PileType.FOUNDATION, 3);
    model1.move(PileType.CASCADE, 3, 9, PileType.FOUNDATION, 3);
    model1.move(PileType.CASCADE, 3, 8, PileType.FOUNDATION, 3);
    model1.move(PileType.CASCADE, 3, 7, PileType.FOUNDATION, 3);
    model1.move(PileType.CASCADE, 3, 6, PileType.FOUNDATION, 3);
    model1.move(PileType.CASCADE, 3, 5, PileType.FOUNDATION, 3);
    model1.move(PileType.CASCADE, 3, 4, PileType.FOUNDATION, 3);
    model1.move(PileType.CASCADE, 3, 3, PileType.FOUNDATION, 3);
    model1.move(PileType.CASCADE, 3, 2, PileType.FOUNDATION, 3);
    model1.move(PileType.CASCADE, 3, 1, PileType.FOUNDATION, 3);
    model1.move(PileType.CASCADE, 3, 0, PileType.FOUNDATION, 3);
    // Foundation piles are full
    assertTrue(model1.isGameOver());
  }

  @Test
  public void getNumCardsInFoundationPile() {
    model1.startGame(deck3, 4, 4, false);
    assertEquals(0, model1.getNumCardsInFoundationPile(0));
    model1.move(PileType.CASCADE, 0, 12, PileType.FOUNDATION, 0);
    assertEquals(1, model1.getNumCardsInFoundationPile(0));
    assertEquals(0, model1.getNumCardsInFoundationPile(1));
    model1.move(PileType.CASCADE, 0, 11, PileType.FOUNDATION, 0);
    assertEquals(2, model1.getNumCardsInFoundationPile(0));
  }

  @Test(expected = IllegalStateException.class)
  public void getNumCardsInFoundationPileErrGameState() {
    model1.getNumCardsInFoundationPile(0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void getNumCardsInFoundationPileErrUnderIndex() {
    model1.startGame(deck3, 4, 4, false);
    model1.getNumCardsInFoundationPile(-1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void getNumCardsInFoundationPileErrOverIndex() {
    model1.startGame(deck3, 4, 4, false);
    model1.getNumCardsInFoundationPile(6);
  }

  @Test
  public void getNumCascadePiles() {
    model1.startGame(deck3, 4, 3, false);
    assertEquals(4, model1.getNumCascadePiles());

    model1.startGame(deck3, 6, 1, false);
    assertEquals(6, model1.getNumCascadePiles());
  }

  @Test
  public void getNumCascadePilesGameState() {
    assertEquals(-1, model1.getNumCascadePiles());
  }

  @Test(expected = IllegalStateException.class)
  public void getNumCardsInCascadePileErrGameState() {
    model1.getNumCardsInCascadePile(0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void getNumCardsInCascadePileErrUnderIndex() {
    model1.startGame(deck3, 4, 4, false);
    model1.getNumCardsInCascadePile(-1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void getNumCardsInCascadePileErrOverIndex() {
    model1.startGame(deck3, 4, 4, false);
    model1.getNumCardsInCascadePile(5);
  }

  @Test
  public void getNumCardsInCascadePile() {
    model1.startGame(deck3, 4, 4, false);
    assertEquals(13, model1.getNumCardsInCascadePile(0));
    model1.move(PileType.CASCADE, 0, 12, PileType.OPEN, 0);
    assertEquals(12, model1.getNumCardsInCascadePile(0));
  }

  @Test
  public void getNumCardsInOpenPile() {
    model1.startGame(deck3, 4, 4, false);
    assertEquals(0, model1.getNumCardsInOpenPile(0));
    model1.move(PileType.CASCADE, 0, 12, PileType.OPEN, 0);
    assertEquals(1, model1.getNumCardsInOpenPile(0));
    assertEquals(0, model1.getNumCardsInOpenPile(1));
    model1.move(PileType.OPEN, 0, 0, PileType.FOUNDATION, 0);
    assertEquals(0, model1.getNumCardsInOpenPile(0));
  }

  @Test(expected = IllegalStateException.class)
  public void getNumCardsInOpenPileErrGameState() {
    model1.getNumCardsInOpenPile(0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void getNumCardsInOpenPileErrUnderIndex() {
    model1.startGame(deck3, 4, 4, false);
    model1.getNumCardsInOpenPile(-1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void getNumCardsInOpenPileErrOverIndex() {
    model1.startGame(deck3, 4, 4, false);
    model1.getNumCardsInOpenPile(6);
  }

  @Test
  public void getNumOpenPiles() {
    model1.startGame(deck3, 5, 4, false);
    assertEquals(4, model1.getNumOpenPiles());

    model1.startGame(deck, 4, 6, false);
    assertEquals(6, model1.getNumOpenPiles());
  }

  @Test
  public void getNumOpenPilesGameState() {
    assertEquals(-1, model1.getNumOpenPiles());
  }

  @Test
  public void getFoundationCardAt() {
    model1.startGame(deck3, 4, 4, false);
    model1.move(PileType.CASCADE, 0, 12, PileType.FOUNDATION, 0);
    assertEquals(new Card(Value.ACE, Suit.CLUBS), model1.getFoundationCardAt(0, 0));
    model1.move(PileType.CASCADE, 0, 11, PileType.FOUNDATION, 0);
    assertEquals(new Card(Value.TWO, Suit.CLUBS), model1.getFoundationCardAt(0, 1));
  }

  @Test(expected = IllegalStateException.class)
  public void getFoundationCardAtErrGameState() {
    model1.getFoundationCardAt(0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void getFoundationCardAtErrNoCard() {
    model1.startGame(deck3, 4, 4, false);
    model1.getFoundationCardAt(0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void getFoundationCardAtErrOverPileIndex() {
    model1.startGame(deck3, 4, 4, false);
    model1.getFoundationCardAt(5, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void getFoundationCardAtErrOverCardIndex() {
    model1.startGame(deck3, 4, 4, false);
    model1.move(PileType.CASCADE, 0, 12, PileType.FOUNDATION, 0);
    model1.getFoundationCardAt(0, 1);
  }

  @Test
  public void getCascadeCardAt() {
    model1.startGame(deck3, 4, 4, false);
    assertEquals(new Card(Value.KING, Suit.CLUBS), model1.getCascadeCardAt(0, 0));
  }

  @Test(expected = IllegalStateException.class)
  public void getCascadeCardAtErrGameState() {
    model1.getCascadeCardAt(0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void getCascadeCardAtErrNoCard() {
    model1.startGame(deck3, 4, 4, false);
    model1.move(PileType.CASCADE, 0, 12, PileType.OPEN, 0);
    model1.getCascadeCardAt(0, 12);
  }

  @Test(expected = IllegalArgumentException.class)
  public void getCascadeCardAtErrOverPileIndex() {
    model1.startGame(deck3, 4, 4, false);
    model1.getCascadeCardAt(5, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void getCascadeCardAtErrOverCardIndex() {
    model1.startGame(deck3, 4, 4, false);
    model1.move(PileType.CASCADE, 0, 12, PileType.FOUNDATION, 0);
    model1.getCascadeCardAt(0, 12);
  }

  @Test
  public void getOpenCardAt() {
    model1.startGame(deck3, 4, 4, false);
    model1.move(PileType.CASCADE, 0, 12, PileType.OPEN, 0);
    assertEquals(acC, model1.getOpenCardAt(0));
  }

  @Test
  public void getOpenCardAtNoCard() {
    model1.startGame(deck3, 4, 4, false);
    assertEquals(null, model1.getOpenCardAt(0));
  }

  @Test(expected = IllegalStateException.class)
  public void getOpenCardAtErrGameState() {
    model1.getOpenCardAt(0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void getOpenCardAtErrPileIndes() {
    model1.startGame(deck3, 4, 4, false);
    model1.getOpenCardAt(4);
  }
}
