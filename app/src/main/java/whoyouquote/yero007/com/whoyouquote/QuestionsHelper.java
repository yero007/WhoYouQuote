package whoyouquote.yero007.com.whoyouquote;

import android.content.Context;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import whoyouquote.yero007.com.whoyouquote.data.Question;

/**
 * Created by sabau on 10-Sep-16.
 * It is used to get the questions from files
 */

public class QuestionsHelper {

    private Context context;

    public QuestionsHelper(Context context) {
        this.context = context;
    }

    private ArrayList<Question> getQuestions(String fileName){
        ArrayList<Question> questions = new ArrayList<>();

        Question question;
        FileInputStream fis;
        try {
            fis = context.openFileInput(fileName);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(isr);
            try{
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    question = new Question(new JSONObject(line));
                    questions.add(question);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return questions;
    }

    public ArrayList<Question> getAllQuestionsInACategory(int category){
        ArrayList<Question> questions = new ArrayList<>();


        switch(category){
            case -1:
                return getQuestions(Constants.TEST_QUESTIONS_FILE);
        }
        return questions;
    }
}
