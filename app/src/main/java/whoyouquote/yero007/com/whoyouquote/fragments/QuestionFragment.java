package whoyouquote.yero007.com.whoyouquote.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import whoyouquote.yero007.com.whoyouquote.R;


/**
 * The Question Fragment used to be display at the top of the
 * {@link whoyouquote.yero007.com.whoyouquote.activities.GameActivity}.
 * It provides a callback when the fab is clicked.
 */
public class QuestionFragment extends BaseFragment {

    private static final String ARG_INITIAL_TEXT = "initialQuestionText";

    private String initialQuestionText;
    private TextView questionTextView;
    private FloatingActionButton mFabValidate;
    private OnQuestionFragmentListener mListener;

    public QuestionFragment() {
        // Required empty public constructor
    }

    /**
     * This method creates a new Instance of the Question Fragment.
     *
     * @param text The text of the question
     * @return A new instance of fragment QuestionFragment.
     */
    public static QuestionFragment newInstance(String text) {
        QuestionFragment fragment = new QuestionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_INITIAL_TEXT, text);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            initialQuestionText = getArguments().getString(ARG_INITIAL_TEXT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.question_layout, container, false);
        questionTextView = (TextView) v.findViewById(R.id.textViewQuote);

        questionTextView.setText(initialQuestionText);

        mFabValidate = (FloatingActionButton) v.findViewById(R.id.fab_question_validate);
        mFabValidate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onValidateQuestionPressed();
            }
        });
        mFabValidate.hide();

        return v;
    }

    public void updateQuestionText(String newQuestionText) {
        if (questionTextView != null) {
            questionTextView.setText(newQuestionText);
        }
    }

    public void showFabButton() {
        mFabValidate.show();
    }

    public void hideFabButton() {
        mFabValidate.hide();
    }

    protected void onAttachToContext(Context context) {
        try {
            mListener = (OnQuestionFragmentListener) context;
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

    public interface OnQuestionFragmentListener {
        void onValidateQuestionPressed();
    }
}
