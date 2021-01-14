package com.example.testproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class postAdapter extends RecyclerView.Adapter<postAdapter.myViewHolder> {

    Context mContext;
    List<post> myPost;

    public postAdapter(Context mContext, List<post> myPost) {
        this.mContext = mContext;
        this.myPost = myPost;
    }

    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        post posts = myPost.get(position);
        holder.textView1.setText(String.valueOf(posts.getId()));
        holder.textView2.setText(String.valueOf(posts.getPostId()));
        holder.textView3.setText(posts.getBody());
        holder.textView4.setText(posts.getEmails());
        holder.textView5.setText(posts.getNames());
    }

    @Override
    public int getItemCount() {
        return myPost.size();
    }

    public static class myViewHolder extends RecyclerView.ViewHolder {
        TextView textView1, textView2, textView3, textView4,textView5;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            textView1 = itemView.findViewById(R.id.text1);
            textView2 = itemView.findViewById(R.id.text2);
            textView3 = itemView.findViewById(R.id.text3);
            textView4 = itemView.findViewById(R.id.text4);
            textView5 = itemView.findViewById(R.id.text5);

        }
    }
}
