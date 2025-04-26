
package factory;

import model.CuentaAhorro;

public class CuentaDigitalFactory implements CuentaAhorroFactory {
    public CuentaAhorro crearCuenta(double monto, String tutor) {
        return new CuentaAhorro("Ahorro Digital", 3.0, monto, true, 3, true, 1, 0, null);
    }
}
