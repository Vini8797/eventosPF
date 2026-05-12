package br.insper.eventosPF.common;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalErrorHandling {

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDTO handleRuntime(RuntimeException ex, HttpServletRequest request) {
        ErrorDTO dto = new ErrorDTO();
        dto.setMensagem(ex.getMessage());
        dto.setCodigoHttp(HttpStatus.BAD_REQUEST.value());
        dto.setData(LocalDateTime.now());
        dto.setCodigoErro("ERROR");
        dto.setPath(request.getRequestURI());
        return dto;
    }
}
