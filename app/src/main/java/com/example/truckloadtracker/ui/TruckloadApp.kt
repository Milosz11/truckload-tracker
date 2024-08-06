package com.example.truckloadtracker.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
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
import com.example.truckloadtracker.R
import com.example.truckloadtracker.controller.TruckViewModel
import com.example.truckloadtracker.ui.theme.TruckloadTrackerTheme

@Composable
fun TruckloadApp(
    viewModel: TruckViewModel = viewModel()
) {
    Scaffold(
        topBar = {
            TruckloadTopBar(titleId = R.string.home_screen_title)
        },
        bottomBar = {
            TruckloadBottomBar()
        }
    ) { paddingValues ->
        val uiState by viewModel.uiState.collectAsState()

        Column {
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))
            // List of loads
            LazyColumn(
                contentPadding = paddingValues,
                modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.padding_small))
            ) {
                items(uiState.activeTruckLoadList) { load ->
                    LoadCard(
                        load = load,
                        modifier = Modifier
                            .padding(bottom = dimensionResource(R.dimen.padding_small))
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TruckloadTopBar(
    @StringRes titleId: Int,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = { Text(stringResource(titleId)) },
        modifier = modifier
    )
}

@Composable
fun TruckloadBottomBar(
    modifier: Modifier = Modifier
) {
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
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = dimensionResource(R.dimen.padding_small))
                ) {
                    Text(stringResource(R.string.current_button_text))
                }
                // History button
                OutlinedButton(
                    onClick = { /*TODO*/ },
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
