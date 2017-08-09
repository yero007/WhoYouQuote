package whoyouquote.yero007.com.whoyouquote.utils;

import android.content.Context;
import android.content.SharedPreferences;

import whoyouquote.yero007.com.whoyouquote.data.Avatar;

/**
 * Created by Dani on 17.06.2015.
 */
public class SharedPreferencesHandler {
    private Context context;
    SharedPreferences sharedpreferences;

    public SharedPreferencesHandler( Context context,String sharedPreferencesName)
    {
        sharedpreferences= context.getSharedPreferences(sharedPreferencesName, Context.MODE_PRIVATE);
        this.context=context;
    }
    public void addPreference(String key,String value)
    {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }
    public void addPreference(String key,int value)
    {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }
    public void addPreference(String key,boolean value)
    {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }
    public String getStringPreference(String key)
    {
        return sharedpreferences.getString(key, null);
    }

    public String getStringPreference(String key,String defaultValue)
    {
        return sharedpreferences.getString(key, defaultValue);
    }

    public int getIntPreference(String key)
    {
        return sharedpreferences.getInt(key, 0);
    }
    public boolean getBooleanPreference(String key)
    {
        return sharedpreferences.getBoolean(key, false);
    }
    public void deletePreference(String key)
    {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.remove(key);
        editor.apply();
    }

    public void addPreference(String name,Avatar avatar) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putInt(name,avatar.getDrawableId());
        editor.apply();
    }
}