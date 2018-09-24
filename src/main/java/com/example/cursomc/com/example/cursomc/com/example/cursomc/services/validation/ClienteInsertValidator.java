package com.example.cursomc.com.example.cursomc.com.example.cursomc.services.validation;

import ch.qos.logback.core.net.server.Client;
import com.example.cursomc.com.example.cursomc.com.example.cursomc.repositories.ClienteRepository;
import com.example.cursomc.com.example.cursomc.com.example.cursomc.services.validation.utils.BR;
import com.example.cursomc.com.example.cursomc.domain.Cliente;
import com.example.cursomc.com.example.cursomc.domain.com.example.cursomc.domain.enums.TipoCliente;
import com.example.cursomc.com.example.cursomc.dto.ClienteNewDTO;
import com.example.cursomc.com.example.cursomc.resource.com.excample.cursomc.resource.exception.FieldMessage;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO>

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public void initialize(ClienteInsert ann) {
    }
    @Override
    public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();

        if(objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) && !BR.isValidCPF(objDto.getCpfOuCnpj())){
            list.add(new FieldMessage("cpfOuCnpj","CPF inválido."));
        }

        if(objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) && !BR.isValidCNPJ(objDto.getCpfOuCnpj())){
            list.add(new FieldMessage("cpfOuCnpj","CNPJ inválido."));
        }

        Cliente aux = clienteRepository.findByEmail(objDto.getEmail());

        if(aux != null) {

            list.add(new FieldMessage("email","Email já existente."));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldName()).addConstraintViolation();
        }
        return list.isEmpty();
    }
}