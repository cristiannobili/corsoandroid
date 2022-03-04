package it.skinjobs.responsive;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import it.skinjobs.responsive.databinding.FragmentTab1Binding;

public class Tab1Fragment extends Fragment {

    private FragmentTab1Binding binding;

    private Tab1ViewModel tab1ViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        tab1ViewModel =
                new ViewModelProvider(this).get(Tab1ViewModel.class);

        binding = FragmentTab1Binding.inflate(inflater, container, false);
        View root = binding.getRoot();

        RecyclerView recyclerView = binding.recyclerviewTransform;
        ListAdapter<String, Tab1ViewHolder> adapter = new Tab1Adapter();
        recyclerView.setAdapter(adapter);
        tab1ViewModel.getTexts().observe(getViewLifecycleOwner(), adapter::submitList);
        return root;
    }
}
