package shan.splan.chat;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import shan.splan.R;
import shan.splan.databinding.ItemChatOtherBinding;
import shan.splan.databinding.ItemChatSelfBinding;

/**
 * Created by chrisweng on 2016/12/3.
 */

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private enum ChatType {
        SELF, OTHER
    }

    private List<String> messages = new ArrayList<>();

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (viewType == ChatType.OTHER.ordinal()) {
            ItemChatOtherBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_chat_other, parent, false);
            return new ChatOtherViewHolder(binding);
        }

        ItemChatSelfBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_chat_self, parent, false);
        return new ChatSelfViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ChatOtherViewHolder) {
            ((ChatOtherViewHolder) holder).bind();
        } else if (holder instanceof ChatSelfViewHolder) {
            ((ChatSelfViewHolder) holder).bind(messages.get(position - 1));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return ChatType.OTHER.ordinal();
        }
        return ChatType.SELF.ordinal();
    }

    @Override
    public int getItemCount() {
        return messages.size() + 1;
    }

    public void addMessage(String message) {
        messages.add(message);
        notifyItemInserted(messages.size() + 1);
    }

}
