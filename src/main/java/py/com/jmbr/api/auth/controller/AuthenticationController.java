package py.com.jmbr.api.auth.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import py.com.jmbr.api.auth.constant.AuthenticationConstant;
import py.com.jmbr.java.commons.beans.mcs.auth.AuthPostReqData;
import py.com.jmbr.java.commons.beans.mcs.auth.AuthPostResData;
import py.com.jmbr.java.commons.context.OperationAllow;
import py.com.jmbr.java.commons.context.SecurityAccess;
import py.com.jmbr.java.commons.exception.JMBRException;

import javax.validation.Valid;

@RestController
@RequestMapping("auth/${version}")
public class AuthenticationController {

    @PostMapping("/login")
    @Operation(summary = "authenticate user",description = "Authenticate user by password and document")
    @SecurityAccess(operation = OperationAllow.POST_LOGIN,apiKey = "${apiKey}")
    public AuthPostResData login(
            @RequestHeader(value = AuthenticationConstant.API_KEY) String apiKey,
            @RequestBody @Valid AuthPostReqData req) throws JMBRException {
        System.out.printf("COntinuando");
        System.out.printf("Prueababasfasfasdf");
        return null;

    }
}
