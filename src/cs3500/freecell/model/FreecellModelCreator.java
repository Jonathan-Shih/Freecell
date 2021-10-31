package cs3500.freecell.model;

import cs3500.freecell.model.hw02.SimpleFreecellModel;
import cs3500.freecell.model.hw04.MultiMoveFreecellModel;

/**
 * Creator class for {@link FreecellModel}. Allows the user to create either a {@link
 * SimpleFreecellModel} or a {@link MultiMoveFreecellModel}.
 */
public class FreecellModelCreator {

  /**
   * Enum class representing a GameType.
   */
  public enum GameType {
    SINGLEMOVE, MULTIMOVE
  }

  /**
   * Creates the users desired {@link FreecellModel}.
   *
   * @param t Provided {@link GameType}
   * @return Desired {@link FreecellModel}
   * @throws IllegalArgumentException if the given type is null
   */
  public static FreecellModel create(GameType t) throws IllegalArgumentException {
    if (t == null) {
      throw new IllegalArgumentException("Provided type cannot be null");
    }
    switch (t) {
      case SINGLEMOVE:
        return new SimpleFreecellModel();
      case MULTIMOVE:
        return new MultiMoveFreecellModel();
      default:
        return null;
    }
  }
}
