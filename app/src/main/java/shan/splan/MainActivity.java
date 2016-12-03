package shan.splan;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import shan.splan.databinding.ActivityMainBinding;
import shan.splan.main.MainAdapter;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private RecyclerView recycler;
    private final static int SPAN_COUNT = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        recycler = binding.recycler;
        recycler.setLayoutManager(new GridLayoutManager(this, SPAN_COUNT));
        recycler.setAdapter(new MainAdapter(this));
    }
}
