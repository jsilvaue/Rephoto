package com.example.rephoto;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewSwitcher;

import androidx.appcompat.app.AppCompatActivity;

public class PortfolioUtilizadorActivity extends AppCompatActivity {

    ImageButton btPrevious, btNext;
    ImageSwitcher imageSwitcher;

    int imageList[] = {R.drawable.i_belem, R.drawable.i_duque, R.drawable.i_marques, R.drawable.i_mosteiro};
    int count = imageList.length;
    int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portfolio_utilizador);

        btPrevious = findViewById(R.id.bt_previous);
        btNext = findViewById(R.id.bt_next);
        imageSwitcher = findViewById(R.id.image_switcher);

        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));
                return imageView;
            }
        });

        imageSwitcher.setImageResource(imageList[0]);

        btPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageSwitcher.setInAnimation(PortfolioUtilizadorActivity.this, R.anim.from_right);
                imageSwitcher.setOutAnimation(PortfolioUtilizadorActivity.this, R.anim.to_left);
                --currentIndex;
                if(currentIndex < 0)
                    currentIndex = imageList.length-1;
                imageSwitcher.setImageResource(imageList[currentIndex]);
            }
        });

        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageSwitcher.setInAnimation(PortfolioUtilizadorActivity.this, R.anim.from_left);
                imageSwitcher.setOutAnimation(PortfolioUtilizadorActivity.this, R.anim.to_right);
                currentIndex++;
                if(currentIndex == count)
                    currentIndex = 0;
                imageSwitcher.setImageResource(imageList[currentIndex]);
            }
        });
    }
}
