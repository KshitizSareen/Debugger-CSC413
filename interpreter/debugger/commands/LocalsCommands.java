package interpreter.debugger.commands;

import interpreter.debugger.Debugger;
import interpreter.debugger.SymbolValues;
import interpreter.debugger.ui.DebuggerCommand;
import interpreter.debugger.ui.LocalSymbolsUI;

public class LocalsCommands extends DebuggerCommand {

    @Override
    public void execute(Debugger debugger) {
        SymbolValues currentFrame = debugger.RetrieveCurrentFrame();
        new LocalSymbolsUI(currentFrame);
        debugger.ExecutePrompt();
    }

}
