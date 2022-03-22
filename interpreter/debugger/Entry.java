package interpreter.debugger;

public class Entry {
    private int lineNumber = 0;
    private String sourceLine = "";
    private Boolean isBreakpointLine;

    Entry(int lineNumber, String sourceLine, Boolean isBreakpointLine) {
        this.lineNumber = lineNumber;
        this.sourceLine = sourceLine;
        this.isBreakpointLine = isBreakpointLine;
    }

    public void SetLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public void SetSourceLine(String sourceLine) {
        this.sourceLine = sourceLine;
    }

    public void SetIsBreakingPoint(Boolean breakingPoint) {
        isBreakpointLine = breakingPoint;
    }

    public int GetLineNumber() {
        return lineNumber;
    }

    public String GetSourceLine() {
        return sourceLine;
    }

    public Boolean GetBreakingPoint() {
        return isBreakpointLine;
    }
}
