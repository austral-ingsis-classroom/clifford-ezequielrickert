package edu.austral.ingsis.clifford.command;

import edu.austral.ingsis.clifford.Response;
import edu.austral.ingsis.clifford.composite.Archive;
import edu.austral.ingsis.clifford.composite.Directory;
import edu.austral.ingsis.clifford.composite.File;
import java.util.List;
import java.util.Objects;

public class RemoveCommand implements Command {

  private final String name;
  private final String flag;
  private final Directory currentDirectory;
  private final Directory root;

  public RemoveCommand(String name, String flag, Directory currentDirectory, Directory root) {
    this.name = name;
    this.flag = flag;
    this.currentDirectory = currentDirectory;
    this.root = root;
  }

  @Override
  public Response execute() {
    if (Objects.equals(name, "")) {
      return new Response("No file to remove", currentDirectory);
    }
    List<Archive> archives = currentDirectory.list();
    for (Archive archive : archives) {
      if (Objects.equals(archive.getName(), name)) {
        return removeFile(archive);
      }
    }
    return new Response("File not found", currentDirectory);
  }

  private Response removeFile(Archive archive) {
    if (Objects.equals(flag, "--recursive")) {
      currentDirectory.remove(archive);
      return new Response("'" + name + "' removed", currentDirectory);
    }
    if (archive instanceof File) {
      currentDirectory.remove(archive);
      return new Response("'" + name + "'" + " removed", currentDirectory);
    }
    return new Response("cannot remove '" + name + "', is a directory", currentDirectory);
  }
}
