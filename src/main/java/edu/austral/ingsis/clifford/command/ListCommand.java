package edu.austral.ingsis.clifford.command;

import edu.austral.ingsis.clifford.Response;
import edu.austral.ingsis.clifford.composite.Archive;
import edu.austral.ingsis.clifford.composite.Directory;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ListCommand implements Command {

  private final String flag;
  private final Directory currentDirectory;

  public ListCommand(String args, Directory currentDirectory) {
    this.flag = args;
    this.currentDirectory = currentDirectory;
  }

  @Override
  public Response execute() {
    List<Archive> archives = currentDirectory.list();
    switch (flag) {
      case "" -> {
        String archiveNames =
            archives.stream().map(Archive::getName).collect(Collectors.joining(" "));
        return new Response(archiveNames, currentDirectory);
      }
      case "--ord=asc" -> {
        archives.sort(Comparator.comparing(Archive::getName));
        String archiveNames =
            archives.stream().map(Archive::getName).collect(Collectors.joining(" "));
        return new Response(archiveNames, currentDirectory);
      }
      case "--ord=desc" -> {
        archives.sort((a1, a2) -> a2.getName().compareTo(a1.getName()));
        String archiveNames =
            archives.stream().map(Archive::getName).collect(Collectors.joining(" "));
        return new Response(archiveNames, currentDirectory);
      }
      default -> {
        return new Response("Invalid flag", null);
      }
    }
  }
}
