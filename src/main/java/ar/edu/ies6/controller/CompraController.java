package ar.edu.ies6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CompraController {

	@GetMapping("/compras")
	public String getIndex() {
		System.out.println("ingreso por aqui IndexCompras");
		return "indexCompra";
	}
}
