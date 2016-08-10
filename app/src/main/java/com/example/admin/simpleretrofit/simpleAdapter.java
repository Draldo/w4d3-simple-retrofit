package com.example.admin.simpleretrofit;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by admin on 8/10/2016.
 */
public class simpleAdapter extends RecyclerView.Adapter<simpleAdapter.ViewHolder> {

    private static final String TAG = simpleAdapter.class.getSimpleName() + "TAG_";
    private ArrayList<String> mArrayStr;
    private Context mContext;

    public simpleAdapter(Context context, ArrayList<String> strings) {
        mContext = context;
        mArrayStr = strings;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder  {

        public TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.list_text);
        }
    }

    @Override
    public simpleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(simpleAdapter.ViewHolder holder, int position) {
        String str = mArrayStr.get(position);

        TextView textView = holder.textView;
        textView.setText(str);
    }

    @Override
    public int getItemCount() {
        return mArrayStr == null ? 0 : mArrayStr.size();
    }

}
