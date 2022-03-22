package interpreter.debugger.ui;

import java.util.HashMap;
import java.util.Scanner;

import interpreter.debugger.Debugger;
import interpreter.debugger.commands.ContinueCommand;
import interpreter.debugger.commands.ExitCommand;
import interpreter.debugger.commands.HelpCommand;
import interpreter.debugger.commands.ListCommand;
import interpreter.debugger.commands.LocalsCommands;
import interpreter.debugger.commands.SetCommand;
import interpreter.debugger.commands.SourceCommand;
import interpreter.debugger.commands.StepCommand;

public class DebuggerShell {

  private HashMap<String, DebuggerCommand> CommandMap = new HashMap<String, DebuggerCommand>();

  public DebuggerShell(Debugger debugger) {
    debugger.DisplaySourceCode(true);
    CommandMap.put("set", new SetCommand());
    CommandMap.put("list", new ListCommand());
    CommandMap.put("locals", new LocalsCommands());
    CommandMap.put("source", new SourceCommand());
    CommandMap.put("step", new StepCommand());
    CommandMap.put("continue", new ContinueCommand());
    CommandMap.put("exit", new ExitCommand());
    CommandMap.put("?", new HelpCommand());
  }

  public DebuggerCommand prompt() {
    // Create the correct command object here, based on user interaction,
    // and return
    System.out.println("Type ? for help");
    System.out.print("> ");
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine().toLowerCase().trim();
    if (CommandMap.containsKey(input)) {
      return CommandMap.get(input);
    }
    System.out.println("Please enter a valid input");
    return prompt();
  }
}