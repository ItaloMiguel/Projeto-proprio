package br.com.estudo.pratica.service.impl;

import br.com.estudo.pratica.model.RoleModel;
import br.com.estudo.pratica.repository.RoleModelRepository;
import br.com.estudo.pratica.service.RolesModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolesModelServiceImpl implements RolesModelService {

    @Autowired
    private RoleModelRepository roleModelRepository;

    @Override
    public RoleModel cadastrarNovaRole(RoleModel roleModel) {
        return roleModelRepository.save(roleModel);
    }
}
