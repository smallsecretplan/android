package shan.splan.utils;

import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import shan.splan.R;

/**
 * Created by chrisweng on 2016/12/3.
 */


public class ToolBarUtil {

    public enum ContainerHeightParams {
        WRAP_CONTENT, MATCH_PARENT
    }

    public static View appendToolBarFromView(Context context,
                                             ContainerHeightParams params,
                                             int layoutResID) {
        return addChildView(context, params, LayoutInflater.from(context).inflate(layoutResID, null));
    }

    public static View appendToolBarFromView(Context context,
                                             ContainerHeightParams params,
                                             View childContentView) {
        if (childContentView == null) {
            return getBaseToolBarView(context, ContainerHeightParams.MATCH_PARENT);
        }
        return addChildView(context, params, childContentView);
    }

    private static View addChildView(Context context,
                                     ContainerHeightParams params,
                                     View childContentView) {
        ViewGroup toolbarViewGroup = getBaseToolBarView(context, params);
        FrameLayout container = (FrameLayout) toolbarViewGroup.findViewById(R.id.container);
        ViewGroup.LayoutParams layoutParams;
        if (params == ContainerHeightParams.WRAP_CONTENT) {
            layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
        } else {
            layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT);
        }
        container.addView(childContentView, layoutParams);
        return toolbarViewGroup;
    }

    public static ViewGroup getBaseToolBarView(Context context, ContainerHeightParams params) {
        ViewGroup toolbarViewGroup = (ViewGroup) LayoutInflater.from(context)
                .inflate(R.layout.activity_base_toolbar, null, false);
        FrameLayout container = (FrameLayout) toolbarViewGroup.findViewById(R.id.container);
        if (params == ContainerHeightParams.WRAP_CONTENT) {
            container.getLayoutParams().height = ViewGroup.LayoutParams.WRAP_CONTENT;
        } else {
            container.getLayoutParams().height = ViewGroup.LayoutParams.MATCH_PARENT;
        }
        return toolbarViewGroup;
    }

    public static void initDefaultBackToolbar(AppCompatActivity activity, Toolbar toolbar) {
        initDefaultBackToolbar(activity, toolbar, null);
    }

    public static void initDefaultBackToolbar(final AppCompatActivity activity,
                                              Toolbar toolbar,
                                              String title) {
        activity.setSupportActionBar(toolbar);
        ActionBar actionBar = activity.getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            if (title != null) {
                actionBar.setDisplayShowTitleEnabled(true);
                actionBar.setTitle(title);
                actionBar.setDisplayOptions(ActionBar.DISPLAY_HOME_AS_UP | ActionBar.DISPLAY_SHOW_TITLE);
            } else {
                actionBar.setDisplayShowTitleEnabled(false);
                actionBar.setDisplayOptions(ActionBar.DISPLAY_HOME_AS_UP);
            }

            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    activity.onBackPressed();
                }
            });
        }
    }
}
