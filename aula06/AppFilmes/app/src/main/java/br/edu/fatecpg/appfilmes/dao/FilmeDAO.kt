package br.edu.fatecpg.appfilmes.dao

import br.edu.fatecpg.appfilmes.model.Filme

class FilmeDAO {
    companion object {
        private val filmes = mutableListOf<Filme>()

        fun salvar(title : String, gender : String, url : String) : String {
            filmes.add(Filme(title, gender, url))
            return "Filme salvo com sucesso!"
        }

        fun buscar() : List<Filme> {
            return filmes
        }

        fun excluir(title : String, gender : String, url : String) : String {
            filmes.remove(Filme(title, gender, url))
            return "Filme removido com sucesso!"
        }
    }
}