package dd.core;
public abstract class Personaje {
    private String nombre;
    private AtaqueTipo ataque;
    private int salud;

    public Personaje(String nom){
        this.nombre=nom;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public AtaqueTipo getAtaque() {
        return ataque; 
            
        
    }

    public void setAtaque(AtaqueTipo ataque) {
        this.ataque = ataque; 
            
         
    }

    public abstract int[] ataca(Personaje r);
}
    

    
    
    


    

   
    






