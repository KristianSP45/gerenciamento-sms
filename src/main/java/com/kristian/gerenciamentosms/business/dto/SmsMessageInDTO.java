package com.kristian.gerenciamentosms.business.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kristian.gerenciamentosms.infrastructure.enums.StatusEnvioEnum;
import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SmsMessageInDTO {

    private String telefone;
    /*private StatusEnvioEnum statusEnvio;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataHoraEnvio;*/
}
