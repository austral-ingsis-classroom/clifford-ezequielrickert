package edu.austral.ingsis.clifford.composite;

import java.util.List;

public interface Archive {
  public String getName();

  public List<Archive> list();
}
