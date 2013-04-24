package kr.co.flneapps.Flneapps;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import kr.co.flneapps.Flneapps.R;

public class MyActivity extends Activity
{
    /**
    * Called when the activity is first created.
    */
    @Override
    public void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.flneapps.co.kr/download.html?utm_source=android&utm_medium=app&utm_campaign=android")));
            }
        }, 2000);
    }

}
