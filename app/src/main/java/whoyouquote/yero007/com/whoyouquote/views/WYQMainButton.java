package whoyouquote.yero007.com.whoyouquote.views;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

public class WYQMainButton extends Button {
    public WYQMainButton(Context context) {
        super(context);
        setTypeface(context);
    }

    public WYQMainButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTypeface(context);
    }

    public WYQMainButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTypeface(context);
    }

    private void setTypeface(Context context){
        this.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Lato-Regular.ttf"));
    }
}
