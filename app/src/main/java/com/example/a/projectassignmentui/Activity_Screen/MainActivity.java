package com.example.a.projectassignmentui.Activity_Screen;

import android.app.Service;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.a.projectassignmentui.BaseActivity.SoftKeyboardCatch;
import com.example.a.projectassignmentui.R;

public class MainActivity extends AppCompatActivity {
    SoftKeyboardCatch softKeyboard;
    EditText edtEmail;
    EditText edtPass;
    ImageView imageView;
    Button btnResgiter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        relativeLayout = (RelativeLayout) findViewById(R.id.layout_main_focus);
//        relativeLayout.setVisibility(View.GONE);
        getSupportActionBar().hide();
        initControl();
        intiEvent();
        initDisplay();
    }

    private void initDisplay() {

    }

    private void intiEvent() {
        btnResgiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        softKeyboard.setSoftKeyboardCallback(new SoftKeyboardCatch.SoftKeyboardChanged() {

            @Override
            public void onSoftKeyboardHide() {
                // Code here

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
//                        hideKeyboard();
                    }
                });
            }

            @Override
            public void onSoftKeyboardShow() {
                // Code here

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
//                        showKeyboard();
                    }
                });
            }
        });
    }

    private void initControl() {
        edtEmail = (EditText) findViewById(R.id.editTextEmail);
        edtPass = (EditText) findViewById(R.id.editTextPass);
        imageView = (ImageView) findViewById(R.id.image_view1);
        btnResgiter = (Button) findViewById(R.id.btn_resgiter);

        RelativeLayout mainLayout = (RelativeLayout) findViewById(R.id.layout_main); // You must use the layout root
        InputMethodManager im = (InputMethodManager) getSystemService(Service.INPUT_METHOD_SERVICE);
        softKeyboard = new SoftKeyboardCatch(mainLayout, im);
    }

//    private void showKeyboard() {
//        imageView.setImageResource(R.drawable.iconfb2);
//    }
//
//    private void hideKeyboard() {
//        imageView.setImageResource(R.drawable.banner);
//    }

}
//    public void showKeyboard(View v) {
//        InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//        mgr.showSoftInput(editInput, InputMethodManager.SHOW_IMPLICIT);
//    }
//
//    public void hideKeyboard(View v) {
//        InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//        mgr.hideSoftInputFromWindow(editInput.getWindowToken(), 0);
//    }

