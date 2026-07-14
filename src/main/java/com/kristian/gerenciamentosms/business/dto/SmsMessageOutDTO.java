package com.kristian.gerenciamentosms.business.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kristian.gerenciamentosms.infrastructure.enums.StatusEnvioEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SmsMessageOutDTO {

    private Long id;
    private String telefone;
    private StatusEnvioEnum statusEnvio;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataHoraEnvio;
}
