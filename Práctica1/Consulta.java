
import java.io.FileNotFoundException;
import java.io.IOException;
import com.csvreader.CsvReader;
import java.util.*;

public class Consulta{

	public List<Cliente> leer(){
		List<Cliente> clientes = new ArrayList<Cliente>();
		int i = 0;

        try {
         
        	CsvReader mi_csv = new CsvReader("/home/manuel/Escritorio/FBD-2018-1/Práctica1/P1.csv");
        	mi_csv.readHeaders(); 
         
        	while (mi_csv.readRecord()){

        		Cliente ci = new Cliente (mi_csv.get(0),mi_csv.get(1),mi_csv.get(2),mi_csv.get(3),mi_csv.get(4),mi_csv.get(5),mi_csv.get(6));
        		clientes.add(ci);            
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

		List<Cliente> clientes = leer();
		Iterator<Cliente> it= clientes.iterator();

		int contador = 0;
		while (it.hasNext()){
			Cliente cliente = it.next();
			if ((Double.parseDouble(cliente.getMetros()) < 200) && (50000 < Double.parseDouble(cliente.getPrecio_Inmueble())) && (Double.parseDouble(cliente.getPrecio_Inmueble()) < 500000)){
				contador = contador + 1;
			}
		}

		return contador;
	}

	public List<String> consulta2(){
		
		List<Cliente> clientes = leer();
		List<String> regresa = new ArrayList<String>();
		Iterator<Cliente> it= clientes.iterator();
		Iterator<Cliente> it2= clientes.iterator();
		it2.next();

		while (it.hasNext()){
			Cliente cliente = it.next();

			while (it2.hasNext()){
				Cliente cliente2 = it2.next();
				if(cliente.getNombre() == cliente2.getNombre()){
					regresa.add(cliente.getNombre());
					break;
				}
				
			}
		}
		
		return regresa;
		
	}

	public static void main(String[] args) {
     	

		Consulta c = new Consulta();
		
        System.out.println("El resultado de la primer consulta es: " + c.consulta1());
        System.out.println("El resultado de la segunda consulta es: " + c.consulta2());
        //System.out.println("El resultado de la tercera consulta es: " + consulta3(clientes));
        //System.out.println("El resultado de la cuarta consulta es: " + consulta4(clientes));
        //System.out.println("El resultado de la quinta consulta es: " + consulta5(clientes));
    }
}