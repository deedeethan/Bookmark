package com.example.deedeehan.bookmark;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BookmarkStart extends AppCompatActivity {

    private Button mNewListButton;
    private Button mSavedListsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmark_start);

        mNewListButton = (Button)findViewById(R.id.newListButton);
        
        mNewListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newList();
            }
        });
        // when savedlistsbutton is clicked, take user to saved lists page
        // add new list titles to this page
        // have buttons on saved lists page that take user to the list he/she   clicked on?
        // if so, need a way to save each page separately

        mSavedListsButton = (Button)findViewById(R.id.savedListsButton);

        mSavedListsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savedLists();
            }
        });
    }

    private void newList() {
        Intent intent = new Intent(this, NewListPage.class);
        startActivity(intent);
        // need more here?
    }

    private void savedLists() {
        Intent intent = new Intent(this, SavedListsPage.class);
        startActivity(intent);
    }
}
