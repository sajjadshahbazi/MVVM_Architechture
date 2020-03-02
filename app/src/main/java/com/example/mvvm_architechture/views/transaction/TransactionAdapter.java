package com.example.mvvm_architechture.views.transaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mvvm_architechture.R;
import java.util.ArrayList;
import java.util.List;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.MyViewHolder> {

    private List<TransactionUIModel> transactionUi = new ArrayList<>();

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public ImageView avatarDestinationImg;
        public TextView unreadMessage;
        public TextView receiveAmount;
        public TextView sendAmount;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            avatarDestinationImg = (ImageView) view.findViewById(R.id.avatarDestinationImg);
//            year = (TextView) view.findViewById(R.id.year);
        }
    }


    public TransactionAdapter(List<TransactionUIModel> transactionUi) {
        this.transactionUi = transactionUi;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_transaction_view, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        TransactionUIModel trans = transactionUi.get(position);
        holder.name.setText(trans.getFirstName());
        Glide.with(holder.avatarDestinationImg).load(
                "https://banner2.cleanpng.com/20171128/5d2/gold-soccer-ball-png-clip-art-image-5a1d466b159ac0.0656563615118680110885.jpg"
        ).apply(new RequestOptions().circleCrop()).into(holder.avatarDestinationImg);

//        holder.genre.setText(movie.getGenre());
//        holder.year.setText(movie.getYear());
    }

    @Override
    public int getItemCount() {
        return transactionUi.size();
    }
}
