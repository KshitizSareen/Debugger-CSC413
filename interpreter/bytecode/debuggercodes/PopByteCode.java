package interpreter.bytecode.debuggercodes;

import interpreter.debugger.DebuggerVirtualMachine;

public class PopByteCode extends DebuggerByteCode {

    private int levels = 0;

    @Override
    public void execute(DebuggerVirtualMachine virtualMachine) {
        init(virtualMachine.GetDataForCode(1));
        for (int i = 0; i < levels; i++) {
            virtualMachine.PopRunStack();
        }
        virtualMachine.PopFromFunctionEnvironmentRecord(levels);
    }

    @Override
    public void init(String... args) {
        levels = Integer.parseInt(args[0]);
    }

}
