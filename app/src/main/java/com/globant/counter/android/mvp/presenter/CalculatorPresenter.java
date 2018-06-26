package com.globant.counter.android.mvp.presenter;

import android.app.Activity;

import com.globant.counter.android.mvp.model.CountModel;
import com.globant.counter.android.mvp.view.CountView;
import com.globant.counter.android.util.bus.RxBus;
import com.globant.counter.android.util.bus.observers.CheckButtonBusObserver;
import com.globant.counter.android.util.bus.observers.ResetButtonObserver;

public class CalculatorPresenter {

    private CountModel model;
    private CountView view;

    public CalculatorPresenter(CountModel model, CountView view) {
        this.model = model;
        this.view = view;
    }

    public void onCheckButtonPressed() {
        String formula = view.getFormula();
        model.execute(formula);
        view.setResult(String.valueOf(model.execute(formula)));
    }

    public void onResetButtonPressed() {
        view.reset();
    }

    public void register() {
        Activity activity = view.getActivity();

        if (activity == null) {
            return;
        }

        RxBus.subscribe(activity, new CheckButtonBusObserver() {
            @Override
            public void onEvent(CheckButton value) {
                onCheckButtonPressed();
            }
        });

        RxBus.subscribe(activity, new ResetButtonObserver() {
            @Override
            public void onEvent(ResetButtonPressed value) {
                onResetButtonPressed();
            }
        });

    }

    public void unregister() {
        Activity activity = view.getActivity();

        if (activity == null) {
            return;
        }
        RxBus.clear(activity);
    }
}
