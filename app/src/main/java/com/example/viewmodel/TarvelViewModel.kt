package com.example.viewmodel
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class TarvelViewModel:ViewModel() {
    private val _travelsList = MutableStateFlow("")
    val travelsList: StateFlow<String> get() = _travelsList.asStateFlow()

    fun showAllTravels(choosenTravel: String){
//        zapytanie do bazy danych o podróże
        _travelsList.value="to będzie lista"

    }
}