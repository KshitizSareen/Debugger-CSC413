package interpreter.debugger.ui;

import java.util.Scanner;

public class SetBreakpointsUI {
    public int RequestLineNumber() {
        System.out.println("Enter Line Number:");
        System.out.print("> ");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        return input;
    }
}
