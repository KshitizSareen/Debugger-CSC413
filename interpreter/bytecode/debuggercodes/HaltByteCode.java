package interpreter.bytecode.debuggercodes;

import interpreter.debugger.DebuggerVirtualMachine;

public class HaltByteCode extends DebuggerByteCode {
    @Override
    public void execute(DebuggerVirtualMachine virtualMachine) {
        virtualMachine.HaltExecution();
    }

    @Override
    public void init(String... args) {

    }

}
