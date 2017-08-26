package se.sugarest.jane.customviewclass;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by jane on 17-8-26.
 */

public class CustomView extends View {

    //circle and text colors
    private int circleColor, labelColor;

    //label text
    private String circleText;

    //paint for drawing custom view
    private Paint circlePaint;

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        // paint object for drawing in onDraw
        circlePaint = new Paint();

        // get the attributes specified in attrs.xml using the name we included
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomView, 0, 0);

        try {
            // get the text and colors specified using the names in attrs.xml
            circleText = a.getString(R.styleable.CustomView_circleLabel);
            // 0 is default
            circleColor = a.getInteger(R.styleable.CustomView_circleColor, 0);
            labelColor = a.getInteger(R.styleable.CustomView_labelColor, 0);
        } finally {
            a.recycle();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // draw the View

        // get half of the width and height as we are working with a circle
        int viewWidthHalf = this.getMeasuredWidth() / 2;
        int viewHeightHalf = this.getMeasuredHeight() / 2;

        drawCircle(canvas, viewWidthHalf, viewHeightHalf);
        drawText(canvas, viewWidthHalf, viewHeightHalf);

    }

    private void drawText(Canvas canvas, int viewWidthHalf, int viewHeightHalf) {
        // set the text color using the color specified
        circlePaint.setColor(labelColor);

        // set the properties
        circlePaint.setTextAlign(Paint.Align.CENTER);
        circlePaint.setTextSize(50);

        // draw the text using the string attribute and chosen properties
        canvas.drawText(circleText, viewWidthHalf, viewHeightHalf, circlePaint);
    }

    private void drawCircle(Canvas canvas, int viewWidthHalf, int viewHeightHalf) {
        // get the radius as half of the width or height, whichever is smaller subtract then so that
        // it has some space around it.
        int radius = 0;
        if (viewWidthHalf > viewHeightHalf) {
            radius = viewHeightHalf - 20;
        } else {
            radius = viewWidthHalf - 20;
        }

        circlePaint.setStyle(Paint.Style.FILL);
        circlePaint.setAntiAlias(true);
        // set the paint color using the circle color specified
        circlePaint.setColor(circleColor);

        canvas.drawCircle(viewWidthHalf, viewHeightHalf, radius, circlePaint);
    }

    public int getCircleColor() {
        return circleColor;
    }

    public void setCircleColor(int circleColor) {
        // update the instance variable
        this.circleColor = circleColor;
        // redraw the view
        invalidate();
        requestLayout();
    }

    public int getLabelColor() {
        return labelColor;
    }

    public void setLabelColor(int labelColor) {
        // update the instance variable
        this.labelColor = labelColor;
        // redraw the view
        invalidate();
        requestLayout();
    }

    public String getCircleText() {
        return circleText;
    }

    public void setCircleText(String circleText) {
        // update the instance variable
        this.circleText = circleText;
        // redraw the view
        invalidate();
        requestLayout();
    }
}
