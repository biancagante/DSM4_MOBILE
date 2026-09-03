package br.edu.fatecpg.appdao.dao

import br.edu.fatecpg.appdao.model.Produto

// Controller do produto que será adicionado.
class ProdutoDAO {
    companion object {
        private var meuProduto = Produto()

        fun salvar (nome:String, preco: Double) : String {
            meuProduto = Produto(nome, preco)
            return "Produto salvo"
        }

        fun buscar() : Produto {
            return meuProduto
        }
    }
}
