package shan.splan;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import shan.splan.databinding.ActivityStartSelfAssessmentBinding;
import shan.splan.utils.ToolBarUtil;

/**
 * Created by chrisweng on 2016/12/3.
 */

public class StartSelfAssessmentActivity extends AppCompatActivity {

    private ActivityStartSelfAssessmentBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_start_self_assessment);
        ToolBarUtil.initDefaultBackToolbar(this, binding.toolBar, getString(R.string.activity_start_self_assessment));
        binding.start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartSelfAssessmentActivity.this, SelfAssessmentActivity.class);
                intent.putExtra("question_number", 0);
                intent.putExtra("first", true);
                startActivity(intent);
            }
        });
    }
}
