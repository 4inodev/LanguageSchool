package kf.chinodev.languageschool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    ImageView headerImage;
    TextView headerTitle;
    TextView contentTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        //init views
        headerImage = findViewById(R.id.header_image);
        headerTitle = findViewById(R.id.header_title);
        contentTextView = findViewById(R.id.content_text_view);
        showData();
        setCallClickListener();
    }


    private void showData() {
        //get view ID from extras
        int viewId = getIntent().getIntExtra("view_id", -1);
        //показываем данные в зависимости от кнопки
        if (viewId != -1) { //если view_id было найдено
            switch (viewId) { //search view ID
                case R.id.service_camp:
                    headerImage.setImageResource(R.drawable.camp);
                    headerTitle.setText("Летний лагерь");
                    contentTextView.setText(R.string.service_camp);
                    break;
                case R.id.service_courses:
                    headerImage.setImageResource(R.drawable.flag);
                    headerTitle.setText("Языковые курсы");
                    contentTextView.setText(R.string.service_languages);
                    break;
                case R.id.service_talking:
                    headerImage.setImageResource(R.drawable.talking);
                    headerTitle.setText("Talking club");
                    contentTextView.setText(R.string.service_talking);
                    break;
                case R.id.service_toefl:
                    headerImage.setImageResource(R.drawable.toefl);
                    headerTitle.setText("TOEFL");
                    contentTextView.setText(R.string.service_toefl);
                    break;
            }
        }
    }

    private void setCallClickListener() {
        TextView callTextView = findViewById(R.id.call_text_view);
        callTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("tel:" + "0558099893");
                Intent callIntent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(callIntent);
            }
        });
    }
}