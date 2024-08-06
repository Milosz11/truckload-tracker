package com.example.truckloadtracker.data

import com.example.truckloadtracker.model.TruckLoad

object DataSource {
    val truckLoadList = listOf(
        TruckLoad(
            originLocation = "Addison, IL",
            destinationLocation = "Grand Rapids, MI",
            pickupDateTime = "Monday 15 June, 2100",
            deliveryDateTime = "Tuesday 16 June, 0800",
            brokerName = "CH Robinson",
            weight = 36_200,
            rate = 600f
        ),
        TruckLoad(
            originLocation = "Byron Center, MI",
            destinationLocation = "Carol Stream, IL",
            pickupDateTime = "Thursday 18 June, 0700",
            deliveryDateTime = "Thursday 18 June, 1500",
            brokerName = "United Global",
            weight = 24_343,
            rate = 550f
        )
    )
}