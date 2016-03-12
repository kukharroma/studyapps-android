package com.cook.animations.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import com.cook.animations.R;

/**
 * Created by roma on 11.03.16.
 */
public class CustomView extends View {

    private boolean customShowText;
    private int labelPosition;

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomView, 0, 0);

        customShowText = typedArray.getBoolean(R.styleable.CustomView_customShowText, false);
        labelPosition = typedArray.getInteger(R.styleable.CustomView_labelPosition, 0);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(250, 250);
    }

    public boolean isCustomShowText() {
        return customShowText;
    }

    public void setCustomShowText(boolean customShowText) {
        this.customShowText = customShowText;
        invalidate();
        requestLayout();
    }
}
