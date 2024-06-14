package edu.austral.ingsis.clifford.invoker;

import edu.austral.ingsis.clifford.Response;

public interface FileSystem {

  Response execute();

  void setCommand(String command);
}
