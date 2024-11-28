package com.example.avaliacaodois;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ShoppingListAdapter extends RecyclerView.Adapter<ShoppingListAdapter.ViewHolder> {
    private final List<String> shoppingList;
    private final OnItemRemoveListener onItemRemoveListener;

    public ShoppingListAdapter(List<String> shoppingList, OnItemRemoveListener onItemRemoveListener) {
        this.shoppingList = shoppingList;
        this.onItemRemoveListener = onItemRemoveListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shopping_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String item = shoppingList.get(position);
        holder.itemName.setText(item);
        holder.removeButton.setOnClickListener(v -> onItemRemoveListener.onItemRemove(position));
    }

    @Override
    public int getItemCount() {
        return shoppingList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView itemName;
        Button removeButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.itemName);
            removeButton = itemView.findViewById(R.id.removeButton);
        }
    }

    public interface OnItemRemoveListener {
        void onItemRemove(int position);
    }
}
