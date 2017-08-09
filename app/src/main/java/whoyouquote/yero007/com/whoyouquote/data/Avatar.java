package whoyouquote.yero007.com.whoyouquote.data;

import android.support.annotation.DrawableRes;

import whoyouquote.yero007.com.whoyouquote.R;

/**
 * Created by Dani on 17.06.2015.
 */
public class Avatar {

//    ONE(R.drawable.abc_ab_share_pack_holo_dark);

/*
    ONE(R.drawable.avatar_1),

    TWO(R.drawable.avatar_2),
    THREE(R.drawable.avatar_3),
    FOUR(R.drawable.avatar_4),
    FIVE(R.drawable.avatar_5),
    SIX(R.drawable.avatar_6),
    SEVEN(R.drawable.avatar_7),
    EIGHT(R.drawable.avatar_8),
    NINE(R.drawable.avatar_9),
    TEN(R.drawable.avatar_10),
    ELEVEN(R.drawable.avatar_11),
    TWELVE(R.drawable.avatar_12),
    THIRTEEN(R.drawable.avatar_13),
    FOURTEEN(R.drawable.avatar_14),
    FIFTEEN(R.drawable.avatar_15),
    SIXTEEN(R.drawable.avatar_16);
*/

    private final int mResId;

    public Avatar(@DrawableRes final int resId) {
        mResId = resId;
    }

    @DrawableRes
    public int getDrawableId() {
        return mResId;
    }
}
