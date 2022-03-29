package it.skinjobs.multiactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import it.skinjobs.multiactivity.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Button button = binding.button;
        button.setOnClickListener(view -> {
            Intent intent = new Intent(this, SecondActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("Chiave", "Valore");
            intent.putExtras(bundle);
            startActivity(intent);
        });
    }
}