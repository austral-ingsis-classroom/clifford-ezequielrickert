package edu.austral.ingsis.clifford.composite;

import java.util.List;

public class File implements Archive {

  private final String name;

  public File(String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public List<Archive> list() {
    return List.of(this);
  }
}
