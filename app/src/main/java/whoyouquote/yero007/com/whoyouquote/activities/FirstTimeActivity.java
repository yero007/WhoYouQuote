package whoyouquote.yero007.com.whoyouquote.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

import whoyouquote.yero007.com.whoyouquote.Constants;
import whoyouquote.yero007.com.whoyouquote.R;
import whoyouquote.yero007.com.whoyouquote.fragments.RegisterFragment;
import whoyouquote.yero007.com.whoyouquote.utils.QuestionInitializer;
import whoyouquote.yero007.com.whoyouquote.utils.SharedPreferencesHandler;
import whoyouquote.yero007.com.whoyouquote.utils.Tags;

/**
 * This is the autenthication activity.
 * Here the user will be able to sign in or register
 */
public class FirstTimeActivity extends AppCompatActivity implements RegisterFragment.OnRegisterFragmentInteraction {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
        RelativeLayout rl = (RelativeLayout) findViewById(R.id.container);
        getSupportFragmentManager().beginTransaction().add(rl.getId(), RegisterFragment.newInstance(), "1").commit();
    }

    /**
     * Callbacks from {@link RegisterFragment}
     */
    @Override
    public void onRegisterButtonPressed(String name, int avatarId) {
        SharedPreferencesHandler handler = new SharedPreferencesHandler(this, Constants.SHARED_PREFERENCES_NAME);
        handler.addPreference(Tags.PLAYER_NAME, "Dani");
        handler.addPreference(Tags.PLAYER_AVATAR, 1);

        QuestionInitializer qi = new QuestionInitializer(this);
        qi.initializeTestQuestion();
        qi.initializeCategories();

        Intent mainActivityIntent = new Intent(this, MainActivity.class);
        startActivity(mainActivityIntent);
    }
}
