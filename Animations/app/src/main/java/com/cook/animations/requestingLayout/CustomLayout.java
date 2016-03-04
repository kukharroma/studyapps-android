package com.cook.animations.requestingLayout;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by roma on 04.03.16.
 */
public class CustomLayout extends LinearLayout {

    public boolean removeRequestPending;
    public boolean addRequestPending;
    private int numbers;

    public CustomLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CustomLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomLayout(Context context) {
        super(context);
    }



    // в onLayout не можна добавляти View в контейнер
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);

//        if (addRequestPending) {
//            Log.i(this.getClass().getSimpleName(), "addRequestPending");
//            addButton();
//            addRequestPending = false;
//        }
//
//        if (removeRequestPending) {
//            Log.i(this.getClass().getSimpleName(), "removeRequestPending");
//            removeButton();
//            removeRequestPending = false;
//        }
    }

    public void removeButton() {
        if (getChildCount() > 0)
            removeViewAt(0);
    }

    public void addButton() {
        Button button = new Button(getContext());
        button.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        button.setText("button " + " " + numbers++);
        addView(button);
    }

}
