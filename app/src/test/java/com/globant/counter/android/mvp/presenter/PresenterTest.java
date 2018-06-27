package com.globant.counter.android.mvp.presenter;

import com.globant.counter.android.mvp.model.CountModel;
import com.globant.counter.android.mvp.view.CountView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class PresenterTest {

    private CalculatorPresenter presenter;
    @Mock private CountModel model;
    @Mock private CountView view;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        presenter = new CalculatorPresenter(model, view);
    }

    @Test
    public void shouldAddNumbers() {
        String formula = "15+21=";
        when(model.execute(formula)).thenReturn(36.0);
        assertEquals(model.execute(formula), 36, 0);
        verifyNoMoreInteractions(view);
    }

    @Test
    public void shouldDivideNumbers() {
        String formula = "15/5=";
        when(model.execute(formula)).thenReturn(3.0);
        assertEquals(model.execute(formula), 3.0, 0);
        verifyNoMoreInteractions(view);
    }

    @Test
    public void shouldMultiplyNumbers() {
        String formula = "12*12=";
        when(model.execute(formula)).thenReturn(144.0);
        assertEquals(model.execute(formula), 144.0, 0);
        verifyNoMoreInteractions(view);
    }

    @Test
    public void shouldSubtractNumbers() {
        String formula = "150-99=";
        when(model.execute(formula)).thenReturn(51.0);
        assertEquals(model.execute(formula), 51.0, 0);
        verifyNoMoreInteractions(view);
    }
}