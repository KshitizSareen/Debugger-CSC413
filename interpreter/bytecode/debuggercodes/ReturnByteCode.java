package interpreter.bytecode.debuggercodes;

import interpreter.debugger.DebuggerVirtualMachine;

public class ReturnByteCode extends DebuggerByteCode {

    @Override
    public void execute(DebuggerVirtualMachine virtualMachine) {
        virtualMachine.ReturnFromFrame();
        virtualMachine.PopFromFunctionEnvironmentRecords();
        virtualMachine.RemoveFrame();
    }

    @Override
    public void init(String... args) {

    }

}
