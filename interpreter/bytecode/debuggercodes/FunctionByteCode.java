package interpreter.bytecode.debuggercodes;

import interpreter.debugger.DebuggerVirtualMachine;

public class FunctionByteCode extends DebuggerByteCode {

    private String functionName = "";
    private int startLine = 0;
    private int endLine = 0;

    @Override
    public void execute(DebuggerVirtualMachine virtualMachine) {
        init(virtualMachine.GetDataForCode(1), virtualMachine.GetDataForCode(2), virtualMachine.GetDataForCode(3));
        virtualMachine.SetFunctionInFunctionEnvironment(functionName, startLine, endLine);
        virtualMachine.AddFrame(startLine, endLine);
    }

    @Override
    public void init(String... args) {
        functionName = args[0];
        startLine = Integer.parseInt(args[1]);
        endLine = Integer.parseInt(args[2]);
    }

}
