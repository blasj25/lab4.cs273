package cs301.birthdaycake;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);

        CakeView cakeView = findViewById(R.id.cakeView);
        CakeController cakeController = new CakeController(cakeView);
        cakeView.setOnTouchListener(cakeController);

        Button blowOut = findViewById(R.id.button2);
        blowOut.setOnClickListener(cakeController);

        Switch candles = findViewById(R.id.switch1);
        candles.setOnCheckedChangeListener(cakeController);

        Switch frosting = findViewById(R.id.switch2);
        frosting.setOnCheckedChangeListener(cakeController);

        SeekBar candleBar = findViewById(R.id.seekBar);
        candleBar.setOnSeekBarChangeListener(cakeController);

    }
    public void goodbye(View button){
        Log.i("button","Goodbye");
        finishAffinity();
    }
}
