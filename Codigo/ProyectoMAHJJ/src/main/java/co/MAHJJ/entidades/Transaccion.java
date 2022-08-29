package co.MAHJJ.entidades;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Transaccion implements Serializable {

    //Atributos propios
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 255)
    private String concepto;

    @Column(nullable = false)
    private float monto;

    @Column(name = "fecha_creacion")
    private Date createAt;

    @Column(name = "fecha_actualizacion")
    private Date updateAt;

    //Relaciones
    @ManyToOne
    private Empleado empleado;

    @ManyToOne
    private Empresa empresa;

    public Transaccion(long id, String concepto, float monto, Date createAt, Date updateAt) {
        this.id = id;
        this.concepto = concepto;
        this.monto = monto;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }
}
