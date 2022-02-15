package cs301.birthdaycake;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class CakeView extends SurfaceView {

    /* These are the paints we'll use to draw the birthday cake below */
    Paint cakePaint = new Paint();
    Paint frostingPaint = new Paint();
    Paint candlePaint = new Paint();
    Paint outerFlamePaint = new Paint();
    Paint innerFlamePaint = new Paint();
    Paint wickPaint = new Paint();
    Paint cordPaint = new Paint();
    Paint checkerBoardRed = new Paint();
    Paint checkerBoardGreen = new Paint();

    /* These constants define the dimensions of the cake.  While defining constants for things
        like this is good practice, we could be calculating these better by detecting
        and adapting to different tablets' screen sizes and resolutions.  I've deliberately
        stuck with hard-coded values here to ease the introduction for CS371 students.
     */
    public static final float cakeTop = 400.0f;
    public static final float cakeLeft = 100.0f;
    public static final float cakeWidth = 1200.0f;
    public static final float layerHeight = 200.0f;
    public static final float frostHeight = 50.0f;
    public static final float candleHeight = 300.0f;
    public static final float candleWidth = 120.0f;
    public static final float wickHeight = 30.0f;
    public static final float wickWidth = 6.0f;
    public static final float outerFlameRadius = 30.0f;
    public static final float innerFlameRadius = 15.0f;
    private CakeModel cakeModel;

    /**
     * ctor must be overridden here as per standard Java inheritance practice.  We need it
     * anyway to initialize the member variables
     */
    public CakeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        cakeModel = new CakeModel();

        //This is essential or your onDraw method won't get called
        setWillNotDraw(false);

        //Setup our palette
        cakePaint.setColor(0xFF00F536);  //not violet-red
        cakePaint.setStyle(Paint.Style.FILL);
        frostingPaint.setColor(0xFF69c420);  //not pale-yellow
        frostingPaint.setStyle(Paint.Style.FILL);
        candlePaint.setColor(0xFFDD1320);  //red
        candlePaint.setStyle(Paint.Style.FILL);
        outerFlamePaint.setColor(0xFF44F8F8);  //cyan
        outerFlamePaint.setStyle(Paint.Style.FILL);
        innerFlamePaint.setColor(0xFFA5F8F8);  //white cyanish
        innerFlamePaint.setStyle(Paint.Style.FILL);
        wickPaint.setColor(Color.BLACK);
        wickPaint.setStyle(Paint.Style.FILL);
        cordPaint.setColor(Color.RED);
        cordPaint.setStyle(Paint.Style.FILL);
        cordPaint.setTextSize(50.0f);
        checkerBoardRed.setColor(0xFFF46040);
        checkerBoardGreen.setColor(0xFF69C420);

        setBackgroundColor(Color.WHITE);  //better than black default

    }


    /**
     * draws a candle at a specified position.  Important:  the left, bottom coordinates specify
     * the position of the bottom left corner of the candle
     */
    public void drawCandle(Canvas canvas, float left, float bottom) {
        canvas.drawRect(left, bottom - candleHeight, left + candleWidth, bottom, candlePaint);
            if(cakeModel.getLit() == true) {
                //draw the outer flame
                float flameCenterX = left + candleWidth / 2;
                float flameCenterY = bottom - wickHeight - candleHeight - outerFlameRadius / 3;
                canvas.drawCircle(flameCenterX, flameCenterY, outerFlameRadius, outerFlamePaint);

                //draw the inner flame
                flameCenterY += outerFlameRadius / 3;
                canvas.drawCircle(flameCenterX, flameCenterY, innerFlameRadius, innerFlamePaint);
            }
        //draw the wick
        float wickLeft = left + candleWidth/2 - wickWidth/2;
        float wickTop = bottom - wickHeight - candleHeight;
        canvas.drawRect(wickLeft, wickTop, wickLeft + wickWidth, wickTop + wickHeight, wickPaint);

    }

    /**
     * onDraw is like "paint" in a regular Java program.  While a Canvas is
     * conceptually similar to a Graphics in javax.swing, the implementation has
     * many subtle differences.  Show care and read the documentation.
     *
     * This method will draw a birthday cake
     */
    @Override
    public void onDraw(Canvas canvas)
    {
        //top and bottom are used to keep a running tally as we progress down the cake layers
        float top = cakeTop;
        float bottom = cakeTop + frostHeight;

        //Frosting on top
        if(cakeModel.isFrosted() == true) {
            canvas.drawRect(cakeLeft, top, cakeLeft + cakeWidth, bottom, frostingPaint);
            top += frostHeight;
            bottom += layerHeight;
        }else{
            canvas.drawRect(cakeLeft, top, cakeLeft + cakeWidth, bottom, cakePaint);
            top += frostHeight;
            bottom += layerHeight;
        }

        //Then a cake layer
        canvas.drawRect(cakeLeft, top, cakeLeft + cakeWidth, bottom, cakePaint);
        top += layerHeight;
        bottom += frostHeight;

        //Then a second frosting layer
        if(cakeModel.isFrosted() == true) {
            canvas.drawRect(cakeLeft, top, cakeLeft + cakeWidth, bottom, frostingPaint);
            top += frostHeight;
            bottom += layerHeight;
        }else{
            canvas.drawRect(cakeLeft, top, cakeLeft + cakeWidth, bottom, cakePaint);
            top += frostHeight;
            bottom += layerHeight;
        }
        //Then a second cake layer
        canvas.drawRect(cakeLeft, top, cakeLeft + cakeWidth, bottom, cakePaint);

            //draws amount of candles depending of seekBar
       if(cakeModel.isHasCandles()) {
           int num = cakeModel.whatNumCandles();
           for (int i = 1; i <= num; i++) {
               drawCandle(canvas,
                       cakeLeft + i*cakeWidth/(num + 1) - i*candleWidth/(num + 1), cakeTop);
           }
       }
       if (cakeModel.xCord >= 0) {
            canvas.drawText(cakeModel.cordString, 1750.0f, 680.0f, cordPaint);
            cakeModel.drawCheckeredBoard(canvas, cakeModel.xCord, cakeModel.yCord);
       }


    }//onDraw



    public CakeModel getCakeModel(){
     return cakeModel;
    }
}//class CakeView

