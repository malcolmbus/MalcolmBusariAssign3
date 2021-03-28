package malcolm.busari.s991523264;
/**
 * Name: Malcolm Busari
 * Student ID: 991523264
 * Section No: 1211_34780
 */

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AnimationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AnimationFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AnimationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AnimationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AnimationFragment newInstance(String param1, String param2) {
        AnimationFragment fragment = new AnimationFragment();
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
        View view = inflater.inflate(R.layout.fragment_animation, container, false);

        Button startBtn = view.findViewById(R.id.malcolmStartBtn);
        startBtn.setOnClickListener(v -> {
            performAnimation(R.anim.orbit);
        });

        Button stopBtn = view.findViewById(R.id.malcolmStopBtn);
        stopBtn.setOnClickListener(v -> {
            stopAnimation();
        });

        requireActivity().getOnBackPressedDispatcher().addCallback(new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
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
            }
        });
        return view;
    }

    private void performAnimation(int animationResourceID)
    {
        ImageView reusableImageView = getView().findViewById(R.id.malcolmMoonImg);
        reusableImageView.setImageResource(R.drawable.moon);
        reusableImageView.setVisibility(View.VISIBLE);

        Animation an =  AnimationUtils.loadAnimation(getContext(), animationResourceID);
        an.setAnimationListener(new MyAnimationListener());
        reusableImageView.startAnimation(an);
    }

    private void stopAnimation(){
        ImageView reusableImageView = getView().findViewById(R.id.malcolmMoonImg);
        reusableImageView.clearAnimation();
    }

    class MyAnimationListener implements Animation.AnimationListener {

        public void onAnimationEnd(Animation animation) {
            // Hide our ImageView
            ImageView reusableImageView = getView().findViewById(R.id.malcolmMoonImg);
            reusableImageView.setVisibility(View.INVISIBLE);
        }

        public void onAnimationRepeat(Animation animation) {
            // what to do when animation loops
        }

        public void onAnimationStart(Animation animation) {
            // Disable all buttons while animation is running

        }
    }
}