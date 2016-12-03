package shan.splan;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import shan.splan.databinding.ActivityChatListBinding;
import shan.splan.utils.ToolBarUtil;

/**
 * Created by chrisweng on 2016/12/3.
 */

public class ChatListActivity extends AppCompatActivity {

    private ActivityChatListBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_chat_list);
        ToolBarUtil.initDefaultBackToolbar(this, binding.toolBar, getString(R.string.activity_chat));
        binding.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChatListActivity.this, ChatActivity.class));
            }
        });
    }
}
