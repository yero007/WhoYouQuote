package whoyouquote.yero007.com.whoyouquote.utils;

import android.content.Context;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import whoyouquote.yero007.com.whoyouquote.Constants;
import whoyouquote.yero007.com.whoyouquote.data.Category;
import whoyouquote.yero007.com.whoyouquote.data.Question;

/**
 * Created by sabau on 10-Sep-16.
 */

public class QuestionInitializer {

    private Context context;

    public QuestionInitializer(Context context) {
        this.context = context;
    }

    public void initializeTestQuestion() {
        ArrayList<String> serializedQuestions = new ArrayList<>();
        ArrayList<String> answers = new ArrayList<>();

        answers.add("Neil Armstrong");
        answers.add("Buzz Aldrin");
        answers.add("Humphrey Bogart");
        Question question = new Question("Who was the first human to travel into space?",
                "Yuri Gagarin", QuestionType.SINGLE_ANSWER, answers);
        serializedQuestions.add(question.toString());

        answers.clear();
        answers.add("Humphrey Bogart");
        answers.add("Paul Allen");
        answers.add("Humphrey Bogart");
        question = new Question("Who said: \"Dream as if you'll live forever. Live as if you'll die today.\"",
                "James Dean", QuestionType.SINGLE_ANSWER, answers);
        serializedQuestions.add(question.toString());

        answers.clear();
        answers.add("Zelda");
        answers.add("Mario");
        answers.add("Heyrule");
        question = new Question("What is the name of the main protagonist in the Legend of Zelda series of video games?",
                "Link", QuestionType.SINGLE_ANSWER, answers);
        serializedQuestions.add(question.toString());

        answers.clear();
        answers.add("Mars");
        answers.add("Gattaca");
        answers.add("Earth");
        question = new Question("Superman is a fictional superhero from what fictional planet?",
                "Krypton", QuestionType.SINGLE_ANSWER, answers);
        serializedQuestions.add(question.toString());

        answers.clear();
        answers.add("An airplane");
        answers.add("Spaceship");
        answers.add("Comet");
        question = new Question("What takes an average of 8 minutes 20 seconds to reach the Earth?",
                "Sun's light", QuestionType.SINGLE_ANSWER, answers);
        serializedQuestions.add(question.toString());

        answers.clear();
        answers.add("Laurent Perrier Rose");
        answers.add("Moet");
        answers.add("Louis Roederer Cristal");
        question = new Question("Who was the legendary Benedictine monk who invented champagne?",
                "Dom Perignon", QuestionType.SINGLE_ANSWER, answers);
        serializedQuestions.add(question.toString());

        answers.clear();
        answers.add("Romania");
        answers.add("Germany");
        answers.add("China");
        answers.add("Japan");
        question = new Question("In 2011, which country hosted a Formula 1 race for the first time?",
                "India", QuestionType.SINGLE_ANSWER, answers);
        serializedQuestions.add(question.toString());

        answers.clear();
        answers.add("A king");
        answers.add("A queen");
        answers.add("Horse");
        question = new Question("Which chess piece can only move diagonally?",
                "A bishop", QuestionType.SINGLE_ANSWER, answers);
        serializedQuestions.add(question.toString());

        answers.clear();
        question = new Question("What is the highest score possible in 10 pin bowling?",
                "300", QuestionType.NUMBER_ANSWER, answers);
        serializedQuestions.add(question.toString());

        FileOutputStream outputStream;
        try {
            outputStream = context.openFileOutput(Constants.TEST_QUESTIONS_FILE, Context.MODE_PRIVATE);
            for (String row : serializedQuestions){
                outputStream.write(row.getBytes());
            }
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initializeCategories(){
        ArrayList<String> serializedCategories = new ArrayList<>();
        serializedCategories.add(new Category(-1,"Test","none").toString());

        FileOutputStream outputStream;
        try {
            outputStream = context.openFileOutput(Constants.TEST_CATEGORIES_FILE, Context.MODE_PRIVATE);
            for (String row : serializedCategories){
                outputStream.write(row.getBytes());
            }
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
