package br.com.estudo.pratica.service;

import br.com.estudo.pratica.model.UserModel;

public interface CadastroService {
    UserModel registrarNovoUser(UserModel userModel);

    UserModel pegarInfoDeUserPorId(Long id);
}
