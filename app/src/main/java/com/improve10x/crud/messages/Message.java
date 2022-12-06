package com.improve10x.crud.messages;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Message implements Serializable {
    @SerializedName("_id")
    public String id;
    public String name;
    public String phoneNumber;
    public String messageText;
}
