package com.example.damon

import FullScreenProductList
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.damon.Screen.CartScreen
import com.example.damon.Screen.EditProfile
import com.example.damon.Screen.LoginScreen
import com.example.damon.Screen.ManagerScreen
import com.example.damon.Screen.MemberScreen
import com.example.damon.Screen.RegisterScreen
import com.example.damon.Screen.SearchSceen
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
