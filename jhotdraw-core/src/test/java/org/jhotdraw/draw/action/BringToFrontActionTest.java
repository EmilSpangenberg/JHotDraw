package org.jhotdraw.draw.action;

import org.jhotdraw.draw.figure.Figure;
import org.jhotdraw.draw.*;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class BringToFrontActionTest {
    private DrawingEditor editor;
    private DrawingView view;
    private BringToFrontAction bringToFrontAction;
    private Set<Figure> figures;
    private Drawing drawing;

    @Before
    public void setUp() {
        editor = mock(DrawingEditor.class);
        view = mock(DrawingView.class);
        drawing = mock(Drawing.class);
        bringToFrontAction = new BringToFrontAction(editor);
        figures = new HashSet<>();
        when(view.getDrawing()).thenReturn(drawing);
        when(view.getSelectedFigures()).thenReturn(figures);
        when(bringToFrontAction.getView()).thenReturn(view);
    }

    @Test
    public void testBringToFrontAction_WithSelectedFigure() {
        Figure figure = mock(Figure.class);
        figures.add(figure); // Adding the figure before the action

        bringToFrontAction.actionPerformed(null);

        verify(drawing, times(1)).sort(any(LinkedList.class)); // Expect any LinkedList as argument

        assert !figures.isEmpty() : "Figures set should not be empty after adding a figure";
    }

    @Test
    public void testBringToFrontAction_WithoutSelectedFigure() {
        bringToFrontAction.actionPerformed(null);

        verify(drawing, never()).bringToFront(any(Figure.class));

        assert figures.isEmpty() : "Figures set should be empty when no figures are selected";
    }
}