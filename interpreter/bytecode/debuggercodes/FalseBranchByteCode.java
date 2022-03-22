package interpreter.bytecode.debuggercodes;

import interpreter.debugger.DebuggerVirtualMachine;

public class FalseBranchByteCode extends DebuggerByteCode {

    private int value = 0;

    @Override
    public void execute(DebuggerVirtualMachine virtualMachine) {
        init(String.valueOf(virtualMachine.PopRunStack()));
        if (value == 0) {
            virtualMachine.SetProgramCounter();
        }
    }

    @Override
    public void init(String... args) {
        value = Integer.parseInt(args[0]);
    }

}
