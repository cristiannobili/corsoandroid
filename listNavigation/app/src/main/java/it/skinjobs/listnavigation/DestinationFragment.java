package it.skinjobs.listnavigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import it.skinjobs.listnavigation.databinding.FragmentDestinationBinding;

public class DestinationFragment extends Fragment {

    FragmentDestinationBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentDestinationBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }
}
