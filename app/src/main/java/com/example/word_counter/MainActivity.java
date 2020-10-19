package com.example.word_counter;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button buttonSearch;
    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.selection, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        buttonSearch = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.yourtext);
        textView = (TextView) findViewById(R.id.textView);
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String spinnertext =  spinner.getSelectedItem().toString();
                String firstchose = "words";
                String writedtext = editText.getText().toString();

                if (TextUtils.isEmpty(editText.getText().toString()))
                {
                    Toast.makeText(MainActivity.this, "The field is empty", Toast.LENGTH_SHORT).show();
                }

                else if (spinnertext.equals("words"))
                {
                    textView.setText("Word: " + Counter.wordCounter(writedtext));
                }



                }

        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text= parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}