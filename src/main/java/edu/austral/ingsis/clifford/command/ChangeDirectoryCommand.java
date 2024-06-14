package edu.austral.ingsis.clifford.command;

import edu.austral.ingsis.clifford.Response;
import edu.austral.ingsis.clifford.composite.Archive;
import edu.austral.ingsis.clifford.composite.Directory;
import edu.austral.ingsis.clifford.composite.File;
import java.util.Arrays;
import java.util.List;

public class ChangeDirectoryCommand implements Command {

  private final String[] path;
  private final Directory root;
  private final Directory currentDirectory;

  public ChangeDirectoryCommand(String[] path, Directory root, Directory currentDirectory) {
    this.path = path;
    this.root = root;
    this.currentDirectory = currentDirectory;
  }

  @Override
  public Response execute() {
    if (path.length == 0) {
      return new Response("moved to directory '/'", root);
    }
    if (path[0].equals("..")) {
      return getDirectory(Arrays.copyOfRange(path, 1, path.length), root);
    } else if (path[0].equals(".")) {
      return new Response(
          "moved to directory" + " '" + currentDirectory.getName() + "'", currentDirectory);
    } else {
      return getDirectory(path, currentDirectory);
    }
  }

  private Response getDirectory(String[] path, Directory currentDirectory) {
    if (path.length == 0) {
      return new Response(
          "moved to directory" + " '" + currentDirectory.getName() + "'", currentDirectory);
    }
    Archive archive = spotArchive(currentDirectory, path[0]);
    if (archive == null || archive instanceof File) {
      return new Response(
          "'" + path[path.length - 1] + "' " + "directory does not exist", currentDirectory);
    }
    return getDirectory(Arrays.copyOfRange(path, 1, path.length), (Directory) archive);
  }

  private Archive spotArchive(Archive navigatedDirectory, String toFind) {
    List<Archive> archives = navigatedDirectory.list();
    for (Archive archive : archives) {
      if (archive.getName().equals(toFind)) {
        return archive;
      }
    }
    return null;
  }
}
