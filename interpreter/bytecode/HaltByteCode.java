package interpreter.bytecode;

import interpreter.VirtualMachine;

public class HaltByteCode extends ByteCode {
    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.HaltExecution();
        virtualMachine.DumpRunStack();
    }

    @Override
    public void init(String... args) {

    }

}
