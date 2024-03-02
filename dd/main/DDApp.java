package dd.main;
import java.util.Scanner;

import dd.core.AtaqueArco;
import dd.core.AtaqueCuchillo;
import dd.core.AtaqueEspada;
import dd.core.AtaqueTipo;
import dd.core.Caballero;
import dd.core.Personaje;
import dd.core.Rey;
import dd.core.Troll;

import java.util.Random;

/*Clase cliente */
public class DDApp {
    private Personaje [] aliados;
    private Personaje [] enemigos;
    private Random random;
    private Scanner entrada; 

    /*Constructor que inicializa la clase y las funcionalidades del juego (explicaciones, ejércitos, batalla...)*/
    public DDApp() throws InterruptedException{
        random= new Random();
        entrada= new Scanner(System.in);
        Intro();
        Historia();
        CrearEjercitos();
        Batalla();           

    }

    private void Intro() throws InterruptedException{
        System.out.println("\t\t\t\t-------------------------------\t");
        System.out.println("\t\t\t\tDRAGONES Y MAZMORRAS by BertoSC\t");
        System.out.println("\t\t\t\t-------------------------------\t");
        System.out.println();
        System.out.println("Bienveni@ a esta humilde aventura");
        System.out.println("La jugabilidad no puede ser más sencilla:");
        System.out.println("Dos ejércitos, una batalla: el primero en caer pierde la partida");
        System.out.println("Tu bando constará de los siguientes personajes:");
        System.out.println("Un Rey [salud - 2.000, máximo daño por golpe - 100]: esta clase ataca tres veces en su turno");
        System.out.println("Un Caballero [salud - 1.500, máximo daño por golpe - 100]: esta clase ataca dos veces en su turno");
        System.out.println("Otro Caballero [salud - 1.500, máximo daño por golpe - 50]: esta clase ataca dos veces en su turno");
        System.out.println("¿Tus rivales? Una horda compuesta por un número aleatorio de trolls sanguinarios");
        System.out.println("En tu turno, y en el de la CPU, cada personaje ataca a un rival aleatorio del equipo enemigo");
        System.out.println("Evidentemente, el daño aplicado dependerá de que los dioses del azar te sonrían en el combate");
        System.out.println("Presiona ENTER y sigue las indicaciones del juego");
        entrada.nextLine();
        System.out.println();
        Thread.sleep(2000);

    }

    private void Historia(){
        System.out.println("Una clásica noche de liada, en Santiago de Compostela...");
        System.out.println("Tú y tus dos colegas salís del Modus Vivendi con exceso de birramen en el cuerpo.");
        System.out.println("Ya ni sabéis si preferís la muerte o un kebap.");
        System.out.println("De pronto, un portal interdimensional se abre ante vosotros.");
        System.out.println("Evidentemente, os adentráis en él, pensando que es la puerta del Makumba, con ánimo de entonar unas piezas.");
        System.out.println("Sin embargo, se trata de una lúgubre taberna de otra dimensión (que bien podría ser cualquier antro nocturno compostelano).");
        System.out.println("Allí os topáis con un grupo de trolls, que aún van peor que vosotros y que os amenazan con daros unas tollinas.");
        System.out.println("En ese momento, una luz mágica os envuelve y os equipa con unas armaduras bastante chulas."); 
        System.out.println("Escuchas una voz en tu cabeza (la diosa del gambling), que te ofrece su ayuda en el combate y te pregunta:");
        System.out.println();

    }

    /*método que llena los arrays de los ejércitos del jugador y la máquina */ 
    private void CrearEjercitos(){
            
       aliados= new Personaje[3];
       System.out.println("¿Cómo te llamas, mi Rey? ");
       String n1=entrada.nextLine();
       System.out.println("¿Cómo se llama tu primer caballero? "); 
       String n2=entrada.nextLine();
       System.out.println("¿Cómo se llama tu segundo caballero? "); 
       String n3=entrada.nextLine();
       aliados[0] = new Rey(n1);
       aliados[1] = new Caballero(n2);
       aliados[2] = new Caballero(n3);
       AsignarArmas();

       int rivales= random.nextInt(9)+2;
       enemigos= new Personaje[rivales];
       for (int x=0; x<rivales; x++){
           enemigos[x]= new Troll("Troll "+(x+1));
           enemigos[x].setAtaque(AtaqueAleatorio());

        }
        
      
      
    }

    /* método que asigna los tipos de ataques a los tres personajes del jugador */ 
    private void AsignarArmas(){
        aliados[0].setAtaque(new AtaqueEspada());
        aliados[1].setAtaque(new AtaqueEspada());
        aliados[2].setAtaque(new AtaqueArco());
    }
    
    /* método que escoge un tipo de ataque de forma aleatoria */
    private AtaqueTipo AtaqueAleatorio() {
        AtaqueTipo[] tiposDeAtaque = {new AtaqueEspada(), new AtaqueArco(), new AtaqueCuchillo()};
        return tiposDeAtaque[random.nextInt(tiposDeAtaque.length)];
    }

    /* método que escoge un rival de forma aleatoria del grupo contrario */ 
    private Personaje ElegirRival(Personaje[] grupo) {
        int indice = random.nextInt(grupo.length);
        if (!ComprobarMuerte(grupo[indice])) {
            return grupo[indice];
        } else {
            
            return ElegirRival(grupo);
        }
    }

    /* método que comprueba la muerte de un personaje */    
    private boolean ComprobarMuerte(Personaje x){
        if (x.getSalud()>0){
            return false;
        } else {
            return true;
        }
    }
    
    /*método que comprueba si un grupo ha ganado analizando el array del equipo rival */
    private boolean ComprobarVictoria(Personaje [] party){
        int contador=0;
        for (int c=0; c<party.length; c++){
            if (party[c].getSalud()<=0){
                contador++;
            }
        }
        if (contador==party.length){
            return true;
        } else {
            return false;
        }


    }
    
    /*método que estructura la batalla por turnos */
    private void Batalla() throws InterruptedException{
        System.out.println();
        System.out.println("QUE EMPIECE LA BATALLA");
        System.out.println();
        while (!ComprobarVictoria(aliados) && !ComprobarVictoria(enemigos)){        
            System.out.println("TURNO DE ATAQUE DEL J1");
            System.out.println();
            System.out.println("HORA DE TIRAR LOS DADOS (presiona ENTER para seguir)");
            entrada.nextLine();
            System.out.println();
            Thread.sleep(2000);
            turnoJugador();
                if (ComprobarVictoria(enemigos)){
                    System.out.println("HAS GANADO LA BATALLA");
                    System.out.println();
                    Supervivientes();
                    break;
                } else {
                    System.out.println("TURNO DE ATAQUE DEL J2");
                    System.out.println();
                    Thread.sleep(2000);
                    turnoRival();
                    if (ComprobarVictoria(aliados)){
                            System.out.println("TE HAN ANIQUILADO");
                            System.out.println();
                            break;
                        }
                }
        }
    }

    /*método que gestiona el turno del jugador */
    private void turnoJugador() throws InterruptedException{
        for (int t=0; t<aliados.length; t++){
            if (ComprobarMuerte(aliados[t])==false){
                Personaje rivalT=ElegirRival(enemigos);
                System.out.println(aliados[t]+" ataca a "+rivalT);
                int [] valores=aliados[t].ataca(rivalT);
                for (int valor:valores){
                    System.out.print(aliados[t].getAtaque());
                    if(valor>0){
                        System.out.println(valor);
                    }else{
                        System.out.println("FALLA");
                    }
                    
                }
                if (rivalT.getSalud()<=0){
                    System.out.println(rivalT.getNombre()+ " HA MUERTO");

                } else {
                    System.out.println("Salud actualizada de "+rivalT.getNombre()+" = "+rivalT.getSalud());
                }
                System.out.println();
                if (ComprobarVictoria(enemigos)){
                    break;
                }
                Thread.sleep(1000);    


            } else {
                continue;
            }
        }
        

    }
    
    /*método que gestiona el turno de la CPU */
    private void turnoRival() throws InterruptedException{
        for (int t=0; t<enemigos.length; t++){
            if (ComprobarMuerte(enemigos[t])==false){
                Personaje rivalT=ElegirRival(aliados);
                System.out.println(enemigos[t]+" ataca a "+rivalT);
                int [] valores=enemigos[t].ataca(rivalT);
                for (int valor:valores){
                    System.out.print(enemigos[t].getAtaque());
                    if(valor>0){
                        System.out.println(valor);
                    }else{
                        System.out.println("FALLA");
                    }
                    
                }
                if (rivalT.getSalud()<=0){
                    System.out.println(rivalT.getNombre()+ " HA MUERTO");

                } else {
                    System.out.println("Salud actualizada de "+rivalT.getNombre()+" = "+rivalT.getSalud());
                }
                System.out.println();
                if (ComprobarVictoria(aliados)){
                    break;
                }
                Thread.sleep(1000);     


            } else {
                continue;
            }
        }

    }
    
    /*método que imprime los supervivientes de la batalla (si los hay) */
    private void Supervivientes(){
        System.out.println("LOS SUPERVIVIENTES SON:");
        for (int i=0; i<3; i++){
             if (aliados[i].getSalud()>0){
                 System.out.println(aliados[i]);

            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        new DDApp();
      
    }
}
