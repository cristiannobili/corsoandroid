package it.skinjobs.responsive;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import it.skinjobs.responsive.databinding.FragmentDetailBinding;

public class DetailFragment extends Fragment {

    private FragmentDetailBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentDetailBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        TextView content = binding.textViewItemDetail;
        content.setText("Ciao");

        return root;
    }
}
