package es.urjc.etsii.metodologias.selenium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
public class Testing_SecureCalculatorTest {

    /**
     * Verify calculator is successfully created
     */
    @Test
    public void smokeTest(){
        Testing_SecureCalculator calculator = new Testing_SecureCalculator();
        Assertions.assertNotNull(calculator);
    }

    // Test Mutiplicar:
    @Test
    public void multiplyTest(){
        Testing_SecureCalculator calculator = new Testing_SecureCalculator();
        Assertions.assertNotNull(calculator);

        long mult = calculator.multiply(4,4);
        Assertions.assertNotNull(mult);
    }

    // Test Divide:
    @Test
    public void divideTest(){
        Testing_SecureCalculator calculator = new Testing_SecureCalculator();
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
        Testing_SecureCalculator calculator = new Testing_SecureCalculator();
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
        Testing_SecureCalculator calculator = new Testing_SecureCalculator();
        Assertions.assertNotNull(calculator);

        boolean odd = calculator.isOdd(345);
        Assertions.assertTrue(odd);
    }

    // Test isEven:
    @Test
    public void isEvenOrOdd(){
        Testing_SecureCalculator calculator = new Testing_SecureCalculator();
        Assertions.assertNotNull(calculator);

        boolean even = calculator.isEven(344);
        Assertions.assertTrue(even);

        boolean odd = calculator.isOdd(345);
        Assertions.assertTrue(odd);
    }

    // Test Random:
    @Test
    public void getRandomNumberTest(){
        Testing_SecureCalculator calculator = new Testing_SecureCalculator();
        Assertions.assertNotNull(calculator);

        int random = calculator.getRandomNumber(Integer.MAX_VALUE);
        Assertions.assertNotNull(random);

        boolean randomBoolean = random <= Integer.MAX_VALUE && random >= 0;
        Assertions.assertTrue(randomBoolean);
    }

    // Test Random Bound:
    @Test
    public void getRandomNumberTestBound(){
        Testing_SecureCalculator calculator = new Testing_SecureCalculator();
        Assertions.assertNotNull(calculator);

        int bound = 45;

        int random = calculator.getRandomNumber(bound);
        Assertions.assertNotNull(random);

        boolean randomBoolean = random <= bound && random >= 0;
        Assertions.assertTrue(randomBoolean);
    }
}
