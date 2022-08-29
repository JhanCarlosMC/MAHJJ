public class MovimientoDinero {
    
    private double monto;
    private String concepto;
    private Empleado encargado;

    public MovimientoDinero() {
    }

    public MovimientoDinero(double monto, String concepto, Empleado encargado) {
        this.monto = monto;
        this.concepto = concepto;
        this.encargado = encargado;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Empleado getEncargado() {
        return encargado;
    }

    public void setEncargado(Empleado encargado) {
        this.encargado = encargado;
    }

    @Override
    public String toString() {
        return "MovimientoDinero{" + "monto=" + monto + ", concepto=" + concepto + ", encargado=" + encargado + '}';
    }

}
