package br.com.estudo.pratica.service.impl;

import br.com.estudo.pratica.model.UserModel;
import br.com.estudo.pratica.repository.UserModelRepository;
import br.com.estudo.pratica.service.CadastroService;
import br.com.estudo.pratica.service.exception.MyDataIntegrityViolationException;
import br.com.estudo.pratica.service.exception.MyObjectNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CadastroControllerImpl implements CadastroService {

    private final String EMAIL_JA_CADASTRADO = "E-mail já cadastrado no sistema";
    private final String OBJETO_NAO_ENCONTRADO = "Objeto não encontrado";

    private final UserModelRepository userModelRepository;
    private final PasswordEncoder passwordEncoder;

    public CadastroControllerImpl(UserModelRepository userModelRepository, PasswordEncoder passwordEncoder) {
        this.userModelRepository = userModelRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserModel registrarNovoUser(UserModel userModel) {
        verificaSeEmailJaExiste(userModel);
        UserModel userComPasswordCriptografado = criptografarPassword(userModel);
        userModelRepository.save(userComPasswordCriptografado);
        return userComPasswordCriptografado;
    }

    @Override
    public UserModel pegarInfoDeUserPorId(Long id) {
        return userModelRepository.findById(id).orElseThrow(() -> new MyObjectNotFoundException(OBJETO_NAO_ENCONTRADO));
    }

    private UserModel criptografarPassword(UserModel userModel) {
        String passwordCriptografado = passwordEncoder.encode(userModel.getPassword());
        userModel.setPassword(passwordCriptografado);
        return userModel;
    }

    private void verificaSeEmailJaExiste(UserModel userModel) {
        Optional<UserModel> user = userModelRepository.findByEmail(userModel.getEmail());
        if(user.isPresent() && !user.get().getId().equals(userModel.getId())) {
            throw new MyDataIntegrityViolationException(EMAIL_JA_CADASTRADO);
        }
    }
}
