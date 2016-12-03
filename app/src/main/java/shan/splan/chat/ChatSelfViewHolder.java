package shan.splan.chat;

import android.support.v7.widget.RecyclerView;

import shan.splan.databinding.ItemChatSelfBinding;

/**
 * Created by chrisweng on 2016/12/3.
 */

public class ChatSelfViewHolder extends RecyclerView.ViewHolder {

    private ItemChatSelfBinding binding;

    public ChatSelfViewHolder(ItemChatSelfBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(String text) {
        binding.text.setText(text);
    }


}
