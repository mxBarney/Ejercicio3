// Importaciones
import java.util.ArrayList; //Collection Framework
import java.util.Collections; 
import java.util.Random;
import java.util.Scanner;

// Main
public class Ejercicio3 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        Deck mazo = new Deck();

            System.out.println("\n");
            mazo.shuffle();

            System.out.println("\n");
            mazo.head();

            System.out.println("\n");
            mazo.pick();

            System.out.println("\n");
            mazo.hand();
    }
    
    // Card
    // Representa una carta de poker
	public static class Card {

        private String palo;
        private String color;
        private String valor;

        public Card(String palo, String color, String valor) {
            this.palo = palo;
            this.color = color;
            this.valor = valor;
        }

        public String getPalo() {
            return palo;}

        public String getColor() {
            return color;}

        public String getValor() {
            return valor;}

        @Override
        public String toString() {
            return "Palo: " + palo + " | " + "Color: " + color +
                    " | " + "Valor: " + valor;
        }
    }
	
    // Clase Deck
	// Representa el deck o conjunto de cartas de Poker
    public static class Deck {

        private final String[] paloDeck = {"corazones", "diamantes", "trébol", "picas"};
        private final String[] colorDeck = {"rojo", "negro"};
        private final String[] valorDeck = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "A", "J", "Q", "K"};

        // Arreglo
        private ArrayList<Card> deck;

        public Deck() {
            deck = new ArrayList<Card>();
            
        // Inicialización
            for (int palo = 0; palo < 2; palo++)
                for (int valor = 0; valor < valorDeck.length; valor++)
                    deck.add(new Card(paloDeck[palo], colorDeck[0], valorDeck[valor]));

            for (int palo = 2; palo < 4; palo++)
                for (int valor = 0; valor < valorDeck.length; valor++)
                    deck.add(new Card(paloDeck[palo], colorDeck[1], valorDeck[valor]));
        }

        public int getSize() {
            return deck.size();}

        public ArrayList<Card> getDeck() {
            return deck;}
            
			
        // Método Shuffle
        public void shuffle() {
            Collections.shuffle(deck);
            System.out.println("Se mezclo el Deck.");
        }


        // Método Head
        public void head() {
            System.out.println(deck.get(0));
            deck.remove(0);
            System.out.println("Quedan " + deck.size() + " cartas");
        }


        // Método Pick
        public void pick() {
            Random random = new Random();
            System.out.println(deck.get(random.nextInt(deck.size())));
            deck.remove(random.nextInt(deck.size()));
            System.out.println("Quedan " + deck.size() + " cartas");
        }

        // Método Hand
        public void hand() {
            for (int i = 0; i <= 4; i++) {
                System.out.println(deck.get(i));
            }
            for (int i = 0; i <= 4; i++) {
                deck.remove(i);
            }
            System.out.println("Quedan " + deck.size() + " cartas");
        }
    }
}