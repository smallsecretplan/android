package shan.splan;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import shan.splan.databinding.ActivityActionPlanBinding;
import shan.splan.utils.ToolBarUtil;

/**
 * Created by chrisweng on 2016/12/3.
 */

public class ActionPlanActivity extends AppCompatActivity {

    private ActivityActionPlanBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_action_plan);
        ToolBarUtil.initDefaultBackToolbar(this, binding.toolBar, getString(R.string.activity_action_plan));
    }
}
