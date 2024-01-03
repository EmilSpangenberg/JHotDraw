package org.jhotdraw.action.edit;

import com.tngtech.jgiven.Stage;
import org.jhotdraw.api.gui.EditableComponent;
import org.jhotdraw.datatransfer.ClipboardUtil;
import org.jhotdraw.draw.figure.Figure;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.event.ActionEvent;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.Set;

import static org.junit.Assert.*;

public class DuplicateActionBDDtest extends Stage<DuplicateActionBDDtest> {
    private DuplicateAction action = new DuplicateAction();
    public JComponent target = new JComponent() {
    };

    @Test
    public void whenADuplicateIsMade() {

        action.actionPerformed(new ActionEvent(target, 0, ""));

        Set<Figure> selectedFigures = null ;
        ArrayList<Figure> duplicates = null ;

        assertEquals(selectedFigures.size(), duplicates.size());

    }
}