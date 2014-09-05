package reproductormusica1;

import java.io.*;
import java.io.IOException;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.NotSupportedException;
import com.mpatric.mp3agic.UnsupportedTagException;
import javazoom.jl.decoder.JavaLayerException;


public class Main{
	public static String direccion;
	public static String playlist;
	public static Archivos fichero = new Archivos();
	public static String[] metainformacion=new String[10];
	//public static String direccionimagen""
	public static String direccioncover="";

	public static void main(String[] args)throws UnsupportedTagException, InvalidDataException, IOException, NotSupportedException, JavaLayerException {

            //direccion="C:\\Users\\ricardo\\Desktop\\wigle.mp3";
		//playlist= "Playlist";
///////////////////////////////////////////
 		fichero.generarDirectorio("FilesMusic");
 		//Interfaz=Interfaz;
 		//fichero.redireccionarFichero(direccion,null);
        String variable = fichero.obtenerDirectorioMusica();
        /////////////System.out.println(variable);
 		fichero.leerArchivosCarpeta(variable,null);
        //fichero.generarDirectorio("FilesMusic" + File.separator + playlist);
        //fichero.redireccionarFichero(direccion,playlist);

        
        direccioncover= fichero.obtenerDirectorioMusica()+"/cover";

        VentanaP b =new VentanaP();
        b.setVisible(true);

	}

}