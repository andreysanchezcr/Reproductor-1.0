package reproductormusica1;

/*
*Importes de librerías necesarias para la reproducción
*y la creación de la interfaz de usuario.
*/

import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.NotSupportedException;
import com.mpatric.mp3agic.UnsupportedTagException;
import java.awt.Color; 
import java.awt.Image; 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level; 
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.ListModel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jlgui.basicplayer.BasicPlayerException;


/*Implementación de la clase VentanaP que contiene todos los componentes del 
*reproductor.
*/
public final class VentanaP extends javax.swing.JFrame {
    Archivos nuevoArchivo = new Archivos();
    String[][]arregloNombreCanciones;
    Datos nuevoDatos = new Datos();
    MetaDatos1 informacionMusica = new MetaDatos1();
    
    
    
    
    
    ReproductorM miReproductor = new ReproductorM();
    String listadereproduccionactual;
    DefaultListModel modelodefecto2 ;
    DefaultListModel modelodefecto;
    Datos listaActual;
    String cancionactual;
    String[] ar = {"","","","",""};
    Datos tCanciones=new Datos(ar);
    String canc;
       //Abro stream, crea el fichero si no existe

    MetaDatos1 metainformacion= new MetaDatos1();
    public static String listaA;
    String[] listaDatos1={"","","","","","",""};
    Datos listaEnlazada = new Datos(listaDatos1);
    public static String listadereproduccionarcual;

    DefaultListModel modelo = new DefaultListModel(); //Utilizado por la lista para insertar elementos a la vez y eliminarlo.
    JFileChooser archivoSeleccionado = new JFileChooser(); // Variable tipo FileChooser que permite acceder a los datos del ordenador. 
    public static File archivo; // Guardara la direccion de las canciones.
    public static File archivo1; // Guardara la direccion de las canciones.

    private boolean enReproduccion; // indicará si hay o no archivos en reproduccion. 

    /*
     * Implementación de la VentanaPrincipal 
     * @throws javazoom.jl.decoder.JavaLayerException
     * @throws java.io.FileNotFoundException
     */
    public VentanaP()throws JavaLayerException, FileNotFoundException, IOException, UnsupportedTagException, InvalidDataException {
        crearlistadefault("default","");

        initComponents();
        cargarmusica();


        this.getContentPane().setBackground(Color.black);
        modelodefecto = new DefaultListModel();
            
        this.arregloNombreCanciones = nuevoArchivo.leerArchivosCarpeta("FilesMusic", null);//Nombre canciones y direcciones
        // Nombre de canciones en el 0 y direcciones en el 1
        
        String[] arregloDeDirecciones = new String[arregloNombreCanciones[1].length];
      
        // Posicion 0 -> ruta
	// Posicion 1 -> nombre
	// Posicion 2 -> artista
	// Posicion 3 -> album
	// Posicion 4 -> genero
 
            String[]listaInformacionMusica = new String[5];
        
        for(int i=0;i < arregloNombreCanciones[0].length;i++){
            
            modelodefecto.addElement(arregloNombreCanciones[0][i]);
            arregloDeDirecciones[i] = arregloNombreCanciones[1][i];
            informacionMusica.agregarc(arregloDeDirecciones[i]);
        
            
            listaInformacionMusica[0]= arregloDeDirecciones[i];
            listaInformacionMusica[1]= arregloNombreCanciones[0][i];
            try{ 
                listaInformacionMusica[2]= informacionMusica.getartista();
            }catch(Exception RunTime){
                listaInformacionMusica[2] = "";
            }
            try{
                listaInformacionMusica[3] = informacionMusica.getalbum();
            }catch(Exception RunTime){
                listaInformacionMusica[3]= "";
            }
            try{
                listaInformacionMusica[4] = informacionMusica.getgenero();
            }catch(Exception RunTime){
                listaInformacionMusica[4]= "";
            }
         
        
            
           this.nuevoDatos.añadirDatos(listaInformacionMusica);
           System.out.println(nuevoDatos.obtenerDatos(0)[1]);
                      System.out.println(nuevoDatos.getTamaño());

                      System.out.println(nuevoDatos.obtenerDatos(0)[2]);
           System.out.println(nuevoDatos.obtenerDatos(0)[3]);
           System.out.println(nuevoDatos.obtenerDatos(0)[4]);
           //System.out.println(nuevoDatos.obtenerDatos(1)[0]);
           //System.out.println(nuevoDatos.obtenerDatos(1)[1]);
           //System.out.println(nuevoDatos.obtenerDatos(1)[2]);

        }
               
           PanelListaCanciones.setModel(modelodefecto);
            Archivos p = new Archivos();
        String[] a;
            
        a=p.leerArchivosCarpeta("FilesMusic", null)[0];
        
        
        //               modelodefecto = new DefaultListModel();
      //                  for(int i=0;a.length>i;i++){
    //                        modelodefecto.addElement(a[i]);
            
  //               }
//            PanelListaCanciones.setModel(modelodefecto);
              
    }
    
    
    
    public void crearlistadefault(String nombre,String informacion) throws IOException{
              
            //Escribimos en el fichero un String y un caracter 97 (a)
            try ( //Abro stream, crea el fichero si no existe
                FileWriter fw = new FileWriter(nombre+".txt")) {
                //Escribimos en el fichero un String y un caracter 97 (a)
                fw.write("Esta es una prueba del archivo default"); 
                fw.write(informacion);
                //ejemplo de escritura
            }
 }
    public void cargarmusica(){
        try{
        Archivos s = new Archivos();
        String p=s.obtenerDirectorioMusica();
        String[] canciones = s.leerArchivosCarpeta(p, null)[1];
        System.out.println("Prueba de cargar musica"+canciones.length);
 
        Archivos h = new Archivos();
        //System.out.println(d+canc);
        for(int i =0;i<canciones.length;i++){
            if(canciones[i]!=null)
            h.redireccionarFichero(canciones[i],null );}
                ///System.out.println("Se ha agregado: "+canciones[i]);
        System.out.println("Se han agreegado las canciones");
        }catch(Exception a){
            System.out.println("No se ha podido cargar la musica");
        }
        
        
        
        
        
    }
        
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox();
        vol = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        volumen = new javax.swing.JSlider();
        btnPlay = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        btnSiguente = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        porsentaje = new javax.swing.JLabel();
        PanelAbajo = new javax.swing.JPanel();
        reproduciendo = new javax.swing.JLabel();
        ListaRepActual = new javax.swing.JLabel();
        abrirplay = new javax.swing.JButton();
        lista = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        PanelListaCanciones = new javax.swing.JList();
        PanelIcono = new javax.swing.JPanel();
        icono = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnSeleccionarCanción = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        agregarCancion = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        PanelListaReproduccion = new javax.swing.JList();
        PanelDatosCancion = new javax.swing.JPanel();
        guardarCancion = new javax.swing.JButton();
        ltitulo = new javax.swing.JLabel();
        lalbum = new javax.swing.JLabel();
        ltiempo = new javax.swing.JLabel();
        lartista = new javax.swing.JLabel();
        titulo = new javax.swing.JTextField();
        laño = new javax.swing.JLabel();
        album = new javax.swing.JTextField();
        lgenero = new javax.swing.JLabel();
        artista = new javax.swing.JTextField();
        año = new javax.swing.JTextField();
        genero = new javax.swing.JTextField();
        PanelBusqueda = new javax.swing.JPanel();
        Buscador = new javax.swing.JTextField();
        buscadorC = new javax.swing.JButton();
        busquedaPor = new javax.swing.JComboBox();
        Menu = new javax.swing.JMenuBar();
        MenuPlayList = new javax.swing.JMenu();
        crearListaRMenu = new javax.swing.JMenuItem();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(12, 12, 12));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 153), 1, true));
        jPanel1.setForeground(new java.awt.Color(12, 12, 12));
        jPanel1.setToolTipText("");

        volumen.setBackground(new java.awt.Color(12, 12, 12));
        volumen.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                volumenAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        volumen.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                volumenStateChanged(evt);
            }
        });

        btnPlay.setText("Play");
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });

        btnStop.setText("Stop");
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });

        btnSiguente.setText(">");
        btnSiguente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguenteActionPerformed(evt);
            }
        });

        btnAnterior.setText("<");
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });

        porsentaje.setForeground(new java.awt.Color(255, 255, 255));
        porsentaje.setText("50%");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(volumen, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(porsentaje, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAnterior)
                        .addGap(9, 9, 9)
                        .addComponent(btnPlay, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnStop)
                        .addGap(18, 18, 18)
                        .addComponent(btnSiguente)
                        .addGap(26, 26, 26))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStop)
                    .addComponent(btnPlay)
                    .addComponent(btnSiguente)
                    .addComponent(btnAnterior))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(volumen, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(porsentaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        PanelAbajo.setBackground(new java.awt.Color(12, 12, 12));
        PanelAbajo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 153), 1, true));

        reproduciendo.setBackground(new java.awt.Color(12, 12, 12));
        reproduciendo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        reproduciendo.setForeground(new java.awt.Color(255, 255, 255));
        reproduciendo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(12, 12, 12)));

        ListaRepActual.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ListaRepActual.setForeground(new java.awt.Color(255, 255, 255));
        ListaRepActual.setText("Lista de Reproduccion Actual:");

        abrirplay.setText("Abrir lista de Reproduccion");
        abrirplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirplayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelAbajoLayout = new javax.swing.GroupLayout(PanelAbajo);
        PanelAbajo.setLayout(PanelAbajoLayout);
        PanelAbajoLayout.setHorizontalGroup(
            PanelAbajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAbajoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ListaRepActual, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reproduciendo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(28, 28, 28)
                .addComponent(lista, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(abrirplay)
                .addGap(26, 26, 26))
        );
        PanelAbajoLayout.setVerticalGroup(
            PanelAbajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelAbajoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelAbajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(abrirplay)
                    .addComponent(reproduciendo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelAbajoLayout.createSequentialGroup()
                        .addGroup(PanelAbajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ListaRepActual, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lista, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        PanelListaCanciones.setBackground(new java.awt.Color(12, 12, 12));
        PanelListaCanciones.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 153), 1, true), "Lista de Canciones", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        PanelListaCanciones.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PanelListaCanciones.setForeground(new java.awt.Color(255, 255, 255));
        PanelListaCanciones.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        PanelListaCanciones.setToolTipText("");
        PanelListaCanciones.setSelectionBackground(new java.awt.Color(0, 153, 153));
        PanelListaCanciones.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(PanelListaCanciones);

        PanelIcono.setBackground(new java.awt.Color(12, 12, 12));
        PanelIcono.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 153), 1, true));

        javax.swing.GroupLayout PanelIconoLayout = new javax.swing.GroupLayout(PanelIcono);
        PanelIcono.setLayout(PanelIconoLayout);
        PanelIconoLayout.setHorizontalGroup(
            PanelIconoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelIconoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(icono, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelIconoLayout.setVerticalGroup(
            PanelIconoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelIconoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(icono, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(12, 12, 12));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 153), 1, true));

        btnSeleccionarCanción.setText("Seleccionar Canción ");
        btnSeleccionarCanción.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarCanciónActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar Canción");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        agregarCancion.setText("Agregar cancion");
        agregarCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarCancionActionPerformed(evt);
            }
        });

        guardar.setText("Guardar lista de Reproduccion ");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(btnSeleccionarCanción)
                .addGap(31, 31, 31)
                .addComponent(btnEliminar)
                .addGap(31, 31, 31)
                .addComponent(agregarCancion)
                .addGap(35, 35, 35)
                .addComponent(guardar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSeleccionarCanción)
                    .addComponent(btnEliminar)
                    .addComponent(agregarCancion)
                    .addComponent(guardar))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        PanelListaReproduccion.setBackground(new java.awt.Color(12, 12, 12));
        PanelListaReproduccion.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 153), 1, true), "Lista de reproducción", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        PanelListaReproduccion.setForeground(new java.awt.Color(255, 255, 255));
        PanelListaReproduccion.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        PanelListaReproduccion.setToolTipText("");
        PanelListaReproduccion.setSelectionBackground(new java.awt.Color(0, 153, 153));
        PanelListaReproduccion.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane3.setViewportView(PanelListaReproduccion);
        PanelListaReproduccion.getAccessibleContext().setAccessibleName("Lista de reproduccion");

        PanelDatosCancion.setBackground(new java.awt.Color(12, 12, 12));
        PanelDatosCancion.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 153), 1, true), "Datos de la Canción", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        PanelDatosCancion.setForeground(new java.awt.Color(255, 255, 255));

        guardarCancion.setText("Guardar Cambios");
        guardarCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarCancionActionPerformed(evt);
            }
        });

        ltitulo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ltitulo.setForeground(new java.awt.Color(255, 255, 255));
        ltitulo.setText("Titulo: ");

        lalbum.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lalbum.setForeground(new java.awt.Color(255, 255, 255));
        lalbum.setText("Álbum ");

        ltiempo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ltiempo.setForeground(new java.awt.Color(255, 255, 255));
        ltiempo.setText("Tiempo: ");

        lartista.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lartista.setForeground(new java.awt.Color(255, 255, 255));
        lartista.setText("Artista:");

        titulo.setEditable(false);
        titulo.setBackground(new java.awt.Color(0, 153, 153));
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tituloActionPerformed(evt);
            }
        });

        laño.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        laño.setForeground(new java.awt.Color(255, 255, 255));
        laño.setText("Año:");

        album.setBackground(new java.awt.Color(102, 102, 102));
        album.setForeground(new java.awt.Color(255, 255, 255));
        album.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                albumActionPerformed(evt);
            }
        });

        lgenero.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lgenero.setForeground(new java.awt.Color(255, 255, 255));
        lgenero.setText("Género:");

        artista.setBackground(new java.awt.Color(0, 153, 153));
        artista.setForeground(new java.awt.Color(255, 255, 255));

        año.setBackground(new java.awt.Color(102, 102, 102));
        año.setForeground(new java.awt.Color(255, 255, 255));

        genero.setBackground(new java.awt.Color(0, 153, 153));
        genero.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout PanelDatosCancionLayout = new javax.swing.GroupLayout(PanelDatosCancion);
        PanelDatosCancion.setLayout(PanelDatosCancionLayout);
        PanelDatosCancionLayout.setHorizontalGroup(
            PanelDatosCancionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDatosCancionLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(PanelDatosCancionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ltiempo)
                    .addGroup(PanelDatosCancionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(guardarCancion)
                        .addGroup(PanelDatosCancionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(PanelDatosCancionLayout.createSequentialGroup()
                                .addComponent(lgenero, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(genero))
                            .addGroup(PanelDatosCancionLayout.createSequentialGroup()
                                .addComponent(ltitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(titulo))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelDatosCancionLayout.createSequentialGroup()
                                .addComponent(lalbum, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(album, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelDatosCancionLayout.createSequentialGroup()
                                .addGroup(PanelDatosCancionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lartista, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(laño, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(PanelDatosCancionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(artista)
                                    .addComponent(año, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        PanelDatosCancionLayout.setVerticalGroup(
            PanelDatosCancionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDatosCancionLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(PanelDatosCancionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ltitulo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelDatosCancionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(album, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lalbum))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelDatosCancionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lartista)
                    .addComponent(artista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelDatosCancionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(laño)
                    .addComponent(año, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelDatosCancionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lgenero)
                    .addComponent(genero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ltiempo)
                .addGap(18, 18, 18)
                .addComponent(guardarCancion)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        PanelBusqueda.setBackground(new java.awt.Color(12, 12, 12));
        PanelBusqueda.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 153), 1, true));

        Buscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscadorActionPerformed(evt);
            }
        });

        buscadorC.setText("Buscar");
        buscadorC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscadorCActionPerformed(evt);
            }
        });

        busquedaPor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nombre", "Artista", "Álbum", "Género" }));
        busquedaPor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                busquedaPorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelBusquedaLayout = new javax.swing.GroupLayout(PanelBusqueda);
        PanelBusqueda.setLayout(PanelBusquedaLayout);
        PanelBusquedaLayout.setHorizontalGroup(
            PanelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBusquedaLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(buscadorC)
                .addGap(18, 18, 18)
                .addComponent(Buscador, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(busquedaPor, 0, 114, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelBusquedaLayout.setVerticalGroup(
            PanelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBusquedaLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(PanelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Buscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscadorC)
                    .addComponent(busquedaPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        Menu.setBackground(new java.awt.Color(0, 51, 51));
        Menu.setForeground(new java.awt.Color(255, 255, 255));

        MenuPlayList.setForeground(new java.awt.Color(255, 255, 255));
        MenuPlayList.setText("Listas de Reproducción ");
        MenuPlayList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuPlayListActionPerformed(evt);
            }
        });

        crearListaRMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        crearListaRMenu.setText("Crear Lista de reproducción");
        crearListaRMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearListaRMenuActionPerformed(evt);
            }
        });
        MenuPlayList.add(crearListaRMenu);

        Menu.add(MenuPlayList);

        setJMenuBar(Menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(PanelAbajo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(PanelIcono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(PanelDatosCancion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(PanelBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)))
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(vol)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(243, 243, 243)
                .addComponent(vol)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(PanelIcono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(PanelDatosCancion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(PanelBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(PanelAbajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
     /*
     * Método que contiene el evento del botón Play, el cual al pulsarlo 
     * reproduce la musica y cambia a Pause automáticamente. 
     */
    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed

    try{
        System.out.println(PanelListaReproduccion.getSelectedValue().toString());
        
        Archivos x = new Archivos();
        String c=x.obtenerDireccion("FilesMusic");
        canc= PanelListaReproduccion.getSelectedValue().toString();
        System.out.println("Cancion seleccionada: "+c+PanelListaReproduccion.getSelectedValue().toString());
        cancionactual=c+PanelListaReproduccion.getSelectedValue().toString();
        System.out.println(cancionactual);
        MetaDatos1 metainformacion1 = new MetaDatos1();
        
        try {
            metainformacion1.agregarc(PanelListaReproduccion.getSelectedValue().toString());
        } catch (IOException | UnsupportedTagException | InvalidDataException ex) {
           metainformacion1.agregarc(c+PanelListaReproduccion.getSelectedValue().toString());

            System.out.println("No se han toado los metadatos");
        }
        try{
        File a = new File("cover.jpg");
        a.delete();}
        catch(Exception a){
            System.out.println("El archivo no se ha podido eliminar");
        }
                try {
            metainformacion1.getImage();
        } catch (UnsupportedTagException | InvalidDataException | IOException | NotSupportedException ex) {
            System.out.println("no se ha podido obtener la imagen");
        }

                ImageIcon iicono = new ImageIcon("cover.jpg");
                   Image imagen = iicono.getImage();
                    ImageIcon iconoEscalado = new ImageIcon (imagen.getScaledInstance(100,150,Image.SCALE_SMOOTH));
                          
        icono.setIcon(iconoEscalado);
        titulo.setText(metainformacion1.gettitulo());
        año.setText(metainformacion1.getyear());
        artista.setText(metainformacion1.getartista());
        album.setText(metainformacion1.getalbum());
        ltiempo.setText("Tiempo: "+metainformacion1.gettiempo());
        
        //********************************// Se verifica si arch es el que tiene el control de archivos
        File arch= new File(c+PanelListaReproduccion.getSelectedValue().toString());
//                File arch= new File("C:\\Users\\ricardo\\Desktop\\reptide.mp3");

                switch (btnPlay.getText()) { //Toma el texto escrito en el botón y lo examina en dos casos
            
            case "Play":  
                              if(btnPlay.getText()=="Pausa"){try {
            miReproductor.control.open(arch);
        } catch (BasicPlayerException ex) {
            Logger.getLogger(VentanaP.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            miReproductor.control.resume();
        } catch (BasicPlayerException ex) {
            Logger.getLogger(VentanaP.class.getName()).log(Level.SEVERE, null, ex);
        }
    
         }
 
                if (!enReproduccion) { // Verifica si hay algun archovo en reproduccion y alguna direccion
        try {
            miReproductor.control.open(arch);
        } catch (BasicPlayerException ex) {
            System.out.println("ha salido de alguna forma");
        }
                
                    try { 
                        miReproductor.control.play(); //Reproduce el archivo
                        btnPlay.setText("Pausa"); // Cambia el texto del botón
                        enReproduccion = true; // Cambia el estado de la variable a true puesto que si esta en reproducción.
                        reproduciendo.setText("Reproduciendo: "+archivo.getName());
                    } catch (BasicPlayerException ex) { 
                        Logger.getLogger(VentanaP.class.getName()).log(Level.SEVERE, null, ex); 
                    } 
                } 
                 if (enReproduccion) { 
            try { 
                miReproductor.control.resume(); // Reanuda la canción
                btnPlay.setText("Pausa"); // Cambia el texto del botón
            } catch (BasicPlayerException ex) { 
                Logger.getLogger(VentanaP.class.getName()).log(Level.SEVERE, null, ex); 
            } 
                        } 
                break; 
            case "Pausa": 
                
                try { 
                    miReproductor.control.pause(); // Pone pausa a la canción
                } catch (BasicPlayerException ex) { 
                    Logger.getLogger(VentanaP.class.getName()).log(Level.SEVERE, null, ex); 
                } 
                btnPlay.setText("Play"); 
                break; 
                }
            }
            catch(Exception a){
                System.out.println("No existe cancion seleccionada");
                
                    PanelListaReproduccion.setSelectedIndex(PanelListaReproduccion.getSelectedIndex());
        Archivos x = new Archivos();
        String c=x.obtenerDireccion("FilesMusic");
                File arch1= new File(c+PanelListaReproduccion.getSelectedValue().toString());
        
                if(btnPlay.getText()=="Play"){try {
            miReproductor.control.open(arch1);
        } catch (BasicPlayerException ex) {
            Logger.getLogger(VentanaP.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            miReproductor.control.play();
        } catch (BasicPlayerException ex) {
            Logger.getLogger(VentanaP.class.getName()).log(Level.SEVERE, null, ex);
        }
    
         }
    /*                if(btnPlay.getText()=="Pausa"){try {
            miReproductor.control.open(arch1);
        } catch (BasicPlayerException ex) {
            Logger.getLogger(VentanaP.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            miReproductor.control.resume();
        } catch (BasicPlayerException ex) {
            Logger.getLogger(VentanaP.class.getName()).log(Level.SEVERE, null, ex);
        }
    
         }*/}
    
    }//GEN-LAST:event_btnPlayActionPerformed
     /*
     * Método que contiene el evento del botón Stop, que detiene la canción por completo
     * al pulsarlo el botón que en el momento esta en estado de Pause automáticamente a Play. 
     */
    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
       try { 
            miReproductor.control.stop(); //Detiene el proceso de reproducción
        } catch (BasicPlayerException ex) { 
            Logger.getLogger(VentanaP.class.getName()).log(Level.SEVERE, null, ex); 
        } 
        enReproduccion = false; // Cambia el estado de la variable puesto que no hay nada reproduciendose
        btnPlay.setText("Play"); // Cambia el texto del botón.
                            
                                           
    }//GEN-LAST:event_btnStopActionPerformed

    private void volumenAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_volumenAncestorAdded

    }//GEN-LAST:event_volumenAncestorAdded
    
    
    /**
     * Método que regula el volumen de la canción. 
     */
    private void volumenStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_volumenStateChanged
            try { 
            miReproductor.control.setGain((double)volumen.getValue()/100);//Se asigna un volumen de 100
            porsentaje.setText(volumen.getValue()+"%");
        } catch (BasicPlayerException ex) {
            Logger.getLogger(VentanaP.class.getName()).log(Level.SEVERE, null, ex);
        }    
            
                                        
    }//GEN-LAST:event_volumenStateChanged
     /**
     * Contiene el evento del botón Seleccionar Canción el cual abre el JFileChooser para escoger
     * las canciones. 
     */
    private void btnSeleccionarCanciónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarCanciónActionPerformed
       // Crea un filtro para obtener solo archivos con es formato "mp3","ogg","wav"
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Música", "mp3","ogg","wav"); 
        archivoSeleccionado.setFileFilter(filtro); // Selección del archivo filtrado


        int seleccion = archivoSeleccionado.showOpenDialog(this); 
        Archivos z = new Archivos();
        String d=z.obtenerDireccion("FilesMusic");
        if (seleccion == JFileChooser.APPROVE_OPTION) {
                Object selecc = PanelListaCanciones.getSelectedValue();
                Object componentes =PanelListaCanciones.getComponents();
                ListModel modelol;
                modelol= PanelListaCanciones.getModel();
                archivo = archivoSeleccionado.getSelectedFile();
                System.out.println("El nombre del archivo a direccionar es: "+archivo);
                Archivos direc = new Archivos();
                System.out.println("Este es archivo: "+archivo.toString());
                         
                    Archivos h = new Archivos();
                    System.out.println(d+canc);
                    h.redireccionarFichero(archivo.toString(),null );
               
                modelodefecto.addElement(archivo.getName());

                PanelListaCanciones.setModel(modelodefecto);
                System.out.println("esto es d"+d);
                MetaDatos1 metainfo = new MetaDatos1();
            try {
                metainfo.agregarc(archivo.toString());
            } catch (IOException | UnsupportedTagException | InvalidDataException ex) {
                Logger.getLogger(VentanaP.class.getName()).log(Level.SEVERE, null, ex);
            }
                System.out.println("El archivo.getname es :"+archivo.getName());
                String[] arregloTCanciones = new String[6];

                arregloTCanciones[0]=d+archivo.getName().toString();
                
                System.out.println("12345");
                
                    
                arregloTCanciones[1]=archivo.getName().toString();
                
                System.out.println("nombre de la cancion: "+archivo.getName());

                arregloTCanciones[2]=metainfo.getartista();
                System.out.println("12345");

                arregloTCanciones[3]=metainfo.getalbum();
                System.out.println("12345");

                arregloTCanciones[4]=metainfo.getgenero();
                arregloTCanciones[5]=metainfo.getyear();
               // System.out.println(arregloTCanciones[2]);
                
                tCanciones.añadirDatos(arregloTCanciones);
                System.out.println("Prueba nuero 1:"+tCanciones.obtenerDatos(0)[0]);

            
            try {

                Archivos x = new Archivos();
                String c=x.obtenerDireccion("FilesMusic");
                File arch= new File(c+PanelListaCanciones.getSelectedValue().toString());
                System.out.println(c+PanelListaCanciones.getSelectedValue().toString());
                
                File archivo2 = new File("FilesMusic" + File.separator+PanelListaCanciones.getSelectedValue().toString());
                System.out.println("FilesMusic" + File.separator+PanelListaCanciones.getSelectedValue().toString());
                miReproductor.control.open(arch);
            } catch (BasicPlayerException ex) {
                Logger.getLogger(VentanaP.class.getName()).log(Level.SEVERE, null, ex);
            }

        } 
    }//GEN-LAST:event_btnSeleccionarCanciónActionPerformed
    
    /*
    * Contiene el evento del botón elminar. 
    */
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        //if(listaCanciones.getSelectedValue()!=null)
        //   modelodefecto.removeElement(listaCanciones.getSelectedValue());
        if(PanelListaReproduccion.getSelectedValue()!=null)
            modelodefecto2.removeElement(PanelListaReproduccion.getSelectedValue());// Elimminar la el elmento seleccionado de la lista
    }//GEN-LAST:event_btnEliminarActionPerformed

    /*
    *Contiene el evento para generar una nueva lista de reproduccion 
    */
    private void crearListaRMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearListaRMenuActionPerformed
       VtnListaReproduccion vPlayList = new VtnListaReproduccion(this,true);
       vPlayList.setVisible(true);
       modelo.addElement(volumen);
    }//GEN-LAST:event_crearListaRMenuActionPerformed

    private void MenuPlayListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuPlayListActionPerformed

    }//GEN-LAST:event_MenuPlayListActionPerformed

    private void btnSiguenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguenteActionPerformed
        PanelListaReproduccion.setSelectedIndex(PanelListaReproduccion.getSelectedIndex()+1);
        Archivos x = new Archivos();
        String c=x.obtenerDireccion("FilesMusic");
                File arch1= new File(c+PanelListaReproduccion.getSelectedValue().toString());
        try {
            miReproductor.control.open(arch1);
        } catch (BasicPlayerException ex) {
            Logger.getLogger(VentanaP.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            miReproductor.control.play();
        } catch (BasicPlayerException ex) {
            Logger.getLogger(VentanaP.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnSiguenteActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        PanelListaReproduccion.setSelectedIndex(PanelListaReproduccion.getSelectedIndex()-1);
        Archivos x = new Archivos();
        String c=x.obtenerDireccion("FilesMusic");
                File arch1= new File(c+PanelListaReproduccion.getSelectedValue().toString());
        try {
            miReproductor.control.open(arch1);
        } catch (BasicPlayerException ex) {
            Logger.getLogger(VentanaP.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            miReproductor.control.play();
        } catch (BasicPlayerException ex) {
            Logger.getLogger(VentanaP.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void abrirplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirplayActionPerformed
        Parser par = new Parser();
        String lstaCanciones=lista.getText();
        
        try {
            listaActual=par.parserD(lista.getText()+".txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VentanaP.class.getName()).log(Level.SEVERE, null, ex);
        }
            modelodefecto2 = new DefaultListModel();
            //modelodefecto2.addElement("hola");
            listadereproduccionactual=lista.getText();
            //modelodefecto2.addElement("fsdfsaf");
            //listaActual.
          //  meta.agregarc(listaActual.obtenerDatos(0)[0]);
            /*for(int i=0;2>i-1;i++){
                modelodefecto2.addElement(listaActual.obtenerDatos(0)[0]);
                modelodefecto2.addElement("ffsfas");
                
            }*/
            
            
            
       try ( //Abro el stream, el fichero debe existir
            FileReader fr = new FileReader(lista.getText()+".txt")) {
                //Leemos el fichero y lo mostramos por pantalla
            
            int valor=fr.read()
                    ;
            String acumulador="";
            while(valor!=-1){
                if((char)valor=='@'){
                    modelodefecto2.addElement(acumulador);
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
            PanelListaReproduccion.setModel(modelodefecto2);
    }//GEN-LAST:event_abrirplayActionPerformed

    private void agregarCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarCancionActionPerformed
                //Object selecc = listaCanciones.getSelectedValue();
                modelodefecto2 = new DefaultListModel();

                Object componentes =PanelListaCanciones.getComponents();
                ListModel modelol;
                modelol= PanelListaReproduccion.getModel();
                DefaultListModel modelodefecto1;
                
                modelodefecto1 = new DefaultListModel();

                for(int i=0;modelol.getSize()!=i;i++){
                    modelodefecto1.addElement(modelol.getElementAt(i));
                    System.out.println(modelol.getElementAt(i));
                    
                }
                archivo = archivoSeleccionado.getSelectedFile();
                Object pasando = PanelListaCanciones.getSelectedValue();
                modelodefecto1.addElement(pasando.toString());
                PanelListaReproduccion.setModel(modelodefecto1);
              //  System.out.println("La cancion seleccionada tiene el indice "+ prueba);
                
    }//GEN-LAST:event_agregarCancionActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed

       //ListModel s; 
        String supers="";
        int contador=0;
        ListModel a = PanelListaReproduccion.getModel();
        
        System.out.println(a);
        for(int i=0;a.getSize()>i;i++){
            if(contador!=0){
            supers=supers+a.getElementAt(i).toString();
            supers=supers+"@";
            }
            contador++;
            
        }
        System.out.println(supers);
        Parser par = new Parser();
        try {
            par.agregar(supers, listadereproduccionactual);
            System.out.println("Se ha guardado tu lista con exito");
        } catch (IOException ex) {
            Logger.getLogger(VentanaP.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_guardarActionPerformed

    private void guardarCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarCancionActionPerformed
        try {                                               
            Archivos x = new Archivos();
            String c=x.obtenerDireccion("FilesMusic");
            try{
                File borrar=new File(PanelListaCanciones.getSelectedValue().toString());
                borrar.delete();
            
            }catch(Exception error){
              System.out.println("No existio");
            }
            
            MetaDatos1 modificar= new MetaDatos1();
            System.out.println(canc);
            try {
                System.out.println(cancionactual);
                modificar.agregarc(cancionactual);
            } catch (IOException | UnsupportedTagException | InvalidDataException ex) {
                Logger.getLogger(VentanaP.class.getName()).log(Level.SEVERE, null, ex);
            }
            modificar.setAlbum(album.getText());
            modificar.setArtist(artista.getText());
            /////////
            

            //////////////

            try {
                modificar.settitulo(titulo.getText());
            } catch (UnsupportedTagException | InvalidDataException ex) {
                Logger.getLogger(VentanaP.class.getName()).log(Level.SEVERE, null, ex);
                
                
            }
            modificar.setyear(año.getText());
            modificar.mp3file.save(PanelListaCanciones.getSelectedValue().toString());
           /* Archivos h = new Archivos();
            if(h.revisarCarpeta(canc)==true){
                    File borrado = new File(c+canc);
                    System.out.println(canc);
                    System.out.println(c+canc);

                    borrado.delete();
                    h.redireccionarFichero(cancionactual,null );
                    System.out.println("if");

                    
                    
                }else{
                    System.out.println("else");
                    h.redireccionarFichero(canc,null );
                }*/
         //   h.redireccionarFichero(c+canc,null);
        } catch (IOException | NotSupportedException ex) {
            System.out.println("Los metadatos no se han podido guardar");
        }
        
        
    }//GEN-LAST:event_guardarCancionActionPerformed

    private void BuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscadorActionPerformed

    private void buscadorCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscadorCActionPerformed
        String texto = Buscador.getText();
        

        int contador = 0;
        System.out.println(nuevoDatos.obtenerDatos(0)[1]);
        System.out.println(nuevoDatos.obtenerDatos(1)[1]);
        System.out.println("hola");
        int estado = 0;
      if(estado == 1){
        if(busquedaPor.getSelectedItem().toString()== "Artista"){
            int tipo = 2;
		for(contador = 0;contador < this.nuevoDatos.getTamaño();contador++){
			String variable = this.nuevoDatos.obtenerDatos(contador)[tipo];

			if(variable == texto){
                            estado = 1;
                            break;
			}
		}
        }
        else if(busquedaPor.getSelectedItem().toString() == "Nombre"){
            int tipo = 1;
		for(contador = 0;contador < this.nuevoDatos.getTamaño();contador++){
			String variable = this.nuevoDatos.obtenerDatos(contador)[tipo];

			if(variable == texto){
                            estado = 1;
                            break;
			}
		}
        }
        else if(busquedaPor.getSelectedItem().toString()== "Álbum"){
                int tipo = 3;
		for(contador = 0;contador < this.nuevoDatos.getTamaño();contador++){
			String variable = this.nuevoDatos.obtenerDatos(contador)[tipo];

			if(variable == texto){
                            estado = 1;
                            break;
			}
		}
     
        }  
        else if(busquedaPor.getSelectedItem().toString()== "Genero"){
                int tipo = 4;
		for(contador = 0;contador < this.nuevoDatos.getTamaño();contador++){
			String variable = this.nuevoDatos.obtenerDatos(contador)[tipo];

			if(variable == texto){
                            estado = 1;
                            break;
			}
		}
                
        }
      }
        PanelListaCanciones.setSelectedIndex(contador);
       
                                             
    }//GEN-LAST:event_buscadorCActionPerformed

    private void tituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tituloActionPerformed

    private void albumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_albumActionPerformed

    }//GEN-LAST:event_albumActionPerformed

    private void busquedaPorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busquedaPorActionPerformed

    }//GEN-LAST:event_busquedaPorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Buscador;
    private javax.swing.JLabel ListaRepActual;
    private javax.swing.JMenuBar Menu;
    private javax.swing.JMenu MenuPlayList;
    private javax.swing.JPanel PanelAbajo;
    private javax.swing.JPanel PanelBusqueda;
    private javax.swing.JPanel PanelDatosCancion;
    private javax.swing.JPanel PanelIcono;
    private javax.swing.JList PanelListaCanciones;
    public javax.swing.JList PanelListaReproduccion;
    private javax.swing.JButton abrirplay;
    private javax.swing.JButton agregarCancion;
    private javax.swing.JTextField album;
    private javax.swing.JTextField artista;
    private javax.swing.JTextField año;
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnPlay;
    private javax.swing.JButton btnSeleccionarCanción;
    private javax.swing.JButton btnSiguente;
    public javax.swing.JButton btnStop;
    private javax.swing.JButton buscadorC;
    private javax.swing.JComboBox busquedaPor;
    private javax.swing.JMenuItem crearListaRMenu;
    private javax.swing.JTextField genero;
    private javax.swing.JButton guardar;
    private javax.swing.JButton guardarCancion;
    private javax.swing.JLabel icono;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lalbum;
    private javax.swing.JLabel lartista;
    private javax.swing.JLabel laño;
    private javax.swing.JLabel lgenero;
    private javax.swing.JTextField lista;
    private javax.swing.JLabel ltiempo;
    private javax.swing.JLabel ltitulo;
    private javax.swing.JLabel porsentaje;
    public javax.swing.JLabel reproduciendo;
    private javax.swing.JTextField titulo;
    public javax.swing.JLabel vol;
    public javax.swing.JSlider volumen;
    // End of variables declaration//GEN-END:variables

}