package com.example.cursomc.com.example.cursomc.com.example.cursomc.repositories;

import com.example.cursomc.com.example.cursomc.domain.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {


}
