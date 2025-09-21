import lombok.*;
import java.time.LocalTime;

//Sucursal: Relación 1:1 con Domicilio (según el diagrama).
@Data @NoArgsConstructor @AllArgsConstructor @Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Sucursal {

    @EqualsAndHashCode.Include
    @NonNull
    private String nombre;

    @NonNull private LocalTime horarioApertura;
    @NonNull private LocalTime horarioCierre;
    private boolean esCasaMatriz;

    @ToString.Exclude
    @NonNull
    private Domicilio domicilio;

}
