
package DB4O;

import static DB4O.FuncionesEmpleado.*;
import static DB4O.FuncionesIncidencia.*;
import static DB4O.FuncionesHistorial.*;
import static DB4O.Utilidades.*;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class FuncionesIncidencia {
    
    /* -----------S-E-P-A-R-A-D-O-R---------((()))-------F-U-N-C-I-O-N-E-S---------------*/
    
    //ESTA FUNCION OBTIENE EL ID DE UNA INCIDENCIA
    public static Incidencia obtenerIncidenciaID(ObjectContainer db){
    //Creamos un objeto incidencia que usaramos para obtener el id y un boolen para
    //salir del bucle while
    Incidencia incidenciaSeleccionado =null;
    boolean filtro = true;
    //Pedimos que introdusca un numero de id
    System.out.println("Introduce el identificador de la incidencia");
    while(filtro){
    int idIncidencia= pedirInt();
    //Creamos un objeto ObjectSet que devuelva todas las incidencias
    ObjectSet result = db.queryByExample(Incidencia.class);
    //Recorremos este objectset
    while (result.hasNext()){
    Incidencia incidencia = (Incidencia) result.next();
    //comparamos el numero introducido con los id de las incidencias
    if(idIncidencia == incidencia.getIdincidencia() ){
    //Si el id cuincide con el numero introducido el boolean pasa a false para salir del bucle
    //y se muestra la incidencia por pantalla
    filtro = false;
    incidenciaSeleccionado = incidencia;}}}
    System.out.println(incidenciaSeleccionado.toString());
    return incidenciaSeleccionado;}
    
    /* -----------S-E-P-A-R-A-D-O-R---------((()))-------F-U-N-C-I-O-N-E-S---------------*/
    
    //ESTA FUNCION MUESTRA LA LISTA DE INCIDENCIA
    public static int listaIncidencia(ObjectContainer db){
    //Creamos un objectset con todas las incidencias
    ObjectSet result = db.queryByExample(Incidencia.class);
    //Y lo recorremos con un wile y lo mostramos por pantalla
    while (result.hasNext()){
    System.out.println(result.next());}
    return result.size();}
    
    /* -----------S-E-P-A-R-A-D-O-R---------((()))-------F-U-N-C-I-O-N-E-S---------------*/
    
    //ESTA FUNCION OBTIENE LAS INCIDENCIA DE ORIGEN USUARIO
    public static void obtenerIncidenciaOrigenUsuario(ObjectContainer db){
    //Obtenemos el usuario seleccionado
    Empleado empleado = obtenerEmpleado(db);
    //Obtenemos su lista de incidencias de origen
    List<Incidencia> listaIncidencia = empleado.getIncidenciasOrigen();
    //Y recorremos esta lista mostrandola por pantalla
    System.out.println("\n");
    for (Incidencia incidencia : listaIncidencia){
    System.out.println( incidencia.toString());}}
    //ESTA FUNCION OBTIENE LAS INCIDENCIA DE DESTINO DE USUARIO
    public static void obtenerIncidenciaDestinoUsuario(ObjectContainer db){
    //igual que la funcion anterior pero seleccionndo la lista de incidencias destino
    Empleado empleado = obtenerEmpleado(db);
    List<Incidencia> listaIncidencia = empleado.getIncidenciasDestino();
    for (Incidencia incidencia : listaIncidencia){
    System.out.println(incidencia.toString());}
    //Una vez creada la incidencia se crea una variable que almacena la fecha y hora y se convierte a string
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    String format = dtf.format(LocalDateTime.now());
    int idHistorial = generarIDhistorial(db);
    //Este string junto el nombre del usuario y el tipo en este caso I se usan par crear un objeto historial
    Historial nuevoHistorial = new Historial(idHistorial,"C",format,empleado.getNombreusuario());
    db.store(nuevoHistorial);}
    
    /* -----------S-E-P-A-R-A-D-O-R---------((()))-------F-U-N-C-I-O-N-E-S---------------*/
    
    //ESTA FUNCION NOS PERMITE PEDIR EL NUMERO DE IDENTIFICACION DE LA INCIDENCIA
    public static int introducirNumeroIncidencia(ObjectContainer db){
    int idIncidencia = 0;
    boolean filtro = false;
    do{
    filtro = false;
    System.out.println("Introduce el id de la incidencia");
    idIncidencia = pedirInt();
    //Creamos el objectSet
    ObjectSet result = db.queryByExample(Incidencia.class);
    //Lo recorremos
    while (result.hasNext()){
    Incidencia incidencia = (Incidencia) result.next();
    //Si cuincide con uno existente activamos el boolean y repetimos el bucle
    if(idIncidencia == incidencia.getIdincidencia() ){
    filtro = true;System.out.println("Esta id ya esta siendo utilizado");}}
    }while(filtro);
    //si no esta usado enviamos el numero introducido
    return idIncidencia;}

    /* -----------S-E-P-A-R-A-D-O-R---------((()))-------F-U-N-C-I-O-N-E-S---------------*/
    
    //ESTA FUNCION NOS PERMITE PEDIR LA FECHA Y HORA DE LA INCIDENCIA
    public static String introducirFechaHora(){
    //Es una funcion sensilla pedimos un string con la funcion pedir string y pasamos su tamaño por el while
    //para controlar los requisitos de cantidad de varchar de la base de datos que no han proporcionado
    String fechaHoraSeleccionada = "";
    do{
    System.out.println("Introduce la fecha y hora recuerda que su tamaño maximo sera de 50 caracteres");
    fechaHoraSeleccionada = pedirString();
    }while(!(fechaHoraSeleccionada.length()<51));
    return fechaHoraSeleccionada;}
    
    /* -----------S-E-P-A-R-A-D-O-R---------((()))-------F-U-N-C-I-O-N-E-S---------------*/
    
    //ESTA FUNCION NOS PERMITE PEDIR EL TIPO DE LA INCIDENCIA
    public static String introducirTipo(){
    //Es una funcion sensilla pedimos un string con la funcion pedir string y pasamos su tamaño por el while
    //para controlar los requisitos de cantidad de varchar de la base de datos que no han proporcionado
    String tipoSeleccionado = "";
    do{
    System.out.println("Introduce el tipo recuerda que su tamaño maximo sera de 8 caracteres");
    tipoSeleccionado = pedirString();
    }while(!(tipoSeleccionado.length()<9));
    return tipoSeleccionado;}     
    
    /* -----------S-E-P-A-R-A-D-O-R---------((()))-------F-U-N-C-I-O-N-E-S---------------*/
    
    //ESTA FUNCION NOS PERMITE PEDIR TODOS LOS DATOS DE LA INCIDENCIA
    public static void insertarIncidencia(ObjectContainer db){
    //Pedimos todos los valores necesarios para crear la incidencias funcionesEmpleado traves de las funciones
    //creadas especificamente en esta clase para este motivo
    System.out.println("Inserta el numero de incidencia");
    int idIncidencia = introducirNumeroIncidencia(db);
    System.out.println("SELECCIONA ORIGEN");
    Empleado origen = obtenerEmpleado(db);
    System.out.println("SELECCIONA DESTINO");
    Empleado destino = obtenerEmpleado(db); 
    String fechaHora = introducirFechaHora();   
    String tipo = introducirTipo();
    System.out.println("Introduce los detalles");
    String detalle = pedirString();
    //Introducimos todos los valores en un nuevo objeto de incidencias
    Incidencia incidencia = new Incidencia(idIncidencia,origen.getNombreusuario(),destino.getNombreusuario(),fechaHora,detalle,tipo);
    origen.setIncidenciaOrigen(incidencia);
    destino.setIncidenciaDestino(incidencia);
    db.store(incidencia);
    //Creamos un if que filtra las incidencia y genera un historial en caso de que sea urgente
    if(tipo.equals("Urgente")||tipo.equals("urgente")){    
    //Una vez creada la incidencia se crea una variable que almacena la fecha y hora y se convierte a string
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    String format = dtf.format(LocalDateTime.now());
    int idHistorial = generarIDhistorial(db);
    //Este string junto el nombre del usuario y el tipo en este caso I se usan par crear un objeto historial
    Historial nuevoHistorial = new Historial(idHistorial,"U",format,origen.getNombreusuario());
    db.store(nuevoHistorial);}}}
