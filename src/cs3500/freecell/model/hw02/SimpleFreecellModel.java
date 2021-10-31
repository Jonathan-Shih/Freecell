package cs3500.freecell.model.hw02;

import cs3500.freecell.model.FreecellModel;
import cs3500.freecell.model.PileType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class representing a {@code SimpleFreecellModel}.
 * A game of Freecell, users will call start game with the
 * correct parameters to play.
 */

public class SimpleFreecellModel implements FreecellModel<Card> {

  protected ArrayList<ArrayList<Card>> open;
  protected ArrayList<ArrayList<Card>> cascade;
  protected ArrayList<ArrayList<Card>> foundation;
  protected boolean gameStart = false;

  /* creates a deck simulating a new deck of cards
   * cards are created from (Ace - King) in each of their suits,
   * e.g. A-K of clubs then A-K of Diamonds... etc.
   */
  @Override
  public List<Card> getDeck() {
    List<Card> deck = new ArrayList();
    for (Value v : Value.values()) {
      for (Suit s : Suit.values()) {
        deck.add(new Card(v, s));
      }
    }

    if (!isValid(deck)) {
      throw new IllegalArgumentException("invalid deck");
    }
    return deck;
  }

  // is the given deck valid
  private boolean isValid(List<Card> deck) {
    boolean valid = true;
    if (deck == null) {
      return false;
    }
    if (deck.size() != 52) {
      valid = false;
    }
    if (hasDup(deck)) {
      valid = false;
    }

    String values = "A12345678910JQK";
    String suits = "♣♦♥♠";
    for (Card c : deck) {
      if (!values.contains(c.getValue().toString()) || !suits.contains(c.getSuit().toString())) {
        valid = false;
      }
    }

    return valid;
  }

  // does the given deck contain duplicates
  private boolean hasDup(List<Card> deck) {
    boolean dupe = false;
    List<Card> seen = new ArrayList<Card>();
    for (Card c : deck) {
      if (!seen.contains(c)) {
        seen.add(c);
      } else {
        dupe = true;
      }
    }
    return dupe;
  }

  @Override
  public void startGame(List<Card> deck, int numCascadePiles, int numOpenPiles, boolean shuffle)
      throws IllegalArgumentException {
    cascade = new ArrayList<ArrayList<Card>>();
    open = new ArrayList<ArrayList<Card>>();
    foundation = new ArrayList<ArrayList<Card>>();
    if (deck == null) {
      throw new IllegalArgumentException("Deck cannot be null");
    }
    // check for errors
    if (numOpenPiles < 1) {
      throw new IllegalArgumentException("Cannot have less than 1 Open pile");
    }
    if (numCascadePiles < 4) {
      throw new IllegalArgumentException("Cannot have less than 4 Cascade piles");
    }
    if (!isValid(deck)) {
      throw new IllegalArgumentException("Provided deck is invalid");
    }
    // initialize our values
    for (int i = 0; i < numCascadePiles; i++) {
      cascade.add(new ArrayList<Card>());
    }
    for (int i = 0; i < numOpenPiles; i++) {
      open.add(new ArrayList<Card>());
    }
    for (int i = 0; i < 4; i++) {
      foundation.add(new ArrayList<Card>());
    }
    if (shuffle) {
      Collections.shuffle(deck);
    }
    // "deals" the cards in our deck to the cascade
    for (int i = 0; i < deck.size(); i++) {
      cascade.get(i % numCascadePiles).add(deck.get(i));
    }
    gameStart = true;
  }

  @Override
  public void move(PileType source, int pileNumber, int cardIndex, PileType destination,
      int destPileNumber) throws IllegalArgumentException, IllegalStateException {
    if (!gameStart) {
      throw new IllegalStateException("Game has not started yet");
    }
    if (source == null || destination == null) {
      throw new IllegalArgumentException("Given pileType cannot be null");
    }
    moveHelp(source, pileNumber, cardIndex, destination, destPileNumber);
  }

  //
  private void moveHelp(PileType source, int pileNumber, int cardIndex,
      PileType dest, int destPileNumber) throws IllegalArgumentException {
    if (source == null || dest == null) {
      throw new IllegalArgumentException("Given pileType cannot be null");
    }
    ArrayList<ArrayList<Card>> from;
    ArrayList<ArrayList<Card>> to;
    switch (source) {
      case OPEN:
        from = open;
        break;
      case CASCADE:
        from = cascade;
        break;
      case FOUNDATION:
        from = foundation;
        break;
      default:
        from = new ArrayList<ArrayList<Card>>();
    }
    switch (dest) {
      case OPEN:
        to = open;
        break;
      case CASCADE:
        to = cascade;
        break;
      case FOUNDATION:
        to = foundation;
        break;
      default:
        to = new ArrayList<ArrayList<Card>>();
    }
    if (pileNumber < from.size() && pileNumber >= 0 && cardIndex < from.get(pileNumber)
        .size() && cardIndex >= 0 && destPileNumber < to.size() && destPileNumber >= 0) {
      if (from.get(pileNumber) == null || from.get(pileNumber).get(cardIndex) == null
          || to.get(destPileNumber) == null) {
        throw new IllegalArgumentException("Given ArrayList cannot be null");
      }
      if ((source.equals(PileType.CASCADE) && cardIndex != from.get(pileNumber).size() - 1)
          || (source.equals(PileType.FOUNDATION))) {
        throw new IllegalArgumentException("Move is not possible");
      }
      // if the given conditions of the destination pile are valid
      if (checkCond(from.get(pileNumber).get(cardIndex),
          to.get(destPileNumber), dest)) {
        // conditions pass, add card to destination pile
        to.get(destPileNumber).add(from.get(pileNumber).remove(cardIndex));
      } else {
        // conditions dont pass, throw exception
        throw new IllegalArgumentException("Move is not possible");
      }
    } else {
      throw new IllegalArgumentException("Move is not possible");
    }
  }

  // checks the conditions of the given pile and determines if the given card
  // can be moved there, based on the conditions set in pileType
  private boolean checkCond(Card cur, ArrayList<Card> dest, PileType pile) {
    switch (pile) {
      case FOUNDATION:
        if (dest.size() == 0 && cur.getValue() == Value.ACE) {
          return true;
        } else {
          return (dest.size() > 0 && cur.getValue().after(dest.get(dest.size() - 1).getValue())
              && cur.getSuit().equals(dest.get(dest.size() - 1).getSuit()));
        }
      case OPEN:
        return dest.size() == 0;
      case CASCADE:
        if (dest.size() == 0 && cur.getValue() == Value.KING) {
          return true;
        } else {
          return (dest.size() > 0 && cur.getValue().before(dest.get(dest.size() - 1).getValue())
              && cur.getSuit().getColor() != dest.get(dest.size() - 1).getSuit().getColor());
        }
      default:
        return false;
    }
  }

  @Override
  public boolean isGameOver() {
    boolean valid = true;
    for (ArrayList<Card> fpile : foundation) {
      if (fpile.size() != 13) {
        return false;
      }
      for (int i = 1; i < 13; i++) {
        if (fpile.get(i) == null) {
          return false;
        }
        valid = fpile.get(i).getValue().after(fpile.get(i - 1).getValue()) && fpile.get(i).getSuit()
            .equals(fpile.get(i - 1).getSuit());
      }
    }
    return valid;
  }

  @Override
  public int getNumCardsInFoundationPile(int index)
      throws IllegalArgumentException, IllegalStateException {
    return getNumCardsInPile(foundation, index);
  }

  @Override
  public int getNumCascadePiles() {
    return getNumPiles(cascade);
  }

  @Override
  public int getNumCardsInCascadePile(int index)
      throws IllegalArgumentException, IllegalStateException {
    return getNumCardsInPile(cascade, index);
  }

  @Override
  public int getNumCardsInOpenPile(int index)
      throws IllegalArgumentException, IllegalStateException {
    return getNumCardsInPile(open, index);
  }

  @Override
  public int getNumOpenPiles() {
    return getNumPiles(open);
  }

  // gets the amount of cards in the given piletype from the given index
  private int getNumCardsInPile(ArrayList<ArrayList<Card>> pile, int index)
      throws IllegalStateException, IllegalArgumentException {
    if (!gameStart) {
      throw new IllegalStateException("Game has not started yet");
    }
    if (index < 0 || index > pile.size() - 1) {
      throw new IllegalArgumentException("Invalid index");
    }
    return pile.get(index).size();
  }

  // gets the amount of piles in the given type
  private int getNumPiles(ArrayList<ArrayList<Card>> pile) {
    if (!gameStart) {
      return -1;
    } else {
      return pile.size();
    }
  }

  @Override
  public Card getFoundationCardAt(int pileIndex, int cardIndex)
      throws IllegalArgumentException, IllegalStateException {
    return getCardAtIndex(foundation, pileIndex, cardIndex, PileType.FOUNDATION);
  }

  @Override
  public Card getCascadeCardAt(int pileIndex, int cardIndex)
      throws IllegalArgumentException, IllegalStateException {
    return getCardAtIndex(cascade, pileIndex, cardIndex, PileType.CASCADE);
  }

  @Override
  public Card getOpenCardAt(int pileIndex) throws IllegalArgumentException, IllegalStateException {
    return getCardAtIndex(open, pileIndex, 0, PileType.OPEN);
  }

  private Card getCardAtIndex(ArrayList<ArrayList<Card>> pile, int pileIndex, int cardIndex,
      PileType p)
      throws IllegalArgumentException, IllegalStateException {
    if (!gameStart) {
      throw new IllegalStateException("Game has not started yet");
    }

    if (pileIndex < 0 || pileIndex > pile.size() - 1) {
      throw new IllegalArgumentException("Invalid pile index");
    }
    // if the given pile is the open pileType, return statement takes us out of method
    if (p.equals(PileType.OPEN)) {
      // return null if there are no cards
      if (open.get(pileIndex).size() == 0) {
        return null;
      } else {
        // returns the first card at the given pileindex
        return open.get(pileIndex).get(0);
      }
      // other pileTypes, check for cardIndex
    } else {
      if (cardIndex < 0 || cardIndex > pile.get(pileIndex).size() - 1) {
        throw new IllegalArgumentException("Invalid card index");
      }
      return pile.get(pileIndex).get(cardIndex);
    }
  }
}
