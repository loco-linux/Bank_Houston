/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duoc.cuentas.cuenta_corriente;

import com.duoc.cuentas.CuentaBancaria;
import java.util.Scanner;

/**
 *
 * @author jbarr
 */
public class CuentaCorriente extends CuentaBancaria {
  
     static Scanner teclado = new Scanner(System.in);
    
    public CuentaCorriente() {
    }

    public CuentaCorriente(int numeroCuenta, int saldo) {    
        super(numeroCuenta, saldo);
    }

    
    public static String getTipoCuenta() {
        return tipoCuenta;
    }
    
    public static void setTipoCuenta(){
        tipoCuenta = "Cuenta Corriente";
    }
    
    public static int getNumeroCuenta() {
        return CuentaCorriente.numeroCuenta;
    }

    public static void setNumeroCuenta(int numeroCuenta) {
        CuentaCorriente.numeroCuenta = numeroCuenta;
    }

    public static int getSaldo() {
        return CuentaCorriente.saldo;
    }

    public static void setSaldo(int saldo) {
        CuentaCorriente.saldo = saldo;
    }
    
    
    @Override
    public void depositarDinero() {
        
        this.setTipoCuenta();
        System.out.println("--------------------------- ACCEDIENDO AL SISTEMA ---------------------------");
        System.out.println("--------------------------=== "+this.getTipoCuenta()+" ===--------------------------");
        System.out.println("--------------------------------- DEPOSITOS ----------------------------------");
        System.out.println("Por favor, indica el monto a depositar. Ejemplo: 50000");
        int deposito = teclado.nextInt(); 
        if (deposito > 0) {
           saldoUsuario = this.getSaldo();
           saldoUsuario = saldoUsuario + deposito;
           this.setSaldo(saldoUsuario);
           System.out.println("Deposito realizado!");
           System.out.println("Haz hecho un deposito por un total de: $ "+deposito+" pesos.");
           System.out.println("Tu nuevo saldo es: $ "+this.getSaldo()+" pesos.");
           } else {
                System.out.println("[ERROR] No se permite el ingreso de montos menores o iguales a 0 pesos. Por favor introduce un monto valido");
            }





    }

    @Override
    public void girarDinero() {
        
        this.setTipoCuenta();
        teclado.nextLine();
        System.out.println("--------------------------- ACCEDIENDO AL SISTEMA ---------------------------");
        System.out.println("--------------------------=== "+this.getTipoCuenta()+" ===--------------------------");
            System.out.println("---------------------------- RETIRAR DINERO -----------------------------");
            System.out.println("Por favor digita el monto que deseas retirar: ");
            int giroUsuario = teclado.nextInt();
            if (giroUsuario <= 0) {
                System.out.println("[ERROR] El monto a retirar debe ser mayor a 0 pesos");
            } else if (giroUsuario > this.getSaldo()) {
                System.out.println("[ERROR] El monto a retirar excede tu saldo actual");
            } else {
            int nuevoSaldo = this.getSaldo();
            nuevoSaldo = nuevoSaldo - giroUsuario;
            this.setSaldo(nuevoSaldo);
                System.out.println("Retiro exitoso! Tu nuevo saldo es: $ "+this.getSaldo()+" pesos.");
            }

    }

    @Override
    public void calcularInteres() {
        
        this.setTipoCuenta();
        System.out.println("--------------------------- ACCEDIENDO AL SISTEMA ---------------------------");
        System.out.println("--------------------------=== "+this.getTipoCuenta()+" ===--------------------------");
        System.out.println("----------------------------- CALCULAR INTERES ------------------------------");   
        double tasaInteres = 0, saldoConInteres = this.getSaldo() + (this.getSaldo() * tasaInteres);
        System.out.println("Su tasa de interes por el periodo es: "+tasaInteres+"%");
        System.out.println("Su saldo al final del periodo sera de $"+saldoConInteres);                
        
    }


    
    @Override
    public void consultarSaldo() {
        
        CuentaCorriente.setTipoCuenta();
        System.out.println("--------------------------- ACCEDIENDO AL SISTEMA ---------------------------");
        System.out.println("--------------------------=== "+this.getTipoCuenta()+" ===--------------------------");
        System.out.println("----------------------------- CONSULTA SALDO ------------------------------");
        System.out.println("Tu saldo es: $ "+this.getSaldo()+" pesos.");
    }
    
}