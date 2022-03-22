package interpreter.bytecode;

import interpreter.VirtualMachine;

public class WriteByteCode extends ByteCode {

    @Override
    public void execute(VirtualMachine virtualMachine) {
        int topItem = virtualMachine.GetTopOfStack();
        System.out.println(topItem);
        virtualMachine.DumpRunStack();
    }

    @Override
    public void init(String... args) {

    }

}
