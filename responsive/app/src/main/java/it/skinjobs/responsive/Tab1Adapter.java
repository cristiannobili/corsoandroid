package it.skinjobs.responsive;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import java.util.Arrays;
import java.util.List;

import it.skinjobs.responsive.databinding.ItemTransformBinding;

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
        ItemTransformBinding binding = ItemTransformBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new Tab1ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull Tab1ViewHolder holder, int position) {
        holder.textView.setText(getItem(position));
        holder.imageView.setImageDrawable(
                ResourcesCompat.getDrawable(holder.imageView.getResources(),
                        drawables.get(position),
                        null));
    }
}
