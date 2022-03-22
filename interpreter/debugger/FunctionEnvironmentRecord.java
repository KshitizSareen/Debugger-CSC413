package interpreter.debugger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class FunctionEnvironmentRecord {

  private HashMap<String, List<Integer>> SymbolTable;
  private Stack<String> IndexStack;
  private String FunctionName;
  private int start, end, LineNumber;

  public void beginScope() {
    SymbolTable = new HashMap<String, List<Integer>>();
    IndexStack = new Stack<String>();
    FunctionName = "";
    start = 0;
    end = 0;
    LineNumber = 0;
  }

  public void setFunctionInfo(String functionName, int startingLineNumber, int endingLineNumber) {
    FunctionName = functionName;
    start = startingLineNumber;
    end = endingLineNumber;
  }

  public void setCurrentLineNumber(int currentLineNumber) {
    LineNumber = currentLineNumber;
  }

  public void enter(String symbol, int value) {
    List<Integer> SymbolValues;
    if (!SymbolTable.containsKey(symbol)) {
      SymbolValues = new ArrayList<Integer>();
    } else {
      SymbolValues = SymbolTable.get(symbol);
    }
    SymbolValues.add(0, value);
    SymbolTable.put(symbol, SymbolValues);
    IndexStack.add(symbol);
  }

  public void pop(int count) {
    for (int i = 0; i < count; i++) {
      String symbol = IndexStack.pop();
      SymbolTable.get(symbol).remove(0);
    }
  }

  public HashMap<String, List<Integer>> GetSymbolTable() {
    return SymbolTable;
  }

  public int GetLineNumber() {
    return LineNumber;
  }

  /**
   * Utility method to test your implementation. The output should be:
   * (<>, -, -, -, -)
   * (<>, g, 1, 20, -)
   * (<>, g, 1, 20, 5)
   * (<a/4>, g, 1, 20, 5)
   * (<b/2, a/4>, g, 1, 20, 5)
   * (<b/2, a/4, c/7>, g, 1, 20, 5)
   * (<b/2, a/1, c/7>, g, 1, 20, 5)
   * (<b/2, a/4>, g, 1, 20, 5)
   * (<a/4>, g, 1, 20, 5)
   */
  public static void main(String[] args) {
    FunctionEnvironmentRecord record = new FunctionEnvironmentRecord();

    record.beginScope();
    System.out.println(record.SymbolTable);
    System.out.println(record.FunctionName);
    System.out.println(record.start);
    System.out.println(record.end);
    System.out.println(record.LineNumber);
    System.out.println("");

    record.setFunctionInfo("g", 1, 20);
    System.out.println(record.SymbolTable);
    System.out.println(record.FunctionName);
    System.out.println(record.start);
    System.out.println(record.end);
    System.out.println(record.LineNumber);
    System.out.println("");

    record.setCurrentLineNumber(5);
    System.out.println(record.SymbolTable);
    System.out.println(record.FunctionName);
    System.out.println(record.start);
    System.out.println(record.end);
    System.out.println(record.LineNumber);
    System.out.println("");

    record.enter("a", 4);
    System.out.println(record.SymbolTable);
    System.out.println(record.FunctionName);
    System.out.println(record.start);
    System.out.println(record.end);
    System.out.println(record.LineNumber);
    System.out.println("");

    record.enter("b", 2);
    System.out.println(record.SymbolTable);
    System.out.println(record.FunctionName);
    System.out.println(record.start);
    System.out.println(record.end);
    System.out.println(record.LineNumber);
    System.out.println("");

    record.enter("c", 7);
    System.out.println(record.SymbolTable);
    System.out.println(record.FunctionName);
    System.out.println(record.start);
    System.out.println(record.end);
    System.out.println(record.LineNumber);
    System.out.println("");

    record.enter("a", 1);
    System.out.println(record.SymbolTable);
    System.out.println(record.FunctionName);
    System.out.println(record.start);
    System.out.println(record.end);
    System.out.println(record.LineNumber);
    System.out.println("");

    record.pop(2);
    System.out.println(record.SymbolTable);
    System.out.println(record.FunctionName);
    System.out.println(record.start);
    System.out.println(record.end);
    System.out.println(record.LineNumber);
    System.out.println("");

    record.pop(1);
    System.out.println(record.SymbolTable);
    System.out.println(record.FunctionName);
    System.out.println(record.start);
    System.out.println(record.end);
    System.out.println(record.LineNumber);
    System.out.println("");
  }
}