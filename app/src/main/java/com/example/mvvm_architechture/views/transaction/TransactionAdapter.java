package com.example.mvvm_architechture.views.transaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mvvm_architechture.R;
import com.example.mvvm_architechture.utils.ConcurrencyTools;
import com.example.mvvm_architechture.utils.TransactionType;
import java.util.ArrayList;
import java.util.List;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.MyViewHolder> {

    private List<TransactionUIModel> transactionUi = new ArrayList<>();

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public ImageView avatarDestinationImg;
        public TextView amountTv;
        public TextView unreadItemCountTv;
        public TextView timeTransactionTv;
        public TextView sendAmount;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            amountTv = (TextView) view.findViewById(R.id.amountTv);
            unreadItemCountTv = (TextView) view.findViewById(R.id.unreadItemCountTv);
            timeTransactionTv = (TextView) view.findViewById(R.id.timeTransactionTv);
            avatarDestinationImg = (ImageView) view.findViewById(R.id.avatarDestinationImg);
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
        if (trans.getType() == TransactionType.ReceiveMoney.getValue()){
            holder.name.setText(trans.getFirstName());
            Glide.with(holder.avatarDestinationImg).load(
                    "https://banner2.cleanpng.com/20171128/5d2/gold-soccer-ball-png-clip-art-image-5a1d466b159ac0.0656563615118680110885.jpg"
            ).apply(new RequestOptions().circleCrop()).into(holder.avatarDestinationImg);
            holder.amountTv.setText("+"+ConcurrencyTools.priceAnnotator(trans.getAmount().toString()));
            holder.amountTv.setTextColor(ContextCompat.getColor(
                    holder.amountTv.getContext(),
                    R.color.green_l1)
            );
        }else if (trans.getType() == TransactionType.SendMoney.getValue()){
            holder.name.setText(trans.getFirstName());
            Glide.with(holder.avatarDestinationImg).load(
                    "https://banner2.cleanpng.com/20171128/5d2/gold-soccer-ball-png-clip-art-image-5a1d466b159ac0.0656563615118680110885.jpg"
            ).apply(new RequestOptions().circleCrop()).into(holder.avatarDestinationImg);
            holder.amountTv.setText(ConcurrencyTools.priceAnnotator(trans.getAmount().toString()));
            holder.amountTv.setTextColor(ContextCompat.getColor(
                    holder.amountTv.getContext(),
                    R.color.grey_l1)
            );
        }else if (trans.getType() == TransactionType.CacheIn.getValue()){
            holder.name.setText("تراکنش های بانکی");
            holder.avatarDestinationImg.setImageDrawable(ContextCompat.getDrawable(
                    holder.amountTv.getContext(),
                    R.drawable.ic_bank_card)
            );
            holder.amountTv.setText("+"+ConcurrencyTools.priceAnnotator(trans.getAmount().toString()));
            holder.amountTv.setTextColor(ContextCompat.getColor(
                    holder.amountTv.getContext(),
                    R.color.green_l1)
            );
        }else if (trans.getType() == TransactionType.CacheOut.getValue()){
            holder.name.setText("تراکنش های بانکی");
            holder.avatarDestinationImg.setImageDrawable(ContextCompat.getDrawable(
                    holder.amountTv.getContext(),
                    R.drawable.ic_bank_card)
            );
            holder.amountTv.setText(ConcurrencyTools.priceAnnotator(trans.getAmount().toString()));
            holder.amountTv.setTextColor(ContextCompat.getColor(
                    holder.amountTv.getContext(),
                    R.color.grey_l1)
            );
        }
        if (trans.getUnreadChatCount()>0){
            holder.unreadItemCountTv.setVisibility(View.VISIBLE);
            holder.unreadItemCountTv.setText(trans.getUnreadChatCount());
        }else {
            holder.unreadItemCountTv.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return transactionUi.size();
    }
}
