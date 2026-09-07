package br.edu.fatecpg.mobile.kotlin.appimc.model

import br.edu.fatecpg.mobile.kotlin.appimc.R

enum class EnumCategory(val message: String) {
    UNDERWEIGHT ("Baixo peso"),
    IDEAL ("Peso ideal"),
    OVERWEIGHT ("Acima do peso ideal"),
    OBESE_CLASS1 ("Obesidade classe 1"),
    OBESE_CLASS2 ("Obesidade classe 2"),
    OBESE_CLASS3 ("Obesidade classe 3");
}