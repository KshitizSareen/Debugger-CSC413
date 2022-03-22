package interpreter.bytecode.debuggercodes;

import interpreter.debugger.DebuggerVirtualMachine;

public class LineByteCode extends DebuggerByteCode {

    private int lineNumber = 0;

    @Override
    public void execute(DebuggerVirtualMachine virtualMachine) {
        init(virtualMachine.GetDataForCode(1));
        virtualMachine.SetLineNumber(lineNumber);
        if (virtualMachine.CheckIfBreakingPoint(lineNumber)) {
            virtualMachine.StopExecution();
        }
    }

    @Override
    public void init(String... args) {
        lineNumber = Integer.parseInt(args[0]);
    }

}
