package com.tt.android_ble.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tt.android_ble.ui.manager.INavigator;

import butterknife.ButterKnife;

/**
 * -------------------------------------------------
 * Description：
 * Author：TT
 * Since：2017/3/15
 * Version：V0.0.1
 * -------------------------------------------------
 * History：
 * V0.0.1 --
 * -------------------------------------------------
 */
public abstract class BaseFragment extends Fragment {

    INavigator navigator;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(container.getContext()).inflate(getLayoutId(), container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof INavigator) {
            navigator = (INavigator) context;
        } else {
            throw new RuntimeException(context.getClass().getSimpleName() + "must implement INavigator");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        navigator = null;
    }

    public abstract int getLayoutId();
}