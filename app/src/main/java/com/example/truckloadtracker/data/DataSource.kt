package com.example.truckloadtracker.data

import com.example.truckloadtracker.model.TruckLoad
import java.time.ZoneId
import java.time.ZonedDateTime

object DataSource {
    val truckLoadList = listOf(
        TruckLoad(
            originLocation = "Addison, IL",
            destinationLocation = "Grand Rapids, MI",
            pickupDateTime = ZonedDateTime.of(2024, 8, 7, 6, 0, 0, 0, ZoneId.systemDefault()),
            deliveryDateTime = ZonedDateTime.of(2024, 8, 7, 13, 30, 0, 0, ZoneId.systemDefault()),
            brokerName = "CH Robinson",
            weight = 36_200,
            rate = 600f
        ),
        TruckLoad(
            originLocation = "Byron Center, MI",
            destinationLocation = "Carol Stream, IL",
            pickupDateTime = ZonedDateTime.of(2024, 8, 13, 19, 30, 0, 0, ZoneId.systemDefault()),
            deliveryDateTime = ZonedDateTime.of(2024, 8, 14, 6, 0, 0, 0, ZoneId.systemDefault()),
            brokerName = "United Global",
            weight = 24_343,
            rate = 550f
        )
    )
}
