package cs3500.freecell.controller;

import java.io.IOException;
import java.nio.CharBuffer;

/**
 * Faulty {@link Readable} class used for testing.
 */
public class FaultyReadable implements Readable {

  @Override
  public int read(CharBuffer cb) throws IOException {
    throw new IOException("read failed");
  }
}
