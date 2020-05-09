package com.github.badsyntax.gradletasks;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public abstract class GradleOutputListener extends OutputStream {
  private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

  @Override
  public final void write(int b) throws IOException {
    char c = (char) b;
    outputStream.write(b);
    if (c == System.lineSeparator().charAt(0)) {
      onOutputChanged(outputStream);
      outputStream.reset();
    }
  }

  public abstract void onOutputChanged(ByteArrayOutputStream output);
}
