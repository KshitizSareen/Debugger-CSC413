/**
 * DO NOT provide a method that returns components contained WITHIN the VM (this 
 * is the exact situation that will break encapsulation) - you should request 
 * that the VM performs operations on its components. This implies that the VM 
 * owns the components and is free to change them, as needed, without breaking 
 * clients' code (e.g., suppose I decide to change the name of the variable that 
 * holds my runtime stack - if your code had referenced that variable then your 
 * code would break. This is not an unusual situation - you can consider the 
 * names of methods in the Java libraries that have been deprecated).
 * 
 * Consider that the VM calls the individual ByteCodes' execute method and 
 * passes itself as a parameter. For the ByteCode to execute, it must invoke 
 * one or more methods in the runStack. It can do this by executing 
 * VM.runStack.pop(); however, this does break encapsulation. To avoid this, 
 * you'll need to have a corresponding set of methods within the VM that do 
 * nothing more than pass the call to the runStack. e.g., you would want to 
 * define a VM method:
 *     public int popRunStack() {
 *       return runStack.pop();
 *     }
 * called by, e.g.,
 *     int temp = VM.popRunStack();
 */
package interpreter;

import java.util.Stack;
import interpreter.bytecode.ByteCode;

public class VirtualMachine {

  protected int pc;
  protected RunTimeStack runTimeStack;
  // This may not be the right parameterized type!!
  protected boolean isRunning;
  protected Program program;
  protected Stack<Integer> returnAddresses = new Stack<Integer>();
  private boolean DumpState = false;

  public VirtualMachine(Program program) {
    this.program = program;
  }

  public void executeProgram() {
    pc = 0;
    returnAddresses.push(0);
    runTimeStack = new RunTimeStack(program);
    isRunning = true;
    while (isRunning) {
      ByteCode code = program.getCode(pc);
      code.execute(this);
      // runTimeStack.printrunStack();
      // check that the operation is correct
      pc++;
    }
  }

  public void HaltExecution() {
    isRunning = false;
  }

  public void SetProgramCounter() {
    pc = Integer.parseInt(program.getDataForCode(pc, 1));
  }

  public int PopRunStack() {
    return runTimeStack.pop();
  }

  public void PushInRunStack(int item) {
    runTimeStack.push(item);
  }

  public int GetTopOfStack() {
    return runTimeStack.peek();
  }

  public int StoreInRunTimeStack() {
    int offset = Integer.parseInt(program.getDataForCode(pc, 1));
    return runTimeStack.store(offset);
  }

  public int LoadItemInRunStack() {
    int offset = Integer.parseInt(program.getDataForCode(pc, 1));
    return runTimeStack.load(offset);
  }

  public void CreateNewFrame() {
    int offset = Integer.parseInt(program.getDataForCode(pc, 1));
    runTimeStack.newFrameAt(offset);
  }

  public void ReturnFromFrame() {
    runTimeStack.popFrame();
    DumpRunStack();
    pc = returnAddresses.pop();
  }

  public void AddProgramCounterToStack() {
    returnAddresses.push(pc);
  }

  public void SetDumpState(Boolean State) {
    DumpState = State;
  }

  public String GetDataForCode(int index) {
    return program.getDataForCode(pc, index);
  }

  public void DumpRunStack() {
    runTimeStack.dump(pc, DumpState);
  }

  public String GetLengthOfRunTimeStack() {
    return Integer.toString(runTimeStack.GetLengthOfRunTimeStack());
  }
}