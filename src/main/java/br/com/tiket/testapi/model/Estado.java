package br.com.tiket.testapi.model;

import br.com.tiket.testapi.model.common.BaseModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "estado")
public class Estado extends BaseModel<Estado> {

    private static final long serialVersionUID = 7073760797475607236L;

    @Column
    public String nome;

}
