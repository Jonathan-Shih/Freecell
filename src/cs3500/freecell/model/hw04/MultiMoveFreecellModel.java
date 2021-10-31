package cs3500.freecell.model.hw04;

import cs3500.freecell.model.PileType;
import cs3500.freecell.model.hw02.Card;
import cs3500.freecell.model.hw02.SimpleFreecellModel;
import java.util.ArrayList;

/**
 * Class representing a {@code MultiMoveFreecellModel}. A game of Freecell, users will call start
 * game with the correct parameters to play. Different to a {@link SimpleFreecellModel}, users can
 * move multiple cards at the same time.
 */
public class MultiMoveFreecellModel extends SimpleFreecellModel {

  /**
   * Move function for a {@code MultiMoveFreecellModel}. Allows users to move multiple cards at the
   * same time
   *
   * @param source         Source pile type
   * @param pileNumber     Source pile index, starting at 0
   * @param cardIndex      Source card index, starting at 0
   * @param destination    Destination pile type
   * @param destPileNumber Destination pile index, starting at 0
   * @throws IllegalArgumentException if move is invalid
   * @throws IllegalStateException    if game hasnt started
   */
  @Override
  public void move(PileType source, int pileNumber, int cardIndex, PileType destination,
      int destPileNumber) throws IllegalArgumentException, IllegalStateException {
    ArrayList<Card> multiPile;
    if (!gameStart) {
      throw new IllegalStateException("Game has not started yet");
    }
    if (source == null || destination == null) {
      throw new IllegalArgumentException("Given pileType cannot be null");
    }
    if (pileNumber >= getPile(source).size() && pileNumber < 0 && cardIndex >= getPile(source)
        .get(pileNumber).size() && cardIndex < 0 && destPileNumber >= getPile(destination).size()
        && destPileNumber < 0) {
      throw new IllegalArgumentException("Move not possible");
    }
    if (getPile(source).get(pileNumber) == null
        || getPile(source).get(pileNumber).get(cardIndex) == null
        || getPile(destination).get(destPileNumber) == null) {
      throw new IllegalArgumentException("given piles cannot be null");
    }

    switch (source) {
      case OPEN:
        super.move(source, pileNumber, cardIndex, destination, destPileNumber);
        break;
      case FOUNDATION:
        throw new IllegalArgumentException("Cannot move from foundation pile");
      case CASCADE:
        if (!haveSpace((cascade.get(pileNumber).size()) - cardIndex)) {
          throw new IllegalArgumentException("Not enough intermediate slots available");
        }
        try {
          multiPile = getMultiPile(pileNumber, cardIndex);
        } catch (IllegalArgumentException iae) {
          throw new IllegalArgumentException("Invalid build");
        }
        Card first = multiPile.get(0);
        if (multiPile.size() == 1) {
          super.move(PileType.CASCADE, pileNumber, cardIndex, destination, destPileNumber);
        } else if (destination.equals(PileType.CASCADE)) {
          if (cascade.get(destPileNumber).size() == 0) {
            moveHelp(pileNumber, destPileNumber, multiPile);
            return;
          }
          Card destLast = cascade.get(destPileNumber).get(cascade.get(destPileNumber).size() - 1);
          if ((first.getSuit().getColor() != destLast.getSuit().getColor())
              && first.getValue().before(destLast.getValue())) {
            moveHelp(pileNumber, destPileNumber, multiPile);
          } else {
            throw new IllegalArgumentException("Invalid move");
          }
        } else {
          throw new IllegalArgumentException(
              "Cannot move multiple cards into Open/Foundation piles");
        }
        break;
      default:
        throw new IllegalArgumentException("Invalid Source Pile");
    }
  }


  // helper function for getting the pile
  private ArrayList<ArrayList<Card>> getPile(PileType pt) {
    switch (pt) {
      case CASCADE:
        return cascade;
      case OPEN:
        return open;
      case FOUNDATION:
        return foundation;
      default:
        throw new IllegalArgumentException("Invalid PileType");
    }
  }

  // helper method for moving cascade piles to cascade piles
  private void moveHelp(int pileNumber, int destPileNumber, ArrayList<Card> multiPile) {
    cascade.get(destPileNumber).addAll(multiPile);
    cascade.get(pileNumber).removeAll(multiPile);
  }

  // do we have enough slots for a multimove
  private boolean haveSpace(int cards) {
    int emptyOpen = 0;
    int emptyCascade = 0;
    double maxMove = 0;
    for (ArrayList<Card> o : open) {
      if (o.size() == 0) {
        emptyOpen++;
      }
    }
    for (ArrayList<Card> c : cascade) {
      if (c.size() == 0) {
        emptyCascade++;
      }
    }
    maxMove = (emptyOpen + 1) * Math.pow(2, emptyCascade);
    return (cards <= maxMove);
  }

  // returns the cards the player is trying to move
  private ArrayList<Card> getMultiPile(int pileNumber, int cardIndex) {
    ArrayList<Card> multiPile = new ArrayList<>();
    for (int i = cardIndex; i < cascade.get(pileNumber).size(); i++) {
      multiPile.add(cascade.get(pileNumber).get(i));
    }
    if (validBuild(multiPile)) {
      return multiPile;
    } else {
      throw new IllegalArgumentException("not valid build");
    }
  }

  // is the given arraylist of cards a valid build
  private boolean validBuild(ArrayList<Card> multiPile) {
    boolean valid = false;
    if (multiPile.size() == 1) {
      return true;
    }
    for (int i = 1; i < multiPile.size(); i++) {
      valid = multiPile.get(i).getValue().before(multiPile.get(i - 1).getValue())
          && !(multiPile.get(i).getSuit().getColor()
          .equals(multiPile.get(i - 1).getSuit().getColor()));
    }
    return valid;
  }
}

