package edu.austral.ingsis.clifford.command;

import edu.austral.ingsis.clifford.Response;
import edu.austral.ingsis.clifford.composite.Archive;
import edu.austral.ingsis.clifford.composite.Directory;
import edu.austral.ingsis.clifford.composite.File;
import java.util.Objects;

public class TouchCommand implements Command {
  private final String name;
  private final Directory currentDirectory;

  public TouchCommand(String name, Directory currentDirectory) {
    this.name = name;
    this.currentDirectory = currentDirectory;
  }

  @Override
  public Response execute() {
    if (!isInList(currentDirectory, name)) {
      File newFile = new File(name);
      currentDirectory.addArchive(newFile);
    }
    return new Response("'" + name + "' " + "file created", currentDirectory);
  }

  private boolean isInList(Directory currentDirectory, String target) {
    for (Archive archive : currentDirectory.list()) {
      if (archive instanceof File) {
        return Objects.equals(archive.getName(), target);
      }
    }
    return false;
  }
}
