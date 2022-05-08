package it.skinjobs.newsfeed;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import it.skinjobs.newsfeed.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment implements Observer {
    private FragmentHomeBinding binding;

    private NewsViewModel newsViewModel;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);

        View root = binding.getRoot();
        recyclerView = binding.recyclerView; // viene associata la recycler view
        recyclerViewAdapter = new RecyclerViewAdapter();
        recyclerView.setAdapter(recyclerViewAdapter); // viene assegnata all'adapter
        newsViewModel = new NewsViewModel(recyclerViewAdapter); // viene creato il view model
        Subject.getInstance().addObserver(this, "finish");
        Subject.getInstance().addObserver(this, "reload");
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    @Override
    public void update(String event) {
        if (event.equals("reload")) {
            this.binding.progressBar.setVisibility(View.VISIBLE);
        } else if (event.equals("finish")){
            this.binding.progressBar.setVisibility(View.GONE);
        }
    }
}