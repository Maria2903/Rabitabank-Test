package com.rabitabank.test;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;



public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ChatViewHolder> {


    public static final int MSG_TYPE_LEFT = 1;
    public static final int MSG_TYPE_RIGHT = 0;
    private ArrayList<DataChat> messages;
    LayoutInflater inflater;




    public DataAdapter(Context context, ArrayList<DataChat> message) {
        this.messages = message;
        this.inflater = LayoutInflater.from(context);

    }

    @Override
    public final int getItemViewType(int position) {




        DataChat msg = messages.get(position);
        if(msg.getContent().isEmpty()) {

        }
        else{


            return MSG_TYPE_RIGHT;


        }
        return position;
    }


    @NotNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {

        switch (viewType) {
            case MSG_TYPE_RIGHT:
                View view = inflater.inflate(R.layout.item, parent, false);
                return new ChatViewHolder(view);
            case MSG_TYPE_LEFT:
                View v = inflater.inflate(R.layout.item_chat_left, parent, false);
                return new ChatViewHolder(v);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull final ChatViewHolder holder, final int position) {

        DataChat dataChat = messages.get(position);
        holder.tvMessage7.setText(dataChat.getContent());


        Picasso.get()
                .load(R.drawable.photo1)
                .transform(new CircularTransformation(0))
                .into(holder.iv_right);


        if(dataChat.getUrl() == null){
            return;
        }
        else {
            Picasso.get()
                    .load(dataChat.getUrl())
                    .into(holder.image_right);
        }

    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public int getCount() {
        return messages.size();
    }

    public void add(DataChat message) {
        messages.add(message);
        notifyItemInserted(messages.size() - 1);
        notifyDataSetChanged();
    }


    static class ChatViewHolder extends RecyclerView.ViewHolder {
        public TextView tvMessage7;
        public ImageView image_right, iv_right;


        public ChatViewHolder(View itemView) {
            super(itemView);
            this.tvMessage7 = (TextView) itemView.findViewById(R.id.tvMessage7);
            this.image_right = itemView.findViewById(R.id.image_right);
            this.iv_right = itemView.findViewById(R.id.iv_right);

        }
    }
}


















