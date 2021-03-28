package malcolm.busari.s991523264;
/**
 * Name: Malcolm Busari
 * Student ID: 991523264
 * Section No: 1211_34780
 */

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment implements IOnBackPressed {

    private static final int CAMERA_PERMISSION_CODE = 100;
    AnimationDrawable mframeAnimation = null;
    private Spinner durationSpinner;
    private static final String[] paths = {"0.25s", "0.3s", "0.35s", "0.4s"};


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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

        final int pic_id = 123;
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        Button cameraBtn = view.findViewById(R.id.malcolmCameraBtn);
        cameraBtn.setOnClickListener(v -> {
            if(checkPermission()) {
                Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(camera_intent, pic_id);
            } else {
                requestPermission();
            }
        });

        durationSpinner = view.findViewById(R.id.malcolmDurationSpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, paths);
        durationSpinner.setAdapter(adapter);

        Button startBtn = view.findViewById(R.id.malcolmStartBtn);
        startBtn.setOnClickListener(v -> durationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view1, int position, long id) {

                int pos = parent.getSelectedItemPosition();
                if (pos == 0) {
                    startAnimation(250);
                }
                else if(pos == 1){
                    startAnimation(300);
                }
                else if(pos == 2){
                    startAnimation(350);
                }
                else if(pos == 3){
                    startAnimation(400);
                }
                else{
                    startAnimation(250);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        }));

        // Handle Stop Button
        Button stopBtn = view.findViewById(R.id.malcolmStopBtn);
        stopBtn.setOnClickListener(v -> stopAnimation());
        return view;
    }


    public boolean checkPermission() {

        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_DENIED) {
            return false;
        } else {
            return true;
        }
    }

    private void requestPermission() {

        ActivityCompat.requestPermissions(getActivity(),
                new String[]{Manifest.permission.CAMERA},
                CAMERA_PERMISSION_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super
                .onRequestPermissionsResult(requestCode,
                        permissions,
                        grantResults);

        if (requestCode == CAMERA_PERMISSION_CODE) {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(getActivity(),
                        "Camera Permission Granted",
                        Toast.LENGTH_SHORT)
                        .show();
            } else {
                Snackbar snackbar = Snackbar.make(getActivity().findViewById(android.R.id.content),
                        "Camera Permission Denied", Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        }
    }

    private void startAnimation(int duration)
    {
        ImageView img = getView().findViewById(R.id.malcolmHomeIV);

        BitmapDrawable frame1 = (BitmapDrawable)getResources().getDrawable(R.drawable.attack__000);
        BitmapDrawable frame2 = (BitmapDrawable)getResources().getDrawable(R.drawable.attack__001);
        BitmapDrawable frame3 = (BitmapDrawable)getResources().getDrawable(R.drawable.attack__002);
        BitmapDrawable frame4 = (BitmapDrawable)getResources().getDrawable(R.drawable.attack__003);
        BitmapDrawable frame5 = (BitmapDrawable)getResources().getDrawable(R.drawable.attack__004);
        BitmapDrawable frame6 = (BitmapDrawable)getResources().getDrawable(R.drawable.attack__005);
        BitmapDrawable frame7 = (BitmapDrawable)getResources().getDrawable(R.drawable.attack__006);
        BitmapDrawable frame8 = (BitmapDrawable)getResources().getDrawable(R.drawable.attack__007);
        BitmapDrawable frame9 = (BitmapDrawable)getResources().getDrawable(R.drawable.attack__008);

        mframeAnimation = new AnimationDrawable();
        mframeAnimation.setOneShot(false);
        mframeAnimation.addFrame(frame1, duration);
        mframeAnimation.addFrame(frame2, duration);
        mframeAnimation.addFrame(frame3, duration);
        mframeAnimation.addFrame(frame4, duration);
        mframeAnimation.addFrame(frame5, duration);
        mframeAnimation.addFrame(frame6, duration);
        mframeAnimation.addFrame(frame7, duration);
        mframeAnimation.addFrame(frame8, duration);
        mframeAnimation.addFrame(frame9, duration);


        img.setBackground(mframeAnimation);

        mframeAnimation.setVisible(true,true);
        mframeAnimation.start();
    }

    private void stopAnimation()
    {
        mframeAnimation.stop();
        mframeAnimation.setVisible(false,false);
    }

    @Override
    public boolean onBackPressed(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getView().getContext())
                .setTitle("Malcolm Busari 991523264")
                .setMessage("Are you sure you want to exit this application?")
                .setIcon(R.drawable.alerticon)
                .setCancelable(true);
        builder.setPositiveButton(
                "Yes",
                (dialog, id) -> {
                    getActivity().finish();
                    System.exit(0);
                });
        builder.setNegativeButton(
                "No",
                (dialog, id) -> dialog.cancel());
        AlertDialog alert = builder.create();
        alert.show();
        return false;
    }

}