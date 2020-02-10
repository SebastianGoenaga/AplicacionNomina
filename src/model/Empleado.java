package model;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Empleado {

    private String documento;
    private String nombre;
    private int edad;
    private HashMap<Date, Float> salarioHistorial = new HashMap<>();
    private HashMap<Date, HoraTrabajo> horaTrabajo = new HashMap<>();
    private Deduccion deducciones;
    private Set<Categoria> categorias = new HashSet<>();
    private boolean activo;

    public Empleado(String documento, String nombre, int edad) {
        this.documento = documento;
        this.nombre = nombre;
        this.edad = edad;
        this.activo = true;
        agregarDeducciones(0, 0, 0);
    }

    public void agregarHorasExtras(HoraTrabajo horaTrabajo, Date fecha) {
        this.horaTrabajo.put(fecha, horaTrabajo);
    }

    public void agregarDeducciones(float adicionPension, float adicionSalud, float adicionSaludPensional) {
        this.deducciones = new Deduccion(adicionPension, adicionSalud, adicionSaludPensional);
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
        salario -= salarioParcial * deducciones.getSalud();
        salario -= salarioParcial * deducciones.getPension();
        salario -= salarioParcial * deducciones.getSolidaridadPensional();
        
        HoraTrabajo horas = horaTrabajo.get(fecha);
        salario += ((horas == null) ? 0 : horas.horasNocturna) * ValorHora.VALOR_HORA_NOCTURNA.porcentaje * valorHoraEstandar;
        salario += ((horas == null) ? 0 : horas.horasDominicalDiurna) * ValorHora.VALOR_HORA_DOMINICAL_DIURNA.porcentaje * valorHoraEstandar;
        salario += ((horas == null) ? 0 : horas.horasDominicalNocturna) * ValorHora.VALOR_HORA_DOMINICAL_NOCTURNA.porcentaje
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

    public Deduccion getDeducciones() {
        return deducciones;
    }

    public Set<Categoria> getCategorias() {
        return categorias;
    }

    public boolean isActivo() {
        return activo;
    }

    public void inhabilitar() {
        this.activo = false;
    }

    public void habilitar() {
        this.activo = true;
    }

}