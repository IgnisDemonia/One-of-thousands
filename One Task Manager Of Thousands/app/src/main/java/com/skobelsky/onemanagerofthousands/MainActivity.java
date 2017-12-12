package com.skobelsky.onemanagerofthousands;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.skobelsky.onemanagerofthousands.adapter.TabsAdapter;
import com.skobelsky.onemanagerofthousands.dto.RememberDTO;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawerlayout;
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTheme(R.style.AppDefault);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        initToolbar();
        initNavigationView();
        initTabs();

    }

    public void initToolbar() {
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });
        toolbar.inflateMenu(R.menu.menu_main);
    }

    private void initNavigationView() {
        drawerlayout = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle
                (this,
                drawerlayout,
                toolbar,
                R.string.View_navigation_open,
                R.string.View_navigation_close);

        drawerlayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.design_navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerlayout.closeDrawers();
                if (item.getItemId() == R.id.item_notification_menu) {
                    showNotificationTab();
                }
                return true;
            }
        });
    }

    private void initTabs() {
        TabsAdapter adapter = new TabsAdapter(getApplicationContext(), getSupportFragmentManager());
        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(adapter);

        new RememberAllTask().execute();

        tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }

    public void showNotificationTab() {
        viewPager.setCurrentItem(Constants.SECOND);
    }

    class RememberAllTask extends AsyncTask<Void, Void, RememberDTO> {
        @Override
        protected RememberDTO doInBackground(Void... voids) {
            RestTemplate template = new RestTemplate();
            template.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            return template.getForObject(Constants.URL.getRememberItem, RememberDTO.class);
        }

        @Override
        protected void onPostExecute(RememberDTO rememberDTO) {
            List<RememberDTO> data = new ArrayList<>();
            data.add(rememberDTO);

            adapter.setData(data);
        }
    }
}
