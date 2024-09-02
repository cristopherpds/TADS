/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.testesjunit;

import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertTimeout;

/**
 *
 * @author IFSul
 */
public class TestesJunitTest {
    
    public TestesJunitTest() {
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

    TestesJunit testesJunit = new TestesJunit();

    @Test
    void testAssertArrayEquals() {
        int[] expected = {1, 2, 3};
        int[] actual = testesJunit.getArray();
        assertArrayEquals(expected, actual, "Os arrays devem ser iguais");
    }

    @Test
    void testAssertIterableEquals() {
        List<String> expected = Arrays.asList("um", "dois", "três");
        List<String> actual = testesJunit.getList();
        assertIterableEquals(expected, actual, "As listas devem ser iguais");
    }

    @Test
    void testAssertLinesMatch() {
        List<String> expected = Arrays.asList("linha1", "linha2", "linha3");
        List<String> actual = testesJunit.getLines();
        assertLinesMatch(expected, actual, "As linhas devem corresponder");
    }

    @Test
    void testAssertNull() {
        Object obj = testesJunit.getNullObject();
        assertNull(obj, "O objeto deve ser nulo");
    }

    @Test
    void testAssertThrows() {
        assertThrows(IllegalArgumentException.class, () -> {
            testesJunit.throwException();
        }, "Deve lançar IllegalArgumentException");
    }

    @Test
    void testAssertTimeout() {
        assertTimeout(Duration.ofSeconds(1), () -> {
            testesJunit.delayedOperation();
        }, "A operação deve ser concluída dentro de 1 segundo");
    }
}
