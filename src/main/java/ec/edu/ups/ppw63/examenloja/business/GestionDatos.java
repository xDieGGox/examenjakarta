package ec.edu.ups.ppw63.examenloja.business;

import ec.edu.ups.ppw63.examenloja.dao.OperadorDao;
import ec.edu.ups.ppw63.examenloja.model.Operador;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class GestionDatos {
	
	@Inject
	private OperadorDao daoOperador;
	
	@PostConstruct
	public void init() {
		System.out.println("Iniciando programa");
		
		Operador operador = new Operador();
		operador.setNombre_operador("Claro");
		
		daoOperador.insert(operador); 
		
		Operador operador1 = new Operador();
		operador1.setNombre_operador("Movistar");
		
		daoOperador.insert(operador1);
	}
}
