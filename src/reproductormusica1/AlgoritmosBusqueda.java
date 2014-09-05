package reproductormusica1;

/**
* Esta clase permite la busqueda de datos utilizando la clase Datos
*/

public class AlgoritmosBusqueda{

	Datos cajaDatos;

	public AlgoritmosBusqueda(Datos cajaDatos){

		this.cajaDatos = cajaDatos;

	}

	public String buscarCancion(String nombre, int tipo){

		for(int contador = 1;contador < this.cajaDatos.getTamaño();contador++){
			String variable = this.cajaDatos.obtenerDatos(contador)[tipo];

			if(variable == nombre){
                                System.out.println("Se ha localizado con exito");

				return this.cajaDatos.obtenerDatos(contador)[tipo];
			}
		}
		return null;
	}
        /*public static void main(String[] args){
            String[] array = new String [3];//{"R","N","A"};
            String[] array1 = {"","",""};
            array[0]="R";
            array[1]="Naaaa";
            array[2]="A";
                    
            Datos a = new Datos(array1);
            a.añadirDatos(array);
            //a.añadirDatos(array);
            AlgoritmosBusqueda b = new AlgoritmosBusqueda(a);
            if(b.buscarCancion("Naaaa", 1)!=null)
                            System.out.println("Entro");

            
            
            
            
        }
*/
}
