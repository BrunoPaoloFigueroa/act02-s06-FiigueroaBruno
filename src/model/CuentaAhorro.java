
package model;

public class CuentaAhorro {
    private String tipo;
    private double tasaInteres;
    private double monto;
    private boolean pagaMantenimiento;
    private int retirosPermitidosATM;
    private boolean esDigital;
    private int cantidadTitulares;
    private int plazoMeses;
    private String tutor;

    public CuentaAhorro(String tipo, double tasaInteres, double monto, boolean pagaMantenimiento,
                        int retirosPermitidosATM, boolean esDigital, int cantidadTitulares, int plazoMeses, String tutor) {
        this.tipo = tipo;
        this.tasaInteres = tasaInteres;
        this.monto = monto;
        this.pagaMantenimiento = pagaMantenimiento;
        this.retirosPermitidosATM = retirosPermitidosATM;
        this.esDigital = esDigital;
        this.cantidadTitulares = cantidadTitulares;
        this.plazoMeses = plazoMeses;
        this.tutor = tutor;
    }

    public String getTipo() { return tipo; }
    public double getTasaInteres() { return tasaInteres; }
    public double getMonto() { return monto; }
    public boolean isPagaMantenimiento() { return pagaMantenimiento; }
    public int getRetirosPermitidosATM() { return retirosPermitidosATM; }
    public boolean isEsDigital() { return esDigital; }
    public int getCantidadTitulares() { return cantidadTitulares; }
    public int getPlazoMeses() { return plazoMeses; }
    public String getTutor() { return tutor; }
}
