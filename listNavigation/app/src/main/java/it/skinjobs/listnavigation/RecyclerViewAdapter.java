package it.skinjobs.listnavigation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    class ViewHolder extends RecyclerView.ViewHolder {
        Button buttonDelete;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            buttonDelete = itemView.findViewById(R.id.button_delete);
            textView = itemView.findViewById(R.id.text_view_title);
        }
    }

    ArrayList<Todo> todoList;
    Context context;
    RemoveDelegate delegate;

    public RecyclerViewAdapter(RemoveDelegate delegate) {
            this.todoList = new ArrayList<>();
            this.delegate = delegate;
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
        viewHolder.buttonDelete.setOnClickListener(view -> {
            this.delegate.remove(position);
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
