package malcolm.busari.s991523264;
/**
 * Name: Malcolm Busari
 * Student ID: 991523264
 * Section No: 1211_34780
 */

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DrawFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DrawFragment extends Fragment {
    private CanvasView customCanvas;
    private Spinner colorSpinner;
    private static final String[] paths1 = {"Red", "Green", "Blue"};
    private static final String[] paths2 = {"5", "6", "7"};
    private Spinner widthSpinner;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DrawFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DrawFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DrawFragment newInstance(String param1, String param2) {
        DrawFragment fragment = new DrawFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_draw, container, false);
        customCanvas = view.findViewById(R.id.malcolmCanvasView);

        colorSpinner = view.findViewById(R.id.malcolmColorSpinner);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, paths1);

        widthSpinner = view.findViewById(R.id.malcolmWidthSpinner);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, paths2);

        colorSpinner.setAdapter(adapter1);
        widthSpinner.setAdapter(adapter2);

        Button clearBtn = view.findViewById(R.id.malcolmClearBtn);
        clearBtn.setOnClickListener(v -> clearCanvas(view));

        Button updateBtn = view.findViewById(R.id.malcolmUpdateBtn);
        updateBtn.setOnClickListener(v -> {
            colorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                       @Override
                                                       public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                           if (colorSpinner.getSelectedItem().toString() == "0") {
                                                               customCanvas.changeColor(Color.RED);
                                                           } else if (colorSpinner.getSelectedItem().toString() == "1") {
                                                               customCanvas.changeColor(Color.GREEN);
                                                           } else if (colorSpinner.getSelectedItem().toString() == "2") {
                                                               customCanvas.changeColor(Color.BLUE);
                                                           } else {
                                                               customCanvas.changeColor(Color.BLACK);
                                                           }
                                                       }

                                                       @Override
                                                       public void onNothingSelected(AdapterView<?> parent) {
                                                       }
                                                   });

                    widthSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            if(widthSpinner.getSelectedItem().toString() == "0"){
                                customCanvas.changeStrokeWidth(5f);
                            }
                            else if(widthSpinner.getSelectedItem().toString() == "1"){
                                customCanvas.changeStrokeWidth(6f);
                            }
                            else if(widthSpinner.getSelectedItem().toString() == "2"){
                                customCanvas.changeStrokeWidth(7f);
                            }
                            else{
                                customCanvas.changeStrokeWidth(5f);
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }

                    });
        });
        return view;
    }

    public void clearCanvas(View v){
        customCanvas.clearCanvas();;
    }
}