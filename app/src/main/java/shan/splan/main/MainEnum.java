package shan.splan.main;

import android.app.Activity;

import shan.splan.ActionPlanActivity;
import shan.splan.ArticleListActivity;
import shan.splan.ChatListActivity;
import shan.splan.FriendHelpActivity;
import shan.splan.GovernmentResourcesActivity;
import shan.splan.R;
import shan.splan.StartSelfAssessmentActivity;

/**
 * Created by chrisweng on 2016/12/3.
 */
public enum MainEnum {

    SELF_ASSESSMENT(R.drawable.icon_main_01, StartSelfAssessmentActivity.class),
    ACTION_PLAN(R.drawable.icon_main_02, ActionPlanActivity.class),
    FRIENDS_HELP(R.drawable.icon_main_03, FriendHelpActivity.class),
    ARTICLES(R.drawable.icon_main_04, ArticleListActivity.class),
    ONLINE_CONSULTATION(R.drawable.icon_main_05, ChatListActivity.class),
    GOVERNMENT_RESOURCES(R.drawable.icon_main_06, GovernmentResourcesActivity.class);

    private int iconResId;
    private Class<? extends Activity> activity;

    MainEnum(int iconResId, Class<? extends Activity> activity) {
        this.iconResId = iconResId;
        this.activity = activity;
    }

    public Class<? extends Activity> getActivity() {
        return activity;
    }

    public int getIconRes() {
        return iconResId;
    }

}
