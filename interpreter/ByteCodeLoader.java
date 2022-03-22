package interpreter;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Scanner;

import interpreter.bytecode.ByteCode;

import interpreter.bytecode.debuggercodes.DebuggerByteCode;
import interpreter.debugger.DebuggerCodeTable;

public class ByteCodeLoader {

  private File sourceFile;
  private Scanner Reader;
  private String CurrentLine;
  private ByteCode byteCode;

  private DebuggerByteCode debuggerByteCode;

  private ArrayList<ByteCode> ByteCodes = new ArrayList<ByteCode>();

  private ArrayList<DebuggerByteCode> debuggerByteCodes = new ArrayList<DebuggerByteCode>();

  private ArrayList<ArrayList<String>> ByteCodeLines = new ArrayList<ArrayList<String>>();

  public ByteCodeLoader(String byteCodeFile) throws IOException {
    sourceFile = new File(byteCodeFile);
    Reader = new Scanner(sourceFile);
  }

  public Program loadCodes(Boolean debuggerSwitch) {
    while (Reader.hasNextLine()) {
      CurrentLine = Reader.nextLine();
      String[] Codes = CurrentLine.split(" ");
      ArrayList<String> ByteCodeProperties = new ArrayList<String>();
      for (int i = 0; i < Codes.length; i++) {
        if (Codes[i] != "") {
          ByteCodeProperties.add(Codes[i]);
        }
      }
      String ByteCodeName = ByteCodeProperties.get(0);
      String CodeClass = DebuggerCodeTable.get(ByteCodeName);
      try {
        if (!debuggerSwitch) {
          byteCode = (ByteCode) Class.forName("interpreter.bytecode." + CodeClass).getDeclaredConstructor()
              .newInstance();
          ByteCodes.add(byteCode);
        } else {
          debuggerByteCode = (DebuggerByteCode) Class.forName("interpreter.bytecode.debuggercodes." + CodeClass)
              .getDeclaredConstructor().newInstance();
          debuggerByteCodes.add(debuggerByteCode);
        }
      } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
          | NoSuchMethodException | SecurityException | ClassNotFoundException e) {
        // e.printStackTrace();
      }
      ByteCodeLines.add(ByteCodeProperties);
    }
    return new Program(ByteCodes, debuggerByteCodes, ByteCodeLines);
  }
}