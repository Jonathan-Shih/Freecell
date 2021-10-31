package cs3500.freecell.controller;

import cs3500.freecell.model.hw02.Card;
import cs3500.freecell.model.hw02.SimpleFreecellModel;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Main class for running {@link SimpleFreecellController}.
 */
public class Main {

  /**
   * Allows users to pass inputs to {@link SimpleFreecellController}.
   *
   * @param args User inputs
   */
  public static void main(String[] args) {
    SimpleFreecellModel model = new SimpleFreecellModel();
    List<Card> deck = model.getDeck();
    new SimpleFreecellController(model, new InputStreamReader(System.in),
        System.out).playGame(deck, 4, 4, false);
  }
}
