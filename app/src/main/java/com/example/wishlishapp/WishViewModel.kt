package com.example.wishlishapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wishlishapp.data.Wish
import com.example.wishlishapp.data.WishRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class WishViewModel(
    private val wishRepository: WishRepository = Graph.wishRepository
) : ViewModel() {

    var wishTitleState by mutableStateOf("")
    var descriptionState by mutableStateOf("")


    fun onWishTitleChanged(newString : String){
        wishTitleState=newString
    }

    fun onWishDescriptionChanged(newString : String){
        descriptionState=newString
    }

    lateinit var getAllWishes : Flow<List<Wish>> // lateinit: makes the var exist before it gets called

    init {
        viewModelScope.launch {
            getAllWishes = wishRepository.getWishes()
        }
    }

    fun addWish(wish: Wish){
        viewModelScope.launch(Dispatchers.IO) { // Dispatchers are responsible for which thread it will run on
            wishRepository.addWish(wish)
        }
    }

      fun getWishById(id : Long) : Flow<Wish> {
        return wishRepository.getWishById(id)
    }

    fun updateWish(wish: Wish){
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.updateWish(wish)
        }
    }

    fun deleteWish(wish: Wish){
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.deleteWish(wish)
        }
    }

}