/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.carro;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


import java.time.Duration;


/**
 *
 * @author IFSul
 */
public class CarroTest {
    private Carro carro;
    private Pneu pneu;
    private Banco banco;
    private Porta porta;
    private Transmissao t;
    private Farol farol;
    private SistemaEletrico sE;
    private TanqueCombustivel tC;
    private Motor motor;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        //inicialize este metodo da mesma forma que esta na clase main
        carro = new Carro("Tesla", "Model S Plaid", 2024, 322, 1020, "Preto", 4.1);
        pneu = new Pneu(235, 45, "Radial", "Michelin");
        banco = new Banco(true, true, true, true, true, true);
        porta = new Porta(true, 4, false);
        t = new Transmissao("Automatica", 1, true);
        farol = new Farol(true);
        sE = new SistemaEletrico(true, true, "Lítio", "Supercharger");
        tC = new TanqueCombustivel(0, "Elétrico", 100);
        motor = new Motor("Eletrico", 1020, 0, "Tesla", sE, tC);

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class Carro.
     */

    @Test
    public void testCarroMarca() {
        assertEquals("Model S Plaid", carro.getMarca());
        System.out.println(carro.getMarca());
    }

    @Test
    public void testCarroModelo() {
        assertNotEquals("Model X", carro.getModelo());
        System.out.println(carro.getModelo());
    }

    @Test
    public void testFarolStatus() {
        assertTrue(farol.getLigado());
        System.out.println(farol.getLigado());
    }

    @Test
    public void testPortaStatus() {
        assertTrue(porta.getFechada());
        System.out.println(porta.getFechada());
    }

    @Test
    public void testPneuMarca() {
        assertNotNull(pneu.getMarca());
        System.out.println(pneu.getMarca());
    }

    @Test
    public void testBancoAquecimento() {
        assertTrue(banco.isAquecido());
        System.out.println(banco.isAquecido());
    }

    @Test
    public void testSEBateria() {
        assertSame("Lítio", sE.getTipoBateria());
        System.out.println(sE.getTipoBateria());
    }

    @Test
    public void testTCCombustivel() {
        assertNotSame("Gasolina", tC.getTipoCombustivel());
        System.out.println(tC.getTipoCombustivel());
    }

    @Test
    public void testMotorPotencia() {
        assertArrayEquals(new int[] { 1020 }, new int[] { motor.getPotencia() });
        System.out.println(motor.getPotencia());
    }

    /*@Test
    public void testTransmissaoMarcha() {
        assertThrows(IllegalArgumentException.class, () -> t.setMarcha(6));
    }

    @Test
    public void testAbastecerCarro() {
        assertTimeout(Duration.ofSeconds(5), () -> {
            carro.abastecerCarro(50);
        });
    } */

}
