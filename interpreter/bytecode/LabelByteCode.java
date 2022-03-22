package interpreter.bytecode;

import interpreter.VirtualMachine;

public class LabelByteCode extends ByteCode {

    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.DumpRunStack();
    }

    @Override
    public void init(String... args) {

    }

}
