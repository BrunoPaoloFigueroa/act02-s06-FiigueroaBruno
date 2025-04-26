
package factory;

import model.CuentaAhorro;

public class CuentaSueldoFactory implements CuentaAhorroFactory {
    public CuentaAhorro crearCuenta(double monto, String tutor) {
        return new CuentaAhorro("Ahorro Sueldo", 2.5, monto, false, 5, false, 1, 0, null);
    }
}
