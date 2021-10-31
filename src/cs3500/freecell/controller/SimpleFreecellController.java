package cs3500.freecell.controller;

import cs3500.freecell.model.FreecellModel;
import cs3500.freecell.model.PileType;
import cs3500.freecell.model.hw02.Card;
import cs3500.freecell.view.FreecellTextView;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * Simple controller for {@link FreecellModel}, allows user to play the game through various
 * inputs.
 */
public class SimpleFreecellController implements FreecellController<Card> {

  private final FreecellTextView view;
  private final Scanner scanner;
  private FreecellModel<Card> model;
  private PileType sourcePile;
  private PileType destPile;
  private int sourcePileIndex;
  private int cardIdx;
  private int destPileIndex;

  /**
   * Constructor for {@link SimpleFreecellController}.
   * @param model {@link FreecellModel}
   * @param rd Provided Readable (User Inputs)
   * @param ap Provided Appendable (Store results)
   * @throws IllegalArgumentException If provided Readable or Appendable are null
   */
  public SimpleFreecellController(FreecellModel<Card> model, Readable rd, Appendable ap)
      throws IllegalArgumentException {
    if (rd == null || ap == null) {
      throw new IllegalArgumentException("Readable and/or Appendable cannot be null");
    }
    this.scanner = new Scanner(rd);
    this.model = model;
    view = new FreecellTextView(model, ap);
  }

  @Override
  public void playGame(List<Card> deck, int numCascades, int numOpens, boolean shuffle)
      throws IllegalStateException, IllegalArgumentException {

    if (model == null || deck == null) {
      throw new IllegalArgumentException("Model and/or deck cannot be null");
    }
    try {
      try {
        model.startGame(deck, numCascades, numOpens, shuffle);
      } catch (IllegalArgumentException iae) {
        view.renderMessage("Could not start game.");
        return;
      }
      view.renderBoard();
      int i = 0;
      while (scanner.hasNext()) {
        String input = scanner.next();
        if (input.equalsIgnoreCase("Q")) {
          view.renderMessage("Game quit prematurely.");
          return;
        }
        if (i % 3 == 0) {
          try {
            sourcePile = ptype(input);
            sourcePileIndex = getPileIndex(input) - 1;
          } catch (IllegalArgumentException iae) {
            view.renderMessage("Invalid source pile: " + input + ", please try again\n");
            continue;
          }
        }
        if (i % 3 == 1) {
          try {
            cardIdx = Integer.valueOf(input) - 1;
          } catch (NumberFormatException nfe) {
            view.renderMessage("Invalid card index: " + input + ", please try again\n");
            continue;
          }
        }
        if (i % 3 == 2) {
          try {
            destPile = ptype(input);
            destPileIndex = getPileIndex(input) - 1;
          } catch (IllegalArgumentException iae) {
            view.renderMessage("Invalid destination pile: " + input + ", please try again\n");
            continue;
          }
          try {
            model.move(sourcePile, sourcePileIndex, cardIdx, destPile, destPileIndex);
          } catch (NullPointerException npe) {
            throw new IllegalArgumentException("Source and/or destination cannot be null");
          } catch (IllegalStateException ise) {
            throw new IllegalStateException("Game has not started");
          } catch (IllegalArgumentException iae) {
            view.renderMessage("Invalid move, try again\n");
            i++;
            resetValues();
            continue;
          }
          view.renderBoard();
          resetValues();
        }
        i++;
        if (model.isGameOver()) {
          view.renderMessage("Game over.");
          break;
        }
      }
    } catch (IOException ioe) {
      throw new IllegalStateException("Could not append.");
    }
    if (!model.isGameOver()) {
      throw new IllegalStateException("Out of inputs but game hasn't ended.");
    }
  }

  private PileType ptype(String pile) {
    Character first = pile.charAt(0);
    switch (first) {
      case 'F':
        return PileType.FOUNDATION;
      case 'C':
        return PileType.CASCADE;
      case 'O':
        return PileType.OPEN;
      default:
        throw new IllegalArgumentException("Invalid PileType: " + pile);
    }
  }

  private int getPileIndex(String in) throws IllegalArgumentException {
    String idx = in.substring(1);
    try {
      return Integer.valueOf(idx);
    } catch (NumberFormatException nfe) {
      throw new IllegalArgumentException("Invalid pile index");
    }
  }

  private void resetValues() {
    sourcePile = null;
    sourcePileIndex = 0;
    cardIdx = 0;
    destPile = null;
    destPileIndex = 0;
  }
}
