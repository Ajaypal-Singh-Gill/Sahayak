package com.gajab.sahayak;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.Window;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ActivitySignIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        getSupportActionBar().hide();
        BottomNavigationView ActivitySignInBottomNav = findViewById(R.id.activity_sign_in_bottom_nav);
        NavController nav = Navigation.findNavController(this, R.id.nav_host_fragment);

        NavigationUI.setupWithNavController(ActivitySignInBottomNav, nav);
    }
}