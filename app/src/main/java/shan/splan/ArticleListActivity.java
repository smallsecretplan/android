package shan.splan;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import shan.splan.databinding.ActivityArticleListBinding;
import shan.splan.utils.ToolBarUtil;

/**
 * Created by chrisweng on 2016/12/3.
 */

public class ArticleListActivity extends AppCompatActivity {

    private ActivityArticleListBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_article_list);
        ToolBarUtil.initDefaultBackToolbar(this, binding.toolBar, getString(R.string.activity_article_list));
    }
}
