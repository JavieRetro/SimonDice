package SimonDice;
import java.io.IOException;
/**
 * @author javie
 */
import java.util.Scanner;
/*
 * Clase Engine
 */
public class Engine {
	/**
	 * Definimos un arrays con los cuatro colores que queremos introducir en la secuencia.
	 * @params clase tColores de los colores
	 * 
	 */
	   private Scanner scanner = new Scanner(System.in);
       public enum tColores{
              Rojo, Verde, Azul, Dorado, Blanco, Marron, Naranja;
			
		}
       private enum tModo{
               ModoFacil, ModoDificil;
         }
        
          //Declaramos una variable estática indicando el max de colores que podemos introducir en la secuencia.
          //Declaramos un array de objetos del tipo TColores, su tamaño se define por MAX_COLORES_SEC
         
        private  int MAX_COLORES_SEC = 15;
        private int MAX_COLORES_FACIL = 3;
        private int MAX_COLORES_DIFICIL = 6;
        private tColores[] secuenciaColores = new tColores [MAX_COLORES_SEC];
        private int numAyudas = 3;
        public int puntuaciones;
        /**
         * charToColor: Recibimos un char, comprobado en el switch y devuelve uno de los colores de tColores
         * si el color no existe devuelve null
         * Método encargado de relacionar los colores del array con una letra
         * @param _color
         * @return
         */
		public tColores charToColor (char _color) {
			
			//Convertir letra a minuscula
			   char colores =Character.toUpperCase(_color);
			   switch (colores) {
			   case 'R':
				       return tColores.Rojo;
				
			   case 'V':
				       return tColores.Verde;
			
			   case 'A':
				       return tColores.Azul;
				
			   case 'D':
				       return tColores.Dorado;
				
			   case 'B':
			           return tColores.Blanco;
			    
			   case 'M':
				       return tColores.Marron;
				
			   case 'N':
				       return tColores.Naranja;
				
			   
	            default:
			           return null;
			
		}
			  
			
	}
		/**
		 * intToColor: Recibimos un int, comparandolo con los casos de switch y devuelve
		 * uno de los colores de tColores
		 * 
		 * @param _numero variable tipo int
		 * @return devuelve un color del tipo tColores
		 */
		public tColores intToColor (int _numero) {

			switch (_numero) {
			case 0:
				   return tColores.Rojo;
				
			case 1:
				   return tColores.Verde;
				
			case 2: 
				   return tColores.Azul;
				 
			case 3:
				   return tColores.Dorado;
				 
			case 4:
				   return tColores.Blanco;
				
			case 5:
				   return tColores.Marron;
				
			case 6:
				   return tColores.Naranja;
				   
		    default:
		           return null;
		 }
			
			
		}
		/**
		 *generarSecuencia: Rellenamos los index del array con nº aleatorios, usamos el método intToColor, y por el parámetro usamos
		 *el nº aleatorio generando colores aleatorios para las posiciones del array usando un for.
		 * @param _numColores
		 */
		
		public void generarSecuencia (int _numColores) {
			// Crear un array de colores de la longitud indicada
          
			int colorAleatorio;
			for(int i = 0; i < MAX_COLORES_SEC; i++) {
				colorAleatorio = 0 + (int)(Math.random()*(_numColores - 0 + 1));
				this.secuenciaColores[i] = intToColor(colorAleatorio);
				
			
		}
			
	}
		/**
		 * comprobarColor: Verificación de si un color dado coincide con el que encontramos en una posición
		 * específica dentro de la secuencia de colores.
		 * 
		 * @param _index Introducimos una vble int
		 * @param _color Introducimos una vble tColores
		 * @return devuelve secuenciaColores
		 */
		public boolean comprobarColor(int _index, tColores _color) {
		
			return secuenciaColores[_index] == _color;
		}
		/**
		 * mostrarSecuencia:Indica el nº de elementos del array indicados.
		 * 
		 * @param _numero vble int
		 */
		
      public void  mostrarSecuencia (int _numero) {
    	 for (int i = 0; i < _numero; i++) {
    		 System.out.print(secuenciaColores[i] + " ");
    	 }
    }
      /**
       * Este método define el uso de ayudas en el juego "Simón Dice". 
       * Comprueba si el jugador tiene ayudas disponibles y, si es así, revela el color correcto en la posición 
       * indicada por el parámetro _index
       * @param _index
       * @return
       */
      public boolean usarAyudas(int _index) {
    	  if(numAyudas < 1) {
    		  System.out.println("Lo siento no te quedan más ayudas");
    		  return false;
    	  }else {
    		  numAyudas -=1;
    		  System.out.println("El siguiente color es el: " + secuenciaColores[_index] + 
    				  ". Te quedan " + numAyudas + " ayudas");
    		  return true;
    	  }
      }
      /**
       * play: Introduce los elementos usados anteriormente. Creamos un objeto de la clase con el cual podemos
       * identificarnos en el juego.
     * @return 
       */


      public int play(tModo _modo){
    	  //Lleva la cuenta del nº de secuencia actual
        int numSecuencia;
        //Indica la cantidad de colores que hay en la secuencia
        int coloresSecuencia;
        //Se establece a true e indica que el juego no ha terminado
        boolean error = true;
         puntuaciones = 0;
        numSecuencia = 1;
        coloresSecuencia = 3;
          //Nº ayudas disponibles
          numAyudas = 3;
          
          if(_modo == tModo.ModoFacil) {
        	  generarSecuencia(MAX_COLORES_DIFICIL);
          }else {
        	  generarSecuencia(MAX_COLORES_FACIL);
          }
          
 			scanner.nextLine();
 			
 			//Se muestra la secuencia actual mientras el nº de coloree sea igual o menor al máx de la secuencia.
 			while(coloresSecuencia <= MAX_COLORES_SEC && error) {
 				System.out.println("Secuencia número " + numSecuencia + ":");
 				mostrarSecuencia(coloresSecuencia);
 				System.out.println("\n" + "Memoriza la secuencia y pulsa ENTER para continuar... (Enter)");
 				scanner.nextLine();
 				for (int i = 0; i <= 50; i++) {
 					System.out.println();
 				}
 				//Recorremos la secuencia color a color, mediante el charToColor pasando de un caracter a color
 				//Para las ayudas por medio de un if si el caracter es x o X y hay ayudas disponibles el juego muestra el color correcto
 				//El color es correcto si coincide con el de la secuencia actual.
 				int j = 0;
 				while(j < coloresSecuencia && error) {
 					char caracter = scanner.next().charAt(0);
 					scanner.nextLine();
 					if((caracter == 'x'|| caracter == 'X')&& numAyudas >= 1) {
 						usarAyudas(j);
 						puntuaciones -= 8;
 						j++;
 					}else if ((caracter == 'x'|| caracter == 'X')&& numAyudas < 1) {
 						usarAyudas(j);
 					}
 				    else if (comprobarColor(j, charToColor(caracter))) {
 						System.out.println("Esta correcto, siga");
 						j++;
 						puntuaciones += 2;
 					}else {
 						System.out.println("Ha fallado, si lo desea vuelva a intentarlo");
 						error = false;
 					}
 				}
 				//Si completamos la secuencia correctamente aumentamos el nº de colores en la siguiente 
 				//Actualizamos la puntuación
 				if (error && coloresSecuencia < MAX_COLORES_SEC) {
 					System.out.println("Buen trabajo!! Sigamos con la próxima secuencia");
 					numSecuencia++;
 					coloresSecuencia++;
 					puntuaciones += 8;
 				}else if(error && coloresSecuencia == MAX_COLORES_SEC) {
 				System.out.println("ENHORABUENA, HAS GANADO");
 				puntuaciones += 40;
 				error = true;
 				//Al final el juego o fallar en una secuencia, se nos mostrará la puntuación final
 				
 				}
 			}
 			return puntuaciones;
 		  }
 		
      			
 			/*
 			 * Metodo que muestra el menú principal, obtenemos una opción del usuario e iniciamos la partida co
 			 * un modo seleccionado.
 			 */
      public void start() throws IOException{
    	      int _opcion;
    	      int puntuaciones;
    		  Record ranking = new Record();
    	      
    	      ranking.cargarRanking();
    	      //bucle do while que se repite mientras no demos lugar a la opción 0 para salir
    	       System.out.println("Bienvenido al...");
    	      System.out.println("¡¡¡Simoooonnn diceeee!!!");
    	      System.out.println("¿Cuál es tu nombre?");
    	      String nombre = scanner.nextLine();
    	      Jugador jugador1 = new Jugador(nombre);
    	      ranking.anadirJugador(jugador1);
    	  do {
    	 
    	  System.out.println("Bienvenido " + nombre + " espero que disfrutes.");
    	  System.out.println("Dime, ¿que modo escoges?:" + "\n 1.Modo Facil\n " + "2.Modo Dificil \n " + "3.Ranking Puntuacion 10 Mejores Jugadores\n " + "4.Mejor(es) jugador(es) ranking\n " + "0.Salir");
    	  _opcion = scanner.nextInt();
     
      
                    switch(_opcion) {
      
                    case 0:
    	            System.out.println("Vuelva pronto, espero que haya disfrutado de esta experiencia");
    	            ranking.escribirRanking();
    	            break;
    	  
                    case 1:
                    	puntuaciones = play(tModo.ModoFacil);
                    	if( puntuaciones > jugador1.getPuntuacion()) {
                    		jugador1.setPuntuacion(puntuaciones);
                    	}
        				System.out.println("Puntuacion final: " + jugador1.getPuntuacion());
        				break;
    	  
                   case 2:
                	   puntuaciones = play(tModo.ModoDificil) ;
                	   if( puntuaciones > jugador1.getPuntuacion()) {
                   		jugador1.setPuntuacion(puntuaciones * 2);
                	   }
       			    System.out.println("Puntuacion final: " + puntuaciones * 2);
       				break;
                   case 3:
                	   ranking.ordenarRanking();
       				ranking.showRanking();
       				break;
       			case 4:
       				ranking.ordenarRanking();
       				ranking.showBestPlayer();
       				break;
    	          default:
    		        System.out.println("Esta opción no existe, use otra por favor");
             }
            }  while (_opcion != 0);
         }
			
      } 
 		

