package com.example.finalexamcpsu2016.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.finalexamcpsu2016.R;
import com.example.finalexamcpsu2016.model.user;

import java.util.ArrayList;

/**
 * Created by tmbeamm on 12/18/2016 AD.
 */

public class userListAdapter extends ArrayAdapter<user> {

    private Context mContext;
    private int mLayoutResId;
    private ArrayList<user> mList;

    public userListAdapter(Context context, int resource,ArrayList<user> user) {
        super(context, resource,user);

        this.mContext = context;
        this.mLayoutResId = resource;
        this.mList = user;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View itemLayout = convertView;

        if (itemLayout == null) {
            itemLayout = View.inflate(mContext, mLayoutResId, null);
        }

        ImageView imageView = (ImageView) itemLayout.findViewById(R.id.image);
        TextView nameTextView = (TextView) itemLayout.findViewById(R.id.name);


        user oUser = mList.get(position);

        String name = oUser.getmName();
        nameTextView.setText(name);


        String image = oUser.getmImage();


        return itemLayout;
    }
}
