package whoyouquote.yero007.com.whoyouquote.fragments.answers;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import whoyouquote.yero007.com.whoyouquote.R;


/**
 * The {@link android.support.v4.app.Fragment} class for the
 * questions that have a list type of possible answers.
 */
public class ListAnswerFragment extends BaseAnswerFragment {

    private OnListFragmentInteractionListener mListener;
    private ArrayList<String> answers;
    private String correctAnswer;
    private String selectedAnswer;

    /**
     * This method is used to create a new instance of the ListAnswerFragment.
     *
     * @param answers       possible answers list
     * @param correctAnswer the question's correct answer
     * @return A new instance of fragment ListAnswerFragment.
     */
    public static ListAnswerFragment newInstance(ArrayList<String> answers, String correctAnswer) {
        ListAnswerFragment fragment = new ListAnswerFragment();
        fragment.setAnswers(answers);
        fragment.setCorrectAnswer(correctAnswer);
        return fragment;
    }

    public ListAnswerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list_answer, container, false);
        final ListView answersList = (ListView) v.findViewById(R.id.lv_list_answer);

        answers.add(correctAnswer);

        answersList.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, answers));
        answersList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                answersList.setSelection(i);
                mListener.onListAnswerPressed(answers.get(i));
                selectedAnswer = answers.get(i);
            }
        });
        return v;
    }

    public void setAnswers(ArrayList<String> answers) {
        this.answers = new ArrayList<>();
        this.answers.addAll(answers);
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    protected void onAttachToContext(Context context) {
        try {
            mListener = (OnListFragmentInteractionListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnStartGameFragmentInteraction");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public boolean validateQuestion() {
        return selectedAnswer.equals(correctAnswer);
    }

    public interface OnListFragmentInteractionListener {
        void onListAnswerPressed(String answer);
    }
}
