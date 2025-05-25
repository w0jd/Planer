package com.example.planer
//import com.example.view.MainView
//import kotlin.io.Serializable
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Database
import androidx.sqlite.db.SupportSQLiteDatabase
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.example.model.UserModel
import com.example.view.MainView
import com.example.view.shared.menu
import com.example.viewmodel.MainViewModel
import kotlinx.serialization.Serializable
import com.example.view.dayView
import com.example.viewmodel.TarvelViewModel

class MainActivity : AppCompatActivity() {
//    private val  userViewModel: MainViewModel by viewModels()
//    obiekty Ścieżek
@Serializable
object UserInput
@Serializable
object DailyActivities
override fun onCreate(savedInstanceState: Bundle?) {
        //        val navController = rememberNavController()

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

            setContent{

                val navController = rememberNavController()
                NavHost(navController=navController, startDestination  = UserInput){
                    val menu=menu()
                    composable<UserInput> {
                        val MainView=MainView()
                        menu.DetailedDrawerExample(navController) { paddingValues ->
                            MainView.UserInputScreen(MainViewModel(UserModel("",0)))
                        }
                    }
                    composable<DailyActivities>{
                        val dayView= dayView()
                        menu.DetailedDrawerExample(navController) { paddingValues ->
                        dayView.TravelsScreen(TarvelViewModel())
                        }
                    }
                }

//                var menu=menu()
//
////                menu.DetailedDrawerExample { paddingValues ->
////                    UserInputScreen(MainViewModel(UserModel("",0)))
////
////                }
            }

//        }
    }

}