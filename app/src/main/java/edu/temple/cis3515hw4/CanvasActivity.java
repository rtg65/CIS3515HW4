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
        Intent colorIntent = getIntent();
        String color = colorIntent.getStringExtra("color");
        View layout = findViewById(R.id.layout);
        layout.setBackgroundColor(Color.parseColor(color));
        TextView text = findViewById((R.id.colorText));
        text.setText(color);
    }
}
