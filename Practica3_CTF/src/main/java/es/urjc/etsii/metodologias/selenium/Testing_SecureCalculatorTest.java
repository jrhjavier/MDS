package org.example.unittests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.mockito.Mockito.*;

/**
 * Los nuevos alumnos andan aprendiendo a programar en Introduccion a la programacion y han creado
 * una calculadora que dicen que no tiene fallos.
 * Debemos comprobar el correcto funcionamiento de la "calculadora segura" que nos han proporcionado.
 * En caso de detectar comportamiento erroneo mediante algun test, arreglalo y comprueba que el test funciona correctamente.
 * En concreto, es necesario verificar la siguiente funcionalidad:
 * - En caso de intento de división entre 0, debe tirar ArithmeticException.
 * - Debe protegerse contra Overflows de forma correcta: por ejemplo la multiplicacion de dos numeros positivos
 * nunca puede dar un numero negativo. En caso de que sea posible overflow, tirar ArithmeticException.
 * - Debe generar numeros aleatorios de forma correcta, respetando el limite pedido
 * - Debe detectar correctamente cuando un numero es par y cuando un numero es impar
 * - Debe emitir mensajes de log si ha sido configurada para ello. (Opcional para nota)
 */
public class SecureCalculatorTests {

    /**
     * Verify calculator is successfully created
     */
    @Test
    public void smokeTest(){
        SecureCalculator calculator = new SecureCalculator();
        Assertions.assertNotNull(calculator);
    }

    // Test Mutiplicar:
    @Test
    public void multiplyTest(){
        SecureCalculator calculator = new SecureCalculator();
        Assertions.assertNotNull(calculator);

        long mult = calculator.multiply(4,4);
        mo
    }

    // Test Divide:
    @Test
    public void divideTest(){
        SecureCalculator calculator = new SecureCalculator();
        Assertions.assertNotNull(calculator);

        double div = calculator.divide(43.4,-3);
        Assertions.assertNotNull(div);

        Assertions.assertThrows(ArithmeticException.class, () -> {
            calculator.divide(5,0);
        });
    }

    // Test Mod:
    @Test
    public void modTest(){
        SecureCalculator calculator = new SecureCalculator();
        Assertions.assertNotNull(calculator);

        int mod = calculator.mod(-3,2);
        Assertions.assertNotNull(mod);

        Assertions.assertThrows(ArithmeticException.class, () -> {
            calculator.mod(1,0);
        });
    }

    // Test Odd:
    @Test
    public void isOddTest(){
        SecureCalculator calculator = new SecureCalculator();
        Assertions.assertNotNull(calculator);

        boolean odd = calculator.isOdd(345);
        Assertions.assertTrue(odd);
    }

    // Test isEven:
    @Test
    public void isEvenOrOdd(){
        SecureCalculator calculator = new SecureCalculator();
        Assertions.assertNotNull(calculator);

        boolean even = calculator.isEven(344);
        Assertions.assertTrue(even);

        boolean odd = calculator.isOdd(345);
        Assertions.assertTrue(odd);
    }

    // Test Random:
    @Test
    public void getRandomNumberTest(){
        SecureCalculator calculator = new SecureCalculator();
        Assertions.assertNotNull(calculator);

        int random = calculator.getRandomNumber(Integer.MAX_VALUE);
        Assertions.assertNotNull(random);

        boolean randomBoolean = random <= Integer.MAX_VALUE && random >= 0;
        Assertions.assertTrue(randomBoolean);
    }

    // Test Random Bound:
    @Test
    public void getRandomNumberTestBound(){
        SecureCalculator calculator = new SecureCalculator();
        Assertions.assertNotNull(calculator);

        int bound = 45;

        int random = calculator.getRandomNumber(bound);
        Assertions.assertNotNull(random);

        boolean randomBoolean = random <= bound && random >= 0;
        Assertions.assertTrue(randomBoolean);
    }


    /*
    *
    *     //ImplementacionRaul:

    // Para que nuestros test no tiren relmente, nos creamos métodonosotros:

    static class TestLogger extends Logger{
        int nVecesLlamado;
        protected TestLogger(String name, String resuorceBound){
            super(name, resuorceBound);
        }

        protected TestLogger(){
            super("fakename",null);
        }

        @Override
        public void log(Level level, String nam){
            nVecesLlamado++;
            System.out.println("HOLA desde metodo");
        }
    }


    //Podemos automatizar el método y la clase de arriba con mockito:
    @Test
    public void verifyLog(){
        var mockLog = Mockito.mock(Logger.class); //Crea log que no va a intaractuar
        var realLog = new TestLogger();

        var calc = new SecureCalculator(realLog);
        calc.divide(4,2);
        System.out.println(realLog.nVecesLlamado);

        var calcM = new SecureCalculator(mockLog);
        calcM.divide(4,2);
        verify(mockLog).info(anyString());//Comprobamos que hemos llamado a reallog con metodo info con cualquier string

        calcM.divide(4,8);
        verify(mockLog,times(2)).info(anyString());//Comprobamos que hemos llamado a reallog con metodo info con cualquier string

        //verifyNoInteractions(realLog); // Va a fallar, ya que se ha llamado a info 2 veces. Si ponemos arriba n veces, se arregla!!

    }
    * */


}
