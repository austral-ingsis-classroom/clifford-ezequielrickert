package edu.austral.ingsis.clifford;

import edu.austral.ingsis.clifford.builder.*;
import edu.austral.ingsis.clifford.command.Command;
import edu.austral.ingsis.clifford.composite.Directory;
import java.util.Arrays;
import java.util.Map;

public class CommandProvider {

  private static final Map<String, CommandParser> commandBuilderMap =
      Map.of(
          "ls", new ListCommandParser(),
          "cd", new ChangeDirectoryCommandParser(),
          "mkdir", new MakeDirectoryCommandParser(),
          "touch", new TouchCommandParser(),
          "rm", new RemoveCommandParser(),
          "pwd", new PrintWorkingDirectoryCommandParser());

  public static Command getCommand(String command, Directory root, Directory currentDirectory) {
    String[] commandParts = command.split(" ");
    CommandParser commandParser = commandBuilderMap.get(commandParts[0]);
    if (commandParser == null) {
      throw new IllegalArgumentException("Command not found");
    }
    String[] commandPartsExceptFirst = Arrays.copyOfRange(commandParts, 1, commandParts.length);
    return commandParser.buildCommand(commandPartsExceptFirst, root, currentDirectory);
  }
}
