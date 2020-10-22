package edu.temple.cis3515hw4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements PaletteFragment.ColorSelectedInterface {
    FragmentManager fm;
    boolean twoPane;
    CanvasFragment canvasFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm = getSupportFragmentManager();
        fm.beginTransaction()
                .replace(R.id.palettefragment, PaletteFragment.newInstance(getResources().getStringArray(R.array.colors)))
                .commit();

        /*
        If we have two containers available, load a single instance
        of BookDetailsFragment to display all selected books
         */
        canvasFragment = new CanvasFragment();
            fm.beginTransaction()
                    .replace(R.id.canvasfragment, canvasFragment)
                    .commit();




                /*final GridView grid = findViewById(R.id.gridview);
                grid.setNumColumns(3);
                String[] colors = getResources().getStringArray(R.array.colors);

                grid.setAdapter(new ColorAdapter(this, colors.length,colors));

                ((GridView) findViewById(R.id.gridview)).setOnItemClickListener(new AdapterView.OnItemClickListener(){

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        TextView text = (TextView) view;
                        Intent colorIntent = new Intent(MainActivity.this, CanvasActivity.class);
                        colorIntent.putExtra("color", text.getText());
                        colorIntent.putExtra("color_value", getResources().getStringArray(R.array.colors_values)[position]);
                        startActivity(colorIntent);

            }

        });*/


    }

    @Override
    public void colorSelected(int index) {

    }
}