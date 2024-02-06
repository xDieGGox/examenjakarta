package ec.edu.ups.ppw63.examenloja.business;

import java.util.List;

import ec.edu.ups.ppw63.examenloja.dao.OperadorDao;
import ec.edu.ups.ppw63.examenloja.dao.RecargaDAO;
import ec.edu.ups.ppw63.examenloja.model.Operador;
import ec.edu.ups.ppw63.examenloja.model.Recarga;
import ec.edu.ups.ppw63.examenloja.model.Recargarecibo;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionRecargas {
	
	@Inject
	private RecargaDAO daoRecarga;
	
	@Inject
	private OperadorDao daoOperador;
	
	public void guardarRecargas(Recargarecibo recargarecibo) throws Exception {
	    System.out.println("RECARGA RECIBIDA:" + recargarecibo);

	    // Validar si el número de recarga tiene 10 dígitos y empieza con cero
	    String numeroRecarga = recargarecibo.getNumero_recargarecibo();
	    if (numeroRecarga.length() == 10 && numeroRecarga.startsWith("0")) {
	        Recarga rec = daoRecarga.read(recargarecibo.getCodigo_recargarecibo());

	        if (rec != null) {
	           
	        } else {
	            Recarga recarga = new Recarga();
	            Operador operador = daoOperador.read(recargarecibo.getCodigo_operador_recargarecibo());
	            recarga.setCodigo_recarga(recargarecibo.getCodigo_recargarecibo());
	            recarga.setNumero_recarga(recargarecibo.getNumero_recargarecibo());
	            recarga.setMonto_recarga(recargarecibo.getMonto_recargarecibo());
	            recarga.setOperador(operador);

	            daoRecarga.insert(recarga);
	        }
	    } else {
	        System.out.println("El número de recarga no cumple con los requisitos.");
	        throw new Exception("El número de recarga no cumple con los requisitos.");
	        
	    }
	}
	
	
	public void actualizarRecarga(Recarga recarga) throws Exception {
		Recarga rec = daoRecarga.read(recarga.getCodigo_recarga());
		if (rec != null){
			daoRecarga.update(recarga);
		}else {
			throw new Exception("Recarga no existe");
		}
	}

	
	public void borrarRecarga(int codigo) {
		
		daoRecarga.remove(codigo); 
	}
	
	public List<Recarga> getRecargas(){
		return daoRecarga.getAll();
	}
}
