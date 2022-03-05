package it.skinjobs.responsive;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import it.skinjobs.responsive.databinding.ItemTab1Binding;

public class Tab1ViewHolder extends RecyclerView.ViewHolder {

        public final ImageView imageView;
        public final TextView textView;
        public final Button buttonItem;

        public Tab1ViewHolder(ItemTab1Binding binding) {
            super(binding.getRoot());
            imageView = binding.imageViewItemTab1;
            textView = binding.textViewItemTab1;
            buttonItem = binding.buttonItemTab1;
        }

}
