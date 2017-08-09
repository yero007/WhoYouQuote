package whoyouquote.yero007.com.whoyouquote.fragments;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import whoyouquote.yero007.com.whoyouquote.R;

/**
 * Created by Dani on 16.06.2015.
 */
public class WelcomeFragment extends Fragment {

    private WelcomeListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_welcome, container, false);

        setRetainInstance(true);

        Button btnContinue = (Button) v.findViewById(R.id.btn_get_started);
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (listener != null) {
                    listener.onGetStartedSelected();
                }
            }
        });

        return v;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = null;
        Log.d("onAttach", "" + context);
        if (context instanceof Activity) {
            activity = (Activity) context;
        }
        if (activity == null) {
            throw new ClassCastException("The activity must implement WelcomeListener");
        } else {
            listener = (WelcomeListener) activity;
        }

    }

    public interface WelcomeListener {
        void onGetStartedSelected();
    }
}
