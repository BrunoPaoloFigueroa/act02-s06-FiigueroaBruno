
package factory;

import model.CuentaAhorro;

public class CuentaMancomunadaFactory implements CuentaAhorroFactory {
    public CuentaAhorro crearCuenta(double monto, String tutor) {
        return new CuentaAhorro("Ahorro Mancomunada", 4.0, monto, false, 5, false, 2, 0, null);
    }
}
