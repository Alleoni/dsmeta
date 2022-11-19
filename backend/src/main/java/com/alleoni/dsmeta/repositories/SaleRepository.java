package com.alleoni.dsmeta.repositories;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.alleoni.dsmeta.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> { // Adicionar JpaRepository<nomeInterface, tipo do
																	// Id>
//Arquivo Criado como Interface. É nos repositories que é feito Update, delete, insert, create etc.

	@Query("SELECT obj FROM Sale obj WHERE obj.date BETWEEN :min AND :max ORDER BY obj.amount DESC")
	Page<Sale> findSales(LocalDate min, LocalDate max, Pageable pageable);
	/*
	 * Seleciona(SELECT) todos os objetos da(FROM) lista Sale, onde(WHERE) as datas
	 * estejam entre(BETWEEN) mínimo(min)e máximo(max). Ordernado(ORDER) por valor
	 * de venda descrescente
	 */

}
