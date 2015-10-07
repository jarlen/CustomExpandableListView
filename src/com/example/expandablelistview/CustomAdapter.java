package com.example.expandablelistview;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class CustomAdapter extends BaseExpandableListAdapter {

	private LayoutInflater mLayoutInflater = null;
	private Context mContext = null;

	private String[] groupList = null;
	private String[][] infoList = null;

	public CustomAdapter(Context context, String[] group, String[][] info) {
		this.mContext = context;
		this.mLayoutInflater = LayoutInflater.from(context);
		this.groupList = group;
		this.infoList = info;
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return infoList[groupPosition][childPosition];
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return childPosition;
	}

	@Override
	public View getChildView(final int groupPosition, final int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub

		String child = (String) getChild(groupPosition, childPosition);

		if (convertView == null) {
			convertView = mLayoutInflater.inflate(R.layout.test_child, null);
		}

		TextView tv = (TextView) convertView.findViewById(R.id.test_child_item);
		tv.setText(child);

		if (childPosition == getChildrenCount(groupPosition) - 1 && groupPosition != getGroupCount() - 1) {
			convertView.findViewById(R.id.child_line).setVisibility(View.GONE);
		}
		else{
			convertView.findViewById(R.id.child_line).setVisibility(View.VISIBLE);
		}

		convertView.findViewById(R.id.test).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						Toast.makeText(mContext, "µã»÷ÁË°´Å¥", Toast.LENGTH_SHORT)
								.show();
					}
				});

		return convertView;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		// TODO Auto-generated method stub
		return infoList[groupPosition].length;
	}

	@Override
	public Object getGroup(int arg0) {
		// TODO Auto-generated method stub
		return groupList[arg0];
	}

	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return groupList.length;
	}

	@Override
	public long getGroupId(int groupPosition) {
		// TODO Auto-generated method stub
		return groupPosition;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		String group = (String) getGroup(groupPosition);

		if (convertView == null) {
			convertView = mLayoutInflater.inflate(R.layout.test_group, null);
		}

		TextView tv = (TextView) convertView.findViewById(R.id.test_group_name);
		tv.setText(group);

		return convertView;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isChildSelectable(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return true;
	}

}
