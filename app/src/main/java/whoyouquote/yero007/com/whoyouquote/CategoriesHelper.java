package whoyouquote.yero007.com.whoyouquote;

import android.content.Context;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import whoyouquote.yero007.com.whoyouquote.data.Category;
import whoyouquote.yero007.com.whoyouquote.data.Question;

/**
 * Created by sabau on 10-Sep-16.
 * It is used to get the questions from files
 */

public class CategoriesHelper {

    private Context context;

    public CategoriesHelper(Context context) {
        this.context = context;
    }

    public ArrayList<Category> getCategories(){
        ArrayList<Category> questions = new ArrayList<>();

        Category category;
        FileInputStream fis;
        try {
            fis = context.openFileInput(Constants.TEST_CATEGORIES_FILE);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(isr);
            try{
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    category = new Category(new JSONObject(line));
                    questions.add(category);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return questions;
    }

}
