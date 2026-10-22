package com.example.practicalfive;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class Municipality extends AppCompatActivity {

    private TextView tvMunicipalityName;
    private TextView tvInformation;
    private ImageView ivMunicipality;
    private Button btnVisitSite;

    private String municipality;
    private String websiteUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_municipality);

        tvMunicipalityName = findViewById(R.id.tvMunicipalityName);
        tvInformation = findViewById(R.id.tvInformation);
        ivMunicipality = findViewById(R.id.ivMunicipality);
        btnVisitSite = findViewById(R.id.btnVisitSite);

        String receivedName =
                getIntent().getStringExtra(MainActivity.EXTRA_MUNICIPALITY);

        TextProcessor textProcessor = new TextProcessor();
        municipality = textProcessor.processMunicipality(receivedName);

        if (municipality == null) {
            Toast.makeText(
                    this,
                    "Invalid municipality",
                    Toast.LENGTH_SHORT
            ).show();

            finish();
            return;
        }

        String[] information =
                getResources().getStringArray(R.array.municipalities_array);

        switch (municipality) {

            case "Beijing":
                setMunicipalityContent(
                        "Beijing",
                        information[0],
                        R.drawable.beijing,
                        R.color.municipality_beijing
                );

                websiteUrl = "https://english.beijing.gov.cn/";
                break;

            case "Shanghai":
                setMunicipalityContent(
                        "Shanghai",
                        information[1],
                        R.drawable.shanghai,
                        R.color.municipality_shanghai
                );

                websiteUrl = "https://english.shanghai.gov.cn/";
                break;

            case "Chongqing":
                setMunicipalityContent(
                        "Chongqing",
                        information[2],
                        R.drawable.chongqing,
                        R.color.municipality_chongqing
                );

                websiteUrl = "https://english.cq.gov.cn/";
                break;

            case "Tianjin":
                setMunicipalityContent(
                        "Tianjin",
                        information[3],
                        R.drawable.tianjin,
                        R.color.municipality_tianjin
                );

                websiteUrl = "https://en.tj.gov.cn/";
                break;
        }

        btnVisitSite.setOnClickListener(v -> openWebsite());
    }

    private void setMunicipalityContent(
            String name,
            String information,
            int imageResource,
            int colourResource) {

        int colour = ContextCompat.getColor(this, colourResource);

        tvMunicipalityName.setText(name);
        tvMunicipalityName.setBackgroundColor(colour);

        tvInformation.setText(information);
        tvInformation.setTextColor(colour);

        ivMunicipality.setImageResource(imageResource);

        btnVisitSite.setBackgroundTintList(
                ColorStateList.valueOf(colour)
        );
    }

    private void openWebsite() {

        Intent intent = new Intent(
                Intent.ACTION_VIEW,
                Uri.parse(websiteUrl)
        );

        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(
                    this,
                    "No application available to open this website",
                    Toast.LENGTH_SHORT
            ).show();
        }
    }
}