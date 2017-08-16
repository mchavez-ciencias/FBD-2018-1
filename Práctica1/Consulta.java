
import java.io.FileNotFoundException;
import java.io.IOException;
import com.csvreader.CsvReader;
import java.util.*;

public class Consulta{

	public Cliente[] leer(){
		Cliente[] clientes = new Cliente[100];
		int i = 0;

        try {
         
        	CsvReader mi_csv = new CsvReader("/home/manuel/Escritorio/FBD-2018-1/Práctica1/P1.csv");
        	mi_csv.readHeaders(); 
         
        	while (mi_csv.readRecord()){

        		Cliente c = new Cliente (mi_csv.get(0),mi_csv.get(1),mi_csv.get(2),mi_csv.get(3),mi_csv.get(4),mi_csv.get(5),mi_csv.get(6));
        		clientes[i]=c;            
            	i += 1;
            
        	}
         
        } catch (FileNotFoundException e) {
           
            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();
        
        }

        return clientes;
	}

	public int consulta1(){

		Cliente[] clientes = leer();
		int contador = 0;

		for (int i = 0 ; i < 100 ; i++){
			
			if ((Double.parseDouble(clientes[i].getMetros()) < 200) && (50000 < Double.parseDouble(clientes[i].getPrecio_Inmueble())) && (Double.parseDouble(clientes[i].getPrecio_Inmueble()) < 500000))
				contador = contador + 1;
		}

		return contador;
	}

	public String consulta2(){
		
		Cliente[] clientes = leer();
		String regresa = "";

		for (int i = 0 ; i < 100 ; i++){
			for (int j = 1 ; j < 100 ; j++){

				if(clientes[i].getNombre().equals(clientes[j].getNombre()) && i != j) {

					regresa = regresa + clientes[i].getNombre() + ", ";
					break;

				}				
			}
		}
		
		return regresa;
		
	}

	public String consulta3(){

		Cliente[] clientes = leer();
		String regresa = "";
		int insercion = 0;
		
		for (int i = 0 ; i < 100 ; i ++){

			Cliente min = clientes [i];

			if( insercion > 9)
				return regresa;

			for(int j = 0; j < 100; j++){

				if(Double.parseDouble(min.getPrecio_Inmueble()) > Double.parseDouble(clientes[j].getPrecio_Inmueble()) && i != j) {
				
					min = clientes[j];
				}
			}

			regresa = regresa + " | " + min.getDireccion();
			min.setPrecio_Inmueble("9999999999");
			insercion += 1;
		}


		return regresa;
	}

	public String consulta4(){

		Cliente[] clientes = leer();
		String regresa = "";
		int contador = 1;
		int insercion = 0;
		
		for (int i = 0 ; i < 100 ; i ++){

			Cliente max = clientes [i];

			if( insercion > 4)
				return regresa;

			for(int j = 0; j < 100; j++){

				if(Double.parseDouble(max.getPrecio_Inmueble()) < Double.parseDouble(clientes[j].getPrecio_Inmueble()) && i != j) {
				
					max = clientes[j];
				}
			}

			for (int k = 0 ; k < 100 ; k++){
				if(max.getDireccion().equals(clientes[k].getDireccion()))
					contador += 1;
			}

			regresa = regresa + " | " + max.getDireccion() + "/" + String.valueOf(contador);
			max.setPrecio_Inmueble("0");
			insercion += 1;
		}


		return regresa;
	}

	public String consulta5(){

		Cliente[] clientes = leer();
		String regresa = "";
		int insercion = 0;
		double mayor_g1 = 0;
		double mayor_g2 = 0;
		
		for (int i = 0 ; i < 100 ; i ++){

			if( insercion > 4)
				return regresa;

			Cliente mayor_ganancia = clientes[i];
			mayor_g1 = Double.parseDouble(clientes[i].getPrecio_Venta()) - Double.parseDouble(clientes[i].getPrecio_Inmueble());

			for(int j = 0; j < 100; j++){

				
				mayor_g2 = Double.parseDouble(clientes[j].getPrecio_Venta()) - Double.parseDouble(clientes[j].getPrecio_Inmueble());

				if(mayor_g1 < mayor_g2 && i != j) {
				
					mayor_ganancia = clientes[j];
				}
			}

			regresa = regresa + " | " + mayor_ganancia.getDireccion();
			mayor_ganancia.setPrecio_Inmueble("1");
			mayor_ganancia.setPrecio_Venta("1");
			insercion += 1;
		}


		return regresa;
	}


	public static void main(String[] args) {
     	

		Consulta c = new Consulta();
		
        System.out.println("El resultado de la primer consulta es: " + c.consulta1() + "\n");
        System.out.println("El resultado de la segunda consulta es: " + c.consulta2() + "\n");
        System.out.println("El resultado de la tercera consulta es: " + c.consulta3() + "\n");
        System.out.println("El resultado de la cuarta consulta es: " + c.consulta4() + "\n");
        System.out.println("El resultado de la quinta consulta es: " + c.consulta5() + "\n");
        
    }
}