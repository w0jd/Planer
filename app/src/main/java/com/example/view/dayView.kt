package com.example.view

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.model.UserModel
import com.example.view.shared.menu
import com.example.viewmodel.ActivitesViewModel
import com.example.viewmodel.MainViewModel
class dayView: AppCompatActivity()  {

//    private val  userViewModel: MainViewModel by viewModels()
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()

            setContent{

                var menu= menu()
//                menu.DetailedDrawerExample() {
                    UserDailyActivityScreen(ActivitesViewModel())

//                }
            }
        }

    @Composable
    fun UserDailyActivityScreen(viewModel: ActivitesViewModel= viewModel()   ) {
        var selectedDate by remember { mutableStateOf("") }

        var age by remember { mutableStateOf("") }
        val activitesList  by viewModel.activiesList.collectAsStateWithLifecycle()

        Column(modifier = Modifier.padding(16.dp)) {
            OutlinedTextField(
                value = selectedDate,
                onValueChange = { selectedDate = it },
                label = { Text("Wybierz date") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))

            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { viewModel.showDailyActivities(selectedDate) }) {
                Text("Submit")
            }
            Button(onClick = {}){ Text("test") }
            Spacer(modifier = Modifier.height(16.dp))
            Text(activitesList)
//            rememberDrawerState(DrawerValue.Open)

//

        }

    }
}

