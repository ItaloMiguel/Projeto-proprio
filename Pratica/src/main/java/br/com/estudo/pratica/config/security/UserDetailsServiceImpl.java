package br.com.estudo.pratica.config.security;

import br.com.estudo.pratica.model.UserModel;
import br.com.estudo.pratica.repository.UserModelRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final String USUARIO_NAO_ENCONTRADO = "Usuário não encontrado com nome de usuário: %s";

    private final UserModelRepository userModelRepository;

    public UserDetailsServiceImpl(UserModelRepository userModelRepository) {
        this.userModelRepository = userModelRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel userModel = userModelRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(USUARIO_NAO_ENCONTRADO, username)));
        return new User(userModel.getUsername(), userModel.getPassword(),
                true, true, true, true,
                userModel.getAuthorities());
    }
}
