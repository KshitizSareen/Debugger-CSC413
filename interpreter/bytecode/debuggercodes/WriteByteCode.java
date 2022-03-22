package interpreter.bytecode.debuggercodes;

import interpreter.debugger.DebuggerVirtualMachine;

public class WriteByteCode extends DebuggerByteCode {

    @Override
    public void execute(DebuggerVirtualMachine virtualMachine) {
        int topItem = virtualMachine.GetTopOfStack();
        System.out.println(topItem);
    }

    @Override
    public void init(String... args) {

    }

}
