package ec.edu.ups.ppw63.examenloja.business;

import java.util.List;

import ec.edu.ups.ppw63.examenloja.dao.OperadorDao;
import ec.edu.ups.ppw63.examenloja.model.Operador;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionOperador {

	@Inject
	private OperadorDao daoOperador;
	
	public void guardarOperadors(Operador operador) {
		
		Operador ope = daoOperador.read(operador.getCodigo_operador());
		if(ope!= null) {
			daoOperador.update(operador);	
		}else {
			daoOperador.insert(operador); 
		}
		
	}
	
	public void actualizarOperador(Operador operador) throws Exception {
		Operador ope = daoOperador.read(operador.getCodigo_operador());
		if (ope != null){
			daoOperador.update(operador);
		}else {
			throw new Exception("Operador no existe");
		}
	}
	
	
	public void borrarOperador(int codigo) {
		
		daoOperador.remove(codigo); 
	}
	
	public List<Operador> getOperadors(){
		return daoOperador.getAll();
	}
}
