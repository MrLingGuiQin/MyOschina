package oschina.ling.com.myoschina;

/**
 * ***************************************
 * statement: 枚举 设置tab栏目数据
 * auther: lingguiqin
 * date created : 2017/6/8 0008
 * ***************************************
 */

public enum MainTab {
    NEWS(0, R.string.main_tab_bar_news, R.drawable.tab_icon_new_selector, TabNewsFragment.class),
    TWEET(1, R.string.main_tab_bar_tweet, R.drawable.tab_icon_tweet_selector, TabTweetFragment.class),
    ADD(2, R.string.main_tab_bar_add, R.drawable.tab_icon_new_selector, TabAddFragment.class),
    EXPLORE(3, R.string.main_tab_bar_explore, R.drawable.tab_icon_explore_selector, TabExploreFragment.class),
    ME(4, R.string.main_tab_bar_me, R.drawable.tab_icon_me_selector, TabMeFragment.class);

    private int idx;
    private int resName;
    private int resIcon;
    private Class<?> clz;

    private MainTab(int idx, int resName, int resIcon, Class<?> clz) {
        this.idx = idx;
        this.resName = resName;
        this.resIcon = resIcon;
        this.clz = clz;
    }

    public int getIdx() {
        return idx;
    }

    public int getResName() {
        return resName;
    }

    public int getResIcon() {
        return resIcon;
    }

    public Class<?> getClz() {
        return clz;
    }


}
