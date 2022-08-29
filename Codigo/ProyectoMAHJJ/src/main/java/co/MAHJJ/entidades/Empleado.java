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
public class Empleado implements Serializable {

    //Atributos propios
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "fecha_creacion")
    private Date createAt;

    @Column(name = "fecha_actualizacion")
    private Date updateAt;

    @Column(nullable = false)
    private RolName rol;

    //Relaciones
    @OneToOne
    private Perfil perfil;

    @ManyToOne
    private Empresa empresa;

    @OneToMany(mappedBy = "empleado")
    private List<Transaccion> transacciones;

    public Empleado(long id, String email, Date createAt, Date updateAt, RolName rol) {
        this.id = id;
        this.email = email;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.rol = rol;
    }
}
