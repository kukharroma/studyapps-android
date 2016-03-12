package com.cook.animations.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.Button;

import com.cook.animations.R;

/**
 * Created by roma on 11.03.16.
 */
public class CustomView extends ViewGroup {

    private boolean customShowText;
    private int labelPosition;
    private Button button;

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomView, 0, 0);

        customShowText = typedArray.getBoolean(R.styleable.CustomView_customShowText, false);
        labelPosition = typedArray.getInteger(R.styleable.CustomView_labelPosition, 0);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        setMeasuredDimension();
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

}
