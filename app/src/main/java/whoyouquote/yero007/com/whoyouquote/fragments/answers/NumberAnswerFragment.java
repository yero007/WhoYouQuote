package whoyouquote.yero007.com.whoyouquote.fragments.answers;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Locale;
import java.util.Random;

import whoyouquote.yero007.com.whoyouquote.R;


/**
 * The {@link android.support.v4.app.Fragment} class for the
 * questions that have a list type of possible answers.
 */
public class NumberAnswerFragment extends BaseAnswerFragment {

    private OnNumberFragmentInteractionListener mListener;
    private int correctAnswer;
    private SeekBar seekBar;
    private TextView value;
    private int intervalDimension;

    /**
     * This method is used to create a new instance of the ListAnswerFragment.
     *
     * @param correctAnswer the question's correct answer
     * @return A new instance of fragment ListAnswerFragment.
     */
    public static NumberAnswerFragment newInstance(int correctAnswer) {
        NumberAnswerFragment fragment = new NumberAnswerFragment();
        fragment.setCorrectAnswer(correctAnswer);
        return fragment;
    }

    public NumberAnswerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_number_answer, container, false);
        value = (TextView) v.findViewById(R.id.tv_number_answer_value);
        seekBar = (SeekBar) v.findViewById(R.id.sb_number_answer_seek);

        Random rand = new Random();
        final int randomValue = rand.nextInt(20);
        final int randomStartValue = rand.nextInt(20);
        intervalDimension = Math.abs(randomStartValue - randomValue);

        seekBar.setMax(Math.abs(randomStartValue - randomValue));

        int initialProgress = seekBar.getMax() / 2;
        seekBar.setProgress(initialProgress);

        value.setText(String.format(Locale.getDefault(),
                "%d",
                initialProgress - intervalDimension + correctAnswer));

        Log.d("randomStartValue", ""+randomStartValue);
        Log.d("randomValue", ""+randomValue);
        Log.d("seekBar max", ""+Math.abs(randomStartValue - randomValue));

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Log.d("seekBar value", ""+i);
                Log.d("computed value", ""+(i - intervalDimension + correctAnswer));
                mListener.onNumberChanged(i - intervalDimension + correctAnswer);
                value.setText(String.format(Locale.getDefault(),"%d",i - intervalDimension + correctAnswer));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        return v;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    protected void onAttachToContext(Context context) {
        try {
            mListener = (OnNumberFragmentInteractionListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnNumberFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public boolean validateQuestion() {
        return seekBar.getProgress() - seekBar.getMax() + correctAnswer == correctAnswer;
    }

    public interface OnNumberFragmentInteractionListener {
        void onNumberChanged(int number);
    }
}
