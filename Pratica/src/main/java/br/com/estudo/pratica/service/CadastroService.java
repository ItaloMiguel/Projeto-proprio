package br.com.estudo.pratica.service;

import br.com.estudo.pratica.model.UserModel;

import java.util.UUID;

public interface CadastroService {
    UserModel registrarNovoUser(UserModel userModel);

    UserModel pegarInfoDeUserPorId(UUID id);

    UserModel atualizarPerfil(UserModel userModel);
}
