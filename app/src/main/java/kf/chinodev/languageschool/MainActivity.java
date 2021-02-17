package kf.chinodev.languageschool;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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

        //set click listeners
        courses.setOnClickListener(this);
        talking.setOnClickListener(this);
        camp.setOnClickListener(this);
        toefl.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //передаем в новое активити ID кликнутой вьюшки
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("view_id", view.getId());
        startActivity(intent);
    }
}