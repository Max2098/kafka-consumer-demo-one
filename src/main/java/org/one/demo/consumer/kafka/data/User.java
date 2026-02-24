package org.demo.producer.kafka.data;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZonedDateTime;

@Data
public class User {
    private String name;
    private String phone;
    private BigDecimal balance;
    private LocalDate birthday;
    private ZonedDateTime created;
}