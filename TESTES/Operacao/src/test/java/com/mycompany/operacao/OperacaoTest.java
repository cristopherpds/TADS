/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.operacao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author IFSul
 */
public class OperacaoTest {
    
    public OperacaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of somaDoisNumerosInteiros method, of class Operacao.
     */
    @Test
    public void testIntegracaoOperacoes() {
        Operacao operacao = new Operacao();

        System.out.println("Integração de operações");
        // Concatenar os resultados de todos os métodos em uma única string
        String resultado = "";
        resultado += operacao.somaDoisNumerosInteiros(2, 3) + ";";
        resultado += operacao.substairDoisNumerosInteiros(3, 2) + ";";
        resultado += operacao.multiplicarDoisNumerosInteiros(2, 3) + ";";
        resultado += operacao.dividirDoisNumerosInteiros(6, 3) + ";";
        resultado += operacao.verificarNumeroPar(4) + ";";
        resultado += operacao.verificarNumeroPar(5) + ";";
        resultado += operacao.verificarNumeroPositivo(5) + ";";
        resultado += operacao.verificarNumeroPositivo(-5) + ";";
        resultado += operacao.concatDuasSting("Hello", "World") + ";";
        resultado += operacao.inverterString("Hello") + ";";
        double[] numeros = {1.0, 2.0, 3.0, 4.0, 5.0};
        resultado += operacao.mediaLista(numeros);

        // String esperada
        String esperado = "5;1;6;2;true;false;true;false;HelloWorld;olleH;3.0";

        System.out.println("Resultado: " + resultado);
        // Verificar se a string resultante é igual à string esperada
        assertEquals(esperado, resultado);
    }

 
}
