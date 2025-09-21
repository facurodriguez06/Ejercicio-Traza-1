País–Provincia–Localidad–Domicilio + Empresa/Sucursal (Java + Lombok)

Proyecto educativo en Java que implementa el diagrama dado con encapsulación y multiplicidades usando HashSet. La demo en App.java crea datos (Argentina → Buenos Aires/Mendoza → localidades → domicilios → sucursales → empresas) y ejecuta un CRUD básico de Empresa.

Modelo y relaciones

Clases: Pais, Provincia, Localidad, Domicilio, Sucursal, Empresa.

Relaciones:
Pais 1..n Provincia → Provincia 1..n Localidad → Localidad 1..n Domicilio → Sucursal 1–1 Domicilio → Empresa 1..n Sucursal.

Técnicas: HashSet para multiplicidades, equals/hashCode controlados para evitar recursión, toString limpio.

Datos de ejemplo (demo en main)

País: Argentina

Provincias: Buenos Aires, Mendoza

Localidades: CABA, La Plata, Ciudad de Mendoza, San Rafael

Sucursales: 1 (CABA, matriz), 2 (La Plata), 3 (Ciudad de Mendoza), 4 (San Rafael)

Empresas:

Empresa1 → sucursales 1 y 2

Empresa2 → sucursales 3 y 4

CRUD implementado

Mostrar todas las empresas

Buscar por ID

Buscar por nombre

Actualizar CUIT por ID

Eliminar por ID

Requisitos

Java 8+

Lombok con annotation processing habilitado en el IDE

# HTTPS
git clone https://github.com/<usuario>/<repo>.git
cd <repo>

# SSH
git clone git@github.com:<usuario>/<repo>.git
cd <repo>

