package com.improve10x.crud.template;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.crud.R;
import com.improve10x.crud.databinding.TemplatesItemBinding;

public class TemplatesViewHolder extends RecyclerView.ViewHolder {

    TemplatesItemBinding binding;

    public TemplatesViewHolder(TemplatesItemBinding templatesItemBinding) {
        super(templatesItemBinding.getRoot());
        binding = templatesItemBinding;
    }
}
