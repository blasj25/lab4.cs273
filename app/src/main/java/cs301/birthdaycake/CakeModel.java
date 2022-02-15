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

    /**
     * this method draws the checker board where user touches
     * @param canvas
     * @param newX
     * @param newY
     */
    public void drawCheckeredBoard(Canvas canvas, int newX, int newY) {
        Paint red = new Paint();
        Paint green = new Paint();

        red.setColor(Color.RED);
        green.setColor(Color.GREEN);

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (i == 0) {
                    if (j == 0) {
                        canvas.drawRect(newX + 15 * i, newY + 15 * j, newX + 15 + (j * 15), newY + 15 + (j * 15), red);
                    } else {
                        canvas.drawRect(newX + 15 * i, newY + 15 * j, newX + 15 + (j * 15), newY + 15 + (j * 15), green);
                    }
                } else {
                    if (j == 0) {
                        canvas.drawRect(newX + 15 * i, newY + 15 * j, newX + 15 + (i * 15), newY + 15 + (j * 15), green);
                    } else {
                        canvas.drawRect(newX + 15 * i, newY + 15 * j, newX + 15 + (j * 15), newY + 15 + (j * 15), red);
                    }
                }
            }
        }
    }
}

