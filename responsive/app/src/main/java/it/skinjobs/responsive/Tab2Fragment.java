package it.skinjobs.responsive;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import it.skinjobs.responsive.databinding.FragmentTab2Binding;

public class Tab2Fragment extends Fragment {

    private FragmentTab2Binding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentTab2Binding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textTab2;
        textView.setText("This is Tab2");
        return root;
    }
}
