package com.kristian.gerenciamentosms.infrastructure.entity;

import com.kristian.gerenciamentosms.infrastructure.enums.StatusEnvioEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SmsMessage")
public class SmsMessage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "telefone",  nullable = false, length = 11)
    private String telefone;
    @Column(name = "statusEnvio",  nullable = false)
    private StatusEnvioEnum statusEnvio;
    @Column(name = "dataHoraEnvio", nullable = false)
    private LocalDateTime dataHoraEnvio;

}
