package whoyouquote.yero007.com.whoyouquote.activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.PersistableBundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;

import com.yero007.circlepager.CirclePageIndicator;

import java.util.ArrayList;

import whoyouquote.yero007.com.whoyouquote.QuestionsHelper;
import whoyouquote.yero007.com.whoyouquote.adapters.MainActivityAdapter;
import whoyouquote.yero007.com.whoyouquote.R;
import whoyouquote.yero007.com.whoyouquote.data.Question;
import whoyouquote.yero007.com.whoyouquote.mainActivityFragments.ProfileFragment;
import whoyouquote.yero007.com.whoyouquote.mainActivityFragments.ScoreBoardFragment;
import whoyouquote.yero007.com.whoyouquote.mainActivityFragments.SettingsFragment;
import whoyouquote.yero007.com.whoyouquote.mainActivityFragments.StartGameFragment;
import whoyouquote.yero007.com.whoyouquote.utils.QuestionInitializer;


public class MainActivity extends AppCompatActivity
        implements
        StartGameFragment.OnStartGameFragmentInteraction,
        ProfileFragment.OnFragmentInteractionListener,
        ScoreBoardFragment.OnFragmentInteractionListener,
        SettingsFragment.OnFragmentInteractionListener
{
    private CharSequence mTitle;
    private Toolbar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTitle = getTitle();

        actionBar = (Toolbar) findViewById(R.id.toolbar);

        this.setSupportActionBar(actionBar);

        ViewPager pager = (ViewPager) findViewById(R.id.pager);

        MainActivityAdapter adapter = new MainActivityAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);

        CirclePageIndicator indicator = (CirclePageIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(pager);


        //todo:remove this on final release
        QuestionInitializer qi = new QuestionInitializer(this);
        qi.initializeTestQuestion();
        qi.initializeCategories();

        ArrayList<Question> questions = new QuestionsHelper(this).getAllQuestionsInACategory(-1);
        questions.size();



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onGameStartedPressed() {
        Intent gameIntent = new Intent(this, GameActivity.class);
        startActivity(gameIntent);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

}
