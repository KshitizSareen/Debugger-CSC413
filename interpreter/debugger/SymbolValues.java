package interpreter.debugger;

import java.util.HashMap;

public class SymbolValues {

    private HashMap<String, Integer> SymbolValue = new HashMap<String, Integer>();

    private int startLine = 0;
    private int endLine = 0;

    public SymbolValues(int startLine, int endLine) {
        this.startLine = startLine;
        this.endLine = endLine;
    }

    public void EnterSymbol(String Symbol, int Value) {
        SymbolValue.put(Symbol, Value);
    }

    public HashMap<String, Integer> GetSymbolValue() {
        return SymbolValue;
    }

    public int GetStartLine() {
        return startLine;
    }

    public int GetEndLine() {
        return endLine;
    }

}
