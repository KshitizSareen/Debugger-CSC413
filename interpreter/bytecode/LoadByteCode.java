package interpreter.bytecode;

import interpreter.VirtualMachine;

public class LoadByteCode extends ByteCode {

    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.LoadItemInRunStack();
        virtualMachine.DumpRunStack();
    }

    @Override
    public void init(String... args) {

    }

}
