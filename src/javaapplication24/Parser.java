package javaapplication24;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author ricardo
 */
public class Parser {
    public void parser(String nombredearchivo) {
        
        try ( //Abro el stream, el fichero debe existir
            FileReader fr = new FileReader(nombredearchivo)) {
                //Leemos el fichero y lo mostramos por pantalla
            
            int valor=fr.read()
                    ;
            String acumulador="";
            while(valor!=-1){
                if((char)valor=='@'){
                    System.out.println(acumulador);
                    acumulador="";
                }
                if((char)valor!='@'){
                    acumulador = acumulador+(char)valor;
                    //System.out.println("ppppppppp");
                } else {
                    System.out.println(acumulador+"Esta en el acumulador");
                    //acumulador=" ";
                    
                    
                }
                //System.out.print((char)valor);
                valor=fr.read();
                }
            }
        catch(Exception a){
            System.out.println("Lista no encontrada");
        }
    
    }
        public Datos parserD(String nombredearchivo) throws FileNotFoundException{
        Archivos x = new Archivos();
        String c=x.obtenerDireccion("FilesMusic");
        String direccionenparser=c;
        
        String[] arreglo= {"","","","","","",""};
        Datos lista2=new Datos(arreglo);
        MetaDatos1 metainfo=new MetaDatos1();
        try ( //Abro el stream, el fichero debe existir
            FileReader fr = new FileReader(nombredearchivo)) {
                //Leemos el fichero y lo mostramos por pantalla
            
            int valor=fr.read()
                    ;
            String acumulador="";
            while(valor!=-1){
                if((char)valor=='@'){
                    	// El arreglo debe tener 5 o más posiciones en donde:
                    // Posicion 0 -> ruta
                    // Posicion 1 -> nombre
                    // Posicion 2 -> artista
                    // Posicion 3 -> album
                    // Posicion 4 -> genero
                    // Posicion 5 o más -> PlayList
                    metainfo.agregarc(acumulador);
                    arreglo[0]=direccionenparser+acumulador;
                    
                    arreglo[1]=acumulador;
                    arreglo[2]=metainfo.getartista();
                    arreglo[3]=metainfo.getalbum();
                    arreglo[4]=metainfo.getgenero();
                    arreglo[5]=metainfo.getyear();
                    
                    
                    
                    lista2.añadirDatos(arreglo);
                    System.out.println(acumulador);
                    acumulador="";
                }
                if((char)valor!='@'){
                    acumulador = acumulador+(char)valor;
                    //System.out.println("ppppppppp");
                } else {
                    System.out.println(acumulador+"Esta en el acumulador");
                    //acumulador=" ";
                    
                    
                }
                //System.out.print((char)valor);
                valor=fr.read();
                }return lista2;
            }
        catch(Exception a){
            System.out.println("Lista no encontrada");
        }
        return null;
        }

    public void agregar(String agregar,String nombreListaReproduccion) throws IOException{
            
            
            
            
        
                   try ( //Abro stream, crea el fichero si no existe
                    FileWriter fw = new FileWriter(nombreListaReproduccion+".txt")) {
                //Escribimos en el fichero un String y un caracter 97 (a)
                fw.write(agregar); 
                //fw.write("aaa.aaaaaa.aaaa.aaaaaaaaa.aaaaaaa.aaaaaaaaaaaaaa.aaaaaaaaa.aaaaaaa");
                //ejemplo de escritura
                System.out.println("SE agrego correctamente: "+agregar);
            }

        
        
        
        }
        
        
        
        
        
    }
    

