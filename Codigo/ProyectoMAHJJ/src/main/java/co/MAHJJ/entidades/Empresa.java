package co.MAHJJ.entidades;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Empresa implements Serializable {

    //Atributos propios
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String nombre;

    @Column(unique = true)
    private String cedula;

    @Column(length = 20)
    private String telefono;

    @Column(length = 255)
    private String direccion;

    @Column(name = "fecha_creacion")
    private Date createAt;

    @Column(name = "fecha_actualizacion")
    private Date updateAt;

    //Relaciones
    @OneToMany(mappedBy = "empresa")
    private List<Empleado> empleados;

    @OneToMany(mappedBy = "empresa")
    private List<Transaccion> transacciones;

    public Empresa(long id, String nombre, String cedula, String telefono, String direccion, Date createAt, Date updateAt) {
        this.id = id;
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.direccion = direccion;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }
}
