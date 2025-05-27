package com.dkkk.soothsayer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Homeactivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeactivity);

        ImageButton settingsButton = findViewById(R.id.settingsButton);
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homeactivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
    }

    public void GotoTaro(View v) {
        startActivity(new Intent(this, TaroActivity.class));
    }

    public void GoToGoroscope(View v) {
        startActivity(new Intent(this, Goroscope.class));
    }

    public void GoToMatrix(View v) {
        startActivity(new Intent(this, Matrix.class));
    }

    public void GoToTest(View v) {
        startActivity(new Intent(this, Test.class));
    }
}
