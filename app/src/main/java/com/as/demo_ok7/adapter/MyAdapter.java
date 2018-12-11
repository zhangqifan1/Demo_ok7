package com.as.demo_ok7.adapter;

import android.support.annotation.Nullable;

import com.as.demo_ok7.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * -----------------------------
 * Created by zqf on 2018/12/11.
 * ---------------------------
 */
public class MyAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public MyAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tvtitle, item);
    }

}
