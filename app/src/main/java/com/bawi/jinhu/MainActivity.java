package com.bawi.jinhu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bawi.jinhu.adapter.RvAdapter_01;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler_view_main;
    private List<String> mList;
    private RvAdapter_01 mAdapter_01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initRV();
        setListener();
    }

    private void setListener() {
        mAdapter_01.setmOnItemClickListener(new RvAdapter_01.OnItemClickListener() {
            @Override
            public void onItemClick(String name, int position) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });
    }

    private void initRV() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recycler_view_main.setLayoutManager(layoutManager);
        mAdapter_01 = new RvAdapter_01(mList, this);
        recycler_view_main.setAdapter(mAdapter_01);
    }

    private void initData() {
        mList = new ArrayList<>();
        mList.add("北京");
        mList.add("上海");
        mList.add("南京");
        mList.add("武汉");
    }

    private void initView() {
        recycler_view_main = (RecyclerView) findViewById(R.id.recycler_view_main);
    }
}
