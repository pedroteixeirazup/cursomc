package com.example.cursomc.com.example.cursomc.com.example.cursomc.services.validation;

import com.example.cursomc.com.example.cursomc.com.example.cursomc.repositories.ClienteRepository;
import com.example.cursomc.com.example.cursomc.com.example.cursomc.services.validation.utils.BR;
import com.example.cursomc.com.example.cursomc.domain.Cliente;
import com.example.cursomc.com.example.cursomc.domain.com.example.cursomc.domain.enums.TipoCliente;
import com.example.cursomc.com.example.cursomc.dto.ClienteDTO;
import com.example.cursomc.com.example.cursomc.resource.com.excample.cursomc.resource.exception.FieldMessage;
import java.util. *;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class ClienteUpdateValidator implements ConstraintValidator<ClienteUpdate, ClienteDTO>{

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public void initialize(ClienteUpdate ann) {
    }
    @Override
    public boolean isValid(ClienteDTO objDto, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();

        Map<String,String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        Integer uriId = Integer.parseInt(map.get("id"));

        Cliente aux = clienteRepository.findByEmail(objDto.getEmail());
        if(aux != null && !aux.getId().equals(uriId)) {

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