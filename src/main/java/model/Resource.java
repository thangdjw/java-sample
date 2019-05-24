package model;

import user.model.UserEntity;

import javax.persistence.*;


@Entity
@Table(name = "resource")
public class Resource {
    @Id
    private String id;

    @ManyToOne(targetEntity = UserEntity.class)
    @JoinColumn(name = "owner", referencedColumnName = "id")
    private String owner;

    @Column(name = "name")
    private String name;

    @Column(name = "size")
    private int size;

    @Column(name = "mime_type")
    private String mimeType;
}
