package PRODUCTO_APP;
//Librerias
import javax.swing.*;
import javax.swing.table.*;



import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.table.*;



//Funcion Main 
public class Producto_app {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Producto_app().formularioPpal());
}
//Interfaz
//Metodo para el formulario principal
private void formularioPpal() {
    JFrame formulario = new JFrame("Gestión de Productos - Droguería la Principal - Pereira");

    //Deshabilitamos el boton X (Esquina superior derecha)
    formulario.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

    //Deshabilitamos el maximizar
    formulario.setResizable(false);

    /*
    Toolkit es una clase para varios métodos para "obtener y tener acceso a la informacion
    de nuestro sistema. En este caso, se usa para
    obtener información sobre el tamaño de la pantalla.
    */  
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Dimension screenSize = toolkit.getScreenSize(); //Este devuelve un dimension para el ancho y altura de la pantalla

    // Segun el tamaño de la pantalla se establece para el formulario
    formulario.setSize(screenSize);

    //Asignar icono:  debe ser .ico o .png
    formulario.setIconImage(new ImageIcon("C:\\Users\\sebas\\OneDrive\\Documentos\\NetBeansProjects\\"
            + "ProductosApp\\src\\main\\java\\folderProductosApp\\ProductosApp.png").getImage());

    //Llamamos el metodo para centrar el formulario en pantalla
    //centrarformularioPpal(formulario);
    //Creamos la barra del menu Principal desde el método MenuPrincipal()
    JMenu menuPpal = MenuPrincipal();
    //Lo anclamos al formulario
    formulario.setMenuBar(menuPpal);
    //Hacer visible el formulario principal
    formulario.setVisible(true);
}





//Menu principal
private JMenu MenuPrincipal(){
    //Creamos e instaciamos la barra del menu
    JMenuBar menuPpal = new JMenuBar();
    //Barra menu
    JMenuBar barraMenu = new JMenuBar();

    //Creamos el item Clientes y agregamos sus opciones
    JMenu menuProducto = new JMenu("Productos");

    //Item
    JMenuItem crearProducto = new JMenuItem("Crear Producto");
    //Asignamos el comportamiento al hacer clic sobre el item, en este caso llama
    //al metodo FormularioProductos
    crearProducto.addActionListener(e -> FormularioProductos (crearProducto.getText()));

    //Item
    JMenuItem editarProducto = new JMenuItem("Editar Producto");
    //Asignamos el comportamiento al hacer clic sobre el item, en este caso llama
    //al metodo FormularioProductos()
    editarProducto.addActionListener(e -> FormularioProductos(editarProducto.getText()));

    //Item
    JMenuItem eliminarProducto = new JMenuItem("Eliminar Producto");
    //Asignamos el comportamiento al hacer clic sobre el item, en este caso llama
    //al metodo FormularioProductos()
    eliminarProducto.addActionListener(e -> FormularioProductos(eliminarProducto.getText()));

    //Item
    JMenu generarInformesProducto = new JMenu("Generar informes de producto");
/* DEPUES HACER (SUB-ITEMS)
    //SubItem de generarInformesProductos
    JMenuItem informedeProductos = new JMenuItem("Informes de Productos");
    informedeProductos.setEnable(false);

    JMenuItem informeBasicoProducto = new JMenuItem("Informe Basico de Produtos");
    // Asignamos el comportamiento al hacer clic sobre el item, en este caso llama
    // al método informedeClientes()
    informeBasicoProducto.addActionListener(e -> informedeProductos(0));
*/
    //Creamos el item Salir y su opcion
    JMenuItem menusalir = new JMenuItem("Salir");

    //Item
    JMenuItem cerrarSesion = new JMenuItem("Cerrar Sesion");

    //Asignamos el comportamiento al hacer clic sobre el item, en este caso llama
    //al metodo cerrarSesion()
    cerrarSesion.addActionListener(e -> cerrarSesion());

    /*Agregar las subopciones al item generarInformesProducto 
    HACER DESPUES 
    //Agregar las subopciones al item generarInformesProducto
    */
    //Agregamos las opciones al item Productos
    menuProducto.add(crearProducto);
    menuProducto.add(editarProducto);
    menuProducto.add(editarProducto);
    menuProducto.add(generarInformesProducto);

    //Agregamos las opciones al item Salir
    menusalir.add(cerrarSesion);

    //Agregamos los Items a la barra del menu
    menuPpal.add(menuProducto);
    menuPpal.add(menusalir);

    return menuPpal;
    
}
}



//Variables 





//Diseño de pestañas





//Creacion de pestañas y funciones 



