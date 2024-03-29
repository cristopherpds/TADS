/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.exercicios;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author IFSul
 */
public class ExerciciosTest {
    private Exercicios e;
    public ExerciciosTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        e = new Exercicios();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class Exercicios.
     */
    @Ignore
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Exercicios.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
        /**
     * Test of somaDoisNumerosInteiros method, of class Exercicios.
     */
    @Test
    public void testSomaDoisNumerosInteiros() {
        int a = 5;
        int b = 3;
        int expResult = 8;
        int result = e.somaDoisNumerosInteiros(a, b);
        assertEquals(expResult, result);
    }

    /**
     * Test of substairDoisNumerosInteiros method, of class Exercicios.
     */
    @Test
    public void testSubstairDoisNumerosInteiros() {
        int a = 5;
        int b = 3;
        int expResult = 2;
        int result = e.substairDoisNumerosInteiros(a, b);
        assertEquals(expResult, result);
    }

    /**
     * Test of multiplicarDoisNumerosInteiros method, of class Exercicios.
     */
    @Test
    public void testMultiplicarDoisNumerosInteiros() {
        int a = 5;
        int b = 3;
        int expResult = 15;
        int result = e.multiplicarDoisNumerosInteiros(a, b);
        assertEquals(expResult, result);
    }

    /**
     * Test of dividirDoisNumerosInteiros method, of class Exercicios.
     */
    @Test
    public void testDividirDoisNumerosInteiros() {
        int a = 6;
        int b = 3;
        int expResult = 2;
        int result = e.dividirDoisNumerosInteiros(a, b);
        assertEquals(expResult, result);
    }

    /**
     * Test of verificarNumeroPar method, of class Exercicios.
     */
    @Test
    public void testVerificarNumeroPar() {
        int x = 4;
        Boolean expResult = true;
        Boolean result = e.verificarNumeroPar(x);
        assertEquals(expResult, result);
    }

    /**
     * Test of verificarNumeroPositivo method, of class Exercicios.
     */
    @Test
    public void testVerificarNumeroPositivo() {
        int x = -1;
        Boolean expResult = false;
        Boolean result = e.verificarNumeroPositivo(x);
        assertEquals(expResult, result);
    }

    /**
     * Test of concatDuasSting method, of class Exercicios.
     */
    @Test
    public void testConcatDuasSting() {
        String s = "Hello";
        String S = " World";
        String expResult = "Hello World";
        String result = e.concatDuasSting(s, S);
        assertEquals(expResult, result);
    }

    /**
     * Test of inverterString method, of class Exercicios.
     */
    @Test
    public void testInverterString() {
        String s = "Hello";
        String expResult = "olleH";
        String result = e.inverterString(s);
        assertEquals(expResult, result);
    }

    /**
     * Test of mediaLista method, of class Exercicios.
     */
    @Test
    public void testMediaLista() {
        double[] numeros = {1.0, 2.0, 3.0, 4.0, 5.0};
        double expResult = 3.0;
        double result = e.mediaLista(numeros);
        assertEquals(expResult, result, 0.0);
    }
}
