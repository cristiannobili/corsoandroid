package it.skinjobs.simpletodo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    class ViewHolder extends RecyclerView.ViewHolder {
        Button buttonDelete;
        Button buttonComplete;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            buttonDelete = itemView.findViewById(R.id.button_delete);
            buttonComplete = itemView.findViewById(R.id.button_complete);
            textView = itemView.findViewById(R.id.text_view_title);
        }
    }

    ArrayList<Todo> todoList;
    Context context;
    ItemDelegate delegate;

    public void setDelegate(ItemDelegate delegate) {
        this.delegate = delegate;
    }

    public RecyclerViewAdapter() {
            this.todoList = new ArrayList<>();
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
        Todo todo = this.todoList.get(position);
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.textView.setText(todo.getTitle());
        if (todo.isComplete()) {
            viewHolder.textView.setTextColor(ContextCompat.getColor(context, R.color.green));
        }
        viewHolder.buttonDelete.setOnClickListener(view -> {
            this.delegate.remove(position);
        });
        viewHolder.buttonComplete.setOnClickListener(view -> {
            this.delegate.complete(position);
        });
    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }

    public void update(final List<Todo> todoList) {
        this.todoList.clear();
        this.todoList = new ArrayList<>(todoList);
        notifyDataSetChanged();
    }


}
