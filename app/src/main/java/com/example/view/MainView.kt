package com.example.view
import androidx.lifecycle.viewmodel.compose.viewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
//import com.example.planer.ui.theme.MyMVVMAppTheme
import com.example.viewmodel.MainViewModel
import kotlinx.coroutines.flow.StateFlow
//import androidx.lifecycle.viewmodel.compose.viewModel.uiState
import androidx.lifecycle.viewmodel.compose.viewModel
open class MainView : AppCompatActivity() {
    @Composable
    fun UserInputScreen(viewModel: MainViewModel= viewModel()   ) {
        var name by remember { mutableStateOf("") }
        var age by remember { mutableStateOf("") }
        val greeting  by viewModel.greeting.collectAsStateWithLifecycle()
        Column(modifier = Modifier.padding(16.dp)) {
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Name") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = age,
                onValueChange = { age = it },
                label = { Text("Age") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { viewModel.updateData(name, age) }) {
                Text("Submit")
            }
            Button(onClick = {}){ Text("test")}
            Spacer(modifier = Modifier.height(16.dp))
            Text(greeting)
//            rememberDrawerState(DrawerValue.Open)

//

        }

    }
}
