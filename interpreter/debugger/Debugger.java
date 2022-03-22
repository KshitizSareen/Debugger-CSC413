package interpreter.debugger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

import interpreter.Interpreter;
import interpreter.Program;
import interpreter.debugger.ui.DebuggerShell;
import interpreter.debugger.ui.DisplayCode;

public class Debugger extends Interpreter {
  private DebuggerShell shell;

  private Stack<FunctionEnvironmentRecord> FunctionEnvironmentRecords = new Stack<FunctionEnvironmentRecord>();

  private FunctionEnvironmentRecord currentFunctionEnvironmentRecord;

  private DebuggerVirtualMachine virtualMachine;

  private Vector<Entry> Entries = new Vector<Entry>();

  private boolean endExecution = false;

  private Stack<SymbolValues> framesStack = new Stack<SymbolValues>();

  private SymbolValues currentFrame;

  public Debugger(String baseFileName) {
    super(baseFileName + ".cod");
    AddToFunctionEnvironmentRecords(new FunctionEnvironmentRecord());
    ReadBaseFile(baseFileName);
    currentFrame = new SymbolValues(1, Entries.size());
    // Update to add the correct extensions to the base file name to
    // load the byte code file, as well as to load the source file
  }

  @Override
  public void run() {
    shell = new DebuggerShell(this);

    Program program = byteCodeLoader.loadCodes(true);
    virtualMachine = new DebuggerVirtualMachine(program, this);
    ExecutePrompt();
  }

  public void AddToFunctionEnvironmentRecords(FunctionEnvironmentRecord functionEnvironmentRecord) {
    FunctionEnvironmentRecords.add(functionEnvironmentRecord);
    currentFunctionEnvironmentRecord = FunctionEnvironmentRecords.peek();
    currentFunctionEnvironmentRecord.beginScope();
  }

  public void SetFunctionInFunctionEnvironment(String name, int startLine, int endLine) {
    currentFunctionEnvironmentRecord.setFunctionInfo(name, startLine, endLine);
  }

  public void SetLineNumber(int lineNumber) {
    currentFunctionEnvironmentRecord.setCurrentLineNumber(lineNumber);
  }

  public void AddSymbolToFunctionEnvironmentRecord(String symbol, int offset) {
    currentFunctionEnvironmentRecord.enter(symbol, offset);
  }

  public void PopFromFunctionEnvironmentRecord(int count) {
    currentFunctionEnvironmentRecord.pop(count);
  }

  public void PopFromFunctionEnvironmentRecords() {
    FunctionEnvironmentRecords.pop();
    currentFunctionEnvironmentRecord = FunctionEnvironmentRecords.peek();
  }

  private void ReadBaseFile(String baseFile) {
    File fileToRead = new File(baseFile);
    Scanner reader;
    try {
      reader = new Scanner(fileToRead);
      int lineNumber = 1;
      while (reader.hasNextLine()) {
        String sourceLine = reader.nextLine();
        Entries.add(new Entry(lineNumber, sourceLine, false));
        lineNumber += 1;
      }
      reader.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  public void SetBreakPoint(int lineNumber) {
    Entries.get(lineNumber - 1).SetIsBreakingPoint(true);
  }

  public void ExecutePrompt() {
    if (!endExecution) {
      shell.prompt().execute(this);
    }
  }

  public Vector<Entry> RetrieveEntries() {
    return Entries;
  }

  public FunctionEnvironmentRecord RetrieveCurrentFunctionEnvironemtRecord() {
    return currentFunctionEnvironmentRecord;
  }

  public void ContinueExecution() {
    virtualMachine.StartExecution();
  }

  public Boolean CheckIfLineIsBreakPoint(int lineNumber) {
    if (lineNumber - 1 >= 0) {
      return Entries.get(lineNumber - 1).GetBreakingPoint();
    }
    return false;
  }

  public void ExecuteBytecode() {
    virtualMachine.ExecuteBytecode();
  }

  public void EndExecution() {
    endExecution = true;
  }

  public void DisplaySourceCode(Boolean DisplayFullCode) {
    if (!endExecution) {
      new DisplayCode(Entries, currentFunctionEnvironmentRecord.GetLineNumber(), currentFrame.GetStartLine(),
          currentFrame.GetEndLine(), DisplayFullCode);
    }
  }

  public void AddFrame(int startLine, int endLine) {
    framesStack.add(new SymbolValues(startLine, endLine));
    currentFrame = framesStack.peek();
  }

  public void RemoveFrame() {
    framesStack.pop();
    currentFrame = framesStack.peek();
  }

  public void AddSymbolToFrame(String Symbol, int Value) {
    currentFrame.EnterSymbol(Symbol, Value);
  }

  public SymbolValues RetrieveCurrentFrame() {
    return currentFrame;
  }
}