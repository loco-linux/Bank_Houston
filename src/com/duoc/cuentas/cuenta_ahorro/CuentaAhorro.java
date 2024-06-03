/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duoc.cuentas.cuenta_ahorro;

import com.duoc.cuentas.CuentaBancaria;
import java.util.Scanner;

/**
 *
 * @author jbarr
 */
public class CuentaAhorro extends CuentaBancaria {

   // private static final String tipoCuenta = "Cuenta de Ahorro";
    static Scanner teclado = new Scanner(System.in);
    
    public CuentaAhorro() {
    }

    
    public CuentaAhorro(int numeroCuenta, int saldo){
        super(numeroCuenta, saldo);
    }
    
    
    public static String getTipoCuenta() {
        return tipoCuenta;
    }
    
    public static void setTipoCuenta(){
        tipoCuenta = "Cuenta de Ahorro";
    }
    
     public static int getNumeroCuenta() {
        return CuentaAhorro.numeroCuenta;
    }

    public static void setNumeroCuenta(int numeroCuenta) {
        CuentaAhorro.numeroCuenta = numeroCuenta;
    }

    public static int getSaldo() {
        return CuentaAhorro.saldo;
    }

    public static void setSaldo(int saldo) {
        CuentaAhorro.saldo = saldo;
    }
    
    
    @Override
    public void depositarDinero() {

        CuentaAhorro.setTipoCuenta();
        System.out.println("--------------------------- ACCEDIENDO AL SISTEMA ---------------------------");
        System.out.println("--------------------------=== "+CuentaAhorro.tipoCuenta+" ===--------------------------");
        System.out.println("--------------------------------- DEPOSITOS ----------------------------------");
        System.out.println("Por favor, indica el monto a depositar. Ejemplo: 50000");
        int deposito = teclado.nextInt(); 
        if (deposito > 0) {
           saldoUsuario = CuentaAhorro.getSaldo();
           saldoUsuario = saldoUsuario + deposito;
           CuentaAhorro.setSaldo(saldoUsuario);
           System.out.println("Deposito realizado!");
           System.out.println("Haz hecho un deposito por un total de: $ "+deposito+" pesos.");
           System.out.println("Tu nuevo saldo es: $ "+CuentaAhorro.getSaldo()+" pesos.");
           } else {
                System.out.println("[ERROR] No se permite el ingreso de montos menores o iguales a 0 pesos. Por favor introduce un monto valido");
            }





    }

    @Override
    public void girarDinero() {

        CuentaAhorro.setTipoCuenta();
        teclado.nextLine();
        System.out.println("--------------------------- ACCEDIENDO AL SISTEMA ---------------------------");
        System.out.println("--------------------------=== "+CuentaAhorro.tipoCuenta+" ===--------------------------");
            System.out.println("---------------------------- RETIRAR DINERO -----------------------------");
            System.out.println("Por favor digita el monto que deseas retirar: ");
            int giroUsuario = teclado.nextInt();
            if (giroUsuario <= 0) {
                System.out.println("[ERROR] El monto a retirar debe ser mayor a 0 pesos");
            } else if (giroUsuario > CuentaAhorro.getSaldo()) {
                System.out.println("[ERROR] El monto a retirar excede tu saldo actual");
            } else {
            int nuevoSaldo = CuentaAhorro.getSaldo();
            nuevoSaldo = nuevoSaldo - giroUsuario;
            CuentaAhorro.setSaldo(nuevoSaldo);
                System.out.println("Retiro exitoso! Tu nuevo saldo es: $ "+CuentaAhorro.getSaldo()+" pesos.");
            }

    }

    @Override
    public void calcularInteres() {
        
        CuentaAhorro.setTipoCuenta();
        System.out.println("--------------------------- ACCEDIENDO AL SISTEMA ---------------------------");
        System.out.println("--------------------------=== "+CuentaAhorro.tipoCuenta+" ===--------------------------");
        System.out.println("----------------------------- CALCULAR INTERES ------------------------------");   
        double tasaInteres = 1.5, saldoConInteres = CuentaAhorro.getSaldo() + (CuentaAhorro.getSaldo() * tasaInteres);
        System.out.println("Su tasa de interes por el periodo es: "+tasaInteres+"%");
        System.out.println("Su saldo al final del periodo sera de $"+saldoConInteres);                
        
    }



    @Override
    public void consultarSaldo() {
        
        CuentaAhorro.setTipoCuenta();
        System.out.println("--------------------------- ACCEDIENDO AL SISTEMA ---------------------------");
        System.out.println("--------------------------=== "+CuentaAhorro.tipoCuenta+" ===--------------------------");
        System.out.println("----------------------------- CONSULTA SALDO ------------------------------");
        System.out.println("Tu saldo es: $ "+CuentaAhorro.getSaldo()+" pesos.");
    }
    
}
