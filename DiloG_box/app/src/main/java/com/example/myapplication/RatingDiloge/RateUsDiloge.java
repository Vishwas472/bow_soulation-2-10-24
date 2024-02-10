package com.example.myapplication.RatingDiloge;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.example.myapplication.R;

public class RateUsDiloge extends Dialog {
    private float userrate =0;
    Context context;
    public RateUsDiloge(@NonNull Context context) {
        super(context);
        this.context=context;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rate_us_dilog_layout);

        final AppCompatButton ratenow = findViewById(R.id.ratenowbtn);
        final AppCompatButton laterbtn = findViewById(R.id.laterbtn);
        final RatingBar ratingBar = findViewById(R.id.ratinbar);
        final ImageView ratingBarImage = findViewById(R.id.ratingbarimage);

        ratenow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(context, "Succesfully Rated", Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });
        laterbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });


        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean b) {

                if (rating <= 1) {
                    ratingBarImage.setImageResource(R.drawable.onestar);
                } else if (rating <= 2) {
                    ratingBarImage.setImageResource(R.drawable.twosatr);
                } else if (rating <= 3) {
                    ratingBarImage.setImageResource(R.drawable.third);
                } else if (rating <= 4) {
                    ratingBarImage.setImageResource(R.drawable.forthstar);

                } else if (rating <= 5) {
                    ratingBarImage.setImageResource(R.drawable.fivestar);


                }
                animateImage(ratingBarImage);
                userrate =rating;
            }
        });
    }
    private  void animateImage(ImageView ratingBarImage){
        //scale animation no use સ્કેલ એનિમેશન મૂળભૂત રીતે વ્યુના કદને વધારવા અથવા ઘટાડવા માટે છે
        ScaleAnimation scaleAnimation = new ScaleAnimation(0f,  1f, 0f,1f,
        Animation.RELATIVE_TO_SELF,0.5f,  Animation.RELATIVE_TO_SELF,0.5f);

        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(200);
        ratingBarImage.startAnimation(scaleAnimation);

    }

}
