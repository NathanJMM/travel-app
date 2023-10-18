package com.wgu.travelapp.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name="cart_item")
@Getter
@Setter
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_id")
    private Long id;

    //TODO check relationship
    @ManyToOne
    @JoinColumn(name ="vacation", nullable = false)
    private Vacation vacation;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "excursions")
    private Set<Excursion> excursions;

    //mapped by vacation(PK)
    @ManyToOne
    @JoinColumn(name ="cart", nullable = false)
    private Cart cart;
    @Column(name = "create_date")
    @CreationTimestamp
    private Date createDate;
    @Column(name = "last_update")
    @UpdateTimestamp
    private Date lastUpdate;

}
