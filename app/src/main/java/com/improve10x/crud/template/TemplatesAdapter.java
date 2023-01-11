package com.improve10x.crud.template;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.crud.R;
import com.improve10x.crud.databinding.TemplatesItemBinding;

import java.util.List;

public class TemplatesAdapter extends RecyclerView.Adapter<TemplatesViewHolder> {

    private List<Template> templates;
    private OnItemActionClickListener onItemActionClickListener;

    public void setData(List<Template>templateList) {
        templates = templateList;
        notifyDataSetChanged();
    }

    public void setOnItemActionClickListener(OnItemActionClickListener actionClickListener) {
        onItemActionClickListener = actionClickListener;
    }

    @NonNull
    @Override
    public TemplatesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TemplatesItemBinding binding = TemplatesItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        TemplatesViewHolder templatesViewHolder = new TemplatesViewHolder(binding);
        return templatesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TemplatesViewHolder holder, int position) {
        Template template = templates.get(position);
        holder.binding.setTemplate(template);
        holder.binding.deleteBtn.setOnClickListener(view -> {
            onItemActionClickListener.onDelete(template.id);
        });
        holder.itemView.setOnClickListener(view -> {
            onItemActionClickListener.onEdit(template);
        });
    }

    @Override
    public int getItemCount() {
        return templates.size();
    }
}
