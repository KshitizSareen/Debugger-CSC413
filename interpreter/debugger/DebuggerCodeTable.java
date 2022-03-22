package interpreter.debugger;

import java.util.HashMap;

import interpreter.CodeTable;

public class DebuggerCodeTable {
  private static HashMap<String, String> codeMap = new HashMap<>();

  public static void init() {
    CodeTable.init();

    // Initialize the new byte codes required for debugging:
    // codeMap.put(... etc. ...)
    codeMap.put("POP", "PopByteCode");
    codeMap.put("LIT", "LitByteCode");
    codeMap.put("CALL", "CallByteCode");
    codeMap.put("LINE", "LineByteCode");
    codeMap.put("FUNCTION", "FunctionByteCode");
    codeMap.put("FORMAL", "FormalByteCode");
    codeMap.put("STORE", "StoreByteCode");
    codeMap.put("LOAD", "LoadByteCode");
    codeMap.put("RETURN", "ReturnByteCode");
  }

  public static String get(String code) {
    String result = codeMap.get(code.trim().toUpperCase());

    if (result == null) {
      return CodeTable.get(code);
    } else {
      return result;
    }
  }
}