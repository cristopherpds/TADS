/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.carro2;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.time.Duration;

/**
 *
 * @author IFSul
 */
public class CarroTest2 {
    private Carro2 carro;
    private Pneu pneu;
    private Banco banco;
    private Porta porta;
    private Transmissao t;
    private Farol farol;
    private SistemaEletrico sE;
    private TanqueCombustivel tC;
    private Motor motor;
    private Painel painel;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        pneu = new Pneu(235, 45, "Radial", "Michelin", false);
        banco = new Banco(true, true, true, true, true, true);
        porta = new Porta(true, 4, false);
        t = new Transmissao("Automatica", 1, true, motor);
        farol = new Farol(true);
        sE = new SistemaEletrico(true, true, "Lítio", "Supercharger");
        tC = new TanqueCombustivel(100, "Elétrico", 100);
        motor = new Motor("Eletrico", 1020, 0, "Tesla", false, sE, tC);
        carro = new Carro2("Tesla", "Model S Plaid", 2024, 322, 1020, "Preto", 4.1, pneu, motor, banco, farol, t, porta,
                sE, tC);
    }

    @After
    public void tearDown() {
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
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

    @Test
    public void testLigarCarroComBateriaCarregadaECombustivel() {
        carro.getSistemaEletrico().setBateriaCarregada(true);
        carro.getTanqueCombustivel().setNivelCombustivel(50);
        carro.ligarCarro();
        assertEquals("O carro foi ligado.", outContent.toString());
    }

    @Test
    public void testLigarCarroSemBateriaCarregada() {
        carro.getSistemaEletrico().setBateriaCarregada(false);
        carro.getTanqueCombustivel().setNivelCombustivel(50);
        carro.ligarCarro();
        assertEquals("O carro não pode ser ligado porque a bateria não está carregada.\n", outContent.toString());
    }

    @Test
    public void testLigarCarroSemCombustivel() {
        carro.getSistemaEletrico().setBateriaCarregada(true);
        carro.getTanqueCombustivel().setNivelCombustivel(0);
        carro.ligarCarro();
        assertEquals("O carro não pode ser ligado porque o tanque de combustível está vazio.\n", outContent.toString());
    }

    /*
     * @Test
     * public void testTransmissaoMarcha() {
     * assertThrows(IllegalArgumentException.class, () -> t.setMarcha(6));
     * }
     * 
     * @Test
     * public void testAbastecerCarro() {
     * assertTimeout(Duration.ofSeconds(5), () -> {
     * carro.abastecerCarro(50);
     * });
     * }
     */

}
