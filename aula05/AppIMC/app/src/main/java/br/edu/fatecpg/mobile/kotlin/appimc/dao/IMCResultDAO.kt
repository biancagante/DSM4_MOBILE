package br.edu.fatecpg.mobile.kotlin.appimc.dao

import br.edu.fatecpg.mobile.kotlin.appimc.model.EnumCategory
import br.edu.fatecpg.mobile.kotlin.appimc.model.IMC
import kotlin.math.nextUp
import kotlin.math.pow
import kotlin.math.round

class IMCResultDAO {
    companion object {
        private var ImcObj = IMC()
        private var ImcResult = 0.0
        private var ImcCategory: String = EnumCategory.IDEAL.toString()

        fun save(height : Double, weight : Double) : String {
            ImcObj = IMC(height, weight)
            ImcResult = ImcObj.getIMCResult()
            ImcCategory = ImcObj.getCategoryResult()
            return "IMC Salvo com sucesso!"
        }

        fun result() : Double {
            return round(ImcResult)
        }

        fun category() : String {
            return ImcCategory
        }
    }
}