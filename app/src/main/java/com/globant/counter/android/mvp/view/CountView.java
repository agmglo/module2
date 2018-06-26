package com.globant.counter.android.mvp.view;

import android.app.Activity;
import android.widget.EditText;
import android.widget.TextView;

import com.globant.counter.android.R;
import com.globant.counter.android.util.bus.RxBus;
import com.globant.counter.android.util.bus.observers.CheckButtonBusObserver;
import com.globant.counter.android.util.bus.observers.ResetButtonObserver;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CountView extends ActivityView {

    @BindView(R.id.count_label)
    TextView countLabel;
    @BindView(R.id.count_edit)
    EditText countEdit;

    public CountView(Activity activity) {
        super(activity);
        ButterKnife.bind(this, activity);
    }

    public void setResult(String count) {
        countLabel.setText(count);
    }

    public void reset() {
        setResult("0");
        countEdit.setText("");
    }

    public String getFormula() {
        return countEdit.getText().toString();
    }

    public void setFormula(String text) {
        countEdit.setText(text);
    }

    @OnClick(R.id.check_button)
    public void checkButtonPressed() {
        RxBus.post(new CheckButtonBusObserver.CheckButton());
    }

    @OnClick(R.id.reset_button)
    public void resetButtonPressed() {
        RxBus.post(new ResetButtonObserver.ResetButtonPressed());
    }

}
