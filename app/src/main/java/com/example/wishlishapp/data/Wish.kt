package com.example.wishlishapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wish-table")
data class Wish(

    @PrimaryKey(autoGenerate = true) // increase the id when adding a new wish
    val id : Long = 0L,

    @ColumnInfo(name = "wish-title")
    val title : String = "",

    @ColumnInfo(name="wish-desc")
    val description : String =""
)


object DummyWish{
    val WishList = listOf(
        Wish(title = "Google Watch 2", description = "Android Watch"),
        Wish(title = "Oculus Quest 2", description = "A VR headset for playing games"),
        Wish(title = "A sci-fi book", description = "from the best seller!")
    )
}