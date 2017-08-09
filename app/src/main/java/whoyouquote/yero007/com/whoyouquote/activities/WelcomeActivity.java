package whoyouquote.yero007.com.whoyouquote.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.RelativeLayout;

import whoyouquote.yero007.com.whoyouquote.Constants;
import whoyouquote.yero007.com.whoyouquote.R;
import whoyouquote.yero007.com.whoyouquote.fragments.WelcomeFragment;
import whoyouquote.yero007.com.whoyouquote.utils.QuestionInitializer;
import whoyouquote.yero007.com.whoyouquote.utils.SharedPreferencesHandler;


public class WelcomeActivity extends FragmentActivity implements WelcomeFragment.WelcomeListener {

    private static final String WELCOME_FRAGMENT_TAG = "WELCOME_FRAGMENT_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferencesHandler handler = new SharedPreferencesHandler(this, Constants.SHARED_PREFERENCES_NAME);
        String playerName = handler.getStringPreference("player_name", "");

        boolean firstTime = false;
        if (playerName.equals("")) {
            firstTime = true;
        }

        if (firstTime) {
            setContentView(R.layout.activity_welcome);
            RelativeLayout rl = (RelativeLayout) findViewById(R.id.relativeLayoutLogIn);
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(rl.getId(), new WelcomeFragment(), WELCOME_FRAGMENT_TAG).commit();
        } else {
            Intent myIntent = new Intent(getApplication().getApplicationContext(), MainActivity.class);
            startActivity(myIntent);
            finish();
        }
    }

    @Override
    public void onGetStartedSelected() {
        Intent myIntent = new Intent(getApplication().getApplicationContext(), FirstTimeActivity.class);
        startActivity(myIntent);
        finish();
    }
}
