package com.example.doc.activitytest.fragment;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.example.doc.activitytest.R;

public class PreferencesFragmentTest extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.display_prefs);
    }
}
