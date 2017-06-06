package com.kaist.antr.firebasechatapp2.messages;


import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.kaist.antr.firebasechatapp2.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MessageListAdapter extends ArrayAdapter<ChatMessage> {
    private ArrayList<ChatMessage> messages;
    Context context;

    public MessageListAdapter(ArrayList<ChatMessage> messages, Context context) {
        super(context, R.layout.message, messages);
        this.messages = messages;
        this.context=context;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.message, null);
        }

        ChatMessage model = getItem(position);
        TextView messageText = (TextView) convertView.findViewById(R.id.message_text);
        TextView messageUser = (TextView) convertView.findViewById(R.id.message_user);
        TextView messageTime = (TextView) convertView.findViewById(R.id.message_time);
        messageText.setText(model.getMessageText());
        messageUser.setText(model.getMessageUser());
        messageTime.setText(new SimpleDateFormat("dd-MM-yyyy (HH:mm:ss)").format(new Date(model.getMessageTime())));

        return convertView;
    }
}