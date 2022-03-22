package interpreter.debugger.commands;

import interpreter.debugger.Debugger;
import interpreter.debugger.ui.DebuggerCommand;

public class ExitCommand extends DebuggerCommand {

    @Override
    public void execute(Debugger debugger) {
        debugger.EndExecution();
    }

}
