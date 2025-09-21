# País–Provincia–Localidad–Domicilio + Empresa/Sucursal (Java + Lombok)

Proyecto educativo en Java que implementa el diagrama dado con encapsulación y multiplicidades usando HashSet. La demo en App.java crea datos (Argentina → Buenos Aires/Mendoza → localidades → domicilios → sucursales → empresas) y ejecuta un CRUD básico de Empresa.

### Modelo y relaciones

- Clases: Pais, Provincia, Localidad, Domicilio, Sucursal, Empresa.

- Relaciones:
  Pais 1..n Provincia → Provincia 1..n Localidad → Localidad 1..n Domicilio → Sucursal 1–1 Domicilio → Empresa 1..n Sucursal.

- Técnicas: HashSet para multiplicidades, equals/hashCode controlados para evitar recursión, toString limpio.

### CRUD implementado

- Mostrar todas las empresas

- Buscar por ID

- Buscar por nombre

- Actualizar CUIT por ID

- Eliminar por ID

### Requisitos

- Java 8+

- Lombok con annotation processing habilitado en el IDE

### Como clonar

##### HTTPS
git clone https://github.com/facurodriguez06/Ejercicio-Traza-1.git
cd Ejercicio-Traza-1

##### SSH
git clone git@github.com:facurodriguez06/Ejercicio-Traza-1.git
cd Ejercicio-Traza-1
