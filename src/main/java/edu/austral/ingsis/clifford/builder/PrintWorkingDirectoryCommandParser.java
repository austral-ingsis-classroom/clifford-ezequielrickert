package edu.austral.ingsis.clifford.builder;

import edu.austral.ingsis.clifford.command.Command;
import edu.austral.ingsis.clifford.command.PrintWorkingDirectoryCommand;
import edu.austral.ingsis.clifford.composite.Directory;

public class PrintWorkingDirectoryCommandParser implements CommandParser {

  @Override
  public Command buildCommand(String[] commandParts, Directory root, Directory currentDirectory) {
    if (commandParts.length == 0) {
      return new PrintWorkingDirectoryCommand(currentDirectory, root);
    } else {
      throw new IllegalArgumentException("Invalid command");
    }
  }
}
