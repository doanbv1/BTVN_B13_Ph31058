package com.ph31058.btvn_b13_ph31058

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ph31058.btvn_b13_ph31058.repository.Repository
import com.ph31058.btvn_b13_ph31058.room.StudentsDB
import com.ph31058.btvn_b13_ph31058.viewmodel.StudentViewModel


@Composable
fun HomeScreen() {
    val context = LocalContext.current
    val db = StudentsDB.getIntance(context)
    val repository = Repository(db)
    val myViewModel = StudentViewModel(repository)
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "Main"){
        composable("Main"){ MainScreen(viewModel = myViewModel, navController)}
        composable("Card/{studentId}/{hoTen}/{mssv}/{diemTB}/{daRaTruong}"){
            com.ph31058.btvn_b13_ph31058.CardScreen(
                navController,
                viewModel = myViewModel,
                studentId = it.arguments?.getString("studentId"),
                hoTen = it.arguments?.getString("hoTen"),
                mssv = it.arguments?.getString("mssv"),
                diemTB = it.arguments?.getString("diemTB"),
                daRaTruong = it.arguments?.getString("daRaTruong")
            )
        }

    }
}