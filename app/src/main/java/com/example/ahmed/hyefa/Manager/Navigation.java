package com.example.ahmed.hyefa.Manager;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.ahmed.hyefa.R;

public class Navigation extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
        {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //display Home Screen when the activity is loaded
        displaySelectedScreen(R.id.nav_home);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        //calling the method displayselectedscreen and passing the id of selected menu
        displaySelectedScreen(id);
        //make this method blank
        return true;
    }

            private void displaySelectedScreen(int itemId) {
                //creating fragment object
                Fragment fragment = null;
                //initializing the fragment object which is selected
                switch (itemId) {
                    case R.id.nav_home:
                        fragment = new Home();
                        break;
                    case R.id.nav_dashboard:
                        fragment = new Dashboard();
                        break;
                    case R.id.nav_profile:
                        fragment = new Profile();
                        break;
                    case R.id.nav_logout:
                      //  fragment = new Menu3();
                      //logout method here..
                        break;
                }
                //replacing the fragment
                if (fragment != null) {
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    //Main content containner
                    ft.replace(R.id.content_frame, fragment);
                    ft.commit();
                }
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
            }

            //For Menu Options..
            @Override
            public boolean onCreateOptionsMenu(Menu menu) {
                // Inflate the menu; this adds items to the action bar if it is present.
                super.onCreateOptionsMenu(menu);
                getMenuInflater().inflate(R.menu.main, menu);
                return true;
            }

            @Override
            public boolean onOptionsItemSelected(MenuItem item) {
                // TODO Auto-generated method stub
                switch (item.getItemId()) {
                    case R.id.Menu_chat:
                        Toast.makeText(Navigation.this, "Chat Activity",
                                Toast.LENGTH_LONG).show();
                        return true;
                    case R.id.Menu_exit:
                        Toast var = Toast.makeText(Navigation.this, "System Exit",
                                Toast.LENGTH_SHORT);
                        var.show();
                        return true;
                }
                return false;

            }
        }
