package com.example.wishlishapp

import android.content.Context
import androidx.room.Room
import com.example.wishlishapp.data.WishDatabase
import com.example.wishlishapp.data.WishRepository

// object - like a class but you can only create this Graph, nothing more
object Graph {

    lateinit var database : WishDatabase

    val wishRepository by lazy {  // lazy makes the variable only initialize when it's needed
        WishRepository(wishDao = database.wishDao())  // AKA, do not load all the stuff when opening the app, but only load them when it's wanted
    }

    fun provide(context: Context){
        database = Room.databaseBuilder(context, WishDatabase::class.java, "wishlist.db").build()
    }

}