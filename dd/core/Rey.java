package dd.core;

public class Rey extends Personaje{
    public Rey(String n){
        super(n);
        setSalud(2000);


    }
    @Override
    public int[] ataca(Personaje rival) {
        int [] daño = new int[3];
        for (int n=0; n<daño.length; n++){
            int golpe=getAtaque().lanzaAtaque();
            daño[n]=golpe;
            rival.setSalud(rival.getSalud()-golpe);
        }
        return daño;
    }
    
    @Override
    public String toString() {
        return "["+getNombre()+": "+getSalud()+"]";
    }   
}
