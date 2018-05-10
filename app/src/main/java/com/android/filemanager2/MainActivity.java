package com.android.filemanager2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.filemanager2.preferences.PrefConstants;
import com.android.filemanager2.utils.AppUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /** my code */
        checkShowTutorial();
        /** my code end */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void checkShowTutorial(){
        int oldVersionCode = PrefConstants.getAppPrefInt(this,"version_code");
        int currentVersionCode = AppUtil.getAppVersionCode(this);
        //if(currentVersionCode > oldVersionCode){
            startActivity(new Intent(MainActivity.this,ProductTourActivity.class));
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            PrefConstants.putAppPrefInt(this,"version_code",currentVersionCode);
        //}
    }
}
