package com.mvpvolley;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.AdapterViewHolder> {


    Context context;
    private final List<Pojo2> list;

    public AdapterRecycler(Context context, List<Pojo2> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_holder,null);

        AdapterViewHolder holder = new AdapterViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder holder, int position) {

     Pojo2 item = list.get(position);

   //  holder.textView.setText(item.getContacts().get(position).getName());
     holder.textView.setText(item.getName());

//        Picasso.get().load(list.get(position)
//                     .getThumbnailUrl())
//                     .into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class AdapterViewHolder extends RecyclerView.ViewHolder{


        TextView textView;
        ImageView imageView;


        public AdapterViewHolder(View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.text);
            imageView = itemView.findViewById(R.id.image);
        }
    }
}
