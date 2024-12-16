package com.example.seminar_04;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Masina> masinaList = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        masinaList = new ArrayList<>();

        Button btn = findViewById(R.id.buttonAdaugaMasina);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(), AddMasinaActivity.class);
                startActivityForResult(it, 203);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button listaMasiniBtn = findViewById(R.id.buttonListaMasini);
        listaMasiniBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(), MasinaListActivity.class);
                it.putParcelableArrayListExtra("masini", (ArrayList<? extends Parcelable>) masinaList);
                startActivity(it);
            }
        });

        Button listaImaginibtn =  findViewById(R.id.buttonImagini);
        listaImaginibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(), ImaginiActivity.class);
                startActivity(it);
            }
        });

        Button sharedPreferencesBtn = findViewById(R.id.buttonMasiniPreferate);
        sharedPreferencesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(), SharedPreferencesList.class);
                startActivity(it);
            }
        });

        Button AccuWeatherbtn =  findViewById(R.id.buttonAccuWeather);
        AccuWeatherbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(), AccuWeatherActivity.class);
                startActivity(it);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 203) {
            if(resultCode == RESULT_OK) {
                Masina masina = data.getParcelableExtra("masina");
                masinaList.add(masina);
            }
        }
    }
}