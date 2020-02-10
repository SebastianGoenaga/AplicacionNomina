import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import model.Categoria;
import model.Deduccion;
import model.Empleado;
import model.Empresa;
import model.HoraTrabajo;

/**
 * main
 */
public class Main {
    public static void main(String[] args) throws Exception {

        Empresa empresa = new Empresa();

        boolean bandera = true;

        Scanner sc = new Scanner(System.in);
        while (bandera) {
            System.out.println();
            System.out.println("Opcion 1: Agregar empleado");
            System.out.println("Opcion 2: Consultar salario empleado");
            System.out.println("Opcion 3: Consultar suma total de salarios");
            System.out.println("Opcion 4: Eliminar empleado");
            System.out.println("Opcion 5: Habilitar empleado");
            System.out.println("Opcion 6: Mostrar todos los empleados");
            System.out.println("Opcion 7: Agregar las horas extras a un empleado");
            System.out.println("Opcion 8: Salir");

            int opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
            case 1:
                System.out.println("Ingrese el documento del empleado");
                String documento = sc.nextLine();
                System.out.println("Ingrese el nombre del empleado");
                String nombre = sc.nextLine();
                System.out.println("Ingrese la edad del empleado");
                int edad = Integer.parseInt(sc.nextLine());

                Empleado empleado = new Empleado(documento, nombre, edad);
                empresa.agregarEmpleados(empleado);

                // Seleccionar cargo del empleado en la empresa

                boolean banderaCargo = true;
                System.out.println("Seleccione los cargos del empleado");
                while (banderaCargo) {
                    System.out.println("Opcion 1: Gerente");
                    System.out.println("Opcion 2: Director de proyecto");
                    System.out.println("Opcion 3: Scrum Master");
                    System.out.println("Opcion 4: Desarrollador Senior");
                    System.out.println("Opcion 5: Desarrollador Junior");
                    int horasExtrasPregunta = Integer.parseInt(sc.nextLine());
                    Categoria categoria;
                    switch (horasExtrasPregunta) {
                    case 1:
                        categoria = Categoria.GERENTE;
                        break;
                    case 2:
                        categoria = Categoria.DIRECTOR;
                        break;
                    case 3:
                        categoria = Categoria.SCRUM_MASTER;
                        break;
                    case 4:
                        categoria = Categoria.DESARROLLADOR_SENIOR;
                        break;
                    case 5:
                        categoria = Categoria.DESARROLLADOR_JUNIOR;
                        break;
                    default:
                        categoria = Categoria.DESARROLLADOR_JUNIOR;
                    }
                    empleado.agregarCategoria(categoria);

                    System.out.println("¿Desea seguir agregando categorias?");
                    System.out.println("Opcion 1: Si");
                    System.out.println("Opcion 2: No");
                    int categoriaPregunta = Integer.parseInt(sc.nextLine());

                    switch (categoriaPregunta) {
                    case 2:
                        banderaCargo = false;
                        break;
                    }

                }

                // ------------------------------------------------------------------------------------------------------

                // Indicar las deducciones del empleado

                System.out.println("¿El empleado agregará deducciones extras?");
                System.out.println("Opcion 1: Si");
                System.out.println("Opcion 2: No");
                int deduccionesExtraPregunta = Integer.parseInt(sc.nextLine());

                switch (deduccionesExtraPregunta) {
                case 1:
                    System.out.println("Ingrese la salud extra: El porcentaje en numero entero");
                    int adicionSalud = Integer.parseInt(sc.nextLine());
                    System.out.println("Ingrese la pension extra: El porcentaje en numero entero");
                    int adicionPension = Integer.parseInt(sc.nextLine());
                    System.out.println("Ingrese la solidaridad pensional extra: El porcentaje en numero entero");
                    int adicionSaludPensional = Integer.parseInt(sc.nextLine());

                    empleado.agregarDeducciones(adicionPension / 100, adicionSalud / 100, adicionSaludPensional / 100);
                    break;
                case 2:
                    break;
                }

                // ------------------------------------------------------------------------------------------------------

                empresa.agregarEmpleados(empleado);
                break;

            case 2:
                // Buscar empleado
                System.out.println("Ingrese el documento del empleado a buscar");
                String documentoBuscar = sc.nextLine();
                Empleado empleadoEncontrado = empresa.buscarEmpleado(documentoBuscar);

                if (empleadoEncontrado.isActivo()) {
                    imprimirEmpleado(empleadoEncontrado);
                } else {
                    System.out.println("El empleado no está activo");
                }

                break;
            case 3:
                // Calcular salario total de empleados
                System.out.println("Ingrese la fecha de los salarios a calcular");
                System.out.println("Ingrese el año:");
                int year = Integer.parseInt(sc.nextLine());
                System.out.println("Ingrese el mes:");
                int month = Integer.parseInt(sc.nextLine());
                float salarioTotal = 0f;
                for (Empleado empleadoSalario : empresa.getEmpleados().values()) {
                    if (empleadoSalario.isActivo()) {
                        float salarioIndividual = empleadoSalario.calcularsalario(
                                new SimpleDateFormat("dd/MM/yyyy").parse(year + "/" + month + "/1"));
                        salarioTotal += salarioIndividual;
                        System.out.println("Nombre: " + empleadoSalario.getNombre() + " Salario: " + salarioIndividual);
                    } else {
                        continue;
                    }

                }
                System.out.println("El salario total de todos los empleados es:");
                System.out.println(salarioTotal);
                break;
            case 4:
                System.out.println("Ingrese el documento del empleado a eliminar");
                String documentoEliminar = sc.nextLine();
                empresa.buscarEmpleado(documentoEliminar).inhabilitar();
                break;
            case 5:
                System.out.println("Ingrese el documento del empleado a habilitar");
                String documentoHabilitar = sc.nextLine();
                empresa.buscarEmpleado(documentoHabilitar).habilitar();
                break;
            case 6:
                for (Empleado emp : empresa.getEmpleados().values()) {
                    imprimirEmpleado(emp);
                    System.out.println();
                    System.out.println();
                }
                break;
            case 7:
                System.out.println("Ingrese el documento del empleado a agregarle las horas extras");
                String documentoHoras = sc.nextLine();
                Empleado empleadoHoras = empresa.buscarEmpleado(documentoHoras);
                // Indicar las horas extras trabajadas por el empleado
                System.out.println("Ingrese las horas nocturnas");
                int nocturnas = Integer.parseInt(sc.nextLine());
                System.out.println("Ingrese las horas dirunas festivas");
                int dirFestiva = Integer.parseInt(sc.nextLine());
                System.out.println("Ingrese las horas nocturnas festivas");
                int nocFestiva = Integer.parseInt(sc.nextLine());

                System.out.println("Ingrese el año correspondiente a las horas");
                int yearHoras = Integer.parseInt(sc.nextLine());
                System.out.println("Ingrese el mes correspondiente a las horas");
                int monthHoras = Integer.parseInt(sc.nextLine());

                HoraTrabajo horasExtras = new HoraTrabajo(nocturnas, dirFestiva, nocFestiva);
                empleadoHoras.agregarHorasExtras(horasExtras,
                        new SimpleDateFormat("dd/MM/yyyy").parse(yearHoras+ "/" + monthHoras + "/1"));
                break;
            case 8:
                bandera = false;
                break;
            default:
                continue;
            }
            System.out.flush();

        }

        sc.close();

    }

    private static void imprimirEmpleado(Empleado empleado) {
        // Imprimir nombre
        System.out.println("Nombre:");
        System.out.println(empleado.getNombre());

        // Imprimir cargos asociados al empleado
        for (Categoria categoria : empleado.getCategorias()) {
            System.out.println("Cargo: " + categoria.getNombre());
            System.out.println("Salario: " + categoria.getSalarioBase());
        }

        // Impirmir deducciones del empleado
        Deduccion deduccion = empleado.getDeducciones();
        System.out.println("Porcentaje de pension: " + deduccion.getPension());
        System.out.println("Porcentaje de salud: " + deduccion.getSalud());
        System.out.println("Porcentaje de solidaridad pensional: " + deduccion.getSolidaridadPensional());

        // Imprimir salario del empleado
        System.out.println("Historial de salarios:");
        for (Date fecha : empleado.getSalarioHistorial().keySet()) {
            String key = fecha.toString();
            String value = empleado.getSalarioHistorial().get(fecha).toString();
            System.out.println(key + ": " + value);
        }
    }

}