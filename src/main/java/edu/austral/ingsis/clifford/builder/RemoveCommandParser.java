package edu.austral.ingsis.clifford.builder;

import edu.austral.ingsis.clifford.command.Command;
import edu.austral.ingsis.clifford.command.RemoveCommand;
import edu.austral.ingsis.clifford.composite.Directory;

public class RemoveCommandParser implements CommandParser {

  @Override
  public Command buildCommand(String[] commandParts, Directory root, Directory currentDirectory) {
    if (commandParts.length <= 1) {
      String name = commandParts.length == 1 ? commandParts[0] : "";
      return new RemoveCommand(name, "", currentDirectory, root);
    } else {
      return new RemoveCommand(commandParts[1], commandParts[0], currentDirectory, root);
    }
  }
}
