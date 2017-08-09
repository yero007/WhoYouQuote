package whoyouquote.yero007.com.whoyouquote.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ScrollView;

import java.util.Locale;

import whoyouquote.yero007.com.whoyouquote.R;

public class ScrollTestActivity extends AppCompatActivity {

    private View scroll1;
    public static String TAG = ScrollTestActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_test);

        scroll1 = findViewById(R.id.iv_scroll_1);
        scroll1.startAnimation(pulsateAnimation());

        final ScrollView scrollView = (ScrollView) findViewById(R.id.sv_container);
        scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                int scrollY = scrollView.getScrollY();
                int maxScrollAmount = scrollView.getMaxScrollAmount();
                Log.d(TAG, String.format(Locale.getDefault(), "Scroll scrollY:%d \n Max Scroll:%d", scrollY, maxScrollAmount));

            }
        });
    }

    private Animation animation() {
        Animation shrinkAnswerCardAnimation =
                new ScaleAnimation(Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0);
        shrinkAnswerCardAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        shrinkAnswerCardAnimation.setDuration(1000);
        return shrinkAnswerCardAnimation;
    }

    private Animation pulsateAnimation() {
        Animation pulsate = new ScaleAnimation(
                1.0f,
                2.0f,
                1.0f,
                2.0f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        pulsate.setDuration(2000);
        pulsate.setRepeatMode(Animation.INFINITE);
        pulsate.setInterpolator(new AccelerateInterpolator());
        pulsate.setFillAfter(true);
        pulsate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Animation pulsate = new ScaleAnimation(
                        2.0f,
                        1.0f,
                        2.0f,
                        1.0f,
                        Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f);
                pulsate.setDuration(2000);
                pulsate.setRepeatMode(Animation.INFINITE);
                pulsate.setInterpolator(new AccelerateInterpolator());
                scroll1.startAnimation(pulsate);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        return pulsate;
    }

    private Animation slightMoveAnimation() {
        Animation inFromRight = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, +1.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f);
        inFromRight.setDuration(500);
        inFromRight.setInterpolator(new AccelerateInterpolator());
        inFromRight.setRepeatMode(Animation.INFINITE);
        return inFromRight;
    }
}
