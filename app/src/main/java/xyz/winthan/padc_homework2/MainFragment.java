package xyz.winthan.padc_homework2;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements ViewPodRommInfo.OnGuestClickListener {

    @BindView(R.id.view_pod_room)
    ViewPodRommInfo viewPodRommInfo;

    private ItemClickListener itemClickListener;

    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance(){
        MainFragment mainFragment = new MainFragment();
        return mainFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        itemClickListener = (ItemClickListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, rootView);

        viewPodRommInfo.setController(this);

        return rootView;
    }

    @OnClick(R.id.btn_check_availability)
    public void performCheckAvailability(){
        itemClickListener.onTapCheckAvailability();
    }

    @Override
    public void onTapGuest() {
        Toast.makeText(getContext(), "guest", Toast.LENGTH_SHORT).show();
    }

    public interface ItemClickListener{
        void onTapCheckAvailability();
    }

}
