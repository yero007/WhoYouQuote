package whoyouquote.yero007.com.whoyouquote.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import whoyouquote.yero007.com.whoyouquote.R;

/**
 * Created by Dani on 16.06.2015.
 * It represents the View that is initially seen by the user,
 * a beautiful splash screen.
 */
public class SplashFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_splash, container, false);

    }

}
