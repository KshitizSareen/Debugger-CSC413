package interpreter.bytecode;

import interpreter.VirtualMachine;

public class CallByteCode extends ByteCode {

    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.AddProgramCounterToStack();
        virtualMachine.DumpRunStack();
        virtualMachine.SetProgramCounter();
    }

    @Override
    public void init(String... args) {

    }

}
