
package DB4O;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;


public class GestorDb {
   private ObjectContainer db; 
    public ObjectContainer abrirDb(){
   db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"primerIntento"); 
return db;
   }
   public void cerrarDb(){
   db.close();
   }

    void close() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    ObjectSet queryByExample(Empleado b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
