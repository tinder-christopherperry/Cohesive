package com.tinder.navigation

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.tinder.navigation.Navigation.loadClassOrNull
import java.util.concurrent.ConcurrentHashMap

object Navigation {
    private val CLASS_MAP = ConcurrentHashMap<String, Class<*>>()

    fun <T> loadClassOrNull(className: String): Class<T>? {
        return CLASS_MAP.getOrPut(className) {
            try {
                Class.forName(className)
            } catch (e: ClassNotFoundException) {
                Log.e("Navigation", "Cannot store a value in the map")
                return null
            }
        } as? Class<T>
    }
}

object Activities {
    fun intentForProfile(context: Context, userId: Long): Intent? {
        val args = Bundle().apply { putLong("userId", userId) }
        return loadClassOrNull<Activity>("com.tinder.profile.ProfileActivity")?.let {
            Intent(context, it)
        }?.apply { putExtras(args) }
    }
}

object Fragments {
    fun fragmentForProfileOptions(userName: String): Fragment? {
        val args = Bundle().apply { putString("userName", userName) }
        return loadClassOrNull<Fragment>("com.tinder.ProfileOptionsFragment")?.newInstance()
            .apply {
                this?.arguments = args
            }
    }
}