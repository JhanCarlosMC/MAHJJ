package co.MAHJJ.entidades;

import lombok.*;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Getter @Setter
@ToString
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Perfil implements Serializable {

    //Atributos propios
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(length = 255)
    private String image;

    @Column(length = 255)
    private String telefono;

    @Column(name = "fecha_creacion")
    private Date createAt;

    @Column(name = "fecha_actualizacion")
    private Date updateAt;

    //Relaciones
    @OneToOne(mappedBy = "perfil")
    private Empleado empleado;

    public Perfil(String id, String image, String telefono, Date createAt, Date updateAt) {
        this.id = id;
        this.image = image;
        this.telefono = telefono;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }
}
