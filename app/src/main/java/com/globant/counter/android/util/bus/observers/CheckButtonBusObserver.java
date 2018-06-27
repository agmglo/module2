package com.globant.counter.android.util.bus.observers;

public abstract class CheckButtonBusObserver extends BusObserver<CheckButtonBusObserver.CheckButton> {
    public CheckButtonBusObserver() {
        super(CheckButton.class);
    }

    public static class CheckButton {
        //do nothing
    }
}