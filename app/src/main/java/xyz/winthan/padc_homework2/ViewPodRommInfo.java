package xyz.winthan.padc_homework2;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by winthanhtike on 6/14/17.
 */

public class ViewPodRommInfo extends LinearLayout implements ViewController{

    @BindView(R.id.tv_guest)
    TextView mGuest;

    OnGuestClickListener guestClickListener;

    public ViewPodRommInfo(Context context) {
        super(context);
    }

    public ViewPodRommInfo(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewPodRommInfo(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this, this);

        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                guestClickListener.onTapGuest();
            }
        });

    }

    @Override
    public void setController(OnGuestClickListener clickListener) {
        guestClickListener = clickListener;
    }

    public interface OnGuestClickListener{

        void onTapGuest();

    }

}
