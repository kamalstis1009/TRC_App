package com.trc.app.views.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.trc.app.R;
import com.trc.app.models.User;
import com.trc.app.services.MyNetworkReceiver;
import com.trc.app.session.SharedPefManager;
import com.trc.app.utils.Utility;
import com.trc.app.views.fragments.FragmentAbout;
import com.trc.app.views.fragments.FragmentContact;
import com.trc.app.views.fragments.FragmentHome;
import com.trc.app.views.fragments.FragmentService;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private MyNetworkReceiver mNetworkReceiver;
    private User mUser;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //-----------------------------------------------| Check network and location
        mNetworkReceiver = new MyNetworkReceiver(this);

        //-----------------------------------------------| Session
        mUser = SharedPefManager.getInstance(this).getUser();

        //-----------------------------------------------| To Display Navigation Bar
        Toolbar toolbar = findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            if (getSupportActionBar() != null) {
                getSupportActionBar().setDisplayShowTitleEnabled(true); //Remove title
                getSupportActionBar().setDisplayShowHomeEnabled(false);
            }
            //toolbar.getBackground().setAlpha(200);
            DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
            setNavigationDrawer(drawerLayout, toolbar);
        }

        //-----------------------------------------------| Profile
        if (mUser != null) {
            //((CircleImageView) findViewById(R.id.userImage)).setImageBitmap(Utility.getInstance().base64ToBitmap(user.getUserImageUrl()));
            //((TextView) findViewById(R.id.nav_header_user)).setText("" + mUser.getFullName());
        }

        //-----------------------------------------------| Home fragment
        Utility.getInstance().onReplaceFragment(getSupportFragmentManager(), new FragmentHome());
    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            registerReceiver(mNetworkReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)); //After Oreo version this code must be used
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        try {
            unregisterReceiver(mNetworkReceiver); //After Oreo version this code must be used
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.home_menu_id) {
            Utility.getInstance().onAddFragment(getSupportFragmentManager(), new FragmentHome());
        }
        if (item.getItemId() == R.id.service_id) {
            Utility.getInstance().onAddFragment(getSupportFragmentManager(), new FragmentService());
        }
        if (item.getItemId() == R.id.about_id) {
            Utility.getInstance().onAddFragment(getSupportFragmentManager(), new FragmentAbout());
        }
        if (item.getItemId() == R.id.contact_id) {
            Utility.getInstance().onAddFragment(getSupportFragmentManager(), new FragmentContact());
        }
        return false;
    }

    private void setNavigationDrawer(DrawerLayout drawerLayout, Toolbar toolbar) {
        ActionBarDrawerToggle mToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.colorWhite));
        drawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        NavigationView mNavigationView = findViewById(R.id.nav_view);
        mNavigationView.setNavigationItemSelectedListener(this);

        View mView = mNavigationView.getHeaderView(0);
        /*if (user != null) {
            //Picasso.get().load(userModel.getImageUrl()).into(((CircleImageView) mView.findViewById(R.id.nav_header_photo)));
            ((TextView) mView.findViewById(R.id.nav_header_user)).setText(user.getUserFullName());
        }*/
        ((CircleImageView) mView.findViewById(R.id.nav_header_photo)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, ProfileActivity.class));
            }
        });

        //((TextView) findViewById(R.id.log_out)).setOnLongClickListener(new ActionHandler());
        ((TextView) findViewById(R.id.log_out)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, SignInActivity.class));
            }
        });
    }

}