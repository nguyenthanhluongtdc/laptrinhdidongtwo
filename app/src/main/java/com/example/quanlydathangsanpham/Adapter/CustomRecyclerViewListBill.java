package com.example.quanlydathangsanpham.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlydathangsanpham.Model.CardViewModel;
import com.example.quanlydathangsanpham.R;

import java.util.ArrayList;
import java.util.List;

public class CustomRecyclerViewListBill extends RecyclerView.Adapter<CustomRecyclerViewListBill.ViewHolder> {

    private ArrayList<CardViewModel> cardViewModels;

    public CustomRecyclerViewListBill(ArrayList<CardViewModel> cardViewModels) {
        this.cardViewModels = cardViewModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recyclerview,viewGroup,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int resource = cardViewModels.get(position).getImgBill();

        String cCodeBill = cardViewModels.get(position).getcCodeBill();
        String cCodeTotalMoney = cardViewModels.get(position).getcTotalBill();
        holder.setData(resource,cCodeBill,cCodeTotalMoney);
    }

    @Override
    public int getItemCount() {
        return cardViewModels.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgBill;
        private TextView tvrcvCodeBill;
        private  TextView tvrcvTotalMoney;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgBill = itemView.findViewById(R.id.imgBill);
            tvrcvCodeBill = itemView.findViewById(R.id.tvRcvCodeBill);
            tvrcvTotalMoney = itemView.findViewById(R.id.tvRcvTotalMoney);
        }

        private void setData(int imageResource, String titleCodeBill, String titleTotalMoney){
            imgBill.setImageResource(imageResource);
            tvrcvCodeBill.setText(titleCodeBill);
            tvrcvTotalMoney.setText(titleTotalMoney);
        }
    }
}
