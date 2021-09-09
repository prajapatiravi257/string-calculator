package planetnoobs.stringcalculator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    TextInputLayout userInput;
    TextView totalCount;
    MaterialButton btncalc;
    StringCalculator stringCalculator = new StringCalculator();

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userInput = findViewById(R.id.userInput);
        btncalc = findViewById(R.id.btncalc);
        totalCount = findViewById(R.id.totalCount);

        btncalc.setOnClickListener(view -> {
            int total = stringCalculator.calculateString(Objects.requireNonNull(userInput.getEditText()).getText().toString());
            if(total > 0) {
                totalCount.setText(String.valueOf(total));
            }else {
                Toast.makeText(this, "Negative numbers are not allowed", Toast.LENGTH_SHORT).show();
            }
        });

    }


}