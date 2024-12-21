package com.example.ktck124lop124lttd04nhom01;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;  // Import for FragmentStatePagerAdapter

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private Bundle bundle;  // Instance variable for Bundle

    // Constructor accepts FragmentManager and behavior (for handling fragment lifecycle)
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);  // Initialize the superclass with FragmentManager and behavior
    }

    // Method to set the Bundle (data to be passed into the fragments)
    public void setBundle(Bundle bundle) {
        this.bundle = bundle;  // Assign the Bundle
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;

        // Determine which fragment to return based on the position
        switch (position) {
            case 0:
                fragment = new Home_Fragment();  // Home Fragment
                break;
            case 1:
                fragment = new TTCN_Fragment();  // TTCN Fragment
                break;
        }

        // Set the Bundle into the Fragment if it exists
        if (fragment != null && bundle != null) {
            fragment.setArguments(bundle);  // Attach the Bundle to the fragment
        }

        return fragment;  // Return the appropriate fragment
    }

    @Override
    public int getCount() {
        return 2;  // Total number of fragments in the ViewPager
    }
}
