package model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Empleado {

    private String documento;
    private String nombre;
    private int edad;
    private HashMap<Date, Float> salarioHistorial = new HashMap<>();
    private HashMap<Date, HoraTrabajo> horaTrabajo = new HashMap<>();
    private Set<Deduccion> deducciones = new HashSet<>();
    private Set<Categoria> categorias = new HashSet<>();

    public Empleado(String documento, String nombre, int edad) {
        this.documento = documento;
        this.nombre = nombre;
        this.edad = edad;
    }

    public void agregarHorasExtras(HoraTrabajo horaTrabajo, Date fecha) {
        this.horaTrabajo.put(fecha, horaTrabajo);
    }

    public void agregarDeduccion(Deduccion deduccion) {
        this.deducciones.add(deduccion);
    }

    public void agregarCategoria(Categoria categoria) {
        this.categorias.add(categoria);
    }

    public float calcularsalario(Date fecha) {
        float salario = 0;

        for (Categoria categoria : categorias) {
            salario += categoria.salarioBase;
        }

        float valorHoraEstandar = salario / 240;
        // System.out.println(valorHoraEstandar);

        float salarioParcial = salario;
        for (Deduccion deduccion : deducciones) {
            salario -= salarioParcial * deduccion.porcentaje;
        }

        HoraTrabajo horas = horaTrabajo.get(fecha);
        salario += horas.horasNocturna * ValorHora.VALOR_HORA_NOCTURNA.porcentaje * valorHoraEstandar;
        salario += horas.horasDominicalDiurna * ValorHora.VALOR_HORA_DOMINICAL_DIURNA.porcentaje * valorHoraEstandar;
        salario += horas.horasDominicalNocturna * ValorHora.VALOR_HORA_DOMINICAL_NOCTURNA.porcentaje
                * valorHoraEstandar;

        salarioHistorial.put(fecha, salario);
        return salario;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public HashMap<Date, Float> getSalarioHistorial() {
        return salarioHistorial;
    }

    public HashMap<Date, HoraTrabajo> getHoraTrabajo() {
        return horaTrabajo;
    }

    public Set<Deduccion> getDeducciones() {
        return deducciones;
    }

    public Set<Categoria> getCategorias() {
        return categorias;
    }

}