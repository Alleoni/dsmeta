package com.alleoni.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.alleoni.dsmeta.entities.Sale;
import com.alleoni.dsmeta.repositories.SaleRepository;

@Service // Registrando o SaleService como sendo um componente do sistema
public class SaleService { // Services, será utilizado para fazer as operações de venda. (Operações que
							// buscam do bando de dados as vendas)

	@Autowired //
	private SaleRepository repository;

	/*
	 * public List<Sale> findSales() { return repository.findAll();//buscar do banco
	 * de dados todas as vendas
	 */

	public Page<Sale> findSales(String minDate, String maxDate, Pageable pageable) {
		
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault()); //Criar uma data no dia de hoje
		
		LocalDate min = minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate);
		LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);
		
		//return repository.findAll(min, max, pageable);
		
		return repository.findSales(min, max, pageable);
	}

}
