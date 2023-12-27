package com.example.wishlishapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


@Dao // DAO = Data Access Object
abstract class WishDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE) // param: what to do if the wish is already added
    abstract suspend fun addWish(wishEntity: Wish)

    @Query("Select * from `wish-table`") // Loads all wishes from the wish table
    abstract fun getAllWishes() : Flow<List<Wish>>

    @Update
    abstract suspend fun updateWish(wishEntity: Wish)

    @Delete
    abstract suspend  fun deleteWish(wishEntity: Wish)

    @Query("Select * from `wish-table` where id=:id ")
    abstract  fun getWishById(id:Long) : Flow<Wish>

}