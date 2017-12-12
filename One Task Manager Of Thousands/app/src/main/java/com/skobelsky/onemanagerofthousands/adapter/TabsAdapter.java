package com.skobelsky.onemanagerofthousands.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.skobelsky.onemanagerofthousands.dto.RememberDTO;
import com.skobelsky.onemanagerofthousands.fragment.HistoryFragment;
import com.skobelsky.onemanagerofthousands.fragment.IdeasFragment;
import com.skobelsky.onemanagerofthousands.fragment.NotesFragment;
import com.skobelsky.onemanagerofthousands.fragment.TabFragment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Skobelsky on 08.12.2017.
 */

public class TabsFragmentAdapter extends FragmentPagerAdapter {

    private Map<Integer, TabFragment> tabs;
    private Context context;

    private List<RememberDTO> data;

    private HistoryFragment historyFragment;

    public TabsFragmentAdapter(Context context, FragmentManager fm, List<RememberDTO> data) {
        super(fm);
        this.data = data;
        this.context = context;
        initTabsMap(context);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position).getTitle();
    }

    @Override
    public Fragment getItem(int position) {
        return tabs.get(position);
    }

    @Override
    public int getCount() {
        return tabs.size();
    }

    private void initTabsMap(Context context) {
        tabs = new HashMap<>();
        historyFragment = HistoryFragment.getInstance(context, data);
        tabs.put(0, historyFragment);
        tabs.put(1, IdeasFragment.getInstance(context));
        tabs.put(2, NotesFragment.getInstance(context));
    }

    public void setData(List<RememberDTO> data) {
        this.data = data;
        historyFragment.refreshList(data);
    }
}
