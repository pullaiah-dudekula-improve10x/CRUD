package com.improve10x.crud.messages;

import com.improve10x.crud.messages.Message;

public interface onItemActionClickListener {
     void onDelete(String id);
     void onEdit(Message message);
}
