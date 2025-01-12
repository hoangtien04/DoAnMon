package com.example.damon

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.damon.Navigation.NavGraph
import com.example.damon.Screen.EditProfile
import com.example.damon.Screen.LoginScreen
import com.example.damon.Screen.ManagerScreen
import com.example.damon.Screen.MemberScreen
import com.example.damon.Screen.ProductList
import com.example.damon.Screen.RegisterScreen
import com.example.damon.ui.theme.DAMONTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DAMONTheme {

//                val navController = rememberNavController()
//                NavGraph(navController = navController)
                ProductList()
//                Scaffold(modifier = Modifier.fillMaxSize()) {
//                    FullScreenProductList()
//                    SearchSceen()
//                    EditProfile()
//                    ManagerScreen()
//                    MemberScreen()
//                    RegisterScreen()
//                    LoginScreen()
//                CartScreen()
//                }

            }
        }
    }
}
