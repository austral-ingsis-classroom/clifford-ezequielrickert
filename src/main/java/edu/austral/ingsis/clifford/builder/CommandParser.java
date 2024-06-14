package edu.austral.ingsis.clifford.builder;

import edu.austral.ingsis.clifford.command.Command;
import edu.austral.ingsis.clifford.composite.Directory;

public interface CommandParser {
  Command buildCommand(String[] commandParts, Directory root, Directory currentDirectory);
}
