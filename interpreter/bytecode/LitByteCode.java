package interpreter.bytecode;

import interpreter.VirtualMachine;

public class LitByteCode extends ByteCode {

    private int framePointer = 0;

    @Override
    public void execute(VirtualMachine virtualMachine) {
        init(virtualMachine.GetDataForCode(1));
        virtualMachine.PushInRunStack(framePointer);
        virtualMachine.DumpRunStack();
    }

    @Override
    public void init(String... args) {
        framePointer = Integer.parseInt(args[0]);
    }

}
