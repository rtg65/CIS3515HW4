package edu.temple.cis3515hw4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final GridView spinner = findViewById(R.id.gridview);
        String[] colors = {"White", "Red", "Blue", "Green","Fuchsia", "Yellow", "Purple", "Gray", "Cyan", "Olive", "Silver","Magenta"};

        spinner.setAdapter(new ColorAdapter(this, colors.length,colors));
        ((GridView) findViewById(R.id.gridview)).setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            private boolean onStart = true;
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(!onStart) {
                    TextView text = (TextView) view;
                    Intent colorIntent = new Intent(MainActivity.this, CanvasActivity.class);
                    colorIntent.putExtra("color", text.getText());
                    startActivity(colorIntent);
                }
                onStart = false;
            }

            @Override
            public void onNothingSelected(AdapterView<?>  parent) {
            }


        });


    }
}