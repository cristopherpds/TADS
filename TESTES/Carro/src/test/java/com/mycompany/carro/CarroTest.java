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

/**
 *
 * @author IFSul
 */
public class CarroTest {
    private Carro c;
    private Pneu p;
    private Banco b;
    private Porta p1;
    private Motor m;
    private Transmissao t;
    private Farol f;
    private SistemaEletrico sE;
    private TanqueCombustivel tC;

    public CarroTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        c = new Carro("tesla", "tesla", 2021, 230, 200, "red", 4.1);
        p = new Pneu(1, 2, "baixo", "pireli");
        b = new Banco(0, true, true, false, true, true);
        p1 = new Porta(true, 2, true);
        m = new Motor("eletrico", 1200, 4, "tesla");
        t = new Transmissao("automatica", 0,true);
        f = new Farol(true);
        sE = new SistemaEletrico(true, true);
        tC = new TanqueCombustivel(100, "Hydrogeno", 50);
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class Carro.
     */

    @Test
    public void testeCarroPneu(){
        c.setPneu(p);
        assertEquals(c.getPneu(), p);
    }

    @Test
    public void testeCarroBanco() {
        c.setBanco(b);

        assertEquals(c.getBanco(), b);
    }

    @Test
    public void testeCarroPorta() {
        c.setPorta(p1);

        assertEquals(c.getPorta(), p1);
    }

    @Test
    public void testeCarroTransmissao() {
        c.setTransmissao(t);

        assertEquals(c.getTransmissao(), t);
    }

    @Test
    public void testeCarroFarol() {
        c.setFarol(f);

        assertEquals(c.getFarol(), f);
    }

    @Test
    public void testeCarroTanqueCombustivel() {
        c.setTanqueCombustivel(tC);

        assertEquals(c.getTanqueCombustivel(), tC);
    }

    @Test
    public void testeCarroSistemaEletrico() {
        c.setSistemaEletrico(sE);

        assertEquals(c.getSistemaEletrico(), sE);
    }

    @Test
    public void testeCarroPainel() {
        c.setPainel(p);

        assertEquals(c.getPainel(), p);
    }

    @Test
    public void testeCarroLigar() {
        c.setMotor(m);
        c.ligar();

        assertTrue(c.isLigado());
    }
    
}
