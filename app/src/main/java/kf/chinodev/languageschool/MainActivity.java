package kf.chinodev.languageschool;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init views
        ConstraintLayout courses = findViewById(R.id.service_courses);
        ConstraintLayout talking = findViewById(R.id.service_talking);
        ConstraintLayout camp = findViewById(R.id.service_camp);
        ConstraintLayout toefl = findViewById(R.id.service_toefl);
        ConstraintLayout newsBanner = findViewById(R.id.news_banner);
        TextView callTextView = findViewById(R.id.call_text_view);
        TextView settings = findViewById(R.id.settings);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
            }
        });

        //set click listeners
        courses.setOnClickListener(this);
        talking.setOnClickListener(this);
        camp.setOnClickListener(this);
        toefl.setOnClickListener(this);
        newsBanner.setOnClickListener(this);
        callTextView.setOnClickListener(this);
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