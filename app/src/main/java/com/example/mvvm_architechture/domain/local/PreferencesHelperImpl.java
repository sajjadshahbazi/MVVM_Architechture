package com.example.mvvm_architechture.domain.local;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

public class PreferencesHelperImpl implements PreferencesHelper {

    private static final String PREF_KEY_AMOUNT = "KEY_AMOUNT";
    private static final String PREF_NAME = "MVVM_ARCH";
    private static final String PREF_KEY_LAST_UPDATE = "KEY_LAST_UPDATE";

    private final SharedPreferences mPrefs;

    @Inject
    public PreferencesHelperImpl(Context context) {
        mPrefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public void insertBalance(Double value) {
        mPrefs.edit().putString(PREF_KEY_AMOUNT, value.toString()).apply();
    }

    @Override
    public void insertLastUpdate(Long value) {
        mPrefs.edit().putLong(PREF_KEY_LAST_UPDATE, value).apply();
    }

    @Override
    public Double getBalance() {
        return Double.parseDouble(mPrefs.getString(PREF_KEY_AMOUNT, "0.0"));
    }

    @Override
    public Long getLastUpdate() {
        return mPrefs.getLong(PREF_KEY_LAST_UPDATE, -1L);
    }
}
