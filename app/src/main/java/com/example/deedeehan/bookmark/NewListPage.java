package com.example.deedeehan.bookmark;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.example.deedeehan.bookmark.R;

public class NewListPage extends Activity implements ListDialogFragmentListener {

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
                PopupWindow title = new PopupWindow();

            }
        });
    }

    @Override
    public void onFinishEditDialog(String inputText) {
        Toast.makeText(this, "Hi, " + inputText, Toast.LENGTH_SHORT).show();
    }

}
