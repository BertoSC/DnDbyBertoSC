package dd.core;

public class AtaqueEspada implements AtaqueTipo{
    
    @Override
    public int lanzaAtaque() {
        int acierto = comprobar.acierta();
        double factor = comprobar.factor() * 100;
        int dañoFinal = (int) (acierto * factor);
                   
        return dañoFinal;
    }

    @Override
    public String toString() {
        return "Ataque con espada: ";
    }

    
}    
