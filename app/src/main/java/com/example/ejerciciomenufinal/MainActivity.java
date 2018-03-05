package com.example.ejerciciomenufinal;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private Toolbar appbar;
    private DrawerLayout drawerLayout;
    private NavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appbar =(Toolbar)findViewById(R.id.appbar);
        setSupportActionBar(appbar);

        getSupportActionBar().setHomeAsUpIndicator(R.mipmap.ic_nav_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        navView=(NavigationView)findViewById(R.id.navview);

        navView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {

                        boolean fragmentTransaction = false;
                        Fragment fragment = null;

                        switch (menuItem.getItemId()) {
                            case R.id.menu_miperfil:
                                fragment = new fragmentperfil();
                                fragmentTransaction = true;
                                break;
                            case R.id.menu_miscategorias:
                                fragment = new fragmentcategorias();
                                fragmentTransaction = true;
                                break;
                            case R.id.menu_ejercicios:
                                fragment = new fragmentejercicios();
                                fragmentTransaction = true;
                                break;
                            case R.id.menu_porcentajes:
                                fragment = new fragmentporcentajes();
                                fragmentTransaction = true;
                                break;
                            case R.id.menu_records:
                                fragment = new fragmentrecords();
                                fragmentTransaction = true;
                                break;
                            case R.id.menu_configuracion:
                                fragment = new fragmentconfiguracion();
                                fragmentTransaction = true;
                                break;
                        }

                        if(fragmentTransaction) {
                            getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.content_frame, fragment)
                                    .commit();

                            menuItem.setChecked(true);
                            getSupportActionBar().setTitle(menuItem.getTitle());
                        }

                        drawerLayout.closeDrawers();

                        return true;
                    }
                });
    }

    private void setSupportActionBar(Toolbar appbar) {
    }


}
