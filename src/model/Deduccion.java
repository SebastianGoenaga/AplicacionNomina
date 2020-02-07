package model;

public enum Deduccion {
    PENSION(0.08f, "Pension"),
    SALUD(0.08f, "Salud"),
    SOLARIDAD_PENSIONAL(0.01f, "Solaridad Pensional");

    String nombre;
    float porcentaje;

    private Deduccion(float porcentaje, String nombre) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;

    }

}
