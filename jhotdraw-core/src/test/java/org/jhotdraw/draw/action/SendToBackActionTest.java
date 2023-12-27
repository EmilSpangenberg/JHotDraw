package org.jhotdraw.draw.action;

import org.jhotdraw.draw.figure.Figure;
import org.jhotdraw.draw.*;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class SendToBackActionTest {
    private DrawingEditor editor;
    private DrawingView view;
    private SendToBackAction sendToBackAction;
    private Set<Figure> figures;
    private Drawing drawing;

    @Before
    public void setUp() {
        editor = mock(DrawingEditor.class);
        view = mock(DrawingView.class);
        drawing = mock(Drawing.class);
        sendToBackAction = new SendToBackAction(editor);
        figures = new HashSet<>();
        when(view.getDrawing()).thenReturn(drawing);
        when(view.getSelectedFigures()).thenReturn(figures);
        when(sendToBackAction.getView()).thenReturn(view);
    }

    @Test
    public void testSendToBack_WithSelectedFigure() {
        Figure figure = mock(Figure.class);
        figures.add(figure);

        sendToBackAction.actionPerformed(null);

        verify(drawing, times(1)).sendToBack(figure);

        assert !figures.isEmpty() : "Figures set should not be empty after adding a figure";
    }

    @Test
    public void testSendToBack_WithoutSelectedFigure() {
        sendToBackAction.actionPerformed(null);

        verify(drawing, never()).sendToBack(any(Figure.class));

        assert figures.isEmpty() : "Figures set should be empty when no figures are selected";
    }
}