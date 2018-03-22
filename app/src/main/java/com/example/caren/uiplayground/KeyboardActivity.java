package com.example.caren.uiplayground;

import android.app.Activity;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Activity to play around with building a custom keyboard to see what's possible and not possible
 *
 * https://stackoverflow.com/questions/25911409/make-popup-of-the-key-pressed-in-a-customized-keyboard
 * http://www.fampennings.nl/maarten/android/09keyboard/
 * https://github.com/eyedol/kasahorow-Keyboard-For-Android
 */

public class KeyboardActivity extends Activity {

    Keyboard mKeyboard;
    KeyboardView mKeyboardView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View parent = getLayoutInflater().inflate(R.layout.activity_keyboard, null);

        setContentView(parent);

        // Create the Keyboard
        mKeyboard = new Keyboard(this, R.layout.keyboard);

        // Lookup the KeyboardView
        mKeyboardView = findViewById(R.id.keyboardview);
        // Attach the keyboard to the view
        mKeyboardView.setKeyboard(mKeyboard);

        // Do not show the preview balloons
//        mKeyboardView.setPreviewEnabled(false);

        // Install the key handler
        mKeyboardView.setOnKeyboardActionListener(mOnKeyboardActionListener);

        openKeyboard(parent);
    }

    public void openKeyboard(View v) {
        mKeyboardView.setVisibility(View.VISIBLE);
        mKeyboardView.setEnabled(true);
        if (v != null) {
            ((InputMethodManager) getSystemService(
                    Activity.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(v.getWindowToken(), 0);
        }
    }

    private KeyboardView.OnKeyboardActionListener mOnKeyboardActionListener =
            new KeyboardView.OnKeyboardActionListener() {
                @Override
                public void onKey(int primaryCode, int[] keyCodes) {
                    //Here check the primaryCode to see which key is pressed
                    //based on the android:codes property
                    if (primaryCode == 1) {
                        Log.i("Key", "You just pressed 1 button");
                    }
                }

                @Override
                public void onPress(int arg0) {
                }

                @Override
                public void onRelease(int primaryCode) {
                }

                @Override
                public void onText(CharSequence text) {
                }

                @Override
                public void swipeDown() {
                }

                @Override
                public void swipeLeft() {
                }

                @Override
                public void swipeRight() {
                }

                @Override
                public void swipeUp() {
                }
            };
}
