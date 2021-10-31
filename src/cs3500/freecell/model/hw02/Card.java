package cs3500.freecell.model.hw02;

import java.util.Objects;

/**
 * Represents a {@code Card}.
 * Holds the Suit and Value of the current card.
 * Used in games like Freecell or Solitaire.
 */
public class Card {

  private final Suit s;
  private final Value v;

  public Card(Value v, Suit s) {
    this.s = s;
    this.v = v;
  }

  @Override
  public String toString() {
    return this.v.toString() + this.s.toString();
  }

  @Override
  public boolean equals(Object c) {
    if (c instanceof Card) {
      Card that = (Card) c;
      return this.s == that.s && this.v == that.v;
    } else {
      return false;
    }
  }

  @Override
  public int hashCode() {
    return Objects.hash(s, v);
  }

  /**
   * Getter method for the suit.
   *
   * @return {@link Suit} of the current Card
   */
  public Suit getSuit() {
    return this.s;
  }

  /**
   * Getter method for the value.
   *
   * @return {@link Value} of the current Card
   */
  public Value getValue() {
    return this.v;
  }
}
