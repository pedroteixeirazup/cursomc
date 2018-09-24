package com.example.cursomc.com.example.cursomc.com.example.cursomc.services;

import com.example.cursomc.com.example.cursomc.com.example.cursomc.repositories.CidadeRepository;
import com.example.cursomc.com.example.cursomc.com.example.cursomc.repositories.ClienteRepository;

import com.example.cursomc.com.example.cursomc.com.example.cursomc.repositories.EnderecoRepository;

import com.example.cursomc.com.example.cursomc.com.example.cursomc.services.com.example.cursomc.services.exceptions.DataIntegityException;
import com.example.cursomc.com.example.cursomc.com.example.cursomc.services.com.example.cursomc.services.exceptions.ObjectNotFoundExcepetion;
import com.example.cursomc.com.example.cursomc.domain.Cidade;
import com.example.cursomc.com.example.cursomc.domain.Cliente;
import com.example.cursomc.com.example.cursomc.domain.Cliente;

import com.example.cursomc.com.example.cursomc.domain.Endereco;
import com.example.cursomc.com.example.cursomc.domain.com.example.cursomc.domain.enums.TipoCliente;
import com.example.cursomc.com.example.cursomc.dto.ClienteDTO;
import com.example.cursomc.com.example.cursomc.dto.ClienteNewDTO;
import com.example.cursomc.com.example.cursomc.dto.ClienteDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    @Autowired
    private EnderecoRepository enderecoRepository;

        public Cliente find(Integer id) {
            Optional<Cliente> obj = repo.findById(id);
            return obj.orElseThrow(() -> new ObjectNotFoundExcepetion(
                    "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
        }


    public Cliente update(Cliente obj){
        Cliente newObj = find(obj.getId());
        updateData(newObj,obj);
        return repo.save(newObj);

   }

    @Transactional
    public Cliente insert(Cliente obj){
            obj.setId(null);
            obj = repo.save(obj);
            enderecoRepository.saveAll(obj.getEnderecos());
            return obj;

    }

    public void delete(Integer id){
        find(id);
        try {
            repo.deleteById(id);
        }catch(DataIntegrityViolationException e){

            throw new DataIntegityException("Não é possivel excluir porque há enditades relacionadas.");
        }
    }

    public List<Cliente> findAll(){
        return repo.findAll();
    }

    public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){

        PageRequest pageRequest = PageRequest.of(page,linesPerPage, Sort.Direction.valueOf(direction),orderBy);
        return repo.findAll(pageRequest);
    }

    public Cliente fromDTO(ClienteDTO objDTO){

        return new Cliente(objDTO.getId(),objDTO.getNome(),objDTO.getEmail(),null,null);
    }


    public Cliente fromDTO(ClienteNewDTO objDTO){

            Cliente cli = new Cliente(null,objDTO.getNome(),objDTO.getEmail(),objDTO.getCpfOuCnpj(), TipoCliente.toEnum(objDTO.getTipo()));

            Cidade cid = new Cidade(objDTO.getCidadeId(),null,null);
            Endereco end = new Endereco(null,objDTO.getLogradouro(),objDTO.getNumero(),objDTO.getComplemento(),objDTO
            .getBairro(),objDTO.getCep(),cli,cid);

            cli.getEnderecos().add(end);
            cli.getTelefones().add(objDTO.getTelefone1());

            if(objDTO.getTelefone2()!=null){

                cli.getTelefones().add(objDTO.getTelefone2());
            }
        if(objDTO.getTelefone2()!=null){

            cli.getTelefones().add(objDTO.getTelefone3());
        }

        return cli;
    }

    private void updateData(Cliente newObj,Cliente obj){

        newObj.setNome(obj.getNome());
        newObj.setEmail(obj.getEmail());

    }
}
