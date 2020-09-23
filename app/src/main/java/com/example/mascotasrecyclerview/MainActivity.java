package com.example.mascotasrecyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mascotasrecyclerview.adapter.MascotaAdaptador;
import com.example.mascotasrecyclerview.adapter.PageAdapter;
import com.example.mascotasrecyclerview.fragments.MascotaFragment;
import com.example.mascotasrecyclerview.fragments.RecyclerViewMascotasFragment;
import com.example.mascotasrecyclerview.pojo.Mascota;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    //Toolbar tool;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //variables para fragments
        toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tabLayout=(TabLayout) findViewById(R.id.tabs);
        viewPager=(ViewPager) findViewById(R.id.vPayer);
        setUpViewPager();


    }

     @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_options,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){

            case R.id.menuContacto:
                Intent intent=new Intent(MainActivity.this, mandar_email.class);
                startActivity(intent);
                break;
            case R.id.menuAcercade:
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    private ArrayList<Fragment> AgregarFragments(){
        ArrayList<Fragment> fragments=new ArrayList<>();

        fragments.add(new RecyclerViewMascotasFragment());
        fragments.add(new MascotaFragment());

        return  fragments;

    }
    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),AgregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.home);
        tabLayout.getTabAt(1).setIcon(R.drawable.mascota);
    }




}