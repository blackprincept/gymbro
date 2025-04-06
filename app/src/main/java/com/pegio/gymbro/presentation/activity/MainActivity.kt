package com.pegio.gymbro.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.pegio.gymbro.presentation.activity.components.DrawerContent
import com.pegio.gymbro.presentation.activity.components.TopBarContent
import com.pegio.gymbro.presentation.navigation.EntryNavigationHost
import com.pegio.gymbro.presentation.core.theme.GymBroTheme
import com.pegio.gymbro.presentation.navigation.MainNavigationHost
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GymBroTheme {
                val entryNavController = rememberNavController()
                val mainNavController = rememberNavController()

                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                val coroutineScope = rememberCoroutineScope()

                EntryNavigationHost(entryNavController) {
                    AppScaffold(drawerState, viewModel) { innerPadding ->
                        MainNavigationHost(
                            navController = mainNavController,
                            onSetupAppBar = viewModel::updateTopBarState,
                            dynamicallyOpenDrawer = { coroutineScope.launch { drawerState.open() } },
                            modifier = Modifier
                                .padding(innerPadding)
                        )
                    }
                }
            }
        }
    }
}

@Composable
@ExperimentalMaterial3Api
private fun AppScaffold(
    drawerState: DrawerState,
    viewModel: MainViewModel,
    content: @Composable (PaddingValues) -> Unit
) {
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            viewModel.currentUser?.let {
                DrawerContent(
                    displayedUser = it,
                    onAccountClick = { },
                    onSignOutClick = { }
                )
            } ?: DrawerContent(onGoogleAuthClick = { })
        }
    ) {
        Scaffold(
            topBar = { TopBarContent(viewModel.topBarState) },
            snackbarHost = { /* TODO: Snackbar */ },
            content = content
        )
    }
}