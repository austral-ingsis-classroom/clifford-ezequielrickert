package edu.austral.ingsis.clifford.builder;

import edu.austral.ingsis.clifford.command.Command;
import edu.austral.ingsis.clifford.command.TouchCommand;
import edu.austral.ingsis.clifford.composite.Directory;

public class TouchCommandParser implements CommandParser {

  @Override
  public Command buildCommand(String[] commandParts, Directory root, Directory currentDirectory) {
    String name = commandParts.length == 1 ? commandParts[0] : "";
    return new TouchCommand(name, currentDirectory);
  }
}
