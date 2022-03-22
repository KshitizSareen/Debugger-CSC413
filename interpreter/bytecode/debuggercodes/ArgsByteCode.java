package interpreter.bytecode.debuggercodes;

import interpreter.debugger.DebuggerVirtualMachine;

public class ArgsByteCode extends DebuggerByteCode {
    @Override
    public void execute(DebuggerVirtualMachine virtualMachine) {
        virtualMachine.CreateNewFrame();
    }

    @Override
    public void init(String... args) {

    }

}
