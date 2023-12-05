package py.com.jmbr.api.auth.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import py.com.jmbr.api.auth.constant.AuthenticationConstant;
import py.com.jmbr.api.auth.service.AuthenticationService;
import py.com.jmbr.java.commons.beans.mcs.auth.AuthPostReqData;
import py.com.jmbr.java.commons.beans.mcs.auth.AuthPostResData;
import py.com.jmbr.java.commons.beans.mcs.user.UserPostReqData;
import py.com.jmbr.java.commons.beans.mcs.user.UserPostResData;
import py.com.jmbr.java.commons.context.OperationAllow;
import py.com.jmbr.java.commons.context.SecurityAccess;
import py.com.jmbr.java.commons.exception.JMBRException;

import javax.validation.Valid;

@RestController
@RequestMapping("auth/${version}")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authService;
    @Value("${apiKey}")
    private String apiKey;
    @PostMapping("/login")
    @Operation(summary = "authenticate user",description = "Authenticate user by password and document")
    @SecurityAccess(operation = OperationAllow.POST_LOGIN)
    public AuthPostResData login(
            @RequestHeader(value = AuthenticationConstant.API_KEY) String apiKey,
            @RequestBody @Valid AuthPostReqData req) throws JMBRException {

        return authService.login(req);
    }

    @PostMapping("/user")
    @Operation(summary = "add user",description = "Add new user")
    @SecurityAccess(operation = OperationAllow.ADD_USER)
    public UserPostResData addUser(
            @RequestHeader(value = AuthenticationConstant.ACCESS_TOKEN) String accessToken,
            @RequestBody @Valid UserPostReqData req) throws JMBRException {

        return authService.addUser(req);
    }
}
