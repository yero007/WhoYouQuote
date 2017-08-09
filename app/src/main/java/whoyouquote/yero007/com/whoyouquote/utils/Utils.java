package whoyouquote.yero007.com.whoyouquote.utils;

import android.content.Context;

import whoyouquote.yero007.com.whoyouquote.R;

public class Utils {
    public static int getUserAvatarResource(Context context, int playerAvatarNumber) {
        switch (playerAvatarNumber) {
            case 0:
                return R.drawable.panda;
            case 1:
                return R.drawable.monkey;
            case 2:
                return R.drawable.parrot;
            case 3:
                return R.drawable.elephant;
            default:
                return R.drawable.panda;
        }
    }
}
