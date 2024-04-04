package invertido;
import java.util.Scanner;

public class Invertido {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("INVERTIR NÚMERO");
        String numero;
        do {                                            //Validar que la cadena ingresada solo tenga números
            System.out.print("Ingrese un número: ");
            numero = scanner.nextLine();
            if (isInteger(numero) == false) {
                System.out.println("Error, ingrese un número válido ");
            }
        } while (isInteger(numero) == false);           //Mientras la validación de error, es decir, mientras contenga carácteres que no son números.

        int num2 = Integer.parseInt(numero);            //Transforma la cadena a entero
        String numInvertido = Invertir(num2);           //Llama a la función Invertir() para dar vuelta el número
        System.out.print("El número invertido es: " + numInvertido);
        scanner.close();
    }
    
    public static String Invertir(int num){
        if  (num < 10){                 //Si el número tiene solo un dígito, lo retorna.
            return String.valueOf(num);
        }
        int ultimoDig = num % 10;       //Devuelve el ultimo digito del número ingresado
        String strInvertido = String.valueOf(ultimoDig) + String.valueOf(Invertir(num / 10)); //Agrega el ultimo digito a una cadena y llama a la funcion nuevamente
        return strInvertido;                                                                  //para obtener los otros dígitos y agregarlos recursivamente
    }

    public static boolean isInteger(String numero){ //Función que valida si la cadena ingresada posee solo números
        try{
            Integer.valueOf(numero);               //Si el valor puede pasarse a Int, solo hay numeros y retorna true
            return true;
        }catch(NumberFormatException e){            //Si hay otro tipo de caracteres en el valor, retorna false
            return false;
        }
    }
}