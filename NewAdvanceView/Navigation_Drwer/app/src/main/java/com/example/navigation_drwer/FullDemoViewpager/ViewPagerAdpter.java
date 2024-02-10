package com.example.navigation_drwer.FullDemoViewpager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.navigation_drwer.R;

public class ViewPagerAdpter extends PagerAdapter {

    Context context;

    public ViewPagerAdpter(Context context) {
        this.context = context;
    }

    int images[] = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4};
    int Headings[] = {R.string.heading_one, R.string.heading_two, R.string.heading_three, R.string.heading_fourth};

    int Discripation[] = {R.string.desc_one, R.string.desc_two, R.string.desc_three, R.string.desc_fourth};

    @Override
    public int getCount() {
        return Headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (LinearLayout) object;


    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slider_layout, container, false);
        ImageView sliderimages = (ImageView) view.findViewById(R.id.titileimage);
        TextView SLideHeading = (TextView) view.findViewById(R.id.txtTitile);
        TextView SlideDiscripation = (TextView) view.findViewById(R.id.textDescripation);

        sliderimages.setImageResource(images[position]);
        SLideHeading.setText(Headings[position]);
        SlideDiscripation.setText(Discripation[position]);

        container.addView(view);
        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
