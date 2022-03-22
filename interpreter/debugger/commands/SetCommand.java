package interpreter.debugger.commands;

import interpreter.debugger.Debugger;
import interpreter.debugger.ui.DebuggerCommand;
import interpreter.debugger.ui.SetBreakpointsUI;

public class SetCommand extends DebuggerCommand {

    @Override
    public void execute(Debugger debugger) {
        int lineNumber = new SetBreakpointsUI().RequestLineNumber();
        debugger.SetBreakPoint(lineNumber);
        debugger.ExecutePrompt();
    }

}
