
package factory;

import model.CuentaAhorro;

public class CuentaPlazoFijoFactory implements CuentaAhorroFactory {
    public CuentaAhorro crearCuenta(double monto, String tutor) {
        return new CuentaAhorro("Depósito Plazo Fijo", 6.0, monto, false, 0, false, 1, 6, null);
    }
}
