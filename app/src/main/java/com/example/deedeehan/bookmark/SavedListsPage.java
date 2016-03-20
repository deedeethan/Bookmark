package com.example.deedeehan.bookmark;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;

public class SavedListsPage extends AppCompatActivity {

    private Button mHomeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_lists_page);

        Intent intent = getIntent();
        String listName = intent.getStringExtra("name of list");
        if (listName == null) {
            listName = "listName";
        }
        Log.d("list name", listName);



        mHomeButton = (Button)findViewById(R.id.homeButton);
        // when save button is clicked, pop up asks user to add the name of the list
        // include button "Create"
        // after clicking this button, user is brought to "Current Lists" page
        // Lists page - delete button, home button
        mHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goHome();
            }
        });
    }

    private void goHome() {
        Intent intent = new Intent(this, BookmarkStart.class);
        startActivity(intent);
    }

}
