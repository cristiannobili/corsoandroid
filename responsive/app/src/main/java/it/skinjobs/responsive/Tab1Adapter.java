package it.skinjobs.responsive;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import java.util.Arrays;
import java.util.List;

import it.skinjobs.responsive.databinding.ItemTab1Binding;

public class Tab1Adapter extends ListAdapter<String, Tab1ViewHolder> {

    private final List<Integer> drawables = Arrays.asList(
            R.drawable.avatar_1,
            R.drawable.avatar_2,
            R.drawable.avatar_3,
            R.drawable.avatar_4,
            R.drawable.avatar_5,
            R.drawable.avatar_6,
            R.drawable.avatar_7,
            R.drawable.avatar_8,
            R.drawable.avatar_9,
            R.drawable.avatar_10,
            R.drawable.avatar_11,
            R.drawable.avatar_12,
            R.drawable.avatar_13,
            R.drawable.avatar_14,
            R.drawable.avatar_15,
            R.drawable.avatar_16);

    public Tab1Adapter() {
        super(new DiffUtil.ItemCallback<String>() {
            @Override
            public boolean areItemsTheSame(@NonNull String oldItem, @NonNull String newItem) {
                return oldItem.equals(newItem);
            }

            @Override
            public boolean areContentsTheSame(@NonNull String oldItem, @NonNull String newItem) {
                return oldItem.equals(newItem);
            }
        });
    }

    @NonNull
    @Override
    public Tab1ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemTab1Binding binding = ItemTab1Binding.inflate(LayoutInflater.from(parent.getContext()));
        return new Tab1ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull Tab1ViewHolder holder, int position) {
        holder.textView.setText(getItem(position));
        holder.imageView.setImageDrawable(
                ResourcesCompat.getDrawable(holder.imageView.getResources(),
                        drawables.get(position),
                        null));
        holder.buttonItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("id", holder.getAdapterPosition()+"");
                Navigation.findNavController(view).navigate(R.id.action_detail, bundle);
            }
        });
    }
}
