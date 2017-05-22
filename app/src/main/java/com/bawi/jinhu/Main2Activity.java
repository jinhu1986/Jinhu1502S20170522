package com.bawi.jinhu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.bawi.jinhu.adapter.RvAdapter_02;

import java.util.ArrayList;
import java.util.HashMap;

public class Main2Activity extends AppCompatActivity {

    private TextView tv_name;
    private RecyclerView recycler_view_02;
    private ArrayList<HashMap<String, String>> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        initData();
        initRV();
    }

    private void initRV() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recycler_view_02.setLayoutManager(layoutManager);
        RvAdapter_02 adapter_02 = new RvAdapter_02(mList, this);
        recycler_view_02.setAdapter(adapter_02);
    }

    private void initData() {
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        tv_name.setText(name);

        mList = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            HashMap<String, String> map = new HashMap();
            map.put("image", "");
            map.put("duoyun", "多云");
            map.put("wendu", "2-15度");
            map.put("riqi", "2-1" + i);
            mList.add(map);
        }
    }

    private void initView() {
        tv_name = (TextView) findViewById(R.id.tv_name);
        recycler_view_02 = (RecyclerView) findViewById(R.id.recycler_view_02);
    }
}
