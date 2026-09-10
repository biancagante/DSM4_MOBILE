package br.edu.fatecpg.applista.dao

import br.edu.fatecpg.applista.model.Usuario

class UsuarioDAO {
    companion object {
        private val usuarios = mutableListOf<Usuario>()

        fun salvar(nome:String) : String {
            usuarios.add(Usuario(nome))
            return "Usuário foi salvo"
        }

        fun buscar() : List<Usuario> {
            return usuarios
        }
    }
}