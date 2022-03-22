package interpreter.bytecode;

import interpreter.VirtualMachine;

public class FalseBranchByteCode extends ByteCode {

    private int value = 0;

    @Override
    public void execute(VirtualMachine virtualMachine) {
        init(String.valueOf(virtualMachine.PopRunStack()));
        if (value == 0) {
            virtualMachine.DumpRunStack();
            virtualMachine.SetProgramCounter();
        } else {
            virtualMachine.DumpRunStack();
        }
    }

    @Override
    public void init(String... args) {
        value = Integer.parseInt(args[0]);
    }

}
