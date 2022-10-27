package br.com.estudo.pratica.controller;

import br.com.estudo.pratica.model.UserModel;
import br.com.estudo.pratica.model.dto.UserModelDTO;
import br.com.estudo.pratica.service.CadastroService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/home")
public class CadastroController {

    private final CadastroService cadastroService;
    private final ModelMapper modelMapper;

    public CadastroController(CadastroService cadastroService, ModelMapper modelMapper) {
        this.cadastroService = cadastroService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<UserModel> registrarNovoUser(@RequestBody UserModel userModel) {
        UserModel userModel1 = cadastroService.registrarNovoUser(userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userModel1);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<UserModelDTO> pergarInformacoesDeLogin(@PathVariable UUID id) {
        UserModel userModel = cadastroService.pegarInfoDeUserPorId(id);
        UserModelDTO userModelDTO = transformaEmDTO(userModel);
        return ResponseEntity.ok().body(userModelDTO);
    }

    @PutMapping("/atualizar")
    public ResponseEntity<UserModelDTO> atualizarPerfil(@RequestBody UserModel userModel) {
        UserModel newUserModel = cadastroService.atualizarPerfil(userModel);
        UserModelDTO userModelDTO = transformaEmDTO(newUserModel);
        return ResponseEntity.status(HttpStatus.UPGRADE_REQUIRED).body(userModelDTO);
    }


    private UserModelDTO transformaEmDTO(UserModel userModel) {
        UserModelDTO userModelDTO = modelMapper.map(userModel, UserModelDTO.class);
        return userModelDTO;
    }

}
