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
        carro = new Carro("Tesla", "Model S Plaid", 2022, 396, 1020, "Preto", 2.1);
        banco = new Banco(true, true, true, true, true, true);
        farol = new Farol(true);
        pneu = new Pneu(265, 35, "Radial", "Michelin");
        porta = new Porta(true, 4, false);
        sE = new SistemaEletrico(true, true, "Lítio", "Supercharger");
        tC = new TanqueCombustivel(0, "Elétrico", 100);
        motor = new Motor("Elétrico", 1020, 0, "Tesla", sE, tC);
        t = new Transmissao("Automática", 1, true);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class Carro.
     */

    @Test
    public void testCarroMarca() {
        assertEquals("Tesla", carro.getMarca());
    }

    @Test
    public void testCarroModelo() {
        assertNotEquals("Model X", carro.getModelo());
    }

    @Test
    public void testFarolStatus() {
        assertTrue(farol.getLigado());
    }

    @Test
    public void testPortaStatus() {
        assertFalse(porta.getFechada());
    }

    @Test
    public void testPneuMarca() {
        assertNotNull(pneu.getMarca());
    }

    @Test
    public void testBancoAquecimento() {
        assertNull(banco.isAquecido());
    }

    @Test
    public void testSEBateria() {
        assertSame("Lítio", sE.getTipoBateria());
    }

    @Test
    public void testTCCombustivel() {
        assertNotSame("Gasolina", tC.getTipoCombustivel());
    }

    @Test
    public void testMotorPotencia() {
        assertArrayEquals(new int[] { 1020 }, new int[] { motor.getPotencia() });
    }

    @Test
    public void testTransmissaoMarcha() {
        assertThrows(IllegalArgumentException.class, () -> t.setMarcha(6));
    }

    /* @Test
    public void testAbastecerCarro() {
        assertTimeout(Duration.ofSeconds(5), () -> carro.abastecerCarro(50));
    } */

}
