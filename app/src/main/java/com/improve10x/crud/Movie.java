package com.improve10x.crud;

import com.google.gson.annotations.SerializedName;

public class Movie {
    @SerializedName("_id")
    private String id;
    public String description;
    public String imageUrl;
    public String movieId;
    public String name;
    public String seriesId;
}
