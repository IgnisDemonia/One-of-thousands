package com.skobelsky.onemanagerofthousands.fragment;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Skobelsky on 10.12.2017.
 */

public abstract class TabFragment extends Fragment{
    Context context;
    String title;
    View view;

    public void setContext(Context context) {
        this.context = context;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState);
}
