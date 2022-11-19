package com.alleoni.dsmeta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alleoni.dsmeta.entities.Sale;
import com.alleoni.dsmeta.repositories.SaleRepository;

@Service // Registrando o SaleService como sendo um componente do sistema
public class SaleService { // Services, será utilizado para fazer as operações de venda. (Operações que buscam do bando de dados as vendas)

	@Autowired // 
	private SaleRepository repository;
	
	public List<Sale> findSales() {
		return repository.findAll();//buscar do banco de dados todas as vendas
	}
	
}
