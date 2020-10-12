package edu.temple.cis3515hw4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CanvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        // Retrieve stored color value
        String color = getIntent().getStringExtra("color");

        // Change text value
        ((TextView) findViewById(R.id.colorText)).setText(color);

        // Change layout background color
        findViewById(R.id.layout).setBackgroundColor(Color.parseColor(color));
    }
}
