package shan.splan.chat;

import android.support.v7.widget.RecyclerView;

import shan.splan.databinding.ItemChatOtherBinding;

/**
 * Created by chrisweng on 2016/12/3.
 */

public class ChatOtherViewHolder extends RecyclerView.ViewHolder {

    private ItemChatOtherBinding binding;

    public ChatOtherViewHolder(ItemChatOtherBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind() {
        binding.text.setText("您好，有什麼需要協助的嗎？");
    }


}
