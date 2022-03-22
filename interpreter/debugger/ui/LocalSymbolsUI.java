package interpreter.debugger.ui;

import java.util.HashMap;
import interpreter.debugger.SymbolValues;

public class LocalSymbolsUI {
    public LocalSymbolsUI(SymbolValues currentFrame) {
        HashMap<String, Integer> SymbolValue = currentFrame.GetSymbolValue();
        SymbolValue.forEach((symbol, value) -> {
            System.out.println(symbol + ": " + value);
        });
    }
}
