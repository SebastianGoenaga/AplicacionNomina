package model;

import java.util.HashMap;

/**
 * empresa
 */
public class Empresa {

    private HashMap<String, Empleado> empleados;

    public Empresa() {
		this.empleados = new HashMap<>();
	}

    public void agregarEmpleados(Empleado empleado) {
        empleados.put(empleado.getDocumento(), empleado);
        
    }

    public HashMap<String, Empleado> getEmpleados() {
        return empleados;
    }

    public Empleado buscarEmpleado(String documento) {
        return empleados.get(documento);
    }
    
}