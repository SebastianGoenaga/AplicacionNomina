package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * empresa
 */
public class Empresa {

    HashMap<String, Empleado> empleados;

    public Empresa() {
		this.empleados = new HashMap<>();
	}

    public void agregarEmpleados(Empleado empleado) {
        empleados.put(empleado.getDocumento(), empleado);
        
    }

    public HashMap<String, Empleado> getEmpleados() {
        return empleados;
    }

    public Empleado getEmpleado(String documento) {
        return empleados.get(documento);
    }
    
}