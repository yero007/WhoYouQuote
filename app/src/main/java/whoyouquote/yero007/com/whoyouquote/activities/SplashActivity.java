package whoyouquote.yero007.com.whoyouquote.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.RelativeLayout;

import whoyouquote.yero007.com.whoyouquote.R;
import whoyouquote.yero007.com.whoyouquote.fragments.SplashFragment;
import whoyouquote.yero007.com.whoyouquote.utils.SharedPreferencesHandler;


public class SplashActivity extends FragmentActivity {

    private static final String SPLASH_FRAGMENT_TAG = "SPLASH_FRAGMENT_TAG";
    public static final int NEXT_SCREEN_DELAY_MILLIS = 1000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_welcome);

        RelativeLayout rl;
        rl = (RelativeLayout) findViewById(R.id.relativeLayoutLogIn);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(rl.getId(), new SplashFragment(), SPLASH_FRAGMENT_TAG).commit();
        rl.postDelayed(new Runnable() {
            @Override
            public void run() {
                decideScreen();
            }
        }, NEXT_SCREEN_DELAY_MILLIS);
    }


    private void decideScreen() {
        SharedPreferencesHandler handler = new SharedPreferencesHandler(this, "WHO_YOU_QUOTE");
        String playerName = handler.getStringPreference("player_name", "");

        boolean firstTime = false;
        if (playerName.equals("")) {
            firstTime = true;
        }

        if (firstTime) {
            Intent myIntent = new Intent(getApplication().getApplicationContext(), WelcomeActivity.class);
            startActivity(myIntent);
            finish();
        } else {
            Intent myIntent = new Intent(getApplication().getApplicationContext(), MainActivity.class);
            startActivity(myIntent);
            finish();
        }
    }
}
