package com.ui.mobilebankingui.data

import androidx.compose.ui.graphics.vector.ImageVector
import java.util.Date

data class Currency(
    val name : String,
    val price : Float,
    val date :  String,
    val icon : ImageVector
)
