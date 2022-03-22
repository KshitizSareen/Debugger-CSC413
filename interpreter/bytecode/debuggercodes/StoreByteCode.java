package interpreter.bytecode.debuggercodes;

import interpreter.debugger.DebuggerVirtualMachine;

public class StoreByteCode extends DebuggerByteCode {

    private String Symbol = "";
    private int value = 0;

    @Override
    public void execute(DebuggerVirtualMachine virtualMachine) {
        init(virtualMachine.GetDataForCode(2));
        value = virtualMachine.StoreInRunTimeStack();
        if (Symbol != null) {
            virtualMachine.AddSymbolToFrame(Symbol, value);
        }
    }

    @Override
    public void init(String... args) {
        Symbol = args[0];
    }

}
