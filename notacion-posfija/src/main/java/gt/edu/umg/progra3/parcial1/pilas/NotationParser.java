package gt.edu.umg.progra3.parcial1.pilas;

import java.util.Arrays;
import java.util.Collections;

public class NotationParser {

	private Pila Pila1;
    private Pila Pila2 = new PilaImplement();

    public NotationParser(Pila pila) {
        this.Pila1 = pila;
    }

    public String posFixToInfix(String expression){
        Pila1 = StringToPila(expression);
        return PostFijo(Pila1);
    }
    
    private Pila StringToPila(String cadena){
        Pila resul = new PilaImplement();
        String[] strArray = cadena.split(" ");
        Collections.reverse(Arrays.asList(strArray));
        for(String x:strArray){
            resul.push(x);
        }
        return resul;
    }
    
    private String PostFijo(Pila pila){
        String Signo, Numero;
        String Resultado = "";
        while(!pila.isEmpty()){
            Pila2.push(Pila1.pop());
            String ultimo = Pila2.peek();
            
            if(ultimo.equals("+") || ultimo.equals("*") || ultimo.equals("-") || ultimo.equals("/")){
                Signo = Pila2.pop();
                Numero = Pila2.pop();
                Pila2.push(Signo);
                Pila2.push(Numero);
            }
        }
        Resultado = pilaToString(Pila2);
        return Resultado;
    }
    
    private String pilaToString(Pila pila){
        int t = pila.size();
        String resultado = "";
        resultado = pila.pop()+resultado;
        for(int x = 0;x<t-1;x++){
            resultado = pila.pop()+" "+resultado;
        }
        return resultado;
    }
}
