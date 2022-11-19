package com.alleoni.dsmeta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alleoni.dsmeta.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> { // Adicionar JpaRepository<nomeInterface, tipo do Id>
//Arquivo Criado como Interface. É nos repositories que é feito Update, delete, insert, create etc.

	
	
}
