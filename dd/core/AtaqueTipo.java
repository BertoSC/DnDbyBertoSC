package dd.core;
import java.util.Random;

public interface AtaqueTipo {
    public Aleatoria comprobar = new Aleatoria();
    int lanzaAtaque();
    String toString();
}

class Aleatoria{
    Random random= new Random();

    public int acierta(){
        return random.nextInt(2);
    }
    public double factor(){
        return random.nextDouble();
    }
        
}

