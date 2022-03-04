package it.skinjobs.responsive;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import it.skinjobs.responsive.databinding.ItemTransformBinding;

public class Tab1ViewHolder extends RecyclerView.ViewHolder {

        public final ImageView imageView;
        public final TextView textView;

        public Tab1ViewHolder(ItemTransformBinding binding) {
            super(binding.getRoot());
            imageView = binding.imageViewItemTransform;
            textView = binding.textViewItemTransform;
        }

}
