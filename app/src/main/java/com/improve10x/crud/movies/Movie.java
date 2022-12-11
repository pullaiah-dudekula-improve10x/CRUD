package com.improve10x.crud.movies;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Movie implements Serializable {
    @SerializedName("_id")
    public String id;
    public String description;
    public String imageUrl;
    public String movieId;
    public String name;
    public String seriesId;
}
