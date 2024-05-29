package com.example.ql_ban_do_an.Controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ql_ban_do_an.Model.Foods;
import com.example.ql_ban_do_an.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BestFoodsAdapter extends RecyclerView.Adapter<BestFoodsAdapter.viewholder> {
    ArrayList<Foods> items;
    Context context;

    public BestFoodsAdapter(ArrayList<Foods> items)
    {
        this.items = items;
    }

    @NonNull
    @Override
    public BestFoodsAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context=viewGroup.getContext();
        View inflate= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.viewholder_best_deal,viewGroup,false);

        return new viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull BestFoodsAdapter.viewholder viewholder, int i) {
        viewholder.titleTxt.setText(items.get(i).getTitle());
        viewholder.priceTxt.setText("$"+items.get(i).getPrice());
        viewholder.timeTxt.setText(items.get(i).getTimeValue()+"min");
        viewholder.starTxt.setText(""+items.get(i).getStar());
        Picasso.with(context).load(items.get(i).getImagePath()).into(viewholder.pic);


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class viewholder  extends RecyclerView.ViewHolder{
        TextView titleTxt,priceTxt,starTxt,timeTxt;
        ImageView pic;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            titleTxt=itemView.findViewById(R.id.titleTxt);
            priceTxt=itemView.findViewById(R.id.priceTxt);
            starTxt=itemView.findViewById(R.id.startTxt);
            timeTxt=itemView.findViewById(R.id.timeTxt);
            pic=itemView.findViewById(R.id.pic);
        }
    }
}
