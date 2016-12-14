package com.github.anastr.speedview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.github.anastr.speedviewlib.AwesomeSpeedometer;
import com.github.anastr.speedviewlib.DeluxeSpeedView;
import com.github.anastr.speedviewlib.PointerSpeedometer;
import com.github.anastr.speedviewlib.RaySpeedometer;
import com.github.anastr.speedviewlib.SpeedView;
import com.github.anastr.speedviewlib.Speedometer;
import com.github.anastr.speedviewlib.TubeSpeedometer;

import java.util.Locale;
import java.util.Random;

public class CreateProgrammatically extends AppCompatActivity {

    LinearLayout rootSpeedometer;
    Speedometer speedometer;
    SeekBar seekBar;
    Button ok;
    TextView textSpeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_programmatically);

        rootSpeedometer = (LinearLayout) findViewById(R.id.root_speedometer);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        ok = (Button) findViewById(R.id.ok);
        textSpeed = (TextView) findViewById(R.id.textSpeed);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (speedometer != null)
                    speedometer.speedTo(seekBar.getProgress());
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textSpeed.setText(String.format(Locale.getDefault(), "%d", progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    public void addRandomSpeedometer(View view) {
        Random mad = new Random();
        switch (mad.nextInt(6)) {
            case 0:
                speedometer = new SpeedView(this);
                break;
            case 1:
                speedometer = new DeluxeSpeedView(this);
                break;
            case 2:
                speedometer = new AwesomeSpeedometer(this);
                break;
            case 3:
                speedometer = new RaySpeedometer(this);
                break;
            case 4:
                speedometer = new PointerSpeedometer(this);
                break;
            case 5:
                speedometer = new TubeSpeedometer(this);
                break;
        }
        rootSpeedometer.removeAllViews();
        rootSpeedometer.addView(speedometer);
    }
}
