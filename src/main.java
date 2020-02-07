import java.sql.Date;
import java.util.Scanner;

import model.Categoria;
import model.Deduccion;
import model.Empleado;
import model.Empresa;
import model.HoraTrabajo;

/**
 * main
 */
public class main {
    public static void main(String[] args) {

        Empresa empresa = new Empresa();

        boolean bandera = true;
        while (bandera) {
            System.out.println("Opcion 1: Agregar empleado");
            System.out.println("Opcion 2: Consultar salario empleado");
            System.out.println("Opcion 3: Consultar total");
            System.out.println("Opcion 4: Salir");

            Scanner sc = new Scanner(System.in);
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

                // Indicar las horas extras trabajadas por el empleado

                System.out.println("¿El empleado tiene horas extras?");
                System.out.println("Opcion 1: Si");
                System.out.println("Opcion 2: No");
                int horasExtrasPregunta = Integer.parseInt(sc.nextLine());

                switch (horasExtrasPregunta) {
                case 1:
                    System.out.println("Ingrese las horas nocturnas");
                    int nocturnas = Integer.parseInt(sc.nextLine());
                    System.out.println("Ingrese las horas dirunas festivas");
                    int dirFestiva = Integer.parseInt(sc.nextLine());
                    System.out.println("Ingrese las horas nocturnas festivas");
                    int nocFestiva = Integer.parseInt(sc.nextLine());

                    System.out.println("Ingrese el año correspondiente a las horas");
                    int year = Integer.parseInt(sc.nextLine());
                    System.out.println("Ingrese el mes correspondiente a las horas");
                    int month = Integer.parseInt(sc.nextLine());

                    HoraTrabajo horasExtras = new HoraTrabajo(nocturnas, dirFestiva, nocFestiva);
                    empleado.agregarHorasExtras(horasExtras, new Date(year, month, 1));
                    break;

                default:
                    break;
                }

                // ------------------------------------------------------------------------------------------------------

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:
                bandera = false;
                break;
            default:
                continue;
            }

        }

        // Empleado empleado = new Empleado("123", "Juan Prez", 30);
        // empleado.agregarCategoria(Categoria.DIRECTOR);
        // empleado.agregarCategoria(Categoria.DESARROLLADOR_SENIOR);
        // empleado.agregarDeduccion(Deduccion.PENSION);
        // empleado.agregarDeduccion(Deduccion.SALUD);
        // empleado.agregarHorasExtras(new HoraTrabajo(1, 0, 0), new Date(2020, 02,
        // 01));

        // System.out.println(empleado.calcularsalario(new Date(2020, 2, 1)));

    }

}