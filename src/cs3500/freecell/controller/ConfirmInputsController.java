package cs3500.freecell.controller;

import cs3500.freecell.model.FreecellModel;
import cs3500.freecell.model.PileType;
import cs3500.freecell.model.hw02.Card;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * Mock class for {@link SimpleFreecellController}.
 * Appends the given inputs to the given appendable.
 * Used to confirm user inputs.
 */
public class ConfirmInputsController implements FreecellController<Card> {

  private final Scanner scanner;
  private final Appendable ap;
  FreecellModel<Card> model;

  /**
   * Constructor for this class.
   * @param model  FreecellModel
   * @param rd     User inputs (Readable)
   * @param ap     Output Appendable
   * @throws IllegalArgumentException If provided Readable or Appendable is null
   */
  public ConfirmInputsController(FreecellModel<Card> model, Readable rd, Appendable ap)
      throws IllegalArgumentException {
    if (rd == null || ap == null) {
      throw new IllegalArgumentException("Readable and/or Appendable cannot be null");
    }
    this.scanner = new Scanner(rd);
    this.model = model;
    this.ap = ap;
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
        ap.append("Could not start game.");
      }
      int i = 0;
      while (scanner.hasNext()) {
        String input = scanner.next();
        if (input.equalsIgnoreCase("Q")) {
          ap.append("Game quit prematurely.");
          return;
        }
        if (i % 3 == 0) {
          try {
            ptype(input);
            getPileIndex(input);
            ap.append("Source pile: " + input + "\n");
          } catch (IllegalArgumentException iae) {
            ap.append("Invalid source pile: " + input + ", please try again\n");
            continue;
          }
        }
        if (i % 3 == 1) {
          try {
            Integer.valueOf(input);
            getPileIndex(input);
            ap.append("Card index: " + input + "\n");
          } catch (NumberFormatException nfe) {
            ap.append("Invalid card index: " + input + ", please try again\n");
            continue;
          }
        }
        if (i % 3 == 2) {
          try {
            ptype(input);
            getPileIndex(input);
            ap.append("Destination pile: " + input + "\n");
          } catch (IllegalArgumentException iae) {
            ap.append("Invalid destination pile: " + input + ", please try again\n");
            continue;
          }
        }
        i++;
        if (model.isGameOver()) {
          ap.append("Game over.");
          break;
        }
      }
    } catch (IOException ioe) {
      throw new IllegalStateException("Could not append.");
    }
    if (!(scanner.hasNext() || model.isGameOver())) {
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
    String idx = "";
    for (int i = 1; i < in.length(); i++) {
      idx += in.charAt(i);
    }
    try {
      return Integer.valueOf(idx);
    } catch (NumberFormatException nfe) {
      throw new IllegalArgumentException("Invalid pile index");
    }
  }
}
