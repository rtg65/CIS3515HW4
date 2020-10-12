package edu.temple.cis3515hw4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final GridView grid = findViewById(R.id.gridview);
        grid.setNumColumns(3);
        String[] colors = {"White", "Red", "Blue", "Green","Fuchsia", "Yellow", "Purple", "Gray", "Cyan", "Olive", "Silver","Magenta"};

        grid.setAdapter(new ColorAdapter(this, colors.length,colors));

        ((GridView) findViewById(R.id.gridview)).setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    TextView text = (TextView) view;
                Log.d("what tho", "onItemClick: "+text.getText());
                    Intent colorIntent = new Intent(MainActivity.this, CanvasActivity.class);
                    colorIntent.putExtra("color", text.getText());
                    startActivity(colorIntent);

            }

        });


    }
}