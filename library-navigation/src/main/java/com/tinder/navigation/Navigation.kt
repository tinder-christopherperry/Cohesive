package com.tinder.navigation

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
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
                // Cannot store a value in the concurrent map
                return null
            }
        } as? Class<T>
    }
}

object Activities {
    fun intentForProfile(context: Context, userName: String): Intent? {
        val args = Bundle().apply { putString("userName", userName) }
        return loadClassOrNull<Activity>("com.tinder.ProfileActivity")?.let {
            Intent(context, it)
        }?.apply { putExtras(args) }
    }
}

object Fragments {
    fun fragmentForProfile(userName: String): Fragment? {
        val args = Bundle().apply { putString("userName", userName) }
        return loadClassOrNull<Fragment>("com.tinder.ProfileFragment")?.newInstance()
            .apply {
                this?.arguments = args
            }
    }
}