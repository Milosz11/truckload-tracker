package com.example.truckloadtracker.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.automirrored.outlined.ArrowForward
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.example.truckloadtracker.R
import com.example.truckloadtracker.data.DataSource
import com.example.truckloadtracker.model.TruckLoad
import com.example.truckloadtracker.ui.theme.TruckloadTrackerTheme

@Composable
fun LoadCard(
    load: TruckLoad,
    modifier: Modifier = Modifier
) {
    OutlinedCard(modifier = modifier) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(dimensionResource(R.dimen.padding_small))
                .fillMaxWidth()
        ) {
            // Origin, destination
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = load.originLocation, textAlign = TextAlign.Center)
                Icon(imageVector = Icons.AutoMirrored.Outlined.ArrowForward, contentDescription = null)
                Text(text = load.destinationLocation)
            }
            // Dates, times
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = load.pickupDateTime)
                Text(text = load.deliveryDateTime)
            }
            // Broker name, weight, rate
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = load.brokerName)
                Text(text = load.weight.toString())
                Text(text = load.rate.toString())
            }
        }
    }
}

@Preview
@Composable
fun CardPreview() {
    TruckloadTrackerTheme {
        LoadCard(DataSource.truckLoadList[0])
    }
}
