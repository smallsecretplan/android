package shan.splan.main;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import shan.splan.R;
import shan.splan.databinding.ItemMainBinding;
import shan.splan.utils.OnClickListener;

/**
 * Created by chrisweng on 2016/12/3.
 */

public class MainAdapter extends RecyclerView.Adapter<MainViewHolder> implements OnClickListener<MainEnum> {

    private Context context;

    public MainAdapter(Context context) {
        this.context = context;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemMainBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_main, parent, false);
        return new MainViewHolder(binding, this);
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        holder.bind(MainEnum.values()[position]);
    }

    @Override
    public int getItemCount() {
        return MainEnum.values().length;
    }

    @Override
    public void onClick(MainEnum item) {
        context.startActivity(new Intent(context, item.getActivity()));
    }
}
