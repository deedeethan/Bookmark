package com.example.deedeehan.bookmark;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
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


    public interface ListDialogListener {
        public void onDialogPositiveClick(DialogFragment dialog, String name);
        public void onDialogNegativeClick(DialogFragment dialog);
    }

    // Use this instance of the interface to deliver action events
    ListDialogListener mListener;

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (EditorInfo.IME_ACTION_DONE == actionId) {
            // Return input text back to activity through the implemented listener
            mListener.onDialogPositiveClick(ListDialogFragment.this, mEditText.getText().toString());
            // Close the dialog and return back to the parent activity
            dismiss();
            return true;
        }
        return false;
    }

    // Override the Fragment.onAttach() method to instantiate the NoticeDialogListener
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            mListener = (ListDialogListener) activity;

        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(activity.toString()
                    + " must implement ListDialogListener");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Context context = getActivity();

        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.dialog_name, null, false);
        mEditText = (EditText) view.findViewById(R.id.name);
        mEditText.setOnEditorActionListener(this);

        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setTitle("New List")
                .setView(inflater.inflate(R.layout.dialog_name, null))
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //mEditText.onEditorAction(mEditText, id, new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.getMaxKeyCode()));
                        //mListener.onDialogPositiveClick(ListDialogFragment.this, mEditText.getText().toString());
                    }
                });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mListener.onDialogNegativeClick(ListDialogFragment.this);
            }
        });

        AlertDialog dialog = builder.create();
        return dialog;
    }

    /*
        // Fires whenever the textfield has an action performed
        // In this case, when the "Done" button is pressed
        // REQUIRES a 'soft keyboard' (virtual keyboard)
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if (EditorInfo.IME_ACTION_DONE == actionId) {
                // Return input text back to activity through the implemented listener
                ListDialogListener listener = (ListDialogListener) getActivity();
                listener.onFinishEditDialog(mEditText.getText().toString());
                // Close the dialog and return back to the parent activity
                dismiss();
                return true;
            }
            return false;
        }
    }
    */
}
