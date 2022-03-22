package interpreter.bytecode.debuggercodes;

import java.util.Scanner;

import interpreter.debugger.DebuggerVirtualMachine;

public class ReadByteCode extends DebuggerByteCode {

    @Override
    public void execute(DebuggerVirtualMachine virtualMachine) {
        System.out.println("\n");
        System.out.println("Please enter an input");
        System.out.println("\n");
        Scanner scanner = new Scanner(System.in);
        int Input = scanner.nextInt();
        virtualMachine.PushInRunStack(Input);
    }

    @Override
    public void init(String... args) {

    }

}
