package com.alleoni.dsmeta.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alleoni.dsmeta.entities.Sale;
import com.alleoni.dsmeta.services.SaleService;

@RestController  //É o controller que vai disponibilizar os Endpoints para que o frontend acesse as informações.
@RequestMapping(value = "/sales") // Requestmapping serve para mapear e informar qual o valor que será utilizado para acessar as informações.
public class SaleController {

	@Autowired
	private SaleService service; //Da mesma maneira que o Service, precisa do repository. O Controller, precisa do service. Controller > Service > Repository
	
	@GetMapping //
	public List<Sale> findSales(){
		return service.findSales();
	}
}
