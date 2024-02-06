package ec.edu.ups.ppw63.examenloja.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Operador {
	@Id
	@GeneratedValue
	private int codigo_operador;
	
	private String nombre_operador;

	public int getCodigo_operador() {
		return codigo_operador;
	}

	public void setCodigo_operador(int codigo_operador) {
		this.codigo_operador = codigo_operador;
	}

	public String getNombre_operador() {
		return nombre_operador;
	}

	public void setNombre_operador(String nombre_operador) {
		this.nombre_operador = nombre_operador;
	}
	
	
	
}
