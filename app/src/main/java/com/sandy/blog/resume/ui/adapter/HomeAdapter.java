package com.sandy.blog.resume.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sandy.blog.resume.R;
import com.sandy.blog.resume.model.HomeModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Sandy Luo on 2017/1/27.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeHolder> {


    private Context mContext;

    private List<HomeModel> mData;


    public HomeAdapter(Context context, List<HomeModel> mData) {
        this.mContext = context;
        this.mData = mData;
    }

    @Override
    public HomeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_content_item, null);
        return new HomeHolder(view);
    }

    @Override
    public void onBindViewHolder(HomeHolder holder, int position) {
        Drawable drawable = mContext.getResources().getDrawable(mData.get(position).getImageRes());
        DrawableCompat.setTint(drawable, mContext.getResources().getColor(R.color.nav_end_color));
        holder.mHomeItemName.setText(mData.get(position).getItemTag());
        holder.mHomeItemIcon.setImageDrawable(drawable);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    class HomeHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.home_item_icon)
        ImageView mHomeItemIcon;
        @BindView(R.id.home_item_name)
        TextView mHomeItemName;
        @BindView(R.id.root_view)
        CardView mRootView;


        public HomeHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.root_view)
        public void onClick() {
            if (onItemClickListener != null) {
                onItemClickListener.clickItem(getAdapterPosition());
            }
        }
    }


    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    /**
     * 条目点击的监听
     */
    public interface OnItemClickListener {

        /**
         * 条目点击事件
         */
        void clickItem(int position);
    }
}
