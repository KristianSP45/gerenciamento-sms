package com.kristian.gerenciamentosms.infrastructure.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StatusEnvioEnum {
    ENVIADO, RECEBIDO, ERRO_ENVIO;
}
