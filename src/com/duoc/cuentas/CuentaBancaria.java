/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duoc.cuentas;

import com.duoc.interfaces.SaldoCliente;

/**
 *
 * @author jbarr
 */
public abstract class CuentaBancaria implements SaldoCliente {
//    Deberian tener visualizacion en "private", pero el codigo me tira errores, por lo que me permitio dejarlo en protected con static

    
    
    protected static  String tipoCuenta;
    protected static int numeroCuenta;
    protected static int saldo;
    protected static int saldoUsuario;
    
    public CuentaBancaria(){
        tipoCuenta = "";
        numeroCuenta = 0;
        saldo = 0;
        saldoUsuario = 0;
    }
    
    public CuentaBancaria(int numeroCuenta, int saldo){
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    
    // Getters y Setters
    public static String getTipoCuenta() {
        return tipoCuenta;
    }

    public static void setTipoCuenta(String tipoCuenta) {
        CuentaBancaria.tipoCuenta = tipoCuenta;
    }

    public static int getNumeroCuenta() {
        return numeroCuenta;
    }

    public static void setNumeroCuenta(int numeroCuenta) {
        CuentaBancaria.numeroCuenta = numeroCuenta;
    }

    public static int getSaldo() {
        return saldo;
    }

    public static void setSaldo(int saldo) {
        CuentaBancaria.saldo = saldo;
    }

    public static int getSaldoUsuario() {
        return saldoUsuario;
    }

    public static void setSaldoUsuario(int saldoUsuario) {
        CuentaBancaria.saldoUsuario = saldoUsuario;
    }
    
    
    // Metodos abstractos
    // Deben ser implementados en las clases hijas
    
    public abstract void depositarDinero();
    public abstract void girarDinero();   
    public abstract void calcularInteres();
    
    // implementa la interface SaldoCliente que contiene el metodo consultarSaldo
    
    
}