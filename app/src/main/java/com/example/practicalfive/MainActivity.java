package com.example.practicalfive;

import android.content.Intent;
import android.os.Bundle;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MUNICIPALITY = "municipality_name";

    private EditText etMunicipality;
    private TextProcessor textProcessor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etMunicipality = findViewById(R.id.etMunicipality);
        textProcessor = new TextProcessor();

        etMunicipality.setOnEditorActionListener((v, actionId, event) -> {

            if (actionId == EditorInfo.IME_ACTION_GO ||
                    actionId == EditorInfo.IME_ACTION_DONE) {

                String input = etMunicipality.getText().toString();

                String processedName =
                        textProcessor.processMunicipality(input);

                if (processedName == null) {

                    if (input.trim().isEmpty()) {
                        etMunicipality.setError("Please enter a municipality");
                    } else {
                        etMunicipality.setError(
                                "Please enter Beijing, Shanghai, Tianjin, or Chongqing"
                        );
                    }

                    return true;
                }

                Intent intent =
                        new Intent(MainActivity.this, Municipality.class);

                intent.putExtra(EXTRA_MUNICIPALITY, processedName);

                startActivity(intent);

                return true;
            }

            return false;
        });
    }
}