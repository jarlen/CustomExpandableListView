package com.example.expandablelistview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.Toast;

public class TestActivity extends Activity {

	private ExpandableListView mExpandableListView;

	private String[] group = { "更新", "关于" };

	private String[][] childInfo = { { "自动更新应用管家", "自动更新已安装应用" }, { "关于" } };

	private CustomAdapter mCustomAdapter = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_main);
		mExpandableListView = (ExpandableListView) findViewById(R.id.expandableListView);

		mCustomAdapter = new CustomAdapter(this, group, childInfo);
		mExpandableListView.setAdapter(mCustomAdapter);
		
		mExpandableListView.setGroupIndicator(null);
		mExpandableListView.setClipChildren(true);

		mExpandableListView.setOnGroupClickListener(new OnGroupClickListener() {

			@Override
			public boolean onGroupClick(ExpandableListView arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				return true;
			}
		});

		mExpandableListView.setOnChildClickListener(new OnChildClickListener() {

			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {
				// TODO Auto-generated method stub

				Toast.makeText(
						TestActivity.this,
						"你点击了"
								+ mCustomAdapter.getChild(groupPosition,
										childPosition), Toast.LENGTH_SHORT)
						.show();
				return false;
			}
		});

		int groupCount = mExpandableListView.getCount();
		for (int i = 0; i < groupCount; i++) {
			mExpandableListView.expandGroup(i);
		}
	}
}
