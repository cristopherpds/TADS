/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.testesjunit;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author IFSul
 */
public class TestesJunit {

     public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public int[] getArray() {
        return new int[]{1, 2, 3};
    }

    public List<String> getList() {
        return Arrays.asList("um", "dois", "três");
    }

    public List<String> getLines() {
        return Arrays.asList("linha1", "linha2", "linha3");
    }

    public Object getNullObject() {
        return null;
    }

    public void throwException() {
        throw new IllegalArgumentException("Exceção esperada");
    }

    public void delayedOperation() throws InterruptedException {
        Thread.sleep(500);
    }
}
