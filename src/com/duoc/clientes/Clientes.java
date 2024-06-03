/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duoc.clientes;

import com.duoc.cuentas.cuenta_ahorro.CuentaAhorro;
import com.duoc.cuentas.cuenta_corriente.CuentaCorriente;
import com.duoc.cuentas.cuenta_inversion.CuentaInversion;
import com.duoc.interfaces.InfoCliente;
import java.util.Scanner;

/**
 *
 * @author jbarr
 */
public class Clientes implements InfoCliente {
    private String rut;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String domicilio;
    private String comuna;
    private String telefono;
       
    private int cuentaBancaria;
    public int numeroCuentaUsuario = 0;
    public int saldoUsuarioRegistro = 0;
    public static int eleccionTipoCuenta = 0;
    public String tipoCuenta = "";
    
    private CuentaCorriente cuentaCorriente;
    private CuentaAhorro cuentaAhorro;
    private CuentaInversion cuentaInversion;
    
    static Scanner teclado = new Scanner(System.in);
    
    public Clientes(){
        
    }

    public Clientes(
            String rut, 
            String nombre, 
            String apellidoPaterno, 
            String apellidoMaterno, 
            String domicilio, 
            String comuna, 
            String telefono, 
            int cuentaBancaria
    ) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.domicilio = domicilio;
        this.comuna = comuna;
        this.telefono = telefono;
        this.cuentaBancaria = cuentaBancaria;        
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(int cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }


    public CuentaCorriente getCuentaCorriente() {
    return cuentaCorriente;
    }
    
    public CuentaAhorro getCuentaAhorro() {
    return cuentaAhorro;
    }
    
    public CuentaInversion getCuentaInversion() {
    return cuentaInversion;
    }
    
    public String getTipoCuenta() {
        return tipoCuenta;
    }
    
    
    
    
    // Metodos adicionales
    public void registrarCliente(){
        
        System.out.println("""
                           -------------------------- REGISTRO DE CLIENTES --------------------------
                           Esta es la plataforma de registro de clientes --- BANK HOUSTON INTERNATIONAL ---
                           Por favor, ingrese su Rut con puntos, guion y digito verificador. Ejemplo: 12.453.412-0
                           """);
        System.out.print(">");
        String rutUsuario = teclado.nextLine(); 
        if (rutUsuario.length() >= 11 && rutUsuario.length() <= 12) {
            numeroCuentaUsuario = 100000000 + (int) (Math.random() * 900000000);
            saldoUsuarioRegistro = 0;
            setRut(rutUsuario);
            System.out.println(">> Rut ingresado correctamente");
        }
        else {
            System.out.println("[ERROR] Invalido. Por favor digite su rut. Con puntos, guion y digito verificacor. Ejemplo: 12.453.412-0");
            return;
        }
        
        System.out.println("""
                           Digite el Tipo de Cuenta que usted desea.
                           [1] Para CREAR una Cuenta Corriente
                           [2] Para CREAR una Cuenta de Ahorro
                           [3] Para CREAR una Cuenta de Inversion                           
                           """);
        System.out.print("> ");
        Clientes.eleccionTipoCuenta = teclado.nextInt();
        
       switch (Clientes.eleccionTipoCuenta) {
       
           case 1 -> {
               System.out.println("Usted ha elegido la Opcion Cuenta Corriente");
               tipoCuenta = "Cuenta Corriente";
               cuentaCorriente = new CuentaCorriente();
               cuentaCorriente.setNumeroCuenta(numeroCuentaUsuario);
               cuentaCorriente.setSaldo(saldoUsuarioRegistro);
            }
               
           case 2 -> {
               System.out.println("Usted ha elegido la Opcion Cuenta de Ahorro");
               tipoCuenta = "Cuenta de Ahorro";
               cuentaAhorro = new CuentaAhorro();
               cuentaAhorro.setNumeroCuenta(numeroCuentaUsuario);
               cuentaAhorro.setSaldo(saldoUsuarioRegistro);
            }
               
           case 3 -> {
               System.out.println("Usted ha elegido la Opcion Cuenta de Inversion");
               tipoCuenta = "Cuenta de Inversion";
               // Implementar nuevos constructores para cuenta inversion
               System.out.println("Desea invertir en un perfil agresivo? [Presione 1]: ");
               try{
               int opcionPerfil = teclado.nextInt();
               if(opcionPerfil == 1){
                    cuentaInversion = new CuentaInversion(3);
                    cuentaInversion.setNumeroCuenta(numeroCuentaUsuario);
                    cuentaInversion.setSaldo(saldoUsuarioRegistro);
                    System.out.println("Tasa interes ajustada a 3%");
               }else{
                    cuentaInversion = new CuentaInversion(numeroCuentaUsuario, saldoUsuarioRegistro);               
               }
               }catch(Exception io){
                    cuentaInversion = new CuentaInversion(numeroCuentaUsuario, saldoUsuarioRegistro);               
               }
            }
            
           default -> {
               System.out.println("[ERROR] Opcion no valida. Por favor Digite 1, 2 o 3");
               return;
            }
           
       }
       
        teclado.nextLine();
        
        System.out.println("Para Continuar, Por favor Ingrese su nombre completo. Ejemplo: Arturo");
        String nombreCompleto = teclado.nextLine();
        if (!nombreCompleto.isEmpty()) {
        setNombre(nombreCompleto);
            System.out.println(">> Nombre ingresado correctamente");
        } else {
            System.out.println("[ERROR] Invalido. Por favor ingrese su nombre completo. Ejemplo: Arturo");
        }
        System.out.println("Ingrese su Apellido Paterno. Ejemplo: Vidal");
        String apellidoPaternoUsuario = teclado.nextLine();
        if (!apellidoPaternoUsuario.isEmpty()) {
            setApellidoPaterno(apellidoPaternoUsuario);
            System.out.println(">> Apellido Paterno ingresado correctamente");
        } else {
            System.out.println("[ERROR] Invalido. Por favor ingrese su Apellido Paterno. Ejemplo: Vidal");
        }
        System.out.println("Ingrese su Apellido Materno. Ejemplo: Quintanilla");
        String apellidoMaternoUsuario = teclado.nextLine();
        if (!apellidoMaternoUsuario.isEmpty()) {
        setApellidoMaterno(apellidoMaternoUsuario);
            System.out.println(">> Apellido Materno ingresado correctamente");
        } else {
            System.out.println("[ERROR] Invalido. Por favor ingrese su Apellido Materno. Ejemplo: Quintanilla");
        }
        System.out.println("Ingrese su Domicilio. Ejemplo: Av. Marathon #5300");
        String domicilioUsuario = teclado.nextLine();
        if (!domicilioUsuario.isEmpty()) {
        setDomicilio(domicilioUsuario);
            System.out.println("Domicilio ingresado correctamente");
        } else {
            System.out.println("[ERROR] Invalido. Por favor ingrese su domicilio. Ejemplo: Av. Marathon #5300");
        }
        System.out.println("Ingrese su Comuna. Ejemplo: Macul");
        String comunaUsuario = teclado.nextLine();
        if (!comunaUsuario.isEmpty()) {
        setComuna(comunaUsuario);
            System.out.println(">> Comuna ingresada correctamente");
        }
        else {
            System.out.println("[ERROR] Invalido. Por favor ingrese su comuna. Ejemplo: Macul");
        }
        System.out.println("Ingrese su Numero de Telefono: Ejemplo: 963867456");
        String telefonoUsuario = teclado.nextLine();
        if (!telefonoUsuario.isEmpty()) {
        setTelefono(telefonoUsuario);
            System.out.println(">> Telefono ingresado correctamente");
        } else {
            System.out.println("[ERROR] Invalido. Por favor ingrese su telefono. Ejemplo: 963867456");
        }
        
        System.out.println("==Proceso exitoso. Se ha creado tu Cuenta Bancaria==");
        System.out.println("A continuacion, tu numero de cuenta. Anotalo, guardalo! No lo olvides!");
        System.out.println("----> Tu Numero de cuenta es: [" + numeroCuentaUsuario+"] \nTipo de cuenta: "+tipoCuenta);
        System.out.println("Muchas gracias por confiar en BANK HOUSTON. Estamos honrados de que nos hayas elegido como tu Banco");
        System.out.println(" ");        
        
        
    }
    
    // Implementado de la infertaz InfoCliente que muestra informacion del cliente 
    @Override
    public void mostrarInformacionCliente(){
        
            
            System.out.println("------------------------ MIS DATOS ------------------------");
            System.out.println("Bienvenido "        +getNombre()+"!");
            System.out.println("El resumen de tus datos personales registrados en BANK HOUSTON: ");
            System.out.println("Rut: "              +getRut());
            System.out.println("Nombre completo: "  +getNombre());
            System.out.println("Apellido Paterno: " +getApellidoPaterno());
            System.out.println("Apellido Materno: " +getApellidoMaterno());
            System.out.println("Domicilio: "        +getDomicilio());
            System.out.println("Comuna: "           +getComuna());
            System.out.println("Telefono: "         +getTelefono());
            System.out.println("Tipo de Cuenta: "   +getTipoCuenta());
            
            switch (tipoCuenta) {
            
                case "Cuenta Corriente" -> {
                    System.out.println("Numero de Cuenta Corriente: "+CuentaCorriente.getNumeroCuenta());
                    System.out.println("Saldo: $ "+CuentaCorriente.getSaldo()+" pesos.");
            }
                    
                case "Cuenta de Ahorro" -> {
                    System.out.println("Numero de Cuenta de Ahorro: "+CuentaAhorro.getNumeroCuenta());
                    System.out.println("Saldo: $ "+CuentaAhorro.getSaldo()+" pesos.");
            }
                    
                case "Cuenta de Inversion" -> {
                    System.out.println("Numero de Cuenta de Inversion: "+CuentaInversion.getNumeroCuenta());
                    System.out.println("Saldo: $ "+CuentaInversion.getSaldo());
            }
                
            }
        
    }


    
    
}
