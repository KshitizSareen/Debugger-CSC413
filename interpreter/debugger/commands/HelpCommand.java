package interpreter.debugger.commands;

import interpreter.debugger.Debugger;
import interpreter.debugger.ui.DebuggerCommand;
import interpreter.debugger.ui.DisplayCommands;

public class HelpCommand extends DebuggerCommand {

    @Override
    public void execute(Debugger debugger) {
        new DisplayCommands();
        debugger.ExecutePrompt();
    }

}
