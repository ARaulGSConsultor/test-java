package com.quindel.test.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "PRICES")
public class Price {

    /**
     * Attribute for mapping to colum ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    /**
     * Attribute for mapping to colum START_DATE.
     */
    @Column(name = "START_DATE")
    private LocalDateTime startDate;

    /**
     * Attribute for mapping to colum END_DATE.
     */
    @Column(name = "END_DATE")
    private LocalDateTime endDate;

    /**
     * Attribute for mapping to colum PRICE_LIST.
     */
    @Column(name = "PRICE_LIST")
    private int priceList;

    /**
     * Attribute for mapping to colum PRODUCT_ID.
     */
    @Column(name = "PRODUCT_ID")
    private int productId;

    /**
     * Attribute for mapping to colum PRIORITY.
     */
    @Column(name = "PRIORITY")
    private int priority;

    /**
     * Attribute for mapping to colum PRICE.
     */
    @Column(name = "PRICE")
    private Double price;

    /**
     * Attribute for mapping to colum CURR.
     */
    @Column(name = "CURR")
    private String curr;

    /**
     * Attribute for mapping to colum BRAND_ID that contain foreign key.
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "BRAND_ID", nullable = false)
    private Brand brand;
}