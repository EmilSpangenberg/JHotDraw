/*
 * @(#)SelectAllAction.java
 *
 * Copyright (c) 1996-2010 The authors and contributors of JHotDraw.
 * You may not use, copy or modify this file, except in compliance with the
 * accompanying license terms.
 */
package org.jhotdraw.action.edit;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
import org.jhotdraw.api.gui.EditableComponent;
import org.jhotdraw.util.*;

import dk.sdu.mmmi.featuretracer.lib.FeatureEntryPoint;

/**
 * Selects all items.
 * <p>
 * This action acts on the last {@link org.jhotdraw.gui.EditableComponent} /
 * {@code JTextComponent} which had the focus when the {@code ActionEvent}
 * was generated.
 * <p>
 * This action is called when the user selects the Select All item in the
 * Edit menu. The menu item is automatically created by the application.
 * <p>
 * If you want this behavior in your application, you have to create an action
 * with this ID and put it in your {@code ApplicationModel} in method
 * {@link org.jhotdraw.app.ApplicationModel#initApplication}.
 * <p>
 * <hr>
 * <b>Design Patterns</b>
 * <p>
 * <em>Framework</em><br>
 * The interfaces and classes listed below work together:
 * <br>
 * Contract: {@link org.jhotdraw.gui.EditableComponent}, {@code JTextComponent}.<br>
 * Client: {@link org.jhotdraw.action.edit.AbstractSelectionAction},
 * {@link org.jhotdraw.action.edit.DeleteAction},
 * {@link org.jhotdraw.action.edit.DuplicateAction},
 * {@link org.jhotdraw.action.edit.SelectAllAction},
 * {@link org.jhotdraw.action.edit.ClearSelectionAction}.
 * <hr>
 *
 * @author Werner Randelshofer.
 * @version $Id$
 */
public class SelectAllAction extends AbstractSelectionAction {

    private static final long serialVersionUID = 1L;
    public static final String ID = "edit.selectAll";

    /**
     * Creates a new instance which acts on the currently focused component.
     */

    /**
     * Creates a new instance which acts on the specified component.
     *
     * @param target The target of the action. Specify null for the currently
     *               focused component.
     */
    @FeatureEntryPoint(value = "SelectAll")
    public SelectAllAction(JComponent target, ResourceBundleUtil labels) {
        super(target);
        configureAction(labels);
    }

    @FeatureEntryPoint(value = "SelectAllActionPerformed")
    @Override
    public void actionPerformed(ActionEvent evt) {
        JComponent c = getTargetComponent();
        if (c != null && c.isEnabled()) {
            if (c instanceof EditableComponent) {
                ((EditableComponent) c).selectAll();
            } else if (c instanceof JTextComponent) {
                ((JTextComponent) c).selectAll();
            } else {
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }

    @Override
    protected void updateEnabled() {
        setEnabled(getTargetComponent() != null && getTargetComponent().isEnabled());
    }

    private void configureAction(ResourceBundleUtil labels) {
        labels.configureAction(this, ID);
    }


    public JComponent getTargetComponent() {
        JComponent c = target;
        if (c == null && (KeyboardFocusManager.getCurrentKeyboardFocusManager().
                getPermanentFocusOwner() instanceof JComponent)) {
            c = (JComponent) KeyboardFocusManager.getCurrentKeyboardFocusManager().
                    getPermanentFocusOwner();
        }
        return c;
    }
}
