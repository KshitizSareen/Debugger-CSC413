package interpreter.bytecode;

import interpreter.VirtualMachine;

public class StoreByteCode extends ByteCode {

    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.StoreInRunTimeStack();
        virtualMachine.DumpRunStack();
    }

    @Override
    public void init(String... args) {

    }

}
