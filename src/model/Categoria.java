package model;

public enum Categoria {
    GERENTE(5000000, "Gerente", "GER"),
    DESARROLLADOR_JUNIOR(2000000, "Desarrollador Junior", "DJU"),
    DESARROLLADOR_SENIOR(2500000, "Desarrollador Senior", "DSE"),
    DIRECTOR(3500000, "Director", "DIR"),
    SCRUM_MASTER(4300000, "Scrum Master", "SCM");

    float salarioBase;
    String nombre;
    String abreviatura;


    private Categoria(float salarioBase, String nombre, String abreviatura) {
        this.salarioBase = salarioBase;
        this.nombre = nombre;
        this.abreviatura = abreviatura;

    }

    public float getSalarioBase() {
        return salarioBase;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

}
