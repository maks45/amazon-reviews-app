package com.maks.durov.amazonreviewapp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity(name = "reviews")
public class Review {
    @Id
    private Long id;
    private String summary;
    @Column(length = 100000)
    private String text;
    private LocalDateTime reviewTime;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Product product;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private ReviewUser reviewUser;
}
