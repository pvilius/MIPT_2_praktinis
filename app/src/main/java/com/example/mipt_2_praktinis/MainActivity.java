package com.example.mipt_2_praktinis;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mipt_2_praktinis.R;

public class MainActivity extends AppCompatActivity {

    EditText editInputText;
    Spinner spinnerCountType;
    Button btnCount;
    TextView tvResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                    Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                    v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                    return insets;
                });

        editInputText = findViewById(R.id.editInputText);
        btnCount = findViewById(R.id.btnCount);
        tvResults = findViewById(R.id.tvResults);

        //Spinner choices
        spinnerCountType = findViewById(R.id.spinnerCountType);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.count_type, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCountType.setAdapter(adapter);

        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputText = editInputText.getText().toString().trim();
                if(inputText.isEmpty()) {
                    Toast.makeText(MainActivity.this, R.string.error_empty_input, Toast.LENGTH_SHORT).show();
                    return;
                }

            int selectedCountType = spinnerCountType.getSelectedItemPosition();
            String result = "";

            WordCharacterCounter counter = new WordCharacterCounter();

                if (selectedCountType == 0) {
                result = "Words: " + counter.getWordsCount(inputText);
            } else if (selectedCountType == 1) {
                result = "Characters: " + counter.getCharactersCount(inputText);
            }

                tvResults.setText(result);
        }
    });
}
}