package com.example.truckloadtracker.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.truckloadtracker.R
import com.example.truckloadtracker.controller.TruckViewModel
import com.example.truckloadtracker.model.TruckLoad
import com.example.truckloadtracker.ui.theme.TruckloadTrackerTheme

enum class TruckloadScreen(@StringRes val titleId: Int) {
    CurrentLoads(titleId = R.string.current_loads_screen_title),
    ArchivedLoads(titleId = R.string.archived_loads_screen_title),
    CreateALoad(titleId = R.string.create_load_screen_title)
}

@Composable
fun TruckloadApp(
    viewModel: TruckViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = TruckloadScreen.valueOf(
        backStackEntry?.destination?.route ?: TruckloadScreen.CurrentLoads.name
    )

    Scaffold(
        topBar = {
            TruckloadTopBar(
                currentScreen = currentScreen,
                canNavigateUp = currentScreen == TruckloadScreen.CreateALoad,
                onNavigateUp = { navController.popBackStack() }
            )
        },
        bottomBar = {
            if (currentScreen == TruckloadScreen.CurrentLoads ||
                    currentScreen == TruckloadScreen.ArchivedLoads) {
                TruckloadBottomBar(
                    currentScreen = currentScreen,
                    onCurrentButtonClick = {
                        navController.navigate(TruckloadScreen.CurrentLoads.name)
                    },
                    onHistoryButtonClick = {
                        navController.navigate(TruckloadScreen.ArchivedLoads.name)
                    }
                )
            }
        },
        floatingActionButton = {
            if (currentScreen != TruckloadScreen.CreateALoad) {
                SmallFloatingActionButton(onClick = { navController.navigate(TruckloadScreen.CreateALoad.name) }) {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = stringResource(R.string.add_a_new_load)
                    )
                }
            }
        }
    ) { paddingValues ->
        val uiState by viewModel.uiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = TruckloadScreen.CurrentLoads.name
        ) {
            // Home screen - active loads
            composable(TruckloadScreen.CurrentLoads.name) {
                LoadListLayout(
                    listToDisplay = uiState.activeTruckLoadList.toList(),
                    paddingValues = paddingValues
                )
            }
            // Archived loads
            composable(TruckloadScreen.ArchivedLoads.name) {
                LoadListLayout(
                    listToDisplay = uiState.archivedTruckLoadList.toList(),
                    paddingValues = paddingValues
                )
            }
            // Create a new load
            composable(TruckloadScreen.CreateALoad.name) {
                /* TODO */
            }
        }
    }
}

@Composable
fun LoadListLayout(
    listToDisplay: List<TruckLoad>,
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))
        // List of loads
        LazyColumn(
            contentPadding = paddingValues,
            modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.padding_small))
        ) {
            items(listToDisplay) { load ->
                LoadCard(
                    load = load,
                    modifier = Modifier
                        .padding(bottom = dimensionResource(R.dimen.padding_small))
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TruckloadTopBar(
    currentScreen: TruckloadScreen,
    canNavigateUp: Boolean,
    onNavigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = { Text(stringResource(currentScreen.titleId)) },
        modifier = modifier,
        navigationIcon = {
            if (canNavigateUp) {
                IconButton(onClick = onNavigateUp) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back)
                    )
                }
            }
        }
    )
}

@Composable
fun TruckloadBottomBar(
    currentScreen: TruckloadScreen,
    onCurrentButtonClick: () -> Unit,
    onHistoryButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val selectedButtonColors = ButtonColors(
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary,
        disabledContainerColor = MaterialTheme.colorScheme.surface,
        disabledContentColor = MaterialTheme.colorScheme.onSurface
    )
    val unselectedButtonColors = ButtonColors(
        containerColor = MaterialTheme.colorScheme.secondary,
        contentColor = MaterialTheme.colorScheme.onSecondary,
        disabledContainerColor = MaterialTheme.colorScheme.surface,
        disabledContentColor = MaterialTheme.colorScheme.onSurface
    )

    BottomAppBar(
        modifier = modifier,
        actions = {
            // Current and History buttons
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                // Current button
                OutlinedButton(
                    onClick = onCurrentButtonClick,
                    colors = if (currentScreen == TruckloadScreen.CurrentLoads) {
                        selectedButtonColors
                    } else {
                        unselectedButtonColors
                    },
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = dimensionResource(R.dimen.padding_small))
                ) {
                    Text(stringResource(R.string.current_button_text))
                }
                // History button
                OutlinedButton(
                    onClick = onHistoryButtonClick,
                    colors = if (currentScreen == TruckloadScreen.ArchivedLoads) {
                        selectedButtonColors
                    } else {
                        unselectedButtonColors
                    },
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = dimensionResource(R.dimen.padding_small))
                ) {
                    Text(stringResource(R.string.history_button_text))
                }
            }
        }
    )
}

@Preview
@Composable
fun TruckloadAppPreview() {
    TruckloadTrackerTheme {
        TruckloadApp()
    }
}
