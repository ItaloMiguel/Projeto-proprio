package br.com.estudo.pratica.controller;

import br.com.estudo.pratica.model.RoleModel;
import br.com.estudo.pratica.model.dto.RoleModelDTO;
import br.com.estudo.pratica.service.RolesModelService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
public class RolesController {

    private final RolesModelService rolesModelService;
    private final ModelMapper modelMapper;

    public RolesController(RolesModelService rolesModelService, ModelMapper modelMapper) {
        this.rolesModelService = rolesModelService;
        this.modelMapper = modelMapper;
    }


    @PostMapping
    public ResponseEntity<RoleModelDTO> cadastrarNovaRole(@RequestBody RoleModel roleModel) {
        RoleModel obj = rolesModelService.cadastrarNovaRole(roleModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(transformaEmDTO(obj));
    }

    private RoleModelDTO transformaEmDTO(RoleModel roleModel) {
        RoleModelDTO roleModelDTO = modelMapper.map(roleModel, RoleModelDTO.class);
        return roleModelDTO;
    }
}
