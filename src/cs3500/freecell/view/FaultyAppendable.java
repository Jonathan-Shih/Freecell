package cs3500.freecell.view;

import java.io.IOException;

/**
 * Faulty {@link Appendable} class used for testing.
 */
public class FaultyAppendable implements Appendable {

  @Override
  public Appendable append(CharSequence csq) throws IOException {
    throw new IOException("append failed");
  }

  @Override
  public Appendable append(CharSequence csq, int start, int end) throws IOException {
    throw new IOException("append failed");
  }

  @Override
  public Appendable append(char c) throws IOException {
    throw new IOException("append failed");
  }
}
