package interpreter;

import java.util.HashMap;

public class CodeTable {

  public static HashMap<String, String> ByteCodeMap = new HashMap<String, String>();

  public static void init() {
    ByteCodeMap.put("HALT", "HaltByteCode");
    ByteCodeMap.put("POP", "PopByteCode");
    ByteCodeMap.put("FALSEBRANCH", "FalseBranchByteCode");
    ByteCodeMap.put("GOTO", "GotoByteCode");
    ByteCodeMap.put("STORE", "StoreByteCode");
    ByteCodeMap.put("LOAD", "LoadByteCode");
    ByteCodeMap.put("LIT", "LitByteCode");
    ByteCodeMap.put("ARGS", "ArgsByteCode");
    ByteCodeMap.put("CALL", "CallByteCode");
    ByteCodeMap.put("RETURN", "ReturnByteCode");
    ByteCodeMap.put("BOP", "BopByteCode");
    ByteCodeMap.put("READ", "ReadByteCode");
    ByteCodeMap.put("WRITE", "WriteByteCode");
    ByteCodeMap.put("LABEL", "LabelByteCode");
    ByteCodeMap.put("DUMP", "DumpByteCode");
  }

  public static String get(String code) {
    String codeClass = ByteCodeMap.get(code);
    return codeClass;
  }
}