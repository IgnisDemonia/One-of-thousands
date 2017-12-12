package com.skobelsky.onemanagerofthousands.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.skobelsky.onemanagerofthousands.R;

/**
 * Created by Skobelsky on 10.12.2017.
 */

public class IdeasFragment extends TabFragment {
    public static final int LAYOUT = R.layout.fragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment, container, false);
        return view;
    }

    public static IdeasFragment getInstance(Context context) {
        Bundle arguments = new Bundle();
        IdeasFragment myFragment = new IdeasFragment();
        myFragment.setArguments(arguments);
        myFragment.setContext(context);
        myFragment.setTitle(context.getString(R.string.tab_ideas));

        return myFragment;
    }
}

