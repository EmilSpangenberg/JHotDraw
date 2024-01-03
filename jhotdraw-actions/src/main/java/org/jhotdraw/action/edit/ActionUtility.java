package org.jhotdraw.action.edit;

import javax.swing.*;
import java.awt.*;

public class ActionUtility {

    public static JComponent getJComponent(JComponent c){
        if (c == null && (KeyboardFocusManager.getCurrentKeyboardFocusManager().
                getPermanentFocusOwner() instanceof JComponent)) {
            c = (JComponent) KeyboardFocusManager.getCurrentKeyboardFocusManager().
                    getPermanentFocusOwner();
        }
        return c;
    }

}
