package org.iesalandalus.programacion.clientesempresa.modelo.negocio;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.clientesempresa.modelo.dominio.*;

public class Clientes {

	private int capacidad;
	private int tamano;
	private static Cliente [] coleccionClientes;  
	
	/* Constructor, recibirá por parámetro un entero que determinará la capacidad
	* de nuestro array de clientes */
	
	public Clientes(int capacidad) {
		
		
			if (capacidad <= 0) {throw new IllegalArgumentException("ERROR: La capacidad debe ser mayor que cero.");}
			this.capacidad = capacidad;
			this.tamano = 0;
			coleccionClientes = new Cliente[capacidad];
	}
	
	 /* Se crea el método borrar que borrará al cliente pasado como parámetro, 
	 * desplazando hacia la izquierda todas los clientes que estén a su 
	 * derecha en caso de encontrarla, o bien lanzará una excepción en caso 
	 * contrario */
	
	public void borrar(Cliente cliente) throws OperationNotSupportedException {
		
			if (cliente == null) {throw new NullPointerException("ERROR: No se puede borrar un cliente nulo.");	}
			int indice = buscarIndice(cliente);
			if (tamanoSuperado(indice)) {throw new OperationNotSupportedException("ERROR: No existe ningún cliente como el indicado.");	}

			desplazarUnaPosicionHaciaIzquierda(indice);
	}
    
	/* Se crea el método buscar que devolverá la copia del cliente que estamos 
	 * buscando o null en caso de que no la encuentre */
	
	public Cliente buscar(Cliente cliente) {
		
		if (cliente == null) {throw new NullPointerException("ERROR: No se puede buscar un cliente nulo.");}
		Cliente cliente2 = null;
		for(int i=0; i<capacidad;i++)
			{if(cliente.equals(coleccionClientes[i])) {cliente2 = new Cliente(coleccionClientes[i]);}
		}
		return cliente2;
	}
	
	/* Se crea el método buscarIndice que buscará dentro de la colección de 
	 * clientes, al cliente pasado como parámetro y devolverá su índice en el 
	 * caso que lo encuentre o el tamaño más uno en caso de que no lo 
	 * encuentre */
	
	private int buscarIndice(Cliente cliente) {
		
		int pos=-1; 
		for(int i=0; i<coleccionClientes.length; i++) {
			
			if(coleccionClientes[i].equals(cliente)) {
				
				pos=i; 
			}
		}
		
		if(pos==-1) {
			
			return this.tamano+1; 
		}else {
			return pos;
		}
	}
		
	// Se crea el método capacidad superada
	
	private boolean capacidadSuperada(int indice) {
		
		return indice>=this.capacidad;
	}
	
	/* Creamos el método copiaProfundaClientes para realizar un clonado o una
	 * copia idéntica a nuestro array de clientes original. Esto conlleva que 
	 * estamos haciendo una nueva isntancia o referencia al mismo objeto, por
	 * lo que si se modifica algún dato del primer o del segundo array los 
	 * cambios se replican en el otro
	 *  */
	private Cliente[] copiaProfundaClientes() {
		
		Cliente [] coleccionClientes2= coleccionClientes.clone();
		
		return coleccionClientes2;
		
	}
	
	/* Se crea el método desplazarUnaPosicionHaciaIzquierda al que le pasamos 
	 * un índice y desplazará una posición a la izquierda todas los clientes 
	 * de la colección que estén a su derecha */
	
	private void desplazarUnaPosicionHaciaIzquierda(int indice) {
			int i;
			for (i = indice; i < coleccionClientes.length - 1; i++) {
				coleccionClientes[i] = coleccionClientes[i + 1];
			}
			coleccionClientes[i] = null;tamano--;
	}
	
	/* Se crea el método get que devolverá una copia de todos los clientes 
	 * existentes */
	
	public Cliente [] get() {
		
		return coleccionClientes; 
	}
	
	public int getCapacidad() {
		return capacidad;
		
	}
	
	public int getTamano() {
		return tamano;
		
	}
	
	/* Se crea el método insertar que insertará una copia del cliente pasado 
	 * como parámetro detrás del último cliente existente en la colección, 
	 * debiendo lanzar las excepciones pertinentes ante cualquier situación 
	 * anómala */
	
	public void insertar(Cliente cliente) throws OperationNotSupportedException {
		if (cliente == null) {throw new NullPointerException("ERROR: No se puede insertar un cliente nulo.");}	

		if (capacidadSuperada(tamano)) {throw new OperationNotSupportedException("ERROR: No se aceptan más clientes.");
		}
		int indice = buscarIndice(cliente);
		
		if (tamanoSuperado(indice)) {coleccionClientes[tamano] = new Cliente(cliente);}
		 else {throw new OperationNotSupportedException("ERROR: Ya existe un cliente con ese dni.");}
		tamano++;	
	}
        
    // Se crea el método tamaño superado
	
	private boolean tamanoSuperado(int indice) {
			
			return indice>=this.tamano;
	} 
} 
