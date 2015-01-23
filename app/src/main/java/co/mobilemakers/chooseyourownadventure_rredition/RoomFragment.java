package co.mobilemakers.chooseyourownadventure_rredition;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class RoomFragment extends Fragment {

    int winButton, loseButton;

    Button mButtonDoor1, mButtonDoor2;

    public RoomFragment() {
        // Required empty public constructor
    }

    protected class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            int whichButton = 0;
            if (v == mButtonDoor2) {
                whichButton = 1;
            }

            boolean canWin = (whichButton == winButton);
            boolean canLose = (whichButton == loseButton);

            float random = new Random().nextFloat();

            Intent intent;
            if (canWin && random < 0.2) {
                intent = new Intent(getActivity(), WinningActivity.class);
            }
            else if (canLose && random > 0.2) {
                intent = new Intent(getActivity(), LosingActivity.class);
            }
            else if (random < 0.5) {
                intent = new Intent(getActivity(), AlleyActivity.class);
            }
            else {
                intent = new Intent(getActivity(), RoomActivity.class);
            }

            startActivity(intent);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_room, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        winButton = new Random().nextInt(2);
        loseButton = new Random().nextInt(2);

        prepareButtons();
    }

    private void prepareButtons() {
        ButtonListener listener = new ButtonListener();

        mButtonDoor1 = (Button)getActivity().findViewById(R.id.button_door_1);
        mButtonDoor2 = (Button)getActivity().findViewById(R.id.button_door_2);
        mButtonDoor1.setOnClickListener(listener);
        mButtonDoor2.setOnClickListener(listener);
    }

}
