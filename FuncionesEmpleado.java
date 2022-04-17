
package DB4O;

import static DB4O.FuncionesEmpleado.*;
import static DB4O.Utilidades.*;
import static DB4O.FuncionesHistorial.*;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FuncionesEmpleado {
    
    /* -----------S-E-P-A-R-A-D-O-R---------((()))-------F-U-N-C-I-O-N-E-S---------------*/
    
    //ESTA FUNCION DEVUELVE UNA LISTA DE LOS EMPLEADOS EXISTENTES
    public static int listaEmpleado(ObjectContainer db){
    //Se crea un objeto object donde se almacena la consulta
    ObjectSet result = db.queryByExample(Empleado.class);
    //Recorremos el result y mostramos los objetos por pantalla
    while (result.hasNext()){
    Empleado empleado = (Empleado)result.next();
    System.out.println(empleado.getNombreusuario());}
    return result.size();}
    
    /* -----------S-E-P-A-R-A-D-O-R---------((()))-------F-U-N-C-I-O-N-E-S---------------*/
    
    //ESTA FUNCION DEVUELVE EL EMPLEADO SELECCIONADO
    public static Empleado obtenerEmpleado(ObjectContainer db){
    //Creamos distintas variables que usaremos una de objeto y dos boolean que serviran
    //para controlar los bucles
    Empleado empleadoSeleccionado =null;
    boolean filtro = true;
    boolean filtroIncorrecto = false;
    //Mostramos los usuarios existentes
    System.out.println("INTRODUCE EL NOMBRE DEL USUARIO");
    listaEmpleado(db);
    while(filtro){
    //Este if se activa si el usuario introducido no existe
    if(filtroIncorrecto){System.out.println("El empleado no existe, intentalo de nuevo.");}
    //Pedimos un string
    String nombreEmpleado = pedirString();
    //Se crea un objeto object donde se almacena la consulta
    ObjectSet result = db.queryByExample(Empleado.class);
    //Lo recorremos
    while (result.hasNext()){         
    Empleado empleado = (Empleado) result.next();
    //Si el string intoducido cuuincide con el nombre de algun usuario sale de los bucles
    //y se envia el objeto
    if(nombreEmpleado.equals(empleado.getNombreusuario())){
    filtro = false;
    empleadoSeleccionado = empleado;}
    }filtroIncorrecto = true;}
    return empleadoSeleccionado;}
    
    /* -----------S-E-P-A-R-A-D-O-R---------((()))-------F-U-N-C-I-O-N-E-S---------------*/
    
    //ELIMINAR EMPLEADO
    public static void eliminarEmpleado(ObjectContainer db){
    //Se crea un objeto object donde se almacena la consulta y se pide un usuario
    Empleado empleado = obtenerEmpleado(db);
    ObjectSet result = db.queryByExample(empleado);
    //se reccore el db con el nombre del usuario
    while (result.hasNext()){
    Empleado empleadoBorrado = (Empleado) result.next();
    //y se borra
    db.delete(empleadoBorrado);}}
    
    /* -----------S-E-P-A-R-A-D-O-R---------((()))-------F-U-N-C-I-O-N-E-S---------------*/
    
    //MODIFICAR EMPLEADO
    public static void modificarEmpleado(ObjectContainer db){
    //Se obtiene el objeto del empleado seleccionado
    Empleado empleado = obtenerEmpleado(db);
    //Se piden los nuevos valores
    String nuevoNombre = insertarNombreCompleto();
    String nuevoPassword = insertarPassword();
    String nuevoTelefono = insertarTelefono();
    //Se crea un objeto object donde se almacena la consulta
    ObjectSet result = db.queryByExample(empleado);
    //Recorremos el objeto selccionado
    while (result.hasNext()){
    Empleado empleadoModificado = (Empleado) result.next();
    //Añadimos los cambios
    empleadoModificado.setNombrecompleto(nuevoNombre);
    empleadoModificado.setPassword(nuevoPassword);
    empleadoModificado.setTelefono(nuevoTelefono);
    //Y introducimos los cambios a la base de datos
    db.store(empleadoModificado);}}
    
    /* -----------S-E-P-A-R-A-D-O-R---------((()))-------F-U-N-C-I-O-N-E-S---------------*/
    
    //MODIFICAR PASSWORD
    public static void modificarPassword(ObjectContainer db){
    //Seleccionamos el empleado
    Empleado empleado = obtenerEmpleado(db);
    //introducimos el nuevo password
    String nuevoPassword = insertarPassword();
    //Se crea un objeto object donde se almacena la consulta
    ObjectSet result = db.queryByExample(empleado);
    while (result.hasNext()){
    Empleado empleadoModificado = (Empleado) result.next();
    //Introducimos el nuevo password 
    empleadoModificado.setPassword(nuevoPassword);
    //Y lo introducimos a la base de datos
    db.store(empleadoModificado);}}
        
    //FUNCION PARA PEDIR EL NOMBRE COMPLETO
    public static String insertarNombreCompleto(){
    String nombreSeleccionado = "";
    //Es una funcion sensilla pedimos un string con la funcion pedir string y pasamos su tamaño por el while
    //para controlar los requisitos de cantidad de varchar de la base de datos que no han proporcionado
    do{
    System.out.println("Introduce el nombre completo recuerda que su tamaño maximo sera de 50 caracteres");
    nombreSeleccionado = pedirString();
    }while(!(nombreSeleccionado.length()<51));
    return nombreSeleccionado;}
    
    /* -----------S-E-P-A-R-A-D-O-R---------((()))-------F-U-N-C-I-O-N-E-S---------------*/
    
    //FUNCION PARA PEDIR EL PASSWORD
    public static String insertarPassword(){
    String passwordSeleccionado = "";
    //Es una funcion sensilla pedimos un string con la funcion pedir string y pasamos su tamaño por el while
    //para controlar los requisitos de cantidad de varchar de la base de datos que no han proporcionado
    do{
    System.out.println("Introduce el password recuerda que su tamaño maximo sera de 10 caracteres");
    passwordSeleccionado = pedirString();
    }while(!(passwordSeleccionado.length()<11));
    return passwordSeleccionado;}
        //FUNCION PARA PEDIR EL TELEFONO
    public static String insertarTelefono(){
    String telefonoSeleccionado = "";
    //Es una funcion sensilla pedimos un string con la funcion pedir string y pasamos su tamaño por el while
    //para controlar los requisitos de cantidad de varchar de la base de datos que no han proporcionado
    do{
    System.out.println("Introduce el telefono recuerda que su tamaño maximo sera de 9 caracteres");
    telefonoSeleccionado = pedirString();
    }while(!(telefonoSeleccionado.length()<10));
    return telefonoSeleccionado;}
    
    /* -----------S-E-P-A-R-A-D-O-R---------((()))-------F-U-N-C-I-O-N-E-S---------------*/
    
    //FUNCION PARA PEDIR EL NOMBRE DE USUARIO
    public static String insertarNombreUsuario(ObjectContainer db){
    boolean filtro = true;
    System.out.println("INTRODUCE EL NOMBRE DEL USUARIO");
    String nombreEmpleado ="";
    while(filtro){
    filtro = false;
    //pedimo un string
    nombreEmpleado = pedirString();
    //Se crea un objeto object donde se almacena la consulta
    ObjectSet result = db.queryByExample(Empleado.class); 
    //recorremos todos los usuarios
    while (result.hasNext()){         
    Empleado empleado = (Empleado) result.next();
    //Comparamos el string con los nombres existentes de los usuarios
    if(nombreEmpleado.equals(empleado.getNombreusuario())){
    //En caso deque exista repetimos el bucle
    filtro = true;System.err.println("El empleado existe");}}}
    return nombreEmpleado;}  
    
    /* -----------S-E-P-A-R-A-D-O-R---------((()))-------F-U-N-C-I-O-N-E-S---------------*/
    
    //FUNCION PARA INSERTAR EMPLEADO
    public static void insertarEmpleado(ObjectContainer db){    
    //Pedimos todos los valores necesarios para crear la incidencias a traves de las funciones
    //creadas especificamente en esta clase para este motivo
    String nombreUsuario = insertarNombreUsuario(db);
    String password = insertarPassword();
    String nombreCompleto = insertarNombreCompleto();
    String telefono = insertarTelefono();                      
    //Introducimos todos los valores en un nuevo objeto empleado y creamos sus LIST
    Empleado empleado = new Empleado(nombreUsuario,password,nombreCompleto,telefono);
    List<Incidencia> listaIncidenciaOrigen = new ArrayList<>();
    List<Incidencia> listaIncidenciaDestino = new ArrayList<>();
    List<Historial> listaHistorial = new ArrayList<>();
    empleado.setIncidenciasDestino(listaIncidenciaDestino);
    empleado.setIncidenciasOrigen(listaIncidenciaOrigen);
    empleado.setListaHistorial(listaHistorial);
    //y lo introducimos en la base de datos
    db.store(empleado);}
    
    /* -----------S-E-P-A-R-A-D-O-R---------((()))-------F-U-N-C-I-O-N-E-S---------------*/
    
    //FUNCION PARA PARA LOGGEAR EMPLEADO
    public static void logginUsuario(ObjectContainer db){
    //Obtenemos un empleado
    Empleado empleado = obtenerEmpleado(db);
    boolean filtro = true;   
    while(filtro){
    //y pedimos su password su passwor y lo comparamos con el del objeto empleado
    //seleccionado con la funcion obtener empleados
    System.out.println("Introduce la contraseña");
    String contraseña = pedirString();
    if(contraseña.equals(empleado.getPassword())){
    filtro = false; System.out.println("Contraseña correcta");} }
    //Una vez creada la incidencia se crea una variable que almacena la fecha y hora y se convierte a string
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    String format = dtf.format(LocalDateTime.now());
    int idHistorial = generarIDhistorial(db);
    //Este string junto el nombre del usuario y el tipo en este caso I se usan par crear un objeto historial
    Historial nuevoHistorial = new Historial(idHistorial,"I",format,empleado.getNombreusuario());
    db.store(nuevoHistorial);}}
