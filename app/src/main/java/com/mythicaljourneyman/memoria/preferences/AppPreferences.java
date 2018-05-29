package com.mythicaljourneyman.memoria.preferences;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Prabodh Dhabaria on 25-05-2018.
 */
public class AppPreferences {
    private static SharedPreferences sPreferences;
    private static final String SHARED_PREFERENCE = "preference";
    private static final String PLAYER_1_NAME = "player_1_name";
    private static final String PLAYER_2_NAME = "player_2_name";
    private static final String PLAYER_1_SYMBOL = "player_1_symbol";
    private static final String PLAYER_2_SYMBOL = "player_2_symbol";
    private static final String GRID_SIZE = "grid_size";


    private static SharedPreferences getPreferences(Context context) {
        if (sPreferences == null) {
            sPreferences = context.getSharedPreferences(SHARED_PREFERENCE, 0);
        }
        return sPreferences;
    }


    public static void clearPref(Context context) {
        SharedPreferences preferences = getPreferences(context);
        preferences.edit().clear().commit();
    }

    public static String getPlayer1Name(Context context) {
        return getPreferences(context).getString(PLAYER_1_NAME, "Player 1");
    }

    public static String getPlayer2Name(Context context) {
        return getPreferences(context).getString(PLAYER_2_NAME, "Player 2");
    }

    public static String getPlayer1Symbol(Context context) {
        return getPreferences(context).getString(PLAYER_1_SYMBOL, "X");
    }

    public static String getPlayer2Symbol(Context context) {
        return getPreferences(context).getString(PLAYER_2_SYMBOL, "O");
    }

    public static int getGridSize(Context context) {
        return getPreferences(context).getInt(GRID_SIZE, 4);
    }

    public static void setPlayer1Name(Context context, String value) {
        SharedPreferences preferences = getPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(PLAYER_1_NAME, value);
        editor.commit();
    }

    public static void setPlayer2Name(Context context, String value) {
        SharedPreferences preferences = getPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(PLAYER_2_NAME, value);
        editor.commit();
    }

    public static void setPlayer1Symbol(Context context, String value) {
        SharedPreferences preferences = getPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(PLAYER_1_SYMBOL, value);
        editor.commit();
    }

    public static void setPlayer2Symbol(Context context, String value) {
        SharedPreferences preferences = getPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(PLAYER_2_SYMBOL, value);
        editor.commit();
    }

    public static void setGridSize(Context context, int gridSize) {
        SharedPreferences preferences = getPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(GRID_SIZE, gridSize);
        editor.commit();
    }
}
