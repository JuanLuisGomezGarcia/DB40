
package DB4O;

import static DB4O.FuncionesEmpleado.*;
import static DB4O.FuncionesHistorial.*;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FuncionesHistorial {
    
    /* -----------S-E-P-A-R-A-D-O-R---------((()))-------F-U-N-C-I-O-N-E-S---------------*/
    
    //ESTA FUNCION MUESTRA UNA LISTA DE LOS HISTORIALES
    public static int listaHistorial(ObjectContainer db){
    //Se crea un objeto object donde se almacena la consulta
    ObjectSet result = db.queryByExample(Historial.class);
    //Y luego se reccorre con un while mientra se muestra por pantalla
    while (result.hasNext()){
    System.out.println(result.next());}
    return result.size();}
    
    /* -----------S-E-P-A-R-A-D-O-R---------((()))-------F-U-N-C-I-O-N-E-S---------------*/
    
    //ESTA FUNCION GENERA EL ID AUTOMATICAMENTE DEL NUEVO HISTORIAL
    public static int generarIDhistorial(ObjectContainer db){
    //Se crea un objeto object donde se almacena la consulta
    Historial historial = null;
    ObjectSet result = db.queryByExample(Historial.class);
    //Y luego se reccorre con un while
    while (result.hasNext()){
    historial = (Historial)result.next();}
    //Guardamos el ultimo historial de la lista cogemos su id y le sumamos uno
    int id = historial.getIdevento();
    id++;return id;}
    
    /* -----------S-E-P-A-R-A-D-O-R---------((()))-------F-U-N-C-I-O-N-E-S---------------*/
    
    //ESTA FUNCION DEVUELVE EL RANKING DE HISTORIALES URGENTES
    public static List<Ranking> obtenerRanking(ObjectContainer db){
    //Se crea un objeto object donde se almacena la consulta
    ObjectSet result = db.queryByExample(Empleado.class);
    //Creamos un list donde meteremos las objetos del ranking objeto especifico para esta funcion
    List <Ranking> listaRanking = new ArrayList<>();
    int posicion = 0;
    //Recorremos cada empleado y sacamos su list de historiales el cual recorremos por un for
    //este for contiene un if y cada historial tipo U deja entrar al if aumentando una variable tipo
    //int que acabara siendo uno de los atributos de los objetos ranking
    while (result.hasNext()){
    Empleado empleado = (Empleado)result.next();
    String nombre = empleado.getNombreusuario();
    int cantidadHistoriales = 0;
    List <Historial> listaHistoriales = empleado.getListaHistorial();
    for(Historial historial : listaHistoriales){
    if(historial.getTipo().equals("U")){
    cantidadHistoriales++;}}
    Ranking ranking = new Ranking(nombre,cantidadHistoriales);
    //Estos objetos semeten en una LIST de objetos ranking
    listaRanking.add(ranking);}
    //para terminar usamos un collection el cual establecera los valores de mayor a menor
    //Segun su atributo int
    Collections.sort(listaRanking,new Comparator<Ranking>(){    
    public int compare(Ranking ranking1,Ranking ranking2){
    return ranking2.getCantidadHistoriales() - ranking1.getCantidadHistoriales();}});
    for(Ranking ranking : listaRanking){posicion++;
    System.out.println("Posicion: " + posicion + " " + ranking.toString());}
    return listaRanking;}   
   
    /* -----------S-E-P-A-R-A-D-O-R---------((()))-------F-U-N-C-I-O-N-E-S---------------*/
    
    //ESTA FUNCION DEVUELVE POSICION EMPLEADO EN EL RANKING
    //Se crea un objeto object donde se almacena la consulta
    public static void posicionRanking(ObjectContainer db){
    //Se obtiene el ranking que retorna la funcion anterior
    List<Ranking> listaRanking = obtenerRanking(db);
    //Se le pideal usuario el nombre de un usuario
    Empleado empleado = obtenerEmpleado(db);
    int posicion = 0;
    //Este ranking se recorre y se compara con el nombre de usuario pedido
    for(Ranking ranking : listaRanking){
    posicion++;
    //Cuando el nombre introducido cuincida con el nombre de la Lista del ranking
    //devolvera la posiciony los datos
    if(empleado.getNombreusuario().equals(ranking.getNombre()))
    System.out.println("Posicion: " + posicion + " " + ranking.toString());}}
    
    /* -----------S-E-P-A-R-A-D-O-R---------((()))-------F-U-N-C-I-O-N-E-S---------------*/
    
    //ESTA FUNCIO TE DA EL ULTIMO HISTORIAL
    public static void ultimoHistorial(ObjectContainer db){
    //Se crea un objeto object donde se almacena la consulta
    ObjectSet result = db.queryByExample(Historial.class);
    Historial historialUltimo = null;
    //Recorremos el result y el ultimo objeto historial de tipo I que nos devuelta lo mostramos
    //por consola ya que es el mas nuevo
    while (result.hasNext()){
    Historial historial = (Historial)result.next();
    if(historial.getTipo().equals("I")){
    historialUltimo=historial;}}
    System.out.println(historialUltimo.toString());}}
