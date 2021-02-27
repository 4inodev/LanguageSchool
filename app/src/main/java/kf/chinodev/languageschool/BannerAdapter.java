package kf.chinodev.languageschool;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class BannerAdapter extends PagerAdapter {
    private ArrayList<BannerItem> data;
    private Context context;
    private BannerListener listener;

    public BannerAdapter(ArrayList<BannerItem> data, Context context) {
        this.data = data;
        this.context = context;
    }

    public void setListener(BannerListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.vp_item_banner, container, false);
        TextView bannerText = view.findViewById(R.id.banner_text);
        ImageView bannerImage = view.findViewById(R.id.banner_image);

        BannerItem item = data.get(position);
        bannerText.setText(item.text);
        bannerImage.setImageResource(item.imageResId);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClicked(item);
            }
        });

        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        View view = (View) object;
        container.removeView(view);
    }

    public interface BannerListener {
        void onItemClicked(BannerItem item);
    }
}
