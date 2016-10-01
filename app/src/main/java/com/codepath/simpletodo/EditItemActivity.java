package com.codepath.simpletodo;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class EditItemActivity extends AppCompatActivity {

    int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        String editItem = getIntent().getStringExtra("item");
        index = getIntent().getExtras().getInt("pos");
        EditText editText = (EditText) findViewById(R.id.txtEdit);
        editText.setText(editItem, TextView.BufferType.EDITABLE);
        editText.setSelection(editText.getText().length());

    }

    public void onSave(View v) {
        EditText etName = (EditText) findViewById(R.id.txtEdit);
        // Prepare data intent
        Intent data = new Intent();
        // Pass relevant data back as a result
        data.putExtra("name", etName.getText().toString());
        data.putExtra("pos", index);
        // Activity finished ok, return the data
        setResult(RESULT_OK, data); // set result code and bundle data for response
        finish(); // closes the activity, pass data to parent
    }


}
