package whoyouquote.yero007.com.whoyouquote.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import whoyouquote.yero007.com.whoyouquote.utils.Tags;

/**
 * Created by sabau on 10-Sep-16.
 */

public class Question {

    //todo:use the question type
    private String text;
    private String correctAnswer;
    private int questionType;
    private ArrayList<String> possibleAnswers;

    public Question(String text, String correctAnswer, int questionType, ArrayList<String> possibleAnswers) {
        this.text = text;
        this.correctAnswer = correctAnswer;
        this.questionType = questionType;
        this.possibleAnswers = possibleAnswers;
    }

    public Question (JSONObject response){
        try{
           deserializeObject(response);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public int getQuestionType() {
        return questionType;
    }

    public void setQuestionType(int questionType) {
        this.questionType = questionType;
    }

    public ArrayList<String> getPossibleAnswers() {
        return possibleAnswers;
    }

    public void setPossibleAnswers(ArrayList<String> possibleAnswers) {
        this.possibleAnswers = possibleAnswers;
    }

    public String toString() {

        //todo:add the others
        JSONObject obj = new JSONObject();
        try {
            obj.put(Tags.QUESTION_TEXT, text);
            obj.put(Tags.QUESTION_CORRECT_ANSWER, correctAnswer);
            obj.put(Tags.QUESTION_QUESTION_TYPE, questionType);

            JSONArray possibleAnswersJsonArray = new JSONArray();
            for(String answer:possibleAnswers){
                possibleAnswersJsonArray.put(answer);
            }
            obj.put(Tags.QUESTION_POSSIBLE_ANSWERS,possibleAnswersJsonArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //todo:manual json create
        return String.format("%s\n", obj.toString());
    }

    private void deserializeObject(JSONObject response) throws JSONException {
        if(response.has(Tags.QUESTION_TEXT)&&!response.isNull(Tags.QUESTION_TEXT)){
           text = response.getString(Tags.QUESTION_TEXT);
        }

        if(response.has(Tags.QUESTION_CORRECT_ANSWER)&&!response.isNull(Tags.QUESTION_CORRECT_ANSWER)){
            correctAnswer = response.getString(Tags.QUESTION_CORRECT_ANSWER);
        }

        if(response.has(Tags.QUESTION_QUESTION_TYPE)&&!response.isNull(Tags.QUESTION_QUESTION_TYPE)){
            questionType = response.getInt(Tags.QUESTION_QUESTION_TYPE);
        }

        ArrayList<String> possibleAnswersList = new ArrayList<>();
        if(response.has(Tags.QUESTION_POSSIBLE_ANSWERS) && !response.isNull(Tags.QUESTION_POSSIBLE_ANSWERS)){
            JSONArray ja = response.getJSONArray(Tags.QUESTION_POSSIBLE_ANSWERS);
            for(int i=0;i<ja.length();i++){
                possibleAnswersList.add(ja.getString(i));
            }
            possibleAnswers = possibleAnswersList;
        }
    }
}
