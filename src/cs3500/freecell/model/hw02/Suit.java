package cs3500.freecell.model.hw02;


/**
 * Represents the {@code Suit} of a {@link Card}.
 */
public enum Suit {
  CLUBS("♣", "Black"), DIAMONDS("♦", "Red"),
  HEARTS("♥", "Red"), SPADES("♠", "Black");

  private final String symbol;
  private final String color;

  /**
   * Constructor for Value enum.
   *
   * @param symbol corresponding symbol of the card
   */
  Suit(String symbol, String color) {
    this.symbol = symbol;
    this.color = color;
  }

  @Override
  public String toString() {
    return symbol;
  }

  /**
   * Getter method for the color.
   *
   * @return color of the current suit
   */
  public String getColor() {
    return color;
  }
}
