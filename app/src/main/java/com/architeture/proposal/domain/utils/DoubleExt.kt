package com.architeture.proprosal.domain.utils

import java.text.DecimalFormat
import java.util.*

fun Double.toMoney(): String {
    val formatter = DecimalFormat.getInstance() as DecimalFormat
    val locale = Locale("pt", "BR")
    val symbol = Currency.getInstance(locale).symbol
    formatter.maximumFractionDigits = 0
    formatter.decimalFormatSymbols = formatter.decimalFormatSymbols.apply {
        groupingSeparator = '.'
        decimalSeparator = ','
    }
    formatter.positivePrefix = "$symbol "
    formatter.negativePrefix = "- $symbol "
    return formatter.format(this)
}