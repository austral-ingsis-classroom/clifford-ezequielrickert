package edu.austral.ingsis.clifford.command;

import edu.austral.ingsis.clifford.Response;
import edu.austral.ingsis.clifford.composite.Archive;
import edu.austral.ingsis.clifford.composite.Directory;
import java.util.Objects;

public class MakeDirectoryCommand implements Command {

  private final String name;
  private final Directory currentDirectory;

  public MakeDirectoryCommand(String name, Directory currentDirectory) {
    this.name = name;
    this.currentDirectory = currentDirectory;
  }

  @Override
  public Response execute() {
    if (!isInList(currentDirectory, name)) {
      Directory newDirectory = new Directory(name);
      currentDirectory.addArchive(newDirectory);
    }
    return new Response("'" + name + "'" + " directory created", currentDirectory);
  }

  private boolean isInList(Directory currentDirectory, String target) {
    for (Archive archive : currentDirectory.list()) {
      if (archive instanceof Directory) {
        return Objects.equals(archive.getName(), target);
      }
    }
    return false;
  }
}
