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
        when(model.execute("15+21=")).thenReturn(36.0);
        assertEquals(model.execute("15+21="), 36, 0);
        verifyNoMoreInteractions(view);
    }

    @Test
    public void shouldDivideNumbers() {
        when(model.execute("15/5=")).thenReturn(3.0);
        assertEquals(model.execute("15/5="), 3.0, 0);
        verifyNoMoreInteractions(view);
    }

    @Test
    public void shouldMultiplyNumbers() {
        when(model.execute("12*12=")).thenReturn(144.0);
        assertEquals(model.execute("12*12="), 144.0, 0);
        verifyNoMoreInteractions(view);
    }

    @Test
    public void shouldSubstractNumbers() {
        when(model.execute("150-99=")).thenReturn(51.0);
        assertEquals(model.execute("150-99="), 51.0, 0);
        verifyNoMoreInteractions(view);
    }
}