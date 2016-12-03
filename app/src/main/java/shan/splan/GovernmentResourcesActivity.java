package shan.splan;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;

import shan.splan.databinding.ActivityGovernmentResourcesBinding;
import shan.splan.gs.GovernmentResourcesAdapter;
import shan.splan.utils.ToolBarUtil;

/**
 * Created by chrisweng on 2016/12/3.
 */

public class GovernmentResourcesActivity extends AppCompatActivity {

    private ActivityGovernmentResourcesBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_government_resources);
        ToolBarUtil.initDefaultBackToolbar(this, binding.toolBar, getString(R.string.activity_government_resources));
        binding.recycler.setLayoutManager(new LinearLayoutManager(this));
        binding.recycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        binding.recycler.setAdapter(new GovernmentResourcesAdapter(this));
    }

}
