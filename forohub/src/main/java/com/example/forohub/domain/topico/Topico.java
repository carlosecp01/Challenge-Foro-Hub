package com.example.forohub.domain.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;
    private String status;
    private String autor;
    private String curso;

    public Topico(DatosRegistroTopico datos) {
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.fechaCreacion = LocalDateTime.now();
        this.status = "ACTIVO";
        this.autor = datos.autor();
        this.curso = datos.curso();
    }

    public void actualizarDatos(DatosActualizarTopico datosActualizar) {
        if (datosActualizar.titulo() != null) {
            this.titulo = datosActualizar.titulo();
        }
        if (datosActualizar.mensaje() != null) {
            this.mensaje = datosActualizar.mensaje();
        }
    }
}