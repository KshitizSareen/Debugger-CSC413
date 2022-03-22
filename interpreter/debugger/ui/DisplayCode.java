package interpreter.debugger.ui;

import java.util.Vector;

import interpreter.debugger.Entry;

public class DisplayCode {
    public DisplayCode(Vector<Entry> Entries, int currentLine, int startIndex, int endIndex, Boolean DisplayFullCode) {
        String LineToPrint = "";
        if(startIndex==-1 && endIndex==-1)
        {
            System.out.println("x code intrinsic function");
            return;
        }
        if (DisplayFullCode) {
            startIndex = 1;
            endIndex = Entries.size();
        }
        for (int i = startIndex - 1; i < endIndex; i++) {
            LineToPrint = FormLineToPrint(Entries.get(i).GetLineNumber(), Entries.get(i).GetSourceLine(),
                    Entries.get(i).GetBreakingPoint(), currentLine == Entries.get(i).GetLineNumber());
            System.out.println(LineToPrint);
        }
    }

    public String FormLineToPrint(int lineNumber, String sourceLine, Boolean isBreakPoint,
            Boolean isCurrentExecutionLine) {
        String LineToPrint = "";
        if (isCurrentExecutionLine) {
            LineToPrint += "- >";
        } else {
            LineToPrint += "   ";
        }
        if (isBreakPoint) {
            LineToPrint += " * ";
        } else {
            LineToPrint += "   ";
        }
        LineToPrint += lineNumber + ": " + sourceLine;
        return LineToPrint;
    }
}
