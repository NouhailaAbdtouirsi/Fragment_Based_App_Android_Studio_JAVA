package com.abdtouirsi.atelier4r;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Find the BottomNavigationView
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        // Get the NavController
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        // Set up the BottomNavigationView with the NavController
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }
}