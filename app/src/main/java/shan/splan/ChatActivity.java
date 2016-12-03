package shan.splan;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import shan.splan.chat.ChatAdapter;
import shan.splan.databinding.ActivityChatBinding;
import shan.splan.utils.ToolBarUtil;

/**
 * Created by chrisweng on 2016/12/3.
 */

public class ChatActivity extends AppCompatActivity {

    private ActivityChatBinding binding;
    private ChatAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_chat);
        ToolBarUtil.initDefaultBackToolbar(this, binding.toolBar, getString(R.string.activity_chat));
        binding.recycler.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ChatAdapter();
        binding.recycler.setAdapter(adapter);

        binding.send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.input.getText() != null) {
                    adapter.addMessage(binding.input.getText().toString());
                    binding.input.setText("");
                }
            }
        });
    }
}
