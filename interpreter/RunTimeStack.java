package interpreter;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Vector;

public class RunTimeStack {

  private Stack<Vector<Integer>> framePointers;
  // This may not be the right parameterized type!!
  private Vector<Integer> runStack;

  private int LeftColumns = 25;

  private Program program;

  public RunTimeStack(Program program) {
    framePointers = new Stack<Vector<Integer>>();
    runStack = new Vector<Integer>();
    framePointers.add(runStack);
    this.program = program;
  }

  /**
   * The purpose of this function is to dump the RunTimeStack for the purpose of
   * debugging.
   */
  public void dump(int programCounter, Boolean DumpState) {
    if (DumpState) {
      ArrayList<String> ByteCodePropeties = program.GetByteCodeProperties(programCounter);
      String ByteCode = ByteCodePropeties.get(0);
      String ByteCodeToPrint = "";
      if (ByteCode.equals("GOTO") || ByteCode.equals("FALSEBRANCH")) {
        ByteCodeToPrint = ByteCode + " " + ByteCodePropeties.get(ByteCodePropeties.size() - 1);
      } else if (ByteCode.equals("LIT")) {
        ByteCodeToPrint = ByteCode + " " + ByteCodePropeties.get(1);
        if (ByteCodePropeties.size() > 2) {
          ByteCodeToPrint = FormCodeForRunstack(ByteCodeToPrint, ByteCodePropeties, ByteCode,
              "int " + ByteCodePropeties.get(2));
        }
      } else if (ByteCode.equals("LOAD")) {
        ByteCodeToPrint = ByteCode + " " + ByteCodePropeties.get(1);
        if (ByteCodePropeties.size() > 2) {
          ByteCodeToPrint = FormCodeForRunstack(ByteCodeToPrint, ByteCodePropeties, ByteCode,
              "<load " + ByteCodePropeties.get(2) + ">");
        }
      } else if (ByteCode.equals("STORE")) {
        ByteCodeToPrint = ByteCode + " " + ByteCodePropeties.get(1);
        if (ByteCodePropeties.size() > 2) {
          ByteCodeToPrint = FormCodeForRunstack(ByteCodeToPrint, ByteCodePropeties, ByteCode,
              ByteCodePropeties.get(2) + " = " + runStack.lastElement());
        }
      } else if (ByteCode.equals("RETURN")) {
        ByteCodeToPrint = ByteCode;
        if (ByteCodePropeties.size() > 1) {
          String BaseID = ByteCodePropeties.get(1).split("<<")[0];
          ByteCodeToPrint += " " + ByteCodePropeties.get(1);
          ByteCodeToPrint = FormCodeForFramePointers(ByteCodeToPrint, "exit " + BaseID + ": " + runStack.lastElement());
        } else {
          ByteCodeToPrint = FormCodeForFramePointers(ByteCodeToPrint, "exit : " + runStack.lastElement());
        }
      } else if (ByteCode.equals("CALL")) {
        ByteCodeToPrint = ByteCode;
        if (ByteCodePropeties.size() > 2) {
          String BaseID = ByteCodePropeties.get(2).split("<<")[0];
          ArrayList<String> ArgElements = GetFrameElements();
          ByteCodeToPrint += " " + ByteCodePropeties.get(2);
          ByteCodeToPrint = FormCodeForFramePointers(ByteCodeToPrint,
              BaseID + "(" + String.join(",", ArgElements) + ")");
        }
      } else {
        ByteCodeToPrint = String.join(" ", ByteCodePropeties);
      }
      System.out.println(ByteCodeToPrint);
      printrunStack();
    }
  }

  private ArrayList<String> GetFrameElements() {
    ArrayList<String> runStackElements = new ArrayList<String>();
    for (int i = 0; i < runStack.size(); i++) {
      runStackElements.add(runStack.get(i).toString());
    }
    return runStackElements;
  }

  /**
   * Returns the top item on the runtime stack.
   */
  public int peek() {
    return runStack.lastElement();
  }

  /**
   * Pops the top item from the runtime stack, returning the item.
   */
  public int pop() {
    return runStack.remove(runStack.size() - 1);
  }

  /**
   * Push an item on to the runtime stack, returning the item that was just
   * pushed.
   */
  public int push(int item) {
    runStack.add(item);
    return item;
  }

  /**
   * This second form with an Integer parameter is used to load literals onto the
   * stack.
   */
  public Integer push(Integer i) {
    runStack.add(i);
    return i;
  }

  /**
   * Start a new frame, where the parameter offset is the number of slots down
   * from the top of the RunTimeStack for starting the new frame.
   */
  public void newFrameAt(int offset) {

    Vector<Integer> tempVector = new Vector<Integer>();
    for (int i = 0; i < offset; i++) {
      tempVector.add(runStack.remove(runStack.size() - 1));
    }
    framePointers.push(tempVector);
    runStack = framePointers.peek();
  }

  /**
   * We pop the top frame when we return from a function; before popping, the
   * functions’ return value is at the top of the stack so we’ll save the value,
   * pop the top frame, and then push the return value.
   */
  public void popFrame() {
    int topElem = runStack.remove(runStack.size() - 1);
    framePointers.pop();
    runStack = framePointers.peek();
    runStack.add(topElem);
  }

  /**
   * Used to store into variables.
   */
  public int store(int offset) {
    int topElem = runStack.lastElement();
    runStack.set(offset, topElem);
    return runStack.remove(runStack.size() - 1);
  }

  /**
   * Used to load variables onto the stack.
   */
  public int load(int offset) {
    int currentElem = runStack.get(offset);
    runStack.add(currentElem);
    return currentElem;
  }

  private void printrunStack() {
    String framePointersString = framePointers.toString();
    System.out.println(framePointersString.substring(1, framePointersString.length() - 1));
  }

  private String FormCodeForRunstack(String InitialString, ArrayList<String> ByteCodePropeties, String ByteCode,
      String EndingString) {
    String ByteCodeToPrint = InitialString;
    if (ByteCodePropeties.size() > 2) {
      ByteCodeToPrint += " " + ByteCodePropeties.get(2);
      ByteCodeToPrint = AddSpaces(ByteCodeToPrint);
      ByteCodeToPrint += EndingString;
    }
    return ByteCodeToPrint;
  }

  private String FormCodeForFramePointers(String InitialString, String EndingString) {
    String ByteCodeToPrint = InitialString;
    ByteCodeToPrint = AddSpaces(ByteCodeToPrint);
    ByteCodeToPrint += EndingString;
    return ByteCodeToPrint;
  }

  private String AddSpaces(String ByteCodeToPrint) {
    int currentLength = ByteCodeToPrint.length();
    for (int i = 0; i < LeftColumns - currentLength; i++) {
      ByteCodeToPrint += " ";
    }
    return ByteCodeToPrint;
  }

  public int GetLengthOfRunTimeStack() {
    return runStack.size();
  }

}