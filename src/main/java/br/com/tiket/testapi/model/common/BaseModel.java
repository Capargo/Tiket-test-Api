package br.com.tiket.testapi.model.common;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public class BaseModel<T extends BaseModel<T>> implements Serializable {

    private static final long serialVersionUID = 1731217984940504996L;

    public static final String ID = "id";

    @Id
    @GeneratedValue
    private Long id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
