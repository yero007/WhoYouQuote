package whoyouquote.yero007.com.whoyouquote.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import whoyouquote.yero007.com.whoyouquote.utils.Tags;

/**
 * Created by sabau on 24-Jul-16.
 */

public class Category {

    private int id;
    private String name;
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Category(int id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public Category (JSONObject response){
        try{
            deserializeObject(response);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        JSONObject obj = new JSONObject();
        try {
            obj.put(Tags.CATEGORIES_ID, id);
            obj.put(Tags.CATEGORIES_NAME, name);
            obj.put(Tags.CATEGORIES_IMAGE, image);

         } catch (JSONException e) {
            e.printStackTrace();
        }
        return String.format("%s\n", obj.toString());
    }

    private void deserializeObject(JSONObject response) throws JSONException {
        if(response.has(Tags.CATEGORIES_ID)&&!response.isNull(Tags.CATEGORIES_ID)){
            id = response.getInt(Tags.CATEGORIES_ID);
        }

        if(response.has(Tags.CATEGORIES_NAME)&&!response.isNull(Tags.CATEGORIES_NAME)){
            name = response.getString(Tags.CATEGORIES_NAME);
        }

        if(response.has(Tags.CATEGORIES_IMAGE)&&!response.isNull(Tags.CATEGORIES_IMAGE)){
            image = response.getString(Tags.CATEGORIES_IMAGE);
        }
    }
}
