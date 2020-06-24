package com.jasjotsingh.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    NavigationView navigationView;
    ImageView imageView;
    TextView textView;
    View headerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        headerView = navigationView.getHeaderView(0);
        imageView = headerView.findViewById(R.id.nav_header_imageView);
        textView = headerView.findViewById(R.id.nav_header_textView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayToastMessage("Image");
            }
        });

        headerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayToastMessage("random");
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayToastMessage("text");
            }
        });


        navigationView.setNavigationItemSelectedListener(this);

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_hamburger);
            getSupportActionBar().setTitle("");
            toolbar.setTitle(R.string.app_name);
            toolbar.setTitleTextColor(Color.WHITE);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    drawerLayout.openDrawer(navigationView);
                }
            });

        }}

    public void displayToastMessage(String string) {
        Toast.makeText(MainActivity.this, string, Toast.LENGTH_SHORT).show();
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_item_one:
            case R.id.nav_item_seven:
            case R.id.nav_item_six:
            case R.id.nav_item_five:
            case R.id.nav_item_four:
            case R.id.nav_item_three:
            case R.id.nav_item_two:
                displayToastMessage(item.getTitle().toString());
                break;

        }
        return  true;
    }
}








