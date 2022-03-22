package interpreter.bytecode.debuggercodes;

import interpreter.debugger.DebuggerVirtualMachine;

public class LitByteCode extends DebuggerByteCode {

    private int framePointer = 0;
    private String symbol = "";
    private int lengthOfStack = 0;

    @Override
    public void execute(DebuggerVirtualMachine virtualMachine) {
        init(virtualMachine.GetDataForCode(1), virtualMachine.GetDataForCode(2),
                virtualMachine.GetLengthOfRunTimeStack());
        virtualMachine.PushInRunStack(framePointer);
        if (symbol != null) {
            virtualMachine.AddSymbolToFunctionEnvironmentRecord(symbol, lengthOfStack);
            virtualMachine.AddSymbolToFrame(symbol, framePointer);
        }
    }

    @Override
    public void init(String... args) {
        framePointer = Integer.parseInt(args[0]);
        symbol = args[1];
        lengthOfStack = Integer.parseInt(args[2]);
    }

}
