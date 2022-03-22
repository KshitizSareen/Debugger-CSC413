package interpreter;

import java.util.ArrayList;

import interpreter.bytecode.ByteCode;
import interpreter.bytecode.debuggercodes.DebuggerByteCode;

public class Program {

  private ArrayList<ByteCode> byteCodes;

  private ArrayList<ArrayList<String>> byteCodeLines;

  private ArrayList<DebuggerByteCode> debuggerByteCodes;

  public Program(ArrayList<ByteCode> ByteCodes, ArrayList<DebuggerByteCode> DebuggerByteCodes,
      ArrayList<ArrayList<String>> ByteCodeLines) {

    byteCodes = ByteCodes;

    debuggerByteCodes = DebuggerByteCodes;

    for (int i = 0; i < ByteCodeLines.size(); i++) {
      if (ByteCodeLines.get(i).get(0).equals("GOTO")) {
        ResolveSymbolicAddress(ByteCodeLines, i);
      } else if (ByteCodeLines.get(i).get(0).equals("FALSEBRANCH")) {
        ResolveSymbolicAddress(ByteCodeLines, i);
      } else if (ByteCodeLines.get(i).get(0).equals("CALL")) {
        ResolveSymbolicAddress(ByteCodeLines, i);
      }
    }

    byteCodeLines = ByteCodeLines;

  }

  private void ResolveSymbolicAddress(ArrayList<ArrayList<String>> ByteCodeLines, int index) {
    String Address = ByteCodeLines.get(index).get(1);
    for (int j = 0; j < ByteCodeLines.size(); j++) {
      if (ByteCodeLines.get(j).get(0).equals("LABEL") && ByteCodeLines.get(j).get(1).equals(Address)) {
        ByteCodeLines.get(index).set(1, Integer.toString(j));
        ByteCodeLines.get(index).add(Address);
      }
    }
  }

  public ByteCode getCode(int programCounter) {
    return byteCodes.get(programCounter);
  }

  public DebuggerByteCode getDebuggerByteCode(int programCounter) {
    return debuggerByteCodes.get(programCounter);
  }

  public String getDataForCode(int programCounter, int index) {
    if (index < byteCodeLines.get(programCounter).size()) {
      return byteCodeLines.get(programCounter).get(index);
    }
    return null;
  }

  public ArrayList<String> GetByteCodeProperties(int programCounter) {
    return byteCodeLines.get(programCounter);
  }
}