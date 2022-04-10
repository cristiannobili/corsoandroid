package it.skinjobs.simpletodo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import it.skinjobs.simpletodo.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;

    private TodoViewModel todoViewModel;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);

        View root = binding.getRoot();
        recyclerView = binding.recyclerView;
        recyclerViewAdapter = new RecyclerViewAdapter();
        recyclerView.setAdapter(recyclerViewAdapter);
        todoViewModel = new TodoViewModel(recyclerViewAdapter);
        recyclerViewAdapter.setDelegate(todoViewModel);
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