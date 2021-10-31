package cs3500.freecell.model.hw02;

/**
 * Represents the {@code Value} of a {@link Card}.
 */
public enum Value {
  KING(13), QUEEN(12), JACK(11), TEN(10), NINE(9), EIGHT(8), SEVEN(7), SIX(6), FIVE(5), FOUR(
      4), THREE(3), TWO(2), ACE(1);

  private final int num;

  /**
   * Constructor for Value enum.
   *
   * @param num corresponding number of the card
   */
  Value(int num) {
    this.num = num;
  }

  // corresponding numerical/alphabetical value of the card
  @Override
  public String toString() {
    switch (num) {
      case 1:
        return "A";
      case 2:
        return "2";
      case 3:
        return "3";
      case 4:
        return "4";
      case 5:
        return "5";
      case 6:
        return "6";
      case 7:
        return "7";
      case 8:
        return "8";
      case 9:
        return "9";
      case 10:
        return "10";
      case 11:
        return "J";
      case 12:
        return "Q";
      case 13:
        return "K";
      default:
        throw new IllegalArgumentException("No Such Value");
    }
  }

  /**
   * Compares two values and determines if this value comes after that value.
   *
   * @param that Value being compared
   * @return if this Value is the one after the given Value numerically
   */
  // is this Value the one after that value
  public boolean after(Value that) {
    return (this.num - that.num == 1);
  }

  /**
   * Compares two values and determines if this value comes before that value.
   *
   * @param that Value being compared
   * @return if this Value is the one before the given value numerically
   */
  public boolean before(Value that) {
    return (that.num - this.num == 1);
  }
}
