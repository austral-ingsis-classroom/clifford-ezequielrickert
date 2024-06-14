package edu.austral.ingsis.clifford.builder;

import edu.austral.ingsis.clifford.command.ChangeDirectoryCommand;
import edu.austral.ingsis.clifford.command.Command;
import edu.austral.ingsis.clifford.composite.Directory;

public class ChangeDirectoryCommandParser implements CommandParser {

  @Override
  public Command buildCommand(String[] commandParts, Directory root, Directory currentDirectory) {
    String[] path = commandParts.length > 0 ? commandParts[0].split("/") : new String[] {""};
    boolean isAbsolutePath = commandParts[0].startsWith("/");
    if (isAbsolutePath) {
      return new ChangeDirectoryCommand(path, root, root);
    } else {
      return new ChangeDirectoryCommand(path, root, currentDirectory);
    }
  }
}
