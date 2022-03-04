package it.skinjobs.responsive;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import it.skinjobs.responsive.databinding.FragmentTab3Binding;

public class Tab3Fragment extends Fragment {

    private FragmentTab3Binding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentTab3Binding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textTab3;
        textView.setText("This is Tab3");
        return root;
    }
}
