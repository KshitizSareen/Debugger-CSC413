package interpreter.debugger.commands;

import java.util.Vector;

import interpreter.debugger.Debugger;
import interpreter.debugger.Entry;
import interpreter.debugger.ui.DebuggerCommand;
import interpreter.debugger.ui.ListBreakpointsUI;

public class ListCommand extends DebuggerCommand {

    @Override
    public void execute(Debugger debugger) {
        Vector<Entry> Entries = debugger.RetrieveEntries();
        for (int i = 0; i < Entries.size(); i++) {
            if (Entries.get(i).GetBreakingPoint() == true) {
                new ListBreakpointsUI(Entries.get(i));
            }
        }
        debugger.ExecutePrompt();
    }

}
