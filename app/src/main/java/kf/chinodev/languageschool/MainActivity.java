package kf.chinodev.languageschool;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ViewPager newsBanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init views
        ConstraintLayout courses = findViewById(R.id.service_courses);
        ConstraintLayout talking = findViewById(R.id.service_talking);
        ConstraintLayout camp = findViewById(R.id.service_camp);
        ConstraintLayout toefl = findViewById(R.id.service_toefl);
        newsBanner = findViewById(R.id.news_banner);
        TextView callTextView = findViewById(R.id.call_text_view);
        TextView settings = findViewById(R.id.settings);

        //set click listeners
        courses.setOnClickListener(this);
        talking.setOnClickListener(this);
        camp.setOnClickListener(this);
        toefl.setOnClickListener(this);
        newsBanner.setOnClickListener(this);
        callTextView.setOnClickListener(this);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
            }
        });
        initBanner();
    }

    private void initBanner() {
        ArrayList<BannerItem> data = new ArrayList<>();
        data.add(new BannerItem("Онлайн курсы английского",
                R.drawable.thumb,
                "https://www.instagram.com/p/CK-d_EEHNnR/"
        ));
        data.add(new BannerItem("Изменения в расписании!!",
                R.drawable.landscape_one,
                "https://www.instagram.com/p/CKiAxN_nBAY/"
        ));
        data.add(new BannerItem("Начался набор на все уровни!",
                R.drawable.landscape_two,
                "https://www.instagram.com/p/CKnUg-VnG-M/"
        ));
        data.add(new BannerItem("11 Января новый учебный месяц...",
                R.drawable.landscape_three,
                "https://www.instagram.com/p/CJ3LZPyHyB0/"
        ));
        BannerAdapter adapter = new BannerAdapter(data, this);
        adapter.setListener(new BannerAdapter.BannerListener() {
            @Override
            public void onItemClicked(BannerItem item) {
                Uri uri = Uri.parse(item.url);
                Intent callIntent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(callIntent);
            }
        });
        newsBanner.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.call_text_view: {
                Uri uri = Uri.parse("tel:" + "0558099893");
                Intent callIntent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(callIntent);
                break;
            }
            case R.id.news_banner: {
                Uri uri = Uri.parse(getResources().getString(R.string.news_url));
                Intent callIntent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(callIntent);
                break;
            }
            default:
                //передаем в новое активити ID кликнутой вьюшки
                Intent intent = new Intent(this, DetailActivity.class);
                intent.putExtra("view_id", view.getId());
                startActivity(intent);
                break;
        }
    }
}