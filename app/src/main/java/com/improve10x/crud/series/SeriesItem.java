package com.improve10x.crud.series;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
public class SeriesItem implements Serializable {

    @SerializedName("_id")
    public String id;
    @SerializedName("id")
    public String seriesId;
    public String imageUrl;
    public String title;
}
