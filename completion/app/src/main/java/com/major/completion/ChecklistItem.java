package com.major.completion;

import android.content.Context;

public class ChecklistItem {
    private String text;
    private int number;
    private boolean checked;
    private Context context;
    private int spinnerIndex;

    public ChecklistItem(String text, int number, boolean checked, Context context, int spinnerIndex) {
        this.text = text;
        this.number = number;
        this.checked = checked;
        this.context = context;
        this.spinnerIndex = spinnerIndex;
    }

    public int getCredits() {
        return number;
    }

    public int getNumber() {
        return number;
    }

    public String getText() {
        return text;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public int getSpinnerIndex() {
        return spinnerIndex;
    }

    public void setSpinnerIndex(int spinnerIndex) {
        this.spinnerIndex = spinnerIndex;
    }
}
