package interpreter.bytecode;

import interpreter.VirtualMachine;

public class GotoByteCode extends ByteCode {

    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.DumpRunStack();
        virtualMachine.SetProgramCounter();
    }

    @Override
    public void init(String... args) {

    }

}
