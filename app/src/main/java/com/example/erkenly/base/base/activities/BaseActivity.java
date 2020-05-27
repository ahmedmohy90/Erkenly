package com.example.erkenly.base.base.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.erkenly.R;
import com.example.erkenly.base.base.activities.fragments.BaseFragment;

import java.util.ArrayList;

public class BaseActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private FrameLayout fragmentContainer;
    private ArrayList<BaseFragment> fragmentToActivity;
    private View backAction, menuAction;
    private TextView title;
    private LinearLayout userName, language, about, logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        fragmentToActivity = new ArrayList<>();
        drawerLayout = findViewById(R.id.drawer_lauout);
        fragmentContainer = findViewById(R.id.fragment_container);
        customizedActionbar();
        if (isMenuEnabled())
        customizedSideMenu();
    }

    private void customizedSideMenu() {
        userName = findViewById(R.id.username_linear);
        userName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        language = findViewById(R.id.language_linear);
        language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        about = findViewById(R.id.about_linear);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        logout = findViewById(R.id.logout_linear);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void customizedActionbar() {
        if (isToolbarEnabled()){
            toolbar = findViewById(R.id.toolbar);
            title = findViewById(R.id.tv_titleTxt);
            setActionBar(toolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            toolbar.setContentInsetsAbsolute(0, 0);
            if (isBackEnabled()){
                backAction = findViewById(R.id.tv_back_action);
                backAction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        handelBackActionClicked();
                    }
                });
            }
        }

        if (isMenuEnabled()){
            menuAction = findViewById(R.id.menu);
            menuAction.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        handelMenuClicked();
                }
            });
        }

    }
    public  void setActionbarTitle (String titleText){
        title.setText(titleText);
    }

    private void handelBackActionClicked() {
    }

    private void handelMenuClicked() {
    }

    public boolean isToolbarEnabled(){
        return true;
    }
    public boolean isBackEnabled(){
        return true;
    }
    public boolean isTitleEnabled(){
        return true;
    }
    public boolean isMenuEnabled(){
        return true;
    }
    public void addFragmentToActivity(BaseFragment fragment){
        if (fragment!=null){
            if (fragment.isAdded()){
                View currentFragment = fragment.getView();
                if (currentFragment!=null){
                    currentFragment.setVisibility(View.INVISIBLE);
                }
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, fragment).commit();
            }else {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commitAllowingStateLoss();
                //commetAllow to sovle null point exception of if the old fragment is equal null for example
            }
        }
        fragmentToActivity.add(fragment);
    }
}
