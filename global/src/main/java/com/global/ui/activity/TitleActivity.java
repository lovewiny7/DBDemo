package com.global.ui.activity;

import android.os.Bundle;

import com.waterbase.ui.BaseTitleActivity;


public class TitleActivity extends BaseTitleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLeftTwoImageVisibity(false);
        setRightOneImageVisibity(false);
        setRightTextViewVisibity(false);
        setRightTwoImageVisibity(false);
        setLeftTextViewVisibity(false);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    
    @Override
    protected boolean isDarkStatusBar() {
        return true;
    }
}
