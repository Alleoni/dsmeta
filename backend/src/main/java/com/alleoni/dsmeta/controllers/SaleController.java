package com.alleoni.dsmeta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alleoni.dsmeta.entities.Sale;
import com.alleoni.dsmeta.services.SaleService;
import com.alleoni.dsmeta.services.SmsService;

@RestController // É o controller que vai disponibilizar os Endpoints para que o frontend acesse
				// as informações.
@RequestMapping(value = "/sales") // Requestmapping serve para mapear e informar qual o valor que será utilizado
									// para acessar as informações.
public class SaleController {

	@Autowired
	private SaleService service; // Da mesma maneira que o Service, precisa do repository. O Controller, precisa
									// do service. Controller > Service > Repository
	@Autowired
	private SmsService smsService;

	/*
	 * @GetMapping //Operações que tem para fazer uma requisição (Get serve para
	 * obter). public List<Sale> findSales(){ return service.findSales();
	 */

	@GetMapping // Operações que tem para fazer uma requisição (Get serve para obter).
	public Page<Sale> findSales(
			@RequestParam(value = "minDate", defaultValue = "") String minDate,
			@RequestParam(value = "maxDate", defaultValue = "") String maxDate,
			Pageable pageable) {
		return service.findSales(minDate, maxDate, pageable);
		/*
		 * Page e Pageable serve para buscar do banco de dados paginado, ou seja, com
		 * menos linha por soliciação, por padrão, será retornado 20 linhas.
		 */
	}
	
	@GetMapping("/{id}/notification")
	public void notifySms(@PathVariable Long id) {
		smsService.sendSms(id);
	}
	
}
