package whoyouquote.yero007.com.whoyouquote.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

import whoyouquote.yero007.com.whoyouquote.QuestionsHelper;
import whoyouquote.yero007.com.whoyouquote.data.Question;
import whoyouquote.yero007.com.whoyouquote.fragments.answers.BaseAnswerFragment;
import whoyouquote.yero007.com.whoyouquote.fragments.answers.ListAnswerFragment;
import whoyouquote.yero007.com.whoyouquote.fragments.answers.NumberAnswerFragment;
import whoyouquote.yero007.com.whoyouquote.fragments.QuestionFragment;
import whoyouquote.yero007.com.whoyouquote.R;
import whoyouquote.yero007.com.whoyouquote.utils.QuestionType;

/**
 * Created by Dani on 17.06.2015.
 * This will be the activity that will display the fragments where the game will run.
 * It will show the question and the answers.
 */
public class GameActivity extends AppCompatActivity implements QuestionFragment.OnQuestionFragmentListener,
        ListAnswerFragment.OnListFragmentInteractionListener,
        NumberAnswerFragment.OnNumberFragmentInteractionListener{

    private static final int ANIMATION_DURATION_MILLIS = 1000;
    private static String QUESTION_FRAGMENT_TAG = "questionFragmentTag";
    private static String ANSWER_FRAGMENT_TAG = "answerFragmentTag";
    public static int mScreenWidth;
    private Question currentQuestion;

    private QuestionFragment questionFragment;
    private BaseAnswerFragment answerFragment;
    private View mAnswerCardView;
    private ArrayList<String> questionsList;
    private ArrayList<Question> questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_game);

        getQuestions();

        RelativeLayout rl = (RelativeLayout) findViewById(R.id.relativeLayoutGameQuote);
        mAnswerCardView =  findViewById(R.id.relativeLayoutGameAnswer);

        //todo:move this to a method
        //Question firstQuestion = questions.get(0);

        //todo: remove this
        Random random = new Random();
        Question firstQuestion = questions.get(random.nextInt(questionsList.size()));

        while (firstQuestion.getQuestionType() != QuestionType.NUMBER_ANSWER){
            firstQuestion = questions.get(random.nextInt(questionsList.size()));
        }

        currentQuestion = firstQuestion;

        questionFragment = QuestionFragment.newInstance(firstQuestion.getText());

        if (firstQuestion.getQuestionType() == QuestionType.SINGLE_ANSWER)
        {
            answerFragment = ListAnswerFragment.newInstance(firstQuestion.getPossibleAnswers(), firstQuestion.getCorrectAnswer());
        } else {
            answerFragment = NumberAnswerFragment.newInstance(Integer.parseInt(firstQuestion.getCorrectAnswer()));
        }

        getSupportFragmentManager().beginTransaction().add(rl.getId(), questionFragment, QUESTION_FRAGMENT_TAG).commit();
        getSupportFragmentManager().beginTransaction().add(mAnswerCardView.getId(), answerFragment, ANSWER_FRAGMENT_TAG).commit();


        calculateScreenWidth();
    }

    private void calculateScreenWidth() {
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        mScreenWidth = metrics.widthPixels;
    }

    private void getQuestions() {
        questions = new QuestionsHelper(this).getAllQuestionsInACategory(-1);
        questionsList = new ArrayList<>();
        for (Question question : questions) {
            questionsList.add(question.getText());
        }
    }

    private void animation() {
        Animation shrinkAnswerCardAnimation =
                new ScaleAnimation(Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0);
        shrinkAnswerCardAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        shrinkAnswerCardAnimation.setDuration(1000);

        shrinkAnswerCardAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {


                Random random = new Random();
                Question nextQuestion = questions.get(random.nextInt(questionsList.size()));
                currentQuestion = nextQuestion;

                questionFragment.updateQuestionText(nextQuestion.getText());

                if (nextQuestion.getQuestionType() == QuestionType.SINGLE_ANSWER)
                {
                    answerFragment = ListAnswerFragment.newInstance(nextQuestion.getPossibleAnswers(), nextQuestion.getCorrectAnswer());
                } else {
                    answerFragment = NumberAnswerFragment.newInstance(Integer.parseInt(nextQuestion.getCorrectAnswer()));
                }

                getSupportFragmentManager().beginTransaction().replace(mAnswerCardView.getId(), answerFragment).commit();
                Animation growAnswerCardAnimation =
                        new ScaleAnimation(0, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF);
                growAnswerCardAnimation.setDuration(1000);
                growAnswerCardAnimation.setInterpolator(new AccelerateDecelerateInterpolator());

                mAnswerCardView.startAnimation(growAnswerCardAnimation);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        mAnswerCardView.startAnimation(shrinkAnswerCardAnimation);

        getCardExitAnimation().start();
    }

    private Animation getCardExitAnimation() {
        Animation cardExitAnimation = new TranslateAnimation(0, -mScreenWidth, 0, 0);
        cardExitAnimation.setDuration(ANIMATION_DURATION_MILLIS);

        return cardExitAnimation;
    }

    private Animation getEntryAnimation() {
        Animation entryAnimation = new TranslateAnimation(-mScreenWidth, 0, 0, 0);
        entryAnimation.setDuration(ANIMATION_DURATION_MILLIS);

        return entryAnimation;
    }

    @Override
    public void onListAnswerPressed(String answer) {
        questionFragment.showFabButton();
    }

    @Override
    public void onValidateQuestionPressed() {
        if (answerFragment.validateQuestion()){
            questionFragment.hideFabButton();
            animation();
            return;
        }

        Toast.makeText(this, "Wrong answer", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNumberChanged(int number) {
        questionFragment.showFabButton();
    }
}
