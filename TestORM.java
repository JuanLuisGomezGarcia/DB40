
package DB4O;
import static DB4O.FuncionesEmpleado.*;
import static DB4O.FuncionesIncidencia.*;
import static DB4O.FuncionesHistorial.*;
import static DB4O.Utilidades.*;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import java.util.ArrayList;
import java.util.List;

public class TestORM {
    
    public static void main(String[] args) {
    //Generamosel objeto ObjectContainer y lo enlazamos a un nuevo documento de texto
    ObjectContainer db; 
    db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"primerIntento");

    //Con un if introducimos los datos iniciales de la base de datos es te if permitira el acceso a la
    //inserccion de los datos en caso de que no existan
    int introducirEmpleados = filtroEmpleado(db);    
    if(introducirEmpleados == 0){
    //Aunque el programa puede usarse con la base de datos vacia e introducido unos datos iniciales
    //para que su prueba sea mas comoda para el usuario
    //Ceamos empleados
    Empleado empleado1=new Empleado("Leonardo","111","Leonardo Tortuga Azul","792758");
    Empleado empleado2=new Empleado("Michelangelo","111","Michelangelo Tortuga Naranja","687748");
    Empleado empleado3=new Empleado("Donatello","111 ","Donatello Tortuga Morada","3408283");
    Empleado empleado4=new Empleado("Raphael","111","Raphael Tortuga Roja","7690987");
    Empleado empleado5=new Empleado("Astilla","111","Astilla Rata","9090003");
    //Creamos las listas de los empleados
    List<Incidencia> listaIncidenciaOrigenEmpleado1 = new ArrayList<>();      
    List<Incidencia> listaIncidenciaDestinoEmpleado1 = new ArrayList<>();
    List<Historial> listaHistorialEmpleado1 = new ArrayList<>();
    List<Incidencia> listaIncidenciaOrigenEmpleado2 = new ArrayList<>();
    List<Incidencia> listaIncidenciaDestinoEmpleado2 = new ArrayList<>();
    List<Historial> listaHistorialEmpleado2 = new ArrayList<>();
    List<Incidencia> listaIncidenciaOrigenEmpleado3 = new ArrayList<>();
    List<Incidencia> listaIncidenciaDestinoEmpleado3 = new ArrayList<>();
    List<Historial> listaHistorialEmpleado3 = new ArrayList<>();
    List<Incidencia> listaIncidenciaOrigenEmpleado4 = new ArrayList<>();
    List<Incidencia> listaIncidenciaDestinoEmpleado4 = new ArrayList<>();
    List<Historial> listaHistorialEmpleado4 = new ArrayList<>();
    List<Incidencia> listaIncidenciaOrigenEmpleado5 = new ArrayList<>();
    List<Incidencia> listaIncidenciaDestinoEmpleado5 = new ArrayList<>();
    List<Historial> listaHistorialEmpleado5 = new ArrayList<>();
    //Introucimos las listas a los empleados
    empleado1.setIncidenciasDestino(listaIncidenciaDestinoEmpleado1);      empleado2.setIncidenciasDestino(listaIncidenciaDestinoEmpleado2);
    empleado1.setIncidenciasOrigen(listaIncidenciaOrigenEmpleado1);        empleado2.setIncidenciasOrigen(listaIncidenciaOrigenEmpleado2);
    empleado1.setListaHistorial(listaHistorialEmpleado1);                  empleado2.setListaHistorial(listaHistorialEmpleado2);
    empleado3.setIncidenciasDestino(listaIncidenciaDestinoEmpleado3);      empleado4.setIncidenciasDestino(listaIncidenciaDestinoEmpleado4);
    empleado3.setIncidenciasOrigen(listaIncidenciaOrigenEmpleado3);        empleado4.setIncidenciasOrigen(listaIncidenciaOrigenEmpleado4);
    empleado3.setListaHistorial(listaHistorialEmpleado3);                  empleado4.setListaHistorial(listaHistorialEmpleado4);
    empleado5.setIncidenciasDestino(listaIncidenciaDestinoEmpleado5);  
    empleado5.setIncidenciasOrigen(listaIncidenciaOrigenEmpleado5);       
    empleado5.setListaHistorial(listaHistorialEmpleado5);  
    //Cramos las incidencias
    Incidencia incidencia1=new Incidencia(1,"Leonardo","Donatello","28/11/2000 12:07:12","Necesitamos reparar algunas armas","Urgente");
    Incidencia incidencia2=new Incidencia(2,"Michelangelo","Leonardo,","02/1/2010 10:47:52","¡Que salvamos primero, el mundo o la lengua castellana?","Urgente");
    Incidencia incidencia3=new Incidencia(3,"Donatello","Leonardo","10/05/2014 22:00:42","¿Qué eres? ¿Tonto? Espera, voy a cambiar eso… ¡Eres un tonto!","Normal");
    Incidencia incidencia4=new Incidencia(4,"Raphael","Leonardo","01/06/2014 19:34:29","No somos ranas kun fu ¡somos tortugas ninja! ","Normal");
    Incidencia incidencia5=new Incidencia(5,"Astilla","Michelangelo","08/105/2015 20:01:55","El enemigo de mi enemigo es mi hermano.","Urgente");
    Incidencia incidencia6=new Incidencia(6,"Leonardo","Michelangelo","26/08/2017 06:59:59","Elegimos lo que nos detiene y lo que nos impulsa.","Urgente");
    Incidencia incidencia7=new Incidencia(7,"Michelangelo","Raphael","07/09/2017 00:00:00","El aburrimiento está convirtiéndose en mi enfermedad. ","Normal");
    Incidencia incidencia8=new Incidencia(8,"Raphael","Raphael","18/11/2017 01:35:16","¿Estar en paz? ¿Qué somos? ¿¡Hippies!? ¡Somos ninjas!","Normal");
    Incidencia incidencia9=new Incidencia(9,"Astilla","Raphael","02/12/2018 11:53:51","No dejes que los demás hagan tu vida.","Urgente");
    Incidencia incidencia10=new Incidencia(10,"Astilla","Raphael","16/05/2020 14:09:40","Vivimos en una sociedad en donde la pizza llega primero que la policía.","Urgente");
    //Introducimos las incidencias a la base de datos
    db.store(incidencia1);                db.store(incidencia2); 
    db.store(incidencia3);                db.store(incidencia4);
    db.store(incidencia5);                db.store(incidencia6); 
    db.store(incidencia7);                db.store(incidencia8);
    db.store(incidencia9);                db.store(incidencia10);
    //Introducimos las incidencias en la lista de los empleados
    empleado1.setIncidenciaOrigen(incidencia1);   empleado1.setIncidenciaOrigen(incidencia6);
    empleado1.setIncidenciaDestino(incidencia2);  empleado1.setIncidenciaDestino(incidencia3); 
    empleado2.setIncidenciaOrigen(incidencia2);   empleado1.setIncidenciaOrigen(incidencia7);
    empleado2.setIncidenciaDestino(incidencia5);  empleado2.setIncidenciaDestino(incidencia6);
    empleado1.setIncidenciaDestino(incidencia4);  empleado3.setIncidenciaOrigen(incidencia3);
    empleado3.setIncidenciaDestino(incidencia1);  empleado4.setIncidenciaOrigen(incidencia4);
    empleado4.setIncidenciaOrigen(incidencia8);   empleado4.setIncidenciaDestino(incidencia7);
    empleado4.setIncidenciaDestino(incidencia8);  empleado4.setIncidenciaDestino(incidencia9);
    empleado4.setIncidenciaDestino(incidencia10); empleado5.setIncidenciaOrigen(incidencia5);
    empleado2.setIncidenciaOrigen(incidencia9);   empleado2.setIncidenciaOrigen(incidencia10);
    //Creamos los historiales  
    Historial historial1 = new Historial(1,"U","28/11/2000 12:07:12","Leonardo");    
    Historial historial2 = new Historial(2,"U","02/1/2010 10:47:52","Michelangelo");  
    Historial historial3 = new Historial(3,"U","08/105/2015 20:01:55","Michelangelo");  
    Historial historial4 = new Historial(4,"U","08/105/2015 20:01:55","Astilla");  
    Historial historial5 = new Historial(5,"U","26/08/2017 06:59:59","Leonardo");  
    Historial historial6 = new Historial(6,"U","02/12/2018 11:53:51","Astilla");  
    Historial historial7 = new Historial(7,"U","16/05/2020 14:09:40","Astilla");  
    Historial historial8 = new Historial(8,"I","28/11/2000 12:07:12","Leonardo");    
    Historial historial9 = new Historial(9,"I","02/1/2010 10:47:52","Michelangelo");  
    Historial historial10 = new Historial(10,"I","08/105/2015 20:01:55","Michelangelo");  
    Historial historial11 = new Historial(11,"I","08/105/2015 20:01:55","Astilla");  
    Historial historial12 = new Historial(12,"I","26/08/2017 06:59:59","Leonardo");  
    Historial historial13 = new Historial(13,"I","02/12/2018 11:53:51","Astilla");  
    Historial historial14 = new Historial(14,"I","16/05/2020 14:09:40","Astilla"); 
    //Los introducimos en la base de datos  
    db.store(historial1);     db.store(historial5);       db.store(historial9);
    db.store(historial2);     db.store(historial6);       db.store(historial10);
    db.store(historial3);     db.store(historial7);       db.store(historial11);
    db.store(historial4);     db.store(historial8);       db.store(historial12);
    db.store(historial13);    db.store(historial14);    
    //Introducimos los historiales a las listas de los usuarios  
    empleado1.addEventoToHistorial(historial1);  empleado1.addEventoToHistorial(historial5);
    empleado1.addEventoToHistorial(historial8);  empleado1.addEventoToHistorial(historial12);
    empleado2.addEventoToHistorial(historial2);  empleado2.addEventoToHistorial(historial3);
    empleado2.addEventoToHistorial(historial9);  empleado2.addEventoToHistorial(historial10);
    empleado5.addEventoToHistorial(historial4); empleado2.addEventoToHistorial(historial6);
    empleado5.addEventoToHistorial(historial7); empleado2.addEventoToHistorial(historial11);
    empleado5.addEventoToHistorial(historial14); empleado2.addEventoToHistorial(historial13);
    //Introducimos los empleados en la base de datos
    db.store(empleado1);                db.store(empleado2); 
    db.store(empleado3);                db.store(empleado4);
    db.store(empleado5); }
     
    //Variable que usaran los distintos menus en su switch y do while
    int numeroMenu = 0;
    int numeroMenuUsuario = 0;
    int numeroMenuIncidencia = 0;
    int numeroMenuHistorial = 0;
    //MENU DE LA ACTIVIDAD
    do{
        //MENU CENTRAL    
        System.out.println("1.GESTION USUARIOS\n" +
        "2.GESTION INCIDENCIAS\n" +
        "3.GESTION HISTORIAL\n" +
        "0 Salir.");
        numeroMenu = pedirInt();    
        switch(numeroMenu){
        case 1:
            //Menu empleado
            do{
            System.out.println("1.Insertar un empleado nuevo en la B.D.\n" +
            "2.Validar la entrada de un empleado (suministrando usuario y contraseña)\n" +
            "3.Modificar el perfil de un empleado existente.\n" +
            "4.Cambiar la contraseña de un empleado existente.\n" +
            "5.Eliminar un empleado.\n" +
            "0 Salir.");
            numeroMenuUsuario = pedirInt();
            switch(numeroMenuUsuario){
            case 1: insertarEmpleado(db);
                break;
            case 2: logginUsuario(db);
                break;
            case 3: modificarEmpleado(db);
                break;
            case 4: modificarPassword(db);
                break;
            case 5: eliminarEmpleado(db);
                break;
            case 0: System.out.println("MENU USUARIOS CERRADO");
                break; }
            }while(!(numeroMenuUsuario == 0));
        break;
        case 2:
            //Menu incidencias
            do{
            System.out.println("1.Obtener un objeto Incidencia a partir de su Id.\n" +
            "2.Obtener la lista de todas las incidencias.\n" +
            "3.Insertar una incidencia.\n" +
            "4.Obtener las incidencias para un empleado a partir de un objeto de clase Empleado.\n" +
            "5.Obtener las incidencias creadas por un empleado concreto.\n" + 
            "0.Salir");
            numeroMenuIncidencia = pedirInt();
            switch(numeroMenuIncidencia){
            case 1: obtenerIncidenciaID(db);
                break;
            case 2: listaIncidencia(db);
                break;
            case 3: insertarIncidencia(db);
                break;
            case 4: obtenerIncidenciaDestinoUsuario(db);
                break;
            case 5: obtenerIncidenciaOrigenUsuario(db);
                break;
            case 0: System.out.println("MENU INCIDENCIAS CERRADO");
                break; }
            }while(!(numeroMenuIncidencia == 0));
        break;
        case 3:
            //Menu historial
            do{
            System.out.println("1.Obtener la fecha-hora del último inicio de sesión para un empleado concreto.\n" +
            "2.Obtener el ranking de los empleados por cantidad de incidencias urgentes creadas (más incidencias primero).\n" +
            "3.Obtener la posición dentro del ranking para un empleado concreto.\n" +
            "0.Salir");
            numeroMenuHistorial = pedirInt();
            switch(numeroMenuHistorial){
            case 1: ultimoHistorial(db);
                break;
            case 2: obtenerRanking(db);
                break;
            case 3: posicionRanking(db);
                break;
            case 0: System.out.println("MENU HISTORIAL CERRADO");
                break; }
            }while(!(numeroMenuHistorial == 0));
        break;}}while(!(numeroMenu == 0)); 
System.out.println("FIN DE PROGRAMA");
    db.close();}}
