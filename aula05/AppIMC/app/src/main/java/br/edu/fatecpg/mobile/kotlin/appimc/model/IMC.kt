package br.edu.fatecpg.mobile.kotlin.appimc.model

import android.R
import kotlin.math.pow

data class IMC(
    val height : Double = 0.0,
    val weight : Double = 0.0
) {
    var result : Double = 0.0

    fun getIMCResult() : Double {
        result = weight / (height.pow(2))
        return result
    }

    fun getCategoryResult() : String {
        if (getIMCResult() < 18.5) return EnumCategory.UNDERWEIGHT.message
        else if (getIMCResult() in 18.5 .. 25.0) return EnumCategory.IDEAL.message
        else if (getIMCResult() in 25.0 .. 30.0) return EnumCategory.OVERWEIGHT.message
        else if (getIMCResult() in 30.0 .. 35.0) return EnumCategory.OBESE_CLASS1.message
        else if (getIMCResult() in 35.0 .. 40.0) return EnumCategory.OBESE_CLASS2.message
        else return EnumCategory.OBESE_CLASS3.message
    }
}
