package interpreter.debugger.ui;

import interpreter.debugger.Debugger;

public abstract class DebuggerCommand {
  public abstract void execute(Debugger debugger);
}