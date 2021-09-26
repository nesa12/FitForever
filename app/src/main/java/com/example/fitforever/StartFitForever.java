package com.example.fitforever;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class StartFitForever<Textview> extends AppCompatActivity {
    EditText username;
    View btnstart;

    //validation
    public boolean validateUsername(){
        String user  = username.getText().toString();
        if(user.isEmpty()){
            username.setError("Enter a Username to start!");
            return false;
        }else{
            username.setError(null);
            return true;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_fitforever);

        btnstart = findViewById(R.id.btnstart);
        username = findViewById(R.id.edtUN);
    }

    protected void onResume(){
        super.onResume();

        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!validateUsername()){
                    return;
                }

                Intent intent = new Intent(StartFitForever.this,WelcomePage.class);
                intent.putExtra("USERNAME",username.getText().toString());
                startActivity(intent);
            }
        });
    }
}

