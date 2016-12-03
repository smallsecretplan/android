package shan.splan.gs;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import shan.splan.R;
import shan.splan.databinding.ItemGovernmentResourcesBinding;
import shan.splan.utils.OnClickListener;

/**
 * Created by chrisweng on 2016/12/3.
 */

public class GovernmentResourcesAdapter extends RecyclerView.Adapter<GovernmentResourcesViewHolder> implements OnClickListener<GREnum> {

    private Context context;

    public GovernmentResourcesAdapter(Context context) {
        this.context = context;
    }

    @Override
    public GovernmentResourcesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemGovernmentResourcesBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_government_resources, parent, false);
        return new GovernmentResourcesViewHolder(binding, this);

    }

    @Override
    public void onBindViewHolder(GovernmentResourcesViewHolder holder, int position) {
        holder.bind(GREnum.values()[position]);
    }

    @Override
    public int getItemCount() {
        return GREnum.values().length;
    }


    @Override
    public void onClick(GREnum item) {
        if (item.equals(GREnum.b) || item.equals(GREnum.f)) {
            Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse(item.getUrl()));
            context.startActivity(browser);
        } else {
            Intent dial = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + item.getUrl()));
            context.startActivity(dial);
        }
    }
}
