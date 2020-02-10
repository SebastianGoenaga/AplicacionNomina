package model;

public class Deduccion {

    public static final float PENSION = 0.08f;
    public static final float SALUD = 0.08f;
    public static final float SOLARIDAD_PENSIONAL = 0.01f;

    private float pension;
    private float salud;
    private float solidaridadPensional;

    public Deduccion(float adicionPension, float adicionSalud, float adicionSolidaridadPensional) {
        this.pension = adicionPension + Deduccion.PENSION;
        this.salud = adicionSalud + Deduccion.SALUD;
        this.solidaridadPensional = adicionSolidaridadPensional + Deduccion.SOLARIDAD_PENSIONAL;
    }

    public float getPension() {
        return pension;
    }

    public void setPension(float pension) {
        this.pension = pension;
    }

    public float getSalud() {
        return salud;
    }

    public void setSalud(float salud) {
        this.salud = salud;
    }

    public float getSolidaridadPensional() {
        return solidaridadPensional;
    }

    public void setSolidaridadPensional(float solidaridadPensional) {
        this.solidaridadPensional = solidaridadPensional;
    }

    
    

}
