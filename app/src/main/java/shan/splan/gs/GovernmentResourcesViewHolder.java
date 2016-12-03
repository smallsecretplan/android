package shan.splan.gs;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import shan.splan.databinding.ItemGovernmentResourcesBinding;
import shan.splan.utils.OnClickListener;

/**
 * Created by chrisweng on 2016/12/3.
 */

public class GovernmentResourcesViewHolder extends RecyclerView.ViewHolder {

    private GREnum grEnum;
    private ItemGovernmentResourcesBinding binding;

    public GovernmentResourcesViewHolder(ItemGovernmentResourcesBinding binding, final OnClickListener<GREnum> onClickListener) {
        super(binding.getRoot());
        this.binding = binding;
        binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickListener.onClick(grEnum);
            }
        });
    }

    public void bind(GREnum grEnum) {
        this.grEnum = grEnum;
        binding.setGrEnum(grEnum);
    }

}
