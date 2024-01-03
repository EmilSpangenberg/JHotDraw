package org.jhotdraw.action.edit;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import javax.swing.JComponent;
import org.jhotdraw.api.gui.EditableComponent;
import org.jhotdraw.datatransfer.ClipboardUtil;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class DuplicateActionTest {

    private DuplicateAction duplicateAction;
    private JComponent target;

    @Before
    public void setUp() {
        duplicateAction = new DuplicateAction();
        target = new JComponent() {
        };
    }

    @Test
    public void testDuplicateAction() {
        assertNotNull(duplicateAction);
        assertTrue(duplicateAction instanceof AbstractSelectionAction);
    }

    @Test
    public void testActionPerformed() {
        duplicateAction.actionPerformed(new ActionEvent(target, 0, ""));

        Transferable transferable = ClipboardUtil.getClipboard().getContents(null);
        assertNotNull(transferable);
        assertTrue(transferable.isDataFlavorSupported(DataFlavor.stringFlavor));
    }
}

