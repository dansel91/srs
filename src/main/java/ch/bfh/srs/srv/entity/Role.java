package ch.bfh.srs.srv.entity;

import javax.persistence.*;
import java.util.List;

/**
 * @author zinggpa
 */
@Entity
public class Role {
    @Id
    @Column(name = "id_role")
    private Integer idRole;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "role", targetEntity = User.class,
            fetch = FetchType.EAGER)
    private List<User> users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
