package interpreter.bytecode.debuggercodes;

import interpreter.debugger.DebuggerVirtualMachine;

public class BopByteCode extends DebuggerByteCode {

    private int resultOperand = 0;
    private int SecondOperand = 0;
    private int firstOperand = 0;
    private String Operation = "";

    @Override
    public void execute(DebuggerVirtualMachine virtualMachine) {
        init(String.valueOf(virtualMachine.PopRunStack()), String.valueOf(virtualMachine.PopRunStack()),
                virtualMachine.GetDataForCode(1));
        if (Operation.equals("+")) {
            resultOperand = firstOperand + SecondOperand;
        }
        if (Operation.equals("-")) {
            resultOperand = firstOperand - SecondOperand;
        }
        if (Operation.equals("/")) {
            resultOperand = firstOperand / SecondOperand;
        }
        if (Operation.equals("*")) {
            resultOperand = firstOperand * SecondOperand;
        }
        if (Operation.equals("==")) {
            resultOperand = firstOperand == SecondOperand ? 1 : 0;
        }
        if (Operation.equals("!=")) {
            resultOperand = firstOperand != SecondOperand ? 1 : 0;
        }
        if (Operation.equals("<=")) {
            resultOperand = firstOperand <= SecondOperand ? 1 : 0;
        }
        if (Operation.equals(">")) {
            resultOperand = firstOperand > SecondOperand ? 1 : 0;
        }
        if (Operation.equals(">=")) {
            resultOperand = firstOperand >= SecondOperand ? 1 : 0;
        }
        if (Operation.equals("<")) {
            resultOperand = firstOperand < SecondOperand ? 1 : 0;
        }
        if (Operation.equals("|")) {
            resultOperand = firstOperand | SecondOperand;
        }
        if (Operation.equals("&")) {
            resultOperand = firstOperand & SecondOperand;
        }
        virtualMachine.PushInRunStack(resultOperand);
    }

    @Override
    public void init(String... args) {
        SecondOperand = Integer.parseInt(args[0]);
        firstOperand = Integer.parseInt(args[1]);
        Operation = args[2];
    }

}
