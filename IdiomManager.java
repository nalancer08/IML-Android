package com.appbuilders.idiommanagerlibrary;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.util.HashMap;

/**
 * Created by Erick on 02/11/2016.
 */
public class IdiomManager {

    // Define basic idioms

    // State variables
    protected String current_idiom;
    protected HashMap<String, String> idioms;

    // Global variables
    protected Context context;

    // Constructor that waits the context
    public IdiomManager(Context context) {

        this.context = context;
    }

    /* Method to set idioms
        params: List of idioms
        return: void
     */
    protected void setIdioms(HashMap<String, String> idioms) {

        this.idioms = idioms;
    }


    /* Method to set current idiom
        params: String prefix of idioam
        return: void
     */
    protected void setCurrentIdiom(String prefix) {

        this.current_idiom = prefix;
        savePreferences("current_idiom", this.current_idiom);
    }

    /* Method to get current idiom
       params: --
       return: String prefix
    */
    protected String getCurrentIdiom() {

        return getPreference("current_idiom");
    }

    /* Method to get text, with the curren idiom
       params: String key text
       return: String text
    */
    protected String getText(String key) {

        String current_text = key.concat("_").concat(getCurrentIdiom());
        return this.context.getResources().getString(this.context.getResources().getIdentifier(current_text, "string", this.context.getPackageName()));
    }



    // Private methods

    private void savePreferences(String key, String value) {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this.context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    private String getPreference(String key) {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this.context);
        return preferences.getString(key, "");
    }


}
