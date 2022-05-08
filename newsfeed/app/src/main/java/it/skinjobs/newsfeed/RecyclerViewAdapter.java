package it.skinjobs.newsfeed;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView mediaText;
        ImageView mediaImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mediaImage = itemView.findViewById(R.id.media_image);
            mediaText = itemView.findViewById(R.id.media_text);
        }
    }

    ArrayList<News> newsList;
    Context context;

    public RecyclerViewAdapter() {
            this.newsList = new ArrayList<>();
        }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        News news = this.newsList.get(position);
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.mediaText.setText(news.getTitle());
        viewHolder.mediaText.setOnClickListener(l -> {
            Uri webpage = Uri.parse(news.getUrl());
            Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
            context.startActivity(intent);
        });
        Picasso.get().load(news.getImageUrl()).into(viewHolder.mediaImage);

    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public void update(final List<News> todoList) {
        this.newsList.clear();
        this.newsList = new ArrayList<>(todoList);
        notifyDataSetChanged();
    }


}
