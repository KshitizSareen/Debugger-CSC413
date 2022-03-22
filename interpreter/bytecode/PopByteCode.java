package interpreter.bytecode;

import interpreter.VirtualMachine;

public class PopByteCode extends ByteCode {

    private int levels = 0;

    @Override
    public void execute(VirtualMachine virtualMachine) {
        init(virtualMachine.GetDataForCode(1));
        for (int i = 0; i < levels; i++) {
            virtualMachine.PopRunStack();
        }
        virtualMachine.DumpRunStack();
    }

    @Override
    public void init(String... args) {
        levels = Integer.parseInt(args[0]);
    }

}
