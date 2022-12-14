package com.improve10x.crud.template;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Template implements Serializable {

    @SerializedName("_id")
    public String id;
    public String messageText;
}
