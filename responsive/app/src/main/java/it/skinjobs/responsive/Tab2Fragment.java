package it.skinjobs.responsive;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import it.skinjobs.responsive.databinding.FragmentTab2Binding;

public class Tab2Fragment extends Fragment {

    private FragmentTab2Binding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentTab2Binding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textTab2;
        textView.setText("This is Tab2");
        Button button = binding.buttonItemTab2;
        button.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.action_detail_tab2);
        });
        return root;
    }
}
