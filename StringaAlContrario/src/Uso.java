public class Uso {
    public static int TOTALE_ATTESA = 0;
    public static final String STRINGA = "Roma";

    public static void main(String[] args) {

        System.out.println("Stringa inversa --> " + " ' " + STRINGA + "\n");
        long inizioTempo = System.nanoTime();

        Stringa str = new Stringa(0, STRINGA);
        str.start();
        try {
            str.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        long tempoAttesa = System.nanoTime() - inizioTempo;
        System.out.println();
        System.out.println("Totale attesa in millisecondi --> " + TOTALE_ATTESA);
        System.out.println("Tempo di esecuzione in millisecondi --> " + tempoAttesa/1000000);
    }
}
