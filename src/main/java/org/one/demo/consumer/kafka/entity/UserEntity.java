package org.one.demo.consumer.kafka.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZonedDateTime;

@Getter
@Setter
@Entity
@ToString
@Table(name = "user")
@SequenceGenerator(name = "sequence", sequenceName = "user_id_seq", allocationSize = 1)
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private BigDecimal balance;

    @Column(nullable = false)
    private LocalDate birthday;

    @Column(nullable = false)
    private ZonedDateTime createAt;

}