package com.example.learn_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import com.example.learn_recyclerview.adapter.RecyclerViewAdapter;
import com.example.learn_recyclerview.databean.DataBean;
import com.example.learn_recyclerview.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    //模拟数据
    ArrayList<DataBean> data = new ArrayList<>();
    String[] text = {"花卉1", "花卉2", "花卉3", "花卉4"};
    int[] src = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setRecyclerView();
    }

    //封装数据，并为RecyclerView设置适配器
    private void setRecyclerView() {
        for (int i = 0; i < text.length; i++) {
            DataBean dataBean = new DataBean();
            dataBean.setSrc(src[i]);
            dataBean.setText(text[i]);
            data.add(dataBean);
        }


        // 创建StaggeredGridLayoutManager实例，实现瀑布流效果
        //StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        // 绑定布局管理器
        //binding.recyclerView.setLayoutManager(layoutManager);

        // 创建LinearLayoutManager实例，实现ListView效果
        LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this);
        //设置RecyclerView布局的排列方向
//         manager.setOrientation(RecyclerView.HORIZONTAL);
        binding.recyclerView.setLayoutManager(manager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(MainActivity.this,data);
        binding.recyclerView.setAdapter(adapter);
    }
}