package edu.temple.cis3515hw4;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CanvasFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CanvasFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "color";
    private static final String ARG_PARAM2 = "color_value";

    // TODO: Rename and change types of parameters
    private String fColor;
    private String fColorValue;

    public CanvasFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param color Parameter 1.
     * @param colorValue Parameter 2.
     * @return A new instance of fragment CanvasFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CanvasFragment newInstance(String color, String colorValue) {
        CanvasFragment fragment = new CanvasFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, color);
        args.putString(ARG_PARAM2, colorValue);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            fColor = getArguments().getString(ARG_PARAM1);
            fColorValue = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_canvas, container, false);

        TextView text = v.findViewById(R.id.colorText);

        text.setText(fColor);
        text.setBackgroundColor(Color.parseColor("WHITE"));
        return v;
    }
}