package co.mobilemakers.chooseyourownadventure_rredition;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Random;

/**
 * Welcome fragment.
 *
 * Created by ariel.cattaneo on 23/01/2015.
 */
public class MainFragment extends Fragment {

    Button mButtonStart;

    protected class ButtonStartListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            int nStartPlace = new Random().nextInt(2);
            Intent intent;

            switch (nStartPlace) {
                case 0:
                    intent = new Intent(getActivity(), AlleyActivity.class);
                    break;
                case 1:
                    intent = new Intent(getActivity(), RoomActivity.class);
                    break;
                default:
                    return;
            }

            startActivity(intent);
        }
    }

    public MainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mButtonStart = (Button)getActivity().findViewById(R.id.button_start);
        mButtonStart.setOnClickListener(new ButtonStartListener());
    }
}
