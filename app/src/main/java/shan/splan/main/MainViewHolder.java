package shan.splan.main;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import shan.splan.databinding.ItemMainBinding;
import shan.splan.utils.OnClickListener;

/**
 * Created by chrisweng on 2016/12/3.
 */

public class MainViewHolder extends RecyclerView.ViewHolder {

    private MainEnum mainEnum;
    private ItemMainBinding binding;

    public MainViewHolder(ItemMainBinding binding, final OnClickListener<MainEnum> onClickListener) {
        super(binding.getRoot());
        this.binding = binding;
        binding.icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickListener.onClick(mainEnum);
            }
        });
    }

    public void bind(MainEnum mainEnum) {
        this.mainEnum = mainEnum;
        binding.icon.setImageResource(mainEnum.getIconRes());
    }

}
