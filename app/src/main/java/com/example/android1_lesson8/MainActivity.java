package com.example.android1_lesson8;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    FragmentList fragmentList;
    Fragment tempFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showListFragment();
    }

    public void showListFragment() {
        if (fragmentList == null) {
            fragmentList = new FragmentList();
        }
        showFragment(fragmentList, tempFragment);
        tempFragment = null;
    }

    public void showAddFragment() {
        FragmentAdd fragmentAdd = new FragmentAdd();
        tempFragment = fragmentAdd;
        showFragment(fragmentAdd, fragmentList);
    }

    public void showShowFragment(Element element) {
        FragmentShow fragmentShow = new FragmentShow();
        tempFragment = fragmentShow;
        showFragment(fragmentShow, fragmentList);
        fragmentShow.showElement(element);
    }

    public void saveElement(Element element) {
        fragmentList.saveElement(element);
        showListFragment();
    }

    void showFragment(Fragment fragment, @Nullable Fragment fragmentToHide) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (fragmentToHide != null) {
            transaction.hide(fragmentToHide);
        }
        transaction.replace(R.id.container, fragment);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        if(tempFragment != null) {
            showListFragment();
        } else {
            super.onBackPressed();
        }
    }
}
