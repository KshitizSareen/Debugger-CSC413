package interpreter.bytecode.debuggercodes;

import interpreter.debugger.DebuggerVirtualMachine;

public class FormalByteCode extends DebuggerByteCode {

    private String symbol = "";
    private int offset = 0;

    @Override
    public void execute(DebuggerVirtualMachine virtualMachine) {
        init(virtualMachine.GetDataForCode(1), virtualMachine.GetDataForCode(2));
        virtualMachine.AddSymbolToFunctionEnvironmentRecord(symbol, offset);
        virtualMachine.AddSymbolToFrame(symbol, 0);
    }

    @Override
    public void init(String... args) {
        symbol = args[0];
        offset = Integer.parseInt(args[1]);
    }

}
