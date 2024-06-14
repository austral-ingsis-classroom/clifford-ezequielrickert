package edu.austral.ingsis.clifford.composite;

import java.util.ArrayList;
import java.util.List;

public class Directory implements Archive {
  List<Archive> archives = new ArrayList<>();
  private final String name;

  public Directory(String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public List<Archive> list() {
    return archives;
  }

  public void addArchive(Archive archive) {
    archives.add(archive);
  }

  public void remove(Archive archive) {
    archives.remove(archive);
  }
}
