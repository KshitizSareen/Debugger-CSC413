package interpreter.bytecode;

import interpreter.VirtualMachine;

public class ReturnByteCode extends ByteCode {

    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.ReturnFromFrame();
    }

    @Override
    public void init(String... args) {

    }

}
