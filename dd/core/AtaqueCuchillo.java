package dd.core;

public class AtaqueCuchillo implements AtaqueTipo{
    
    @Override
    public int lanzaAtaque() {
        int acierto = comprobar.acierta();
        double factor = comprobar.factor() * 25;
        int dañoFinal = (int) (acierto * factor);
                
        return dañoFinal;
    }

    @Override
    public String toString() {
        return "Ataque con cuchillo: ";
    }

}
