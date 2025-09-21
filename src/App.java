import java.time.LocalTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class App {

    // Conjunto en memoria donde vamos a guardar todas las empresas creadas
    private static final Set<Empresa> EMPRESAS = new HashSet<>();

    // ================== CRUD ==================

    // Agregar empresa al "repositorio"
    private static void crearEmpresa(Empresa e) { EMPRESAS.add(e); }

    // Mostrar todas las empresas guardadas
    private static void mostrarTodasLasEmpresas() {
        System.out.println("===== Empresas =====");
        EMPRESAS.forEach(System.out::println);
    }

    // Buscar empresa por su ID
    private static Optional<Empresa> buscarPorId(Long id) {
        return EMPRESAS.stream().filter(e -> e.getId().equals(id)).findFirst();
    }

    // Buscar empresa por nombre
    private static Optional<Empresa> buscarPorNombre(String nombre) {
        return EMPRESAS.stream().filter(e -> e.getNombre().equalsIgnoreCase(nombre)).findFirst();
    }

    // Actualizar el CUIT de una empresa según ID
    private static boolean actualizarCuitPorId(Long id, Long nuevoCuit) {
        return buscarPorId(id).map(e -> { e.setCuit(nuevoCuit); return true; }).orElse(false);
    }

    // Eliminar empresa según ID
    private static boolean eliminarPorId(Long id) {
        return EMPRESAS.removeIf(e -> e.getId().equals(id));
    }

    // ================== MAIN ==================
    public static void main(String[] args) {
        // 1. Creamos el País Argentina
        Pais argentina = Pais.builder().nombre("Argentina").build();

        // 2. Creamos la Provincia Buenos Aires y la asociamos a Argentina
        Provincia bsas = Provincia.builder().nombre("Buenos Aires").build();
        argentina.addProvincia(bsas);

        // 3. Creamos la Localidad CABA con su domicilio
        Localidad caba = Localidad.builder().nombre("CABA").build();
        bsas.addLocalidad(caba);
        Domicilio domCaba = Domicilio.builder().calle("Av. Corrientes").numero(1234).cp(1043).build();
        caba.addDomicilio(domCaba);

        // 4. Creamos la Localidad La Plata con su domicilio
        Localidad laPlata = Localidad.builder().nombre("La Plata").build();
        bsas.addLocalidad(laPlata);
        Domicilio domLaPlata = Domicilio.builder().calle("Calle 7").numero(777).cp(1900).build();
        laPlata.addDomicilio(domLaPlata);

        // 5. Creamos la Provincia Mendoza y la asociamos a Argentina
        Provincia mendoza = Provincia.builder().nombre("Mendoza").build();
        argentina.addProvincia(mendoza);

        // 6. Localidad Ciudad de Mendoza + domicilio
        Localidad ciudadMza = Localidad.builder().nombre("Ciudad de Mendoza").build();
        mendoza.addLocalidad(ciudadMza);
        Domicilio domCiudadMza = Domicilio.builder().calle("San Martín").numero(500).cp(5500).build();
        ciudadMza.addDomicilio(domCiudadMza);

        // 7. Localidad San Rafael + domicilio
        Localidad sanRafael = Localidad.builder().nombre("San Rafael").build();
        mendoza.addLocalidad(sanRafael);
        Domicilio domSanRafael = Domicilio.builder().calle("Av. Mitre").numero(200).cp(5600).build();
        sanRafael.addDomicilio(domSanRafael);

        // 8. Creamos las Sucursales (una por cada domicilio importante)
        Sucursal suc1 = Sucursal.builder()
                .nombre("Sucursal 1 - CABA")
                .horarioApertura(LocalTime.of(9,0))
                .horarioCierre(LocalTime.of(18,0))
                .esCasaMatriz(true)
                .domicilio(domCaba)
                .build();

        Sucursal suc2 = Sucursal.builder()
                .nombre("Sucursal 2 - La Plata")
                .horarioApertura(LocalTime.of(9,0))
                .horarioCierre(LocalTime.of(18,0))
                .esCasaMatriz(false)
                .domicilio(domLaPlata)
                .build();

        Sucursal suc3 = Sucursal.builder()
                .nombre("Sucursal 3 - Ciudad de Mendoza")
                .horarioApertura(LocalTime.of(9,0))
                .horarioCierre(LocalTime.of(18,0))
                .esCasaMatriz(false)
                .domicilio(domCiudadMza)
                .build();

        Sucursal suc4 = Sucursal.builder()
                .nombre("Sucursal 4 - San Rafael")
                .horarioApertura(LocalTime.of(9,0))
                .horarioCierre(LocalTime.of(18,0))
                .esCasaMatriz(false)
                .domicilio(domSanRafael)
                .build();

        // 9. Creamos Empresa1 y la relacionamos con Sucursal1 y Sucursal2
        Empresa empresa1 = Empresa.builder()
                .nombre("Empresa1")
                .razonSocial("Empresa Uno SA")
                .cuit(30_12345678_9L)
                .logo("logo1.png")
                .build();
        empresa1.addSucursal(suc1);
        empresa1.addSucursal(suc2);

        // 10. Creamos Empresa2 y la relacionamos con Sucursal3 y Sucursal4
        Empresa empresa2 = Empresa.builder()
                .nombre("Empresa2")
                .razonSocial("Empresa Dos SRL")
                .cuit(30_87654321_9L)
                .logo("logo2.png")
                .build();
        empresa2.addSucursal(suc3);
        empresa2.addSucursal(suc4);

        // 11. Guardamos las empresas en el "repositorio"
        crearEmpresa(empresa1);
        crearEmpresa(empresa2);

        // ========== DEMOSTRACIÓN DE FUNCIONALIDAD ==========
        // a) Mostrar todas las empresas
        mostrarTodasLasEmpresas();

        // b) Buscar empresa por ID
        Long idBuscar = empresa1.getId();
        System.out.println("\nBuscar por ID = " + idBuscar);
        System.out.println(buscarPorId(idBuscar).orElse(null));

        // c) Buscar empresa por nombre
        System.out.println("\nBuscar por nombre = Empresa2");
        System.out.println(buscarPorNombre("Empresa2").orElse(null));

        // d) Actualizar CUIT de Empresa1
        System.out.println("\nActualizar CUIT de Empresa1:");
        actualizarCuitPorId(empresa1.getId(), 30_11223344_9L);
        System.out.println(buscarPorId(empresa1.getId()).orElse(null));

        // e) Eliminar Empresa2
        System.out.println("\nEliminar Empresa2 por ID:");
        eliminarPorId(empresa2.getId());
        mostrarTodasLasEmpresas();
    }
}
