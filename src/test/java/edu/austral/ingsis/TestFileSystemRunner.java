package edu.austral.ingsis;

import edu.austral.ingsis.clifford.invoker.FileSystem;
import edu.austral.ingsis.clifford.invoker.LinuxFileSystem;
import java.util.ArrayList;
import java.util.List;

public class TestFileSystemRunner implements FileSystemRunner {
  FileSystem fileSystem = new LinuxFileSystem();

  @Override
  public List<String> executeCommands(List<String> commands) {
    List<String> result = new ArrayList<>();
    for (String command : commands) {
      fileSystem.setCommand(command);
      result.add(fileSystem.execute().message());
    }
    return result;
  }
}
