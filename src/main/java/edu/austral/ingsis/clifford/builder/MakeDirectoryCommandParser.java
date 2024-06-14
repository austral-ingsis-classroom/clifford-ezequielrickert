package edu.austral.ingsis.clifford.builder;

import edu.austral.ingsis.clifford.command.Command;
import edu.austral.ingsis.clifford.command.MakeDirectoryCommand;
import edu.austral.ingsis.clifford.composite.Directory;

public class MakeDirectoryCommandParser implements CommandParser {

  @Override
  public Command buildCommand(String[] commandParts, Directory root, Directory currentDirectory) {
    String name = commandParts.length == 1 ? commandParts[0] : "";
    return new MakeDirectoryCommand(name, currentDirectory);
  }
}
