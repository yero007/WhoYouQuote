package whoyouquote.yero007.com.whoyouquote.utils;

import android.content.Context;

import whoyouquote.yero007.com.whoyouquote.Constants;
import whoyouquote.yero007.com.whoyouquote.data.Player;

/**
 * Created by Dani on 17.06.2015.
 */
public class DataSaver {
    Context context;
    DataSaver (Context context)
    {
    this.context=context;
    }
    public void savePlayerInfo(Player player)
    {
        SharedPreferencesHandler sh = new SharedPreferencesHandler(context, Constants.playerShared);
        sh.addPreference("name",player.getName());
       // sh.addPreference("avatar",player.getAvatar());
    }


}
