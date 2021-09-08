package planetnoobs.stringcalculator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    TextInputLayout userInput;
    MaterialButton btncalc;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userInput = findViewById(R.id.userInput);
        btncalc = findViewById(R.id.btncalc);

        btncalc.setOnClickListener(view -> {
            Integer total = calculateString(Objects.requireNonNull(userInput.getEditText()).getText().toString());
            Toast topToast = Toast.makeText(this, "Total: "+ total.toString(), Toast.LENGTH_SHORT);
            topToast.setGravity(Gravity.TOP, 0, 0);
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private int calculateString(String input) {
        if(input.isEmpty()) {
            return 0;
        }
        String delimiterRegex = "[,.-/\n]+";
        String[] list = input.split(delimiterRegex);

        int total = 0;
        for(String item: list) {
            int num = Integer.parseInt(item);
            total += num;
        }

        if(total> 1000) {
            total -= 1000;
        }

        return total;
    }
}