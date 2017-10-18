package yaskiv.clean_cache_for_all.app.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import yaskiv.clean_cache_for_all.R;
import yaskiv.clean_cache_for_all.app.fragment.CleanerFragment;
import yaskiv.clean_cache_for_all.app.fragment.HomeFragment;
import yaskiv.clean_cache_for_all.app.fragment.SettingsFragment;
import yaskiv.clean_cache_for_all.app.model.Singleton;


public class CleanerActivity extends AppCompatActivity implements SettingsFragment.OnFragmentInteractionListener,HomeFragment.OnFragmentInteractionListener {
    public static final String APP_PREFERENCES = "mysettings";
    public static final String APP_PREFERENCES_LAST_DATE_OF_CLEAN = "clean_date";
    private SharedPreferences mSettings;

    @Override
    protected void onPause() {
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putString(APP_PREFERENCES_LAST_DATE_OF_CLEAN, Singleton.getmLastDateOfClean());
        Log.d("Bla bla date","|"+ Singleton.getmLastDateOfClean());
        editor.apply();
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mSettings.contains(APP_PREFERENCES_LAST_DATE_OF_CLEAN)) {
            // Получаем число из настроек
            Singleton.setmLastDateOfClean(mSettings.getString(APP_PREFERENCES_LAST_DATE_OF_CLEAN,"1999/12/31"));
            // Выводим на экран данные из настроек

            TextView lastdate=(TextView) findViewById(R.id.last_date);
            lastdate.setText(Singleton.getmLastDateOfClean());
            Log.d("Bla bla date", Singleton.getmLastDateOfClean());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        setContentView(R.layout.cleaner_activity);
        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setDefaultTab(R.id.tab_friends);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId)
                {
                    case  R.id.tab_favorites:
                        displayView(R.id.tab_favorites);
                        break;
                    case  R.id.tab_friends:
                        displayView(R.id.tab_friends);
                        break;
                    case  R.id.tab_nearby:
                        displayView(R.id.tab_nearby);
                        break;

                }
            }
        });
        displayView(R.id.tab_friends);
    }
    public void displayView(int viewId) {

        Fragment fragment = null;
        String title = getString(R.string.app_name);

        switch (viewId) {
            case R.id.tab_favorites:
                fragment
                        = new CleanerFragment();
                title  = "Clean";

                break;
            case R.id.tab_friends:
                fragment = new HomeFragment();
                title  = "Home";

                break;
            case R.id.tab_nearby:
                fragment = new SettingsFragment();
                title  = "Setting";

                break;



        }

        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.contentContainer, fragment);
            ft.commit();
        }

        // set the toolbar title
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }


    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
