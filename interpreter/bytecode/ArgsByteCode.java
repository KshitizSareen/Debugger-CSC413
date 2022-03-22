package interpreter.bytecode;

import interpreter.VirtualMachine;

public class ArgsByteCode extends ByteCode {
    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.CreateNewFrame();
        virtualMachine.DumpRunStack();
    }

    @Override
    public void init(String... args) {

    }

}
