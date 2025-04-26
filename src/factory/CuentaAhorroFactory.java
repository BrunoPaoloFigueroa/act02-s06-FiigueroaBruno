
package factory;

import model.CuentaAhorro;

public interface CuentaAhorroFactory {
    CuentaAhorro crearCuenta(double monto, String tutor);
}
