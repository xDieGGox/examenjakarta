package ec.edu.ups.ppw63.examenloja.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Recarga {
	
	@Id
	private int codigo_recarga;
	
	private String numero_recarga;
	
	private int monto_recarga;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="codigo_operador")
	private Operador operador;


	public int getCodigo_recarga() {
		return codigo_recarga;
	}


	public void setCodigo_recarga(int codigo_recarga) {
		this.codigo_recarga = codigo_recarga;
	}


	public String getNumero_recarga() {
		return numero_recarga;
	}


	public void setNumero_recarga(String numero_recarga) {
		this.numero_recarga = numero_recarga;
	}


	public int getMonto_recarga() {
		return monto_recarga;
	}


	public void setMonto_recarga(int monto_recarga) {
		this.monto_recarga = monto_recarga;
	}


	public Operador getOperador() {
		return operador;
	}


	public void setOperador(Operador operador) {
		this.operador = operador;
	}
	
	
	
	
}
