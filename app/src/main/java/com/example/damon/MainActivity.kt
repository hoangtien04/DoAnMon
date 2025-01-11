package com.example.damon

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.damon.Navigation.NavGraph
import com.example.damon.Screen.LoginScreen
import com.example.damon.Screen.SearchScreen
import com.example.damon.ui.theme.DAMONTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DAMONTheme {

                val navController = rememberNavController()
                NavGraph(navController = navController)

//                Scaffold(modifier = Modifier.fillMaxSize()) {
//                    FullScreenProductList()
 //                   SearchScreen(navController)
//                    EditProfile()
//                    ManagerScreen()
//                    MemberScreen()
//                    RegisterScreen()
 //                  LoginScreen(navController)
//                      CartScreen()
//                }
//                    PayScreen()
            }
        }
    }
}
