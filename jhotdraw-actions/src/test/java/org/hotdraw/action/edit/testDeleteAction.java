package org.hotdraw.action.edit;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import org.jhotdraw.action.edit.DeleteAction;
import org.jhotdraw.api.gui.EditableComponent;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import javax.swing.text.JTextComponent;

public class testDeleteAction {
    @Mock
    private JTextComponent mockTextComponent;

    @Mock
    private ActionEvent mockEvent;

    @Mock
    private Document mockDocument;

    @Mock
    private Caret mockCaret;

    @InjectMocks
    private DeleteAction deleteactionclass;

    @Mock
    private EditableComponent mockEditableComponent;


    @Test
    public void testDeleteTextSelectionOrNextCharacter() throws BadLocationException {

        JTextComponent mockComponent = mock(JTextComponent.class);
        Document mockDocument = mock(Document.class);
        Caret mockCaret = mock(Caret.class);

        when(mockComponent.getDocument()).thenReturn(mockDocument);
        when(mockComponent.getCaret()).thenReturn(mockCaret);
        when(mockCaret.getDot()).thenReturn(5);
        when(mockCaret.getMark()).thenReturn(7);
        when(mockDocument.getLength()).thenReturn(10);

        boolean result = deleteactionclass.deleteTextSelectionOrNextCharacter(mockComponent, true);
        verify(mockDocument, times(1)).remove(anyInt(), anyInt());
        assertEquals(false, result);
    }

    @Test
    public void testDeleteNextChar() throws BadLocationException {
        DeleteAction deleteAction = new DeleteAction();

        JTextComponent textComponent = new JTextArea("Hello");
        textComponent.setSelectionStart(0);
        textComponent.setSelectionEnd(1);

        ActionEvent actionEvent = new ActionEvent(
                textComponent,
                ActionEvent.ACTION_PERFORMED,
                "Delete",
                KeyEvent.VK_DELETE,
                InputEvent.CTRL_DOWN_MASK
        );

        deleteAction.deleteNextChar(actionEvent);

        assertEquals("ello", textComponent.getText());
    }

    @Test
    public void FalsetestDeleteNextChar() throws BadLocationException {
        DeleteAction deleteAction = new DeleteAction();

        JTextComponent textComponent = new JTextArea("Hello");
        textComponent.setSelectionStart(0);
        textComponent.setSelectionEnd(1);

        ActionEvent actionEvent = new ActionEvent(
                textComponent,
                ActionEvent.ACTION_PERFORMED,
                "Delete",
                KeyEvent.VK_DELETE,
                InputEvent.CTRL_DOWN_MASK
        );

        deleteAction.deleteNextChar(actionEvent);

        assertNotEquals("bob", textComponent.getText());
    }
}
