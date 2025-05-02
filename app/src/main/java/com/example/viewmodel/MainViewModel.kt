package com.example.viewmodel
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.model.UserModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel(userModel: UserModel): ViewModel()  {
    private val _user = MutableStateFlow(UserModel("",0))
    val user: StateFlow<UserModel> get() = _user.asStateFlow()

    private val _greeting = MutableStateFlow("")
    val greeting: StateFlow<String>  = _greeting.asStateFlow()

    fun updateData(name: String, age: String) {
        if (name.isNotBlank() && age.isNotBlank()) {
            val ageInt = age.toIntOrNull()
            if (ageInt != null) {
                val user = UserModel(name, ageInt)
                _user.value = user

                _greeting.value = "Hello, $name! You are $ageInt years old."
            }
        } else {
            _greeting.value = "Please enter valid name and age."
        }
    }

}