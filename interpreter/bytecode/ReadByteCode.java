package interpreter.bytecode;

import java.util.Scanner;

import interpreter.VirtualMachine;

public class ReadByteCode extends ByteCode {

    @Override
    public void execute(VirtualMachine virtualMachine) {
        System.out.println("\n");
        System.out.println("Please enter an input");
        System.out.println("\n");
        Scanner scanner = new Scanner(System.in);
        int Input = scanner.nextInt();
        virtualMachine.PushInRunStack(Input);
        virtualMachine.DumpRunStack();
    }

    @Override
    public void init(String... args) {

    }

}
