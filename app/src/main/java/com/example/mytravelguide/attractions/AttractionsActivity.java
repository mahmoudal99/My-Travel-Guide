package com.example.mytravelguide.attractions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.mytravelguide.HomePageActivity;
import com.example.mytravelguide.R;

public class AttractionsActivity extends AppCompatActivity {

    ImageView backArrow;
    CardView europeCardView,africaCardView,asiaCardView, americaCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover);
//
//        init();
//        setUpWidgets();
    }

//    private void init(){
//        backArrow = findViewById(R.id.backArrow);
//        europeCardView = findViewById(R.id.attractionsCardEurope);
//        africaCardView = findViewById(R.id.attractionsCardAfrica);
//        asiaCardView = findViewById(R.id.attractionsCardAsia);
//        americaCardView = findViewById(R.id.attractionsCardAmerica);
//    }

//    private void setUpWidgets(){
//        backArrow.setOnClickListener(v -> {
//            Intent backIntent = new Intent(AttractionsActivity.this, HomePageActivity.class);
//            startActivity(backIntent);
//        });
//
//        europeCardView.setOnClickListener(v -> startActivity(new Intent(AttractionsActivity.this, ContinentAttractionsActivity.class).putExtra("Continent", "Europe")));
//
//        asiaCardView.setOnClickListener(v -> startActivity(new Intent(AttractionsActivity.this, ContinentAttractionsActivity.class).putExtra("Continent", "Asia")));
//
//        americaCardView.setOnClickListener(v -> startActivity(new Intent(AttractionsActivity.this, ContinentAttractionsActivity.class).putExtra("Continent", "America")));
//
//        africaCardView.setOnClickListener(v -> startActivity(new Intent(AttractionsActivity.this, ContinentAttractionsActivity.class).putExtra("Continent", "Africa")));
//    }
}






























