package com.example.deedeehan.bookmark;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by deedeehan on 2/28/16.
 */
public class ListDialogFragment extends DialogFragment implements TextView.OnEditorActionListener {
        private EditText mEditText;

        // 1. Defines the listener interface with a method passing back data result.
        public interface ListDialogFragmentListener {
            void onFinishEditDialog(String inputText);
        }

        // ...
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // ...
            // 2. Setup a callback when the "Done" button is pressed on keyboard
            mEditText.setOnEditorActionListener(this);
        }

        // Fires whenever the textfield has an action performed
        // In this case, when the "Done" button is pressed
        // REQUIRES a 'soft keyboard' (virtual keyboard)
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if (EditorInfo.IME_ACTION_DONE == actionId) {
                // Return input text back to activity through the implemented listener
                ListDialogFragmentListener listener = (ListDialogFragmentListener) getActivity();
                listener.onFinishEditDialog(mEditText.getText().toString());
                // Close the dialog and return back to the parent activity
                dismiss();
                return true;
            }
            return false;
        }
    }

}
