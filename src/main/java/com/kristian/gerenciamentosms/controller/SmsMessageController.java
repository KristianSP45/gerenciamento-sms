package com.kristian.gerenciamentosms.controller;

import com.kristian.gerenciamentosms.business.SmsMessageService;
import com.kristian.gerenciamentosms.business.dto.SmsMessageInDTO;
import com.kristian.gerenciamentosms.business.dto.SmsMessageOutDTO;
import com.kristian.gerenciamentosms.infrastructure.enums.StatusEnvioEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sms")
public class SmsMessageController {

    private final SmsMessageService service;

    @PostMapping()
    public ResponseEntity<SmsMessageOutDTO> smsCadastrada(@RequestBody SmsMessageInDTO dto) {
        return ResponseEntity.ok(service.smsCadastrada(dto));
    }

    @GetMapping()
    public ResponseEntity<List<SmsMessageOutDTO>> buscarSmsPorStatus(@RequestParam StatusEnvioEnum status, LocalDateTime dataHora) {
        return ResponseEntity.ok(service.buscarSmsPorStatus(status,  dataHora));
    }

    @PatchMapping()
    public ResponseEntity<SmsMessageOutDTO> alterarStatusMessage(@RequestParam("id") Long id,StatusEnvioEnum status) {
        return ResponseEntity.ok(service.alterarStatusMessage(id, status));
    }

}
