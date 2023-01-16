package org.iesalandalus.programacion.clientesempresa.modelo.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Cliente {

		private static final String ER_CORREO="^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$";
        private static final String ER_DNI="\\d{8}[A-Za-z]";
		private static final String ER_TELEFONO="\\d{9}";
		private static final DateTimeFormatter FORMATO_FECHA=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		private String nombre; 
		private String dni;
		private String correo; 
		private String telefono; 
		private LocalDate fechaNacimiento; 
		
		/* Constructor Copia, se le invoca introduciendo un parámetro (objeto) de 
		 * tipo Cliente que se haya creado previamente para copiarlo */
		
		public Cliente(Cliente cliente) {
		
			if (cliente==(null)) {
				throw new NullPointerException("ERROR: No es posible copiar un cliente nulo.");
			}
			
			this.nombre=cliente.getNombre();
			this.dni=cliente.getDni();	
			this.correo=cliente.getCorreo();	
			this.telefono=cliente.getTelefono();
			this.fechaNacimiento=cliente.getFechaNacimiento();
				
		}
		
		/* Constructor normal con parámetros, que darán un valor inicial a los 
		 * atributos de clase */
		
		public Cliente(String nombre, String dni, String correo, String telefono, LocalDate fechaNacimiento) {
			
			setNombre(nombre); 
			setDni(dni); 
			setCorreo(correo); 
			setTelefono(telefono);
			setFechaNacimiento(fechaNacimiento);
		}
		
		/* Se crea el método comprobarLetraDni. Este método hará uso de los grupos de las 
		 * expresiones regulares (para ello has debido definir la expresión regular con grupos)
		 * para quedarse con el número por un lado y con la letra por otro */
		
		private boolean comprobarLetraDni(String dni) {
	
			String dniConFormato=dni.toUpperCase();
			int numeroDni=Integer.parseInt(dniConFormato.substring(0, 8)); 
			int resto=(numeroDni%23); 
			char letraDni=dniConFormato.charAt(8); 
			
			if(dniConFormato.matches(ER_DNI)
					&& (resto==0) && letraDni=='T') {
				return true; 
			}else if(dniConFormato.matches(ER_DNI)
						&& (resto==1) && letraDni=='R') {
				return true; 
			}else if(dniConFormato.matches(ER_DNI)
						&& (resto==2) && letraDni=='W') {
				return true; 
			}else if(dniConFormato.matches(ER_DNI)
						&& (resto==3) && letraDni=='A') {
				return true; 
			}else if(dniConFormato.matches(ER_DNI)
						&& (resto==4) && letraDni=='G') {
				return true; 
			}else if(dniConFormato.matches(ER_DNI)
						&& (resto==5) && letraDni=='M') {
				return true; 
			}else if(dniConFormato.matches(ER_DNI)
						&& (resto==6) && letraDni=='Y') {
				return true; 
			}else if(dniConFormato.matches(ER_DNI)
						&& (resto==7) && letraDni=='F') {
				return true; 
			}else if(dniConFormato.matches(ER_DNI)
						&& (resto==8) && letraDni=='P') {
				return true; 
			}else if(dniConFormato.matches(ER_DNI)
						&& (resto==9) && letraDni=='D') {
				return true; 
			}else if(dniConFormato.matches(ER_DNI)
						&& (resto==10) && letraDni=='X') {
				return true; 
			}else if(dniConFormato.matches(ER_DNI)
						&& (resto==11) && letraDni=='B') {
				return true; 
			}else if(dniConFormato.matches(ER_DNI)
						&& (resto==12) && letraDni=='N') {
				return true; 
			}else if(dniConFormato.matches(ER_DNI)
						&& (resto==13) && letraDni=='J') {
				return true; 
			}else if(dniConFormato.matches(ER_DNI)
						&& (resto==14) && letraDni=='Z') {
				return true; 
			}else if(dniConFormato.matches(ER_DNI)
						&& (resto==15) && letraDni=='S') {
				return true; 
			}else if(dniConFormato.matches(ER_DNI)
						&& (resto==16) && letraDni=='Q') {
				return true; 
			}else if(dniConFormato.matches(ER_DNI)
						&& (resto==17) && letraDni=='V') {
				return true; 
			}else if(dniConFormato.matches(ER_DNI)
						&& (resto==18) && letraDni=='H') {
				return true; 
			}else if(dniConFormato.matches(ER_DNI)
						&& (resto==19) && letraDni=='L') {
				return true; 
			}else if(dniConFormato.matches(ER_DNI)
						&& (resto==20) && letraDni=='C') {
				return true; 
			}else if(dniConFormato.matches(ER_DNI)
						&& (resto==21) && letraDni=='K') {
				return true; 
			}else if(dniConFormato.matches(ER_DNI)
						&& (resto==22) && letraDni=='E') {
				return true; 
			}else
				return false;
		}
		
		/* Se crean los métodos equals y hashCode, sabiendo que dos clientes se 
		 * considerarán iguales si su DNI es el mismo */
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Cliente other = (Cliente) obj;
			return Objects.equals(dni, other.dni);
		}
		
		/* Se crea el método formateaNombre. Este método debe normalizar un nombre eliminando
		 *  caracteres en blanco de sobra y poniendo en mayúsculas la primera letra de cada 
		 *  palabra y en minúsculas las demás */
		
		private String formateaNombre(String nombre) {
			
			String stg="";
			
			char c=' ';
			int aux=0;
			
			for(int i=0; i<nombre.length(); i++) {
				
				c=nombre.charAt(i); 
				
				if(i==0) {
					
					c=Character.toUpperCase(c);
				}
				
				if(i>=1) {
					
					c=Character.toLowerCase(c);
				}
				
				if(c==' ') {
					
					aux=(i+1); 
				}
				
				if(aux==i) {
					
					c=Character.toUpperCase(c);
				}
				stg+=c;
			}
			
			String resultado=stg.trim();
			return resultado;
		}
		
		// Método hash code
		
		@Override
		public int hashCode() {
			return Objects.hash(ER_CORREO, ER_DNI, ER_TELEFONO, FORMATO_FECHA, correo, dni, fechaNacimiento, nombre,
					telefono);
		}

		public String getCorreo() {
			return correo;
		}
		
		public String getDni() {
			return dni;
		}
		
		public LocalDate getFechaNacimiento() {
			return fechaNacimiento;
		}
		
		private String getIniciales() {
			
			getNombre(); 
			
			String resultado="" + getNombre().charAt(0);
			
			for(int i=1; i<getNombre().length(); i++) {
				
				if(getNombre().charAt(i-1)==' ') {
					resultado+=getNombre().charAt(i);
				}
			}
			
			return resultado; 
		}
		
		public String getNombre() {
			return nombre;
		}
		
		public String getTelefono() {
			return telefono;
		}
		
		public void setCorreo(String correo) {
			
			if (correo == null) {throw new NullPointerException("ERROR: El correo de un cliente no puede ser nulo.");}
			if (!correo.matches(ER_CORREO)) {throw new IllegalArgumentException("ERROR: El correo del cliente no tiene un formato válido.");		}
			this.correo = correo;
		}
		
		private void setDni(String dni) {
			
			if (dni == null) {throw new NullPointerException("ERROR: El dni de un cliente no puede ser nulo.");}
			String dni1 = dni;
			dni1.replaceAll("\\W","");
			dni1.toUpperCase();
			if (!dni1.matches(ER_DNI)) {throw new IllegalArgumentException("ERROR: El dni del cliente no tiene un formato válido.");}		
			if(!comprobarLetraDni(dni1)) {throw new IllegalArgumentException("ERROR: La letra del dni del cliente no es correcta.");}		
			this.dni = dni1;
		}
		
		private void setFechaNacimiento(LocalDate fechaNacimiento) {	
			if (fechaNacimiento == null) {throw new NullPointerException("ERROR: La fecha de nacimiento de un cliente no puede ser nula.");}
			this.fechaNacimiento = fechaNacimiento;
		}
		
		public void setNombre(String nombre) {
			
			if(nombre==null) {
				
				throw new NullPointerException("ERROR: El nombre de un cliente no puede ser nulo.");
			}else if (nombre.trim().isEmpty()) {
				
				throw new IllegalArgumentException("ERROR: El nombre de un cliente no puede estar vacío.");
			}else 
				this.nombre = formateaNombre(nombre);
		}
		
		public void setTelefono(String telefono) {
			
			if (telefono == null) {throw new NullPointerException("ERROR: El teléfono de un cliente no puede ser nulo.");}
			if (!telefono.matches(ER_TELEFONO)) {throw new IllegalArgumentException("ERROR: El teléfono del cliente no tiene un formato válido.");}
			this.telefono = telefono;
		}
		
		/* Se crea el método toString. Este método devolverá una cadena representando la 
		 * información de los diferentes atributos, pero para el caso del nombre le 
		 * antepondrá sus iniciales encerradas en paréntesis */
		
		@Override
		public String toString() {
			return "nombre=" + nombre + " (" + getIniciales() + ")" + ", DNI=" + dni + ", correo=" + correo + ", teléfono="
					+ telefono + ", fecha nacimiento=" + fechaNacimiento.format(FORMATO_FECHA);
		}
}
