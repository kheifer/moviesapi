package com.epicodus.movieapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.epicodus.movieapp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {
    @Bind(R.id.radioGroup) RadioGroup mRadioSelection;
    @Bind(R.id.button) Button mButton;
    @Bind(R.id.editText2) EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == mButton){
            Intent searchIntent = new Intent(MainActivity.this, MovieListActivity.class);
            String query= mEditText.getText().toString();
            searchIntent.putExtra("query", query);
            startActivity(searchIntent);
        }
    }
}
