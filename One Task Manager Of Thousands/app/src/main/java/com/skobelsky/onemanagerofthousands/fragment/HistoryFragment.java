package com.skobelsky.onemanagerofthousands.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.skobelsky.onemanagerofthousands.R;
import com.skobelsky.onemanagerofthousands.adapter.RememberListAdapter;
import com.skobelsky.onemanagerofthousands.dto.RememberDTO;

import java.util.List;

/**
 * Created by Skobelsky on 10.12.2017.
 */

public class HistoryFragment extends TabFragment {
    private static final int LAYOUT = R.layout.fragment_history;

    private List<RememberDTO> data;

    private RememberListAdapter adapter;

    public static HistoryFragment getInstance(Context context, List<RememberDTO> data) {
        Bundle args = new Bundle();
        HistoryFragment fragment = new HistoryFragment();
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setData(data);
        fragment.setTitle(context.getString(R.string.tab_history));

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);

        RecyclerView rv = (RecyclerView) view.findViewById(R.id.recycleView);
        rv.setLayoutManager(new LinearLayoutManager(context));

        adapter = new RememberListAdapter(data);
        rv.setAdapter(adapter);

        return view;
    }

    public void refreshList(List<RememberDTO> data) {
        adapter.setData(data);
        adapter.notifyDataSetChanged();
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setData(List<RememberDTO> data) {
        this.data = data;
    }
}
