package interpreter.bytecode;

import interpreter.VirtualMachine;

public class DumpByteCode extends ByteCode {

    private String State = "";

    @Override
    public void execute(VirtualMachine virtualMachine) {
        init(virtualMachine.GetDataForCode(1));
        if (State.equals("on")) {
            virtualMachine.SetDumpState(true);
        } else {
            virtualMachine.SetDumpState(false);
        }
    }

    @Override
    public void init(String... args) {
        State = args[0].trim().toLowerCase();
    }

}
