package edu.austral.ingsis.clifford.builder;

import edu.austral.ingsis.clifford.command.Command;
import edu.austral.ingsis.clifford.command.ListCommand;
import edu.austral.ingsis.clifford.composite.Directory;

public class ListCommandParser implements CommandParser {
  @Override
  public Command buildCommand(String[] commandParts, Directory root, Directory currentDirectory) {
    String flag = commandParts.length > 0 ? commandParts[0] : "";
    return new ListCommand(flag, currentDirectory);
  }
}
