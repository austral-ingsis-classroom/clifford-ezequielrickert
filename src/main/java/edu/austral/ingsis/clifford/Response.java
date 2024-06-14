package edu.austral.ingsis.clifford;

import edu.austral.ingsis.clifford.composite.Directory;

public class Response {
  private final String message;
  private final Directory directory;

  public Response(String message, Directory directory) {
    this.message = message;
    this.directory = directory;
  }

  public String message() {
    return message;
  }

  public Directory directory() {
    return directory;
  }
}
