package interpreter.debugger.ui;

import interpreter.debugger.Entry;

public class ListBreakpointsUI {

    public ListBreakpointsUI(Entry entry) {
        String LineToPrint = FormLineToPrint(entry.GetLineNumber(), entry.GetSourceLine());
        System.out.println(LineToPrint);
    }

    public String FormLineToPrint(int lineNumber, String sourceLine) {
        String LineToPrint = "";
        LineToPrint = "   *  ";
        for (int i = 0; i < 3 - Integer.toString(lineNumber).length(); i++) {
            LineToPrint += " ";
        }
        LineToPrint += lineNumber + ": " + sourceLine;
        return LineToPrint;
    }
}
