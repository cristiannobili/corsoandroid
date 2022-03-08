package it.skinjobs.listnavigation;

import android.app.Application;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import it.skinjobs.listnavigation.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private TodoViewModel todoViewModel;
    private FragmentHomeBinding binding;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        todoViewModel =
                new ViewModelProvider(this).get(TodoViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        recyclerView = binding.recyclerView;
        recyclerViewAdapter = new RecyclerViewAdapter(todoViewModel);
        recyclerView.setAdapter(recyclerViewAdapter);
        todoViewModel.getTodoLiveData().observe(this, todoList -> {
            recyclerViewAdapter.update(todoList);
        });
        EditText editText = binding.editText;
        Button addButton = binding.buttonAdd;
        addButton.setOnClickListener(view -> {
            String value = editText.getText().toString();
            if (!value.equals("")) {
                todoViewModel.add(value.toString());
                editText.setText("");
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}