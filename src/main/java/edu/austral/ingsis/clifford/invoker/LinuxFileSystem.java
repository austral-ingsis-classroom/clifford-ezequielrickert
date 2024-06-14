package edu.austral.ingsis.clifford.invoker;

import edu.austral.ingsis.clifford.CommandProvider;
import edu.austral.ingsis.clifford.Response;
import edu.austral.ingsis.clifford.command.Command;
import edu.austral.ingsis.clifford.composite.Directory;
import java.util.Objects;

public class LinuxFileSystem implements FileSystem {

  private String commandLine = "";
  private final Directory root = new Directory("/");
  private Directory currentDirectory = root;

  @Override
  public Response execute() {
    if (!Objects.equals(commandLine, "")) {
      Command command = CommandProvider.getCommand(commandLine, root, currentDirectory);
      Response response = command.execute();
      currentDirectory = response.directory();
      return response;
    }
    return new Response("No command to execute", null);
  }

  @Override
  public void setCommand(String command) {
    if (command != null) {
      this.commandLine = command;
    }
  }
}
