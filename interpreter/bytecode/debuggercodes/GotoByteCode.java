package interpreter.bytecode.debuggercodes;

import interpreter.debugger.DebuggerVirtualMachine;

public class GotoByteCode extends DebuggerByteCode {

    @Override
    public void execute(DebuggerVirtualMachine virtualMachine) {
        virtualMachine.SetProgramCounter();
    }

    @Override
    public void init(String... args) {

    }

}
