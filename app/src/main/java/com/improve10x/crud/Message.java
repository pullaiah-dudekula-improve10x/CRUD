package com.improve10x.crud;

import com.google.gson.annotations.SerializedName;

public class Message {
    @SerializedName("_id")
    public String id;
    public String name;
    public String phoneNumber;
    public String messageText;
}
