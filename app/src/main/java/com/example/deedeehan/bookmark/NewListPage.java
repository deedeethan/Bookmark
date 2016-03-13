package com.example.deedeehan.bookmark;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.example.deedeehan.bookmark.R;

public class NewListPage extends Activity implements ListDialogFragment.ListDialogListener {

    // each new list will have this format, so maybe a newList page should be a class
    // without a layout?
    // newList should be a class with a bunch of editTexts for name and page
    // REDO

    private Button mSaveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_list);

        mSaveButton = (Button)findViewById(R.id.saveButton);
        // when save button is clicked, pop up asks user to add the name of the list
        // include button "Create"
        // after clicking this button, user is brought to "Current Lists" page
        // Lists page - delete button, home button
        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // instead of popupwindow, use dialogfragment
                showNoticeDialog();

            }
        });
    }

    public void showNoticeDialog() {
        // Create an instance of the dialog fragment and show it
        DialogFragment dialog = new ListDialogFragment();
        dialog.show(getFragmentManager(), "ListDialogFragment");
    }


    @Override
    public void onDialogPositiveClick(DialogFragment dialog, String name) {
        Log.d("from dialog fragment - ", name);
        Intent intent = new Intent(this, SavedListsPage.class);
        startActivity(intent);

        // pass the string to the saved lists page and add a list with that name
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {
        dialog.dismiss();
    }

}
