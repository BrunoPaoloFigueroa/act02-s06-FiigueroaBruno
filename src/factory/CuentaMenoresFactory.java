
package factory;

import model.CuentaAhorro;

public class CuentaMenoresFactory implements CuentaAhorroFactory {
    public CuentaAhorro crearCuenta(double monto, String tutor) {
        return new CuentaAhorro("Cuenta para Menores", 1.5, monto, false, 0, false, 1, 0, tutor);
    }
}
