package com.improve10x.crud.movies;

public interface OnItemActionClickListener {

    void onEdit(Movie movie);

    void onDelete(String id);
}
