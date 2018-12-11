package com.as.demo_ok7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.as.demo_ok7.adapter.MyAdapter;
import com.as.demo_ok7.shimmer_recyclerview.ShimmerRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ShimmerRecyclerView shimmerRecyclerView = findViewById(R.id.shimmer_recycler);
        shimmerRecyclerView.showShimmerAdapter();

        new Thread(){
            @Override
            public void run() {
                //模拟网络请求
                try {
                    Thread.sleep(2000);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            shimmerRecyclerView.hideShimmerAdapter();
                            List<String> list=new ArrayList<>();
                            for (int i = 0; i < 50; i++) {
                                list.add(i+"条目");
                            }
                            MyAdapter myAdapter = new MyAdapter(R.layout.item_layout, list);
                            shimmerRecyclerView.setAdapter(myAdapter);
                            shimmerRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false));
                        }
                    });

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();


    }
}
