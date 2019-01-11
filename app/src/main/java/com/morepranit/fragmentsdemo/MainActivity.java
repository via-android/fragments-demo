package com.morepranit.fragmentsdemo;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.morepranit.fragmentsdemo.fragments.ButtonFragment;
import com.morepranit.fragmentsdemo.fragments.DetailFragment;

public class MainActivity extends AppCompatActivity implements ButtonFragment.OnButtonClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.fragment_container) != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .add(R.id.fragment_container, new ButtonFragment())
                    .commit();
        }
    }

    @Override
    public void onButtonClick(View view, String txt) {
        boolean dualPane = getResources().getBoolean(R.bool.dual_pane);
        if (dualPane) {
            // Landscape
            DetailFragment df = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.detail_fragment);
            df.setText(txt);
        } else {
            // Portrait
            FragmentManager fragmentManager = getSupportFragmentManager();

            Bundle bundle = new Bundle();
            bundle.putString("text_key", txt);

            DetailFragment df = new DetailFragment();
            df.setArguments(bundle);

            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, df)
                    .addToBackStack(null)
                    .commit();
        }
    }
}
