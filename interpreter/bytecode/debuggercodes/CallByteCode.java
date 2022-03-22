package interpreter.bytecode.debuggercodes;

import interpreter.debugger.DebuggerVirtualMachine;
import interpreter.debugger.FunctionEnvironmentRecord;

public class CallByteCode extends DebuggerByteCode {

    @Override
    public void execute(DebuggerVirtualMachine virtualMachine) {
        virtualMachine.AddProgramCounterToStack();
        virtualMachine.SetProgramCounter();
        virtualMachine.AddToFunctionEnvironmentRecords(new FunctionEnvironmentRecord());
    }

    @Override
    public void init(String... args) {

    }

}
