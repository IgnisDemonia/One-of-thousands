package com.skobelsky.onemanagerofthousands.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.skobelsky.onemanagerofthousands.R;
import com.skobelsky.onemanagerofthousands.dto.RememberDTO;

import java.util.List;

/**
 * Created by Skobelsky on 10.12.2017.
 */

public class RememberListAdapter extends RecyclerView.Adapter<RememberListAdapter.RememberViewHolder>{

    List<RememberDTO> data;
    RememberListAdapter(List<RememberDTO> data) {
        this.data = data;
    }

    @Override
    public RememberViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.remember_item, parent, false);

        return  new RememberViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RememberViewHolder holder, int position) {
        holder.title.setText(data.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class RememberViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView title;

        RememberViewHolder(View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.card_view);
            title = itemView.findViewById(R.id.title);
        }
    }
}
