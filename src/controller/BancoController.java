
package controller;

import factory.*;
import model.CuentaAhorro;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BancoController {
    public CuentaAhorro crearCuenta(String tipoCuenta, double monto, String tutor) {
        CuentaAhorroFactory factory;
        switch (tipoCuenta) {
            case "Ahorro Sueldo":
                factory = new CuentaSueldoFactory();
                break;
            case "Ahorro Digital":
                factory = new CuentaDigitalFactory();
                break;
            case "Ahorro Mancomunada":
                factory = new CuentaMancomunadaFactory();
                break;
            case "Plazo Fijo":
                factory = new CuentaPlazoFijoFactory();
                break;
            case "Cuenta para Menores":
                factory = new CuentaMenoresFactory();
                break;
            default:
                throw new IllegalArgumentException("Tipo de cuenta inválido");
        }
        CuentaAhorro cuenta = factory.crearCuenta(monto, tutor);
        guardarCuentaEnArchivo(cuenta);
        return cuenta;
    }

    private void guardarCuentaEnArchivo(CuentaAhorro cuenta) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("cuentas.txt", true))) {
            writer.write(cuenta.getTipo() + "|" + cuenta.getMonto() + "|" + cuenta.getTasaInteres() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
