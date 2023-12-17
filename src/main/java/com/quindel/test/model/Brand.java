package com.quindel.test.model;


import jakarta.persistence.*;
import lombok.*;

/**
 * Entity class for mapping the STORE_GROUP table.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "BRAND")
public class Brand {

    /**
     * Attribute for mapping to colum ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    /**
     * Attribute for mapping to colum STORE.
     */
    @Column(name = "STORE")
    private String store;
}