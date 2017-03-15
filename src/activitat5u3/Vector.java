package activitat5u3;

import java.io.Serializable;

/**
 *
 * @author Eric
 */
public class Vector implements Serializable {
    
    private String[] cadena;

    public Vector() {
    }   
    
    public Vector(String[] cadena) {
        this.cadena = cadena;
    }

    public String[] getCadena() {
        return cadena;
    }

    public void setCadena(String[] cadena) {
        this.cadena = cadena;
    }
    
    
    
}
