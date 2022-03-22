package interpreter.bytecode;

import interpreter.VirtualMachine;

public class BopByteCode extends ByteCode {

    private int resultOperand = 0;
    private int SecondOperand = 0;
    private int firstOperand = 0;
    private String Operation = "";

    @Override
    public void execute(VirtualMachine virtualMachine) {
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
        virtualMachine.DumpRunStack();
    }

    @Override
    public void init(String... args) {
        SecondOperand = Integer.parseInt(args[0]);
        firstOperand = Integer.parseInt(args[1]);
        Operation = args[2];
    }

}
