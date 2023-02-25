package com.example.asanbekov.data.local

import android.content.Context
import android.content.Context.MODE_PRIVATE

class Pref(context:Context) {
    private val pref = context.getSharedPreferences("PREF_NAME",MODE_PRIVATE)


    fun isUserSee():Boolean{
        return pref.getBoolean(SEEN_KEY,false)
    }
    fun saveUserSeen(){
        pref.edit().putBoolean(SEEN_KEY,true).apply()
    }


    fun setProfile(Profile: String){
        pref.getString(PROF_KEY,"").toString()

    }

    fun getProfile():String {
        return pref.getString(PROF_KEY,"").toString()
    }

    companion object{
        const val PREF_NAME = "pref.task"
        const val SEEN_KEY = "seen.key"
        const val PROF_KEY = "profile.key"
    }
}