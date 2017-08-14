
import java.io.FileNotFoundException;
import java.io.IOException;
import com.csvreader.CsvReader;
import java.util.*;

public class Consulta{

	 public static void main(String[] args) {
     	


		List<Cliente> clientes = new ArrayList<Cliente>();
		int i = 0;

        try {
         
        	CsvReader mi_csv = new CsvReader("/home/manuel/Descargas/Practica01/P1.csv");
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
    }


}