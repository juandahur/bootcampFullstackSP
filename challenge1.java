package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class challenge1 {


    /*
    a. Crear un método que genere y retorne una cadena de texto (String) de forma
        aleatoria con una longitud igual a 10 caracteres, y que serán únicamente
        números (0-9), por ejemplo “3845346790”. El método tendrá como entrada
        un valor tipo texto. La cadena de texto que se retorna tendrá las siguientes
        dos condiciones:
            i. Si el valor de entrada es igual a “Tipo A” la cadena de texto deberá
                iniciar en “54”
            ii. Si el valor de entrada es igual a “Tipo B” la cadena de texto deberá
                iniciar en “08”
     */


    static String method1(String type) {
        String method1String = "";
        if (type == "Tipo A") {
            method1String = "54";

        } else if (type == "Tipo B") {
            method1String = "08";
        }
        method1String = appendString(method1String);
        return method1String;
    }

    static String appendString(String typeString) {
        String appendedString = typeString;
        Random r = new Random();
        Integer randomNumber = 0;

        for (int i = 0; i <= 7; i++) {
            randomNumber = r.nextInt(0, 10);
            appendedString += randomNumber.toString();
        }

        return appendedString;
    }

    /*
    b. Crear un método que tenga como entrada un valor tipo String y una lista de
    cadena List<String>. El método devuelve un valor de tipo booleano. El
    método verifica si el valor tipo String está contenido en la lista, si el valor se
    encuentra dentro de la lista deberá devolver un valor false, de lo contrario
    retorna un valor true.
 */

    static boolean method2(String inputString, List<String> inputList) {
        boolean stringInList;
        stringInList = inputList.contains(inputString);

        return stringInList;
    }
/*

    //Test A
        System.out.println("Prueba para Tipo A: " + method1("Tipo A"));
        System.out.println("Prueba para Tipo B: " + method1("Tipo B"));

    //Test B
        String[] array = {"b","c","d","e","a"};
        List<String> listArray= Arrays.asList(array);
        System.out.println("Prueba Afirmativa: " + method2("a", listArray));
        System.out.println("Prueba Negativa: " + method2("z", listArray));


*/



}

