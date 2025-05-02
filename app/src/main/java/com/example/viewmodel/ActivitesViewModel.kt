package com.example.viewmodel
import androidx.lifecycle.ViewModel
import com.example.model.UserModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ActivitesViewModel:ViewModel() {
    private val _activitiesList = MutableStateFlow("")
    val activiesList: StateFlow<String> get() = _activitiesList.asStateFlow()
    fun showDailyActivities(choosenDate: String){
        _activitiesList.value="to będzie lista"

    }
}