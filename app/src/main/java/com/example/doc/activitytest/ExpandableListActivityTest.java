package com.example.doc.activitytest;

import android.app.ExpandableListActivity;
import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ExpandableListActivityTest extends ExpandableListActivity {

    private int[] logs = {
            R.mipmap.face_1,
            R.mipmap.face_2,
            R.mipmap.face_3
    };
    private String[] armTypes =
            {
                    "神族兵种",
                    "虫族兵种",
                    "人族兵种"
            };
    private String[][] arms=
            {
                    {
                            "狂战士","龙骑士",
                            "暗黑圣堂", "电兵"
                    },
                    {
                            "小狗","刺蛇",
                            "飞龙", "自爆飞机"
                    },
                    {
                            "机枪兵","护士", "幽灵"
                    }
            };
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ExpandableListAdapter adapter =
                new BaseExpandableListAdapter() {
                    @Override
                    public int getGroupCount() {
                        return armTypes.length;
                    }

                    @Override
                    public int getChildrenCount(int groupPosition) {
                        return arms[groupPosition].length;
                    }

                    @Override
                    public Object getGroup(int groupPosition) {
                        return armTypes[groupPosition];
                    }

                    @Override
                    public Object getChild(int groupPosition, int childPosition) {
                        return arms[groupPosition][childPosition];
                    }

                    @Override
                    public long getGroupId(int groupPosition) {
                        return groupPosition;
                    }

                    @Override
                    public long getChildId(int groupPosition, int childPosition) {
                        return childPosition;
                    }

                    @Override
                    public boolean hasStableIds() {
                        return true;
                    }

                    @Override
                    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
                        LinearLayout linear = new LinearLayout(ExpandableListActivityTest.this);
                        linear.setOrientation(LinearLayout.HORIZONTAL);
                        ImageView logo = new ImageView(ExpandableListActivityTest.this);
                        logo.setImageResource(logs[groupPosition]);
                        linear.addView(logo);
                        TextView textView = getTextView();
                        textView.setText(getGroup(groupPosition).toString());
                        return linear;
                    }

                    @Override
                    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
                        TextView textView = getTextView();
                        textView.setText(getChild(groupPosition,childPosition).toString());
                        return textView;
                    }

                    @Override
                    public boolean isChildSelectable(int groupPosition, int childPosition) {
                        return true;
                    }
                };
        setListAdapter(adapter);
    }

    public TextView getTextView() {
        AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                64
        );
        TextView textView = new TextView(ExpandableListActivityTest.this);
        textView.setLayoutParams(lp);
        textView.setPadding(36, 0, 0, 0);
        textView.setTextSize(20);

        return textView;
    }

}
