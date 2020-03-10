import java.util.Random;

public class Stringa extends Thread {
    public static final int TEMPO_MINIMO = 1000;
    public static final int TEMPO_MASSIMO = 3000;

    private int indice;
    private String stringa;

    public Stringa(int indice, String stringa){
        this.indice = indice;
        this.stringa = stringa;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public String getStringa() {
        return stringa;
    }

    public void setStringa(String stringa) {
        this.stringa = stringa;
    }

    @Override
    public String toString() {
        return "Stringa{" +
                "indice=" + indice +
                ", stringa='" + stringa + '\'' +
                '}';
    }

    public void esegui(){
        if(indice < stringa.length()-1){
            Stringa str = new Stringa(indice +1, stringa);
            str.start();
            try {
                str.join();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        Random casuale = new Random();
        int attesa = casuale.nextInt((TEMPO_MASSIMO - TEMPO_MINIMO) +1) + TEMPO_MINIMO;
        try {
            sleep(attesa);
            Uso.TOTALE_ATTESA += attesa;
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("' " + stringa.charAt(indice) + " '" + "tempo di attesa di: " + attesa);
    }
}
