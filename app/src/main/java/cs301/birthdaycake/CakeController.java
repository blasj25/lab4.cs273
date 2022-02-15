package cs301.birthdaycake;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.SeekBar;

public class CakeController implements View.OnClickListener,CompoundButton.OnCheckedChangeListener,
        SeekBar.OnSeekBarChangeListener, View.OnTouchListener {
private CakeView cakeView;
private CakeModel cakeModel;

    CakeController(CakeView initCakeView){
        cakeView = initCakeView;
        cakeModel = cakeView.getCakeModel();
    }

    @Override
    public void onClick(View view) {
        Log.d("Blow Out", "CLICK");
        if(cakeModel.getLit() == true) {
            cakeModel.isLit(false);
            cakeView.invalidate();
        }else if(cakeModel.getLit() == false) {
            cakeModel.isLit(true);
            cakeView.invalidate();
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (compoundButton.getId() == R.id.switch1){
        cakeModel.setHasCandles(b);
        } else{
        cakeModel.setFrosting(b);
        }
        cakeView.invalidate();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        cakeModel.setNumCandles(i);
        cakeView.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        //set the coordinates
        int x = (int)motionEvent.getX();
        int y = (int)motionEvent.getY();
        cakeModel.setCords(x, y);

        //print the thing
        cakeView.invalidate();
        return true;
    }
}
