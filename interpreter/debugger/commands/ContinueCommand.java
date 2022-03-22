package interpreter.debugger.commands;

import interpreter.debugger.Debugger;
import interpreter.debugger.ui.DebuggerCommand;

public class ContinueCommand extends DebuggerCommand {

    @Override
    public void execute(Debugger debugger) {
        debugger.ContinueExecution();
    }

}
