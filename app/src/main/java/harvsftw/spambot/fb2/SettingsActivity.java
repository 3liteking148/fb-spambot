package harvsftw.spambot.fb2;


import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.RingtonePreference;
import android.text.TextUtils;
import android.view.MenuItem;

import java.util.List;

/**
 * A {@link PreferenceActivity} that presents a set of application settings. On
 * handset devices, settings are presented as a single list. On tablets,
 * settings are split by category, with category headers shown to the left of
 * the list of settings.
 * <p/>
 * See <a href="http://developer.android.com/design/patterns/settings.html">
 * Android Design: Settings</a> for design guidelines and the <a
 * href="http://developer.android.com/guide/topics/ui/settings.html">Settings
 * API Guide</a> for more information on developing a Settings UI.
 */
import android.app.ActionBar;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;

public class SettingsActivity extends PreferenceActivity {
    public static final String config1 = "config1";
    public static final String config2 = "config2";
    public static final String config3 = "config3";
    public static final String config4 = "config4";
    public static final String config5 = "config5";
    public static final String config6 = "config6";
    public static final String config7 = "config7";
    private static OnPreferenceChangeListener sBindPreferenceSummaryToValueListener;

    public static class LocationFragment extends PreferenceFragment {
        private static final String TAG = "LocationFragment";

        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.pref_general);
            setHasOptionsMenu(true);
            SettingsActivity.bindPreferenceSummaryToValue(findPreference(SettingsActivity.config1));
            SettingsActivity.bindPreferenceSummaryToValue(findPreference(SettingsActivity.config2));
            SettingsActivity.bindPreferenceSummaryToValue(findPreference(SettingsActivity.config3));
            SettingsActivity.bindPreferenceSummaryToValue(findPreference(SettingsActivity.config4));
            SettingsActivity.bindPreferenceSummaryToValue(findPreference(SettingsActivity.config5));
            SettingsActivity.bindPreferenceSummaryToValue(findPreference(SettingsActivity.config6));
            SettingsActivity.bindPreferenceSummaryToValue(findPreference(SettingsActivity.config7));
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActionBar();
        getFragmentManager().beginTransaction().replace(16908290, new LocationFragment()).commit();
    }

    static {
        sBindPreferenceSummaryToValueListener = new OnPreferenceChangeListener() {
            public boolean onPreferenceChange(Preference preference, Object value) {
                preference.setSummary(value.toString());
                return true;
            }
        };
    }

    private void setupActionBar() {
        android.app.ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private static void bindPreferenceSummaryToValue(Preference preference) {
        preference.setOnPreferenceChangeListener(sBindPreferenceSummaryToValueListener);
        sBindPreferenceSummaryToValueListener.onPreferenceChange(preference, PreferenceManager.getDefaultSharedPreferences(preference.getContext()).getString(preference.getKey(), BuildConfig.FLAVOR));
    }
}
