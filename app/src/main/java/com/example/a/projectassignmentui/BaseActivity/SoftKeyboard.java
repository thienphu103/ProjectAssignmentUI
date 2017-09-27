package com.example.a.projectassignmentui.BaseActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;

import com.example.a.projectassignmentui.R;

/**
 * Created by Tobaco Mojito on 25-Sep-17.
 */

public class SoftKeyboard extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private ViewTreeObserver.OnGlobalLayoutListener keyboardLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
        @Override
        public void onGlobalLayout() {
            int heightDiff = rootLayout.getRootView().getHeight() - rootLayout.getHeight();
            int heightScreen = rootLayout.getRootView().getHeight();
            int contentViewBottom = getWindow().findViewById(Window.ID_ANDROID_CONTENT).getBottom();
            int heightStatusbar = contentViewBottom - heightDiff;
            int contentViewTop = getWindow().findViewById(Window.ID_ANDROID_CONTENT).getTop();

            System.out.println("______________________________________");
            System.out.println("height diff          : " + heightDiff);
            System.out.println("height screen        : " + heightScreen);
            System.out.println("height statusbar     : " + heightStatusbar);
            System.out.println("height content top   : " + contentViewTop);
            System.out.println("height content bottom: " + contentViewBottom);            System.out.println("______________________________________");


            LocalBroadcastManager broadcastManager = LocalBroadcastManager.getInstance(SoftKeyboard.this);

            if(heightDiff <= heightStatusbar){
                onHideKeyboard();

                Intent intent = new Intent("KeyboardWillHide");
                broadcastManager.sendBroadcast(intent);
            } else {
                int keyboardHeight = heightScreen - contentViewBottom;
                onShowKeyboard(keyboardHeight);
                Intent intent = new Intent("KeyboardWillShow");
                intent.putExtra("KeyboardHeight", keyboardHeight);
                broadcastManager.sendBroadcast(intent);
            }
        }
    };

    private boolean keyboardListenersAttached = false;
    private ViewGroup rootLayout;

    protected void onShowKeyboard(int keyboardHeight) {}
    protected void onHideKeyboard() {}

    protected void attachKeyboardListeners() {
        if (keyboardListenersAttached) {
            return;
        }

        rootLayout = (ViewGroup) findViewById(R.id.layout_main);
        rootLayout.getViewTreeObserver().addOnGlobalLayoutListener(keyboardLayoutListener);

        keyboardListenersAttached = true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (keyboardListenersAttached) {
            rootLayout.getViewTreeObserver().removeGlobalOnLayoutListener(keyboardLayoutListener);
        }
    }
}