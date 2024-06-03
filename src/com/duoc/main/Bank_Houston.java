/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duoc.main;


import com.duoc.clientes.Clientes;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author jbarr
 */
public class Bank_Houston {
    public static void main(String[] args){
        
        
    int seleccionUsuario;
    int opcionUsuario = 0;
    String ingresoRut;
    boolean salir=false;
    
    Scanner teclado = new Scanner(System.in);
    ArrayList<Clientes> clientes = new ArrayList <>();
     
        do {
        
            try {
        
                System.out.println("""
                                   \n------------------------------ BIENVENIDO A BANK HOUSTON ------------------------------
                                   Por favor, DIGITE una opcion valida:
                                   [1] Para REGISTRARSE como Nuevo Cliente de BANK HOUSTON.
                                   [2] Para ACCEDER a tu Sucursal Virtual (RUT Requerido).
                                   [3] Para SALIR.
                                   """);
                System.out.print(">> ");
        opcionUsuario = teclado.nextInt();
            } catch (Exception e) {
                System.out.println("[ERROR] DEBES INGRESAR UN NUMERO VALIDO. EJEMPLO: 3");
                return;
             
    }
        if (opcionUsuario == 1) {
        Clientes usuario = new Clientes();
        usuario.registrarCliente();
        clientes.add(usuario);
        } else if (opcionUsuario == 2) {
        teclado.nextLine();
        try {
            System.out.println("Por favor, ingrese su RUT de Cliente. Recuerde que para acceder a Sucursal Virtual, usted debe ser Cliente.");
            ingresoRut = teclado.nextLine();
            }catch (Exception e){
                System.out.println("[ERROR] DEBES INGRESAR UN FORMATO DE RUT VALIDO CON PUNTOS, GUION Y DIGITO VERIFICADOR." + e);
                return;    
                }
            boolean usuarioEncontrado = false;
            for (Clientes cliente : clientes){
            if (ingresoRut.equals(cliente.getRut())) {
                usuarioEncontrado = true;
           do { 
               System.out.println("""
                                  \n-------------------------- BIENVENIDO A SUCURSAL VIRTUAL BANK HOUSTON --------------------------
                                  Por favor, DIGITE una opcion valida: 
                                  [1] Para VER tus datos de cliente.
                                  [2] Para DEPOSITAR dinero en tu cuenta.
                                  [3] Para RETIRAR dinero de tu cuenta.
                                  [4] Para CONSULTAR tu saldo.
                                  [5] Para CONSULTAR INTERESES acumulados.
                                  [6] Para SALIR.
                                  """);
               System.out.print(">> ");
        seleccionUsuario = teclado.nextInt();
        
        
        switch (seleccionUsuario) {
        
            case 1 -> cliente.mostrarInformacionCliente();
            case 2 ->   {
                switch (cliente.getTipoCuenta()) {
                    case "Cuenta Corriente" -> cliente.getCuentaCorriente().depositarDinero();
                    case "Cuenta de Ahorro" -> cliente.getCuentaAhorro().depositarDinero();                    
                    case "Cuenta de Inversion" -> cliente.getCuentaInversion().depositarDinero();
                }}

            case 3 ->   {
                switch (cliente.getTipoCuenta()) {                    
                    case "Cuenta Corriente" -> cliente.getCuentaCorriente().girarDinero();                        
                    case "Cuenta de Ahorro" -> cliente.getCuentaAhorro().girarDinero();                        
                    case "Cuenta de Inversion" -> cliente.getCuentaInversion().girarDinero();
                }}
            case 4 ->   {
                switch (cliente.getTipoCuenta()) {                    
                    case "Cuenta Corriente" -> cliente.getCuentaCorriente().consultarSaldo();                        
                    case "Cuenta de Ahorro" -> cliente.getCuentaAhorro().consultarSaldo();                        
                    case "Cuenta de Inversion" -> cliente.getCuentaInversion().consultarSaldo();
                }}
            case 5 -> {
                switch (cliente.getTipoCuenta()) {                    
                    case "Cuenta Corriente" -> cliente.getCuentaCorriente().calcularInteres();                 
                    case "Cuenta de Ahorro" -> cliente.getCuentaAhorro().calcularInteres();                       
                    case "Cuenta de Inversion" -> cliente.getCuentaInversion().calcularInteres();
                }}
            case 6 -> salir = true;
            default ->  {
                System.out.println("[ERROR] POR FAVOR DIGITE UNA OPCION VALIDA.");
                }             
        }
        
    } while (salir==false); 
            } 
        } if (!usuarioEncontrado) {
            System.out.println("[ERROR] RUT no valido. Por favor, intente nuevamente");
        
            }   
        } else if (opcionUsuario != 3) {
        System.out.println("[ERROR] POR FAVOR DIGITE UNA OPCION VALIDA.");
                }
        } while (opcionUsuario != 3);
                System.out.println("**** =GRACIAS POR OPERAR CON BANK HOUSTON= ****");
        
                
    teclado.close();
    }
    
        
        
    
}
