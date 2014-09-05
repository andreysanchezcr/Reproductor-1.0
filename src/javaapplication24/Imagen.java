package javaapplication24;

import javax.swing.ImageIcon;
import java.awt.Image;
/**
* Clase que permite el manejo de imagenes
*@author Kenneth Martinez
*/

public class Imagen {

	String direccionImagen; // Almancena la direccion
	ImageIcon imagen; // Almacena la imagen

	/**
	* Construye una imagen tipo icon
	*@param directorioImagen La direccion de la imagen
	*/	
	public Imagen(String directorioImagen){

		this.direccionImagen = direccionImagen;
		this.imagen = new ImageIcon(this.direccionImagen);
	}

	/**
	* Redimensiona la imagen para que tenga el tamaño del label
	*@param nombreLabel Nombre del label donde se va insertar
	*/
	public ImageIcon redimensionarImagen(int alto, int ancho){

		// Ajusta la dimension de la imagen segun el alto y ancho del label
		Image nuevaImagen = imagen.getImage();
		ImageIcon imagenRedimencionada = new ImageIcon (nuevaImagen.getScaledInstance(ancho,alto,Image.SCALE_SMOOTH));

		return imagenRedimencionada;
		
	}
}