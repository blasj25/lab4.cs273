package cs301.birthdaycake;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class CakeModel {
    public boolean isLit = true;
    public int numCandles = 2;
    public boolean isFrosting = true;
    public boolean hasCandles = true;

    public boolean getLit() {
        return isLit;
    }

    public void isLit(boolean flame) {
        isLit = flame;
    }

    public void setHasCandles(boolean does) {
        hasCandles = does;
    }

    public boolean isHasCandles() {
        return hasCandles;
    }

    public int whatNumCandles() {
        return numCandles;
    }

    public void setNumCandles(int newNumCandles) {
        numCandles = newNumCandles;
    }

    public boolean isFrosted() {
        return isFrosting;
    }

    public void setFrosting(boolean newFrosted) {
        isFrosting = newFrosted;
    }

    public int xCord = -1;
    public int yCord = -1;
    public String cordString;

    public void setCords(int newX, int newY) {
        xCord = newX;
        yCord = newY;
        cordString = "" + newX + "," + newY;
    }

    //draws a red/green checkered block centered on param x/y values
    public void drawCheckeredBoard(Canvas canvas, int newX, int newY) {
        Paint red = new Paint();
        Paint green = new Paint();

        red.setColor(Color.RED);
        green.setColor(Color.GREEN);

        //creates a effective 2 by 2 matrix for each box
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (i == 0) {
                    if (j == 0) {
                        canvas.drawRect(newX - (15), newY - (15), newX, newY, red);//draws top-let red square
                    } else {
                        canvas.drawRect(newX + (15), newY - (15), newX, newY, green);//draws top-right green square
                    }
                } else {
                    if (j == 0) {
                        canvas.drawRect(newX, newY, newX - 15, newY + 15, green);//draws bottom-let green square
                    } else {
                        canvas.drawRect(newX, newY, newX + 15, newY + 15, red);//draws bottom-right red square
                    }
                }
            }
        }
    }
}

