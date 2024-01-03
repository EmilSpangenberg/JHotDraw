package org.jhotdraw.action.edit;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import org.jhotdraw.util.ResourceBundleUtil;
import org.mockito.Mockito;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.event.ActionEvent;
import java.util.Locale;

import static org.mockito.Mockito.*;
class SelectAllActionTest {

    @Test
    void testActionPerformedWithNullTarget() {
        // Create a mock ResourceBundleUtil
        ResourceBundleUtil labelsMock = mock(ResourceBundleUtil.class);

        // Create SelectAllAction with the mock ResourceBundleUtil
        SelectAllAction selectAllAction = new SelectAllAction(null, labelsMock);

        // Perform the test
        selectAllAction.actionPerformed(null); // Should not throw any exceptions
    }

    /*
    @Test
    public void testActionPerformed() {
        ResourceBundleUtil mockBundleUtil = mock(ResourceBundleUtil.class);
        when(mockBundleUtil.getString(anyString())).thenReturn("Mocked Label");

        SelectAllAction selectAllAction = Mockito.spy(new SelectAllAction(null, mockBundleUtil));

        ActionEvent mockEvent = mock(ActionEvent.class);
        JComponent mockComponent = mock(JComponent.class);

        // Mock the getTargetComponent method to return your mocked component
        doReturn(mockComponent).when(selectAllAction).getTargetComponent();

        // Mock the isEnabled method of the component
        when(mockComponent.isEnabled()).thenReturn(true);

        // Mock the selectAll method to avoid its actual execution
        doNothing().when(mockComponent).selectAll();

        // Trigger the actionPerformed method
        selectAllAction.actionPerformed(mockEvent);

        // Verify that the selectAll method was called with the mocked component
        verify(mockComponent).selectAll();
    }
    */

    @Test
    public void testUpdateEnabled() {
        ResourceBundleUtil labelsMock = mock(ResourceBundleUtil.class);

        SelectAllAction selectAllAction = Mockito.spy(new SelectAllAction(null, labelsMock));

        JComponent mockComponent = mock(JComponent.class);

        // Mock the getTargetComponent method to return your mocked component
        doReturn(mockComponent).when(selectAllAction).getTargetComponent();

        // Mock the isEnabled method of the component
        when(mockComponent.isEnabled()).thenReturn(true);

        // Trigger the updateEnabled method
        selectAllAction.updateEnabled();

        // Verify that the setEnabled method was called with the correct argument
        verify(selectAllAction).setEnabled(true);
    }
}
