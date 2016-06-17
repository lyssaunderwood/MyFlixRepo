package com.example.lyssaunderwood.flixster;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

public class activity_view_movie extends AppCompatActivity {

    ImageView ivImage;
    TextView tvTitle;
    TextView tvSynopsis;
    RatingBar rbRate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_view_movie);
        getSupportActionBar().hide();

        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvSynopsis = (TextView) findViewById(R.id.tvSynopsis);
        ivImage = (ImageView) findViewById(R.id.ivImage);
        rbRate = (RatingBar) findViewById(R.id.rbRate);


        String title = getIntent().getStringExtra("title");
        String image = getIntent().getStringExtra("image");
        String overview = getIntent().getStringExtra("overview");
        double rating = getIntent().getDoubleExtra("rating", 0);

        tvTitle.setText(title);
        tvSynopsis.setText(overview);
        rbRate.setRating((float)rating/2);
        Picasso.with(this.getApplicationContext()).load(image).transform(new RoundedCornersTransformation(10, 10)).into(ivImage);



    }
}
