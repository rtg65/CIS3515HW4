package edu.temple.cis3515hw4;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PaletteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PaletteFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String F_COLOR_PARAM = "color";
    private static final String F_COLOR_VALUE_PARAM = "color_value";

    // TODO: Rename and change types of parameters
    private String fColor;
    private String fColorValue;
    private ColorSelectedInterface parentActivity;

    public PaletteFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param colors Parameter 1.
     * @return A new instance of fragment PaletteFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PaletteFragment newInstance(String[] colors) {
        PaletteFragment fragment = new PaletteFragment();
        Bundle args = new Bundle();
        args.putStringArray(F_COLOR_PARAM, colors);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        /*
         This fragment needs to communicate with its parent activity
         so we verify that the activity implemented our known interface
         */
        if (context instanceof ColorSelectedInterface) {
            parentActivity = (ColorSelectedInterface) context;
        } else {
            throw new RuntimeException("Please implement the required interface(s)");
        }
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        GridView gridView = (GridView) inflater.inflate(R.layout.fragment_palette, container, false);
        String[] colors = getResources().getStringArray(R.array.colors);
        gridView.setAdapter(new ColorAdapter(getContext(), colors.length,colors));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                parentActivity.colorSelected(position);
            }
        });
        return gridView;
    }

    interface ColorSelectedInterface {
        void colorSelected(int index);
    }
}