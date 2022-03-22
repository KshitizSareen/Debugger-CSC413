package interpreter.debugger;

import interpreter.Program;
import interpreter.RunTimeStack;
import interpreter.VirtualMachine;
import interpreter.bytecode.debuggercodes.DebuggerByteCode;

public class DebuggerVirtualMachine extends VirtualMachine {

  private Debugger debugger;

  public DebuggerVirtualMachine(Program program, Debugger debugger) {
    super(program);

    this.debugger = debugger;
    pc = 0;
    returnAddresses.push(0);
    runTimeStack = new RunTimeStack(program);
    isRunning = true;
  }

  @Override
  public void executeProgram() {
    while (isRunning) {
      ExecuteBytecode();
    }
    DisplaySourceCode();
    ExecutePrompt();
  }

  @Override
  public void HaltExecution() {
    isRunning = false;
    EndExecution();
  }

  public void AddToFunctionEnvironmentRecords(FunctionEnvironmentRecord functionEnvironmentRecord) {
    debugger.AddToFunctionEnvironmentRecords(functionEnvironmentRecord);
  }

  public void SetFunctionInFunctionEnvironment(String name, int startLine, int endLine) {
    debugger.SetFunctionInFunctionEnvironment(name, startLine, endLine);
  }

  public void SetLineNumber(int lineNumber) {
    debugger.SetLineNumber(lineNumber);
  }

  public void AddSymbolToFunctionEnvironmentRecord(String symbol, int offset) {
    debugger.AddSymbolToFunctionEnvironmentRecord(symbol, offset);
  }

  public void PopFromFunctionEnvironmentRecord(int count) {
    debugger.PopFromFunctionEnvironmentRecord(count);
  }

  public void PopFromFunctionEnvironmentRecords() {
    debugger.PopFromFunctionEnvironmentRecords();
  }

  public void StartExecution() {
    isRunning = true;
    executeProgram();
  }

  public void StopExecution() {
    isRunning = false;
  }

  public Boolean CheckIfBreakingPoint(int lineNumber) {
    return debugger.CheckIfLineIsBreakPoint(lineNumber);
  }

  public void ExecuteBytecode() {
    DebuggerByteCode code = program.getDebuggerByteCode(pc);
    code.execute(this);
    pc++;
  }

  public void EndExecution() {
    debugger.EndExecution();
  }

  public void ExecutePrompt() {
    debugger.ExecutePrompt();
  }

  public void DisplaySourceCode() {
    debugger.DisplaySourceCode(true);
  }

  public void AddSymbolToFrame(String Symbol, int Value) {
    debugger.AddSymbolToFrame(Symbol, Value);
  }

  public void AddFrame(int startLine, int endLine) {
    debugger.AddFrame(startLine, endLine);
  }

  public void RemoveFrame() {
    debugger.RemoveFrame();
  }
}