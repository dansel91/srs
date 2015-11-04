package ch.bfh.srs.srv.entity;

import javax.persistence.*;
import java.util.List;

/**
 * @author zinggpa
 */
@Entity
public class Organisation {

    @Id
    @Column(name = "id_organisation")
    private Integer idOrganisation;

    @Basic
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "organisation", targetEntity = Resource.class,
            fetch = FetchType.EAGER)
    private List<Resource> resources;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }
}
