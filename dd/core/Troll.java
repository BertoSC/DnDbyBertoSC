package dd.core;

public class Troll extends Personaje{

    public Troll(String nom) {
        super(nom);
        setSalud(1000);
        
    }

    @Override
    public int[] ataca(Personaje rival) {
        int [] daño = new int[1];
        for (int n=0; n<daño.length; n++){
            int golpe=getAtaque().lanzaAtaque();
            daño[n]=golpe;
            rival.setSalud(rival.getSalud()-golpe);
        }
        return daño;
    }

    @Override
    public String toString() {
        return "["+getNombre()+": "+getSalud()+"];";
    }
}
