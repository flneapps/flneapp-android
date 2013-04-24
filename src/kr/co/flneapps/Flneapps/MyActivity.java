package kr.co.flneapps.Flneapps;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.widget.TextView;

public class MyActivity extends Activity
{
    AlertDialog dialog;

    @Override
    public void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro);

        dialog = createDialog(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(!dialog.isShowing()){
                    dialog.show();
                }
            }
        }, 2000);
    }

    private AlertDialog createDialog(Context context) {
        final TextView message = new TextView(context);
        final SpannableString s = new SpannableString("이 앱은 금융위/금감원의 터무니없는 보안 정책에 항의하기 위해 제작하여 배포하는 것입니다.\n\n" +
                "귀하의 안드로이드 폰은 '알 수 없는 소스'에서 내려받은 앱을 마구 설치할 수 있도록 설정되어 있습니다.\n\n" +
                "이런 설정은 매우 위험할 수 있으니, 지금이라도 '알 수 없는 소스'는 허용하지 않도록 설정을 바꾸어 주세요.\n\n" +
                "금융'얩'스토어\nhttp://www.flneapps.co.kr\n\n" +
                "오픈넷\nhttp://opennet.or.kr/2007");

        Linkify.addLinks(s, Linkify.WEB_URLS);
        message.setText(s);
        message.setMovementMethod(LinkMovementMethod.getInstance());

        DialogInterface.OnClickListener closeListener = new AlertDialog.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                finish();
            }
        };

        return new AlertDialog.Builder(context)
                .setTitle("낚이셨습니다.")
                .setCancelable(true)
                .setPositiveButton("닫기", closeListener)
                .setView(message)
                .create();
    }

}
