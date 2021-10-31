package cs3500.freecell.view;

import cs3500.freecell.model.FreecellModelState;
import cs3500.freecell.model.PileType;
import cs3500.freecell.model.hw02.SimpleFreecellModel;
import java.io.IOException;

/**
 * Represents a text view of a {@link SimpleFreecellModel}.
 */
public class FreecellTextView implements FreecellView {

  private FreecellModelState<?> state;
  private Appendable ap;

  public FreecellTextView(FreecellModelState<?> state) {
    this.state = state;
  }

  public FreecellTextView(FreecellModelState<?> state, Appendable ap) {
    this.state = state;
    this.ap = ap;
  }

  @Override
  public String toString() {
    if (state.getNumCascadePiles() == -1 || state.getNumOpenPiles() == -1) {
      return "";
    }

    String result = "";
    result += toStringHelpPile(PileType.FOUNDATION);
    result += "\n";
    result += toStringHelpPile(PileType.OPEN);
    result += "\n";
    result += toStringHelpPile(PileType.CASCADE);

    return result;
  }

  @Override
  public void renderBoard() throws IOException {
    if (ap == null) {
      System.out.println(state.toString());
    }
    ap.append(this.toString() + "\n");
  }

  @Override
  public void renderMessage(String message) throws IOException {
    if (ap == null) {
      System.out.println(message);
    }
    if (message == null) {
      return;
    }
    ap.append(message);
  }

  private String toStringHelpPile(PileType pile) {
    String starter;
    String result = "";
    int numPiles;
    switch (pile) {
      case OPEN:
        starter = "O";
        numPiles = state.getNumOpenPiles();
        break;
      case CASCADE:
        starter = "C";
        numPiles = state.getNumCascadePiles();
        break;
      case FOUNDATION:
        starter = "F";
        numPiles = 4;
        break;
      default:
        starter = "";
        numPiles = 0;
    }
    for (int i = 0; i < numPiles; i++) {
      int numCards;
      switch (pile) {
        case OPEN:
          numCards = state.getNumCardsInOpenPile(i);
          break;
        case CASCADE:
          numCards = state.getNumCardsInCascadePile(i);
          break;
        case FOUNDATION:
          numCards = state.getNumCardsInFoundationPile(i);
          break;
        default:
          numCards = 0;
      }
      result += starter + (i + 1) + ":" + toStringHelpCard(pile, i, numCards);
    }
    return result;
  }

  private String toStringHelpCard(PileType pile, int pileNum, int numCards) {
    String result = "";
    int totalNumPiles;
    switch (pile) {
      case OPEN:
        totalNumPiles = state.getNumOpenPiles();
        break;
      case CASCADE:
        totalNumPiles = state.getNumCascadePiles();
        break;
      case FOUNDATION:
        totalNumPiles = 4;
        break;
      default:
        totalNumPiles = 0;
    }
    // if there are no cards in the pile, new line
    if (numCards == 0 && pileNum != totalNumPiles - 1) {
      result += "\n";
    }

    for (int j = 0; j < numCards; j++) {
      String cur;
      switch (pile) {
        case OPEN:
          cur = state.getOpenCardAt(pileNum).toString();
          break;
        case CASCADE:
          cur = state.getCascadeCardAt(pileNum, j).toString();
          break;
        case FOUNDATION:
          cur = state.getFoundationCardAt(pileNum, j).toString();
          break;
        default:
          cur = "";
      }

      // last card in the pile, last pile in pileType, no comma
      if (j == numCards - 1 && pileNum == totalNumPiles - 1) {
        result += " " + cur;
        // last card in pile =, no comma, new line
      } else if (j == numCards - 1) {
        result += " " + cur + "\n";
      } else {
        result += " " + cur + ",";
      }
    }
    return result;
  }
}
