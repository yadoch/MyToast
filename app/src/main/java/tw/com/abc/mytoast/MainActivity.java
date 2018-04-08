package tw.com.abc.mytoast;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String strMsg;
    private static Toast toast0,toast1;
    private static TextView toastText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toast1(View view) {
        //.show()沒有加的話不會顯示
        Toast.makeText(this,"Show ...............Toast1 !!",Toast.LENGTH_SHORT).show();
        Toast.makeText(this,"Show Toast2 !!",Toast.LENGTH_SHORT).show();
    }

//不覆蓋訊息,會直接顯示最新訊息

    private static void makeTextAndShow0(final Context context,final String text,final int duration){
        if (toast0 == null) {
            //如果還沒有用過makeText方法，才使用
            toast0 = android.widget.Toast.makeText(context, text, duration);
        } else {
            toast0.setText(text);
            toast0.setDuration(duration);
        }
        toast0.show();
    }

    //自訂Toast的樣式
   private static void makeTextAndShow1(final Context context,final String text,final int duration){
       if (toast1 == null) {
           //如果還沒有建立過Toast，才建立
           final ViewGroup toastView = new FrameLayout(context); // 用來裝toastText的容器
           final FrameLayout.LayoutParams flp = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
           final GradientDrawable background = new GradientDrawable();
           toastText = new TextView(context);
           toastText.setLayoutParams(flp);
           toastText.setSingleLine(false);
           toastText.setTextSize(18);
           toastText.setTextColor(Color.argb(0xAA, 0xFF, 0xFF, 0xFF)); // 設定文字顏色為有點透明的白色
           background.setColor(Color.argb(0xAA, 0xFF, 0x00, 0x00)); // 設定氣泡訊息顏色為有點透明的紅色
           background.setCornerRadius(20); // 設定氣泡訊息的圓角程度

           toastView.setPadding(30, 30, 30, 30); // 設定文字和邊界的距離
           toastView.addView(toastText);
           toastView.setBackgroundDrawable(background);

           toast1 = new Toast(context);
           toast1.setView(toastView);
       }
       toastText.setText(text);
       toast1.setDuration(duration);
       toast1.show();
   }
    public void toast2(View view) {
        strMsg="TEST ......................1 Time!!";
        makeTextAndShow0(this,strMsg,Toast.LENGTH_SHORT);

        strMsg="TEST 2 Time!!";
        makeTextAndShow0(this,strMsg,Toast.LENGTH_SHORT);
    }


    public void toast3(View view) {
        strMsg="TEST ......................1 Time!!";
        makeTextAndShow1(this,strMsg,Toast.LENGTH_SHORT);

        strMsg="TEST 2 Time!!";
        makeTextAndShow1(this,strMsg,Toast.LENGTH_SHORT);
    }

}
