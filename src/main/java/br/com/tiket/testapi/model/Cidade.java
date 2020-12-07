package br.com.tiket.testapi.model;

import br.com.tiket.testapi.model.common.BaseModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "cidade")
public class Cidade extends BaseModel<Cidade> {

    private static final long serialVersionUID = 431614204301136038L;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "estado_id", referencedColumnName = "id")
    public Estado estado;

    @Column(nullable = false)
    public String nome;

    @Column(nullable = false)
    public Integer populacao;
}
