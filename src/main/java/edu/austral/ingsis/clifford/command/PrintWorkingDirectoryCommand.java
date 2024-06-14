package edu.austral.ingsis.clifford.command;

import edu.austral.ingsis.clifford.Response;
import edu.austral.ingsis.clifford.composite.Archive;
import edu.austral.ingsis.clifford.composite.Directory;

public class PrintWorkingDirectoryCommand implements Command {

  Directory currentDirectory;
  Directory root;

  public PrintWorkingDirectoryCommand(Directory currentDirectory, Directory root) {
    this.currentDirectory = currentDirectory;
    this.root = root;
  }

  @Override
  public Response execute() {
    return findPath(root, currentDirectory, "");
  }

  private Response findPath(Directory currentDirectory, Directory target, String path) {
    if (currentDirectory == target) {
      return new Response(path, currentDirectory);
    }
    for (Archive directory : currentDirectory.list()) {
      if (directory instanceof Directory) {
        Response response =
            findPath((Directory) directory, target, path + "/" + directory.getName());
        if (!response.message().equals("Directory not found")) {
          return response;
        }
      }
    }
    return new Response("Directory not found", currentDirectory);
  }
}
