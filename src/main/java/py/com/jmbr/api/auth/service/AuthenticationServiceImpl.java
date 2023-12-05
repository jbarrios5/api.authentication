package py.com.jmbr.api.auth.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import py.com.jmbr.java.commons.beans.mcs.auth.AuthPostReqData;
import py.com.jmbr.java.commons.beans.mcs.auth.AuthPostResData;
import py.com.jmbr.java.commons.beans.mcs.user.UserGetResData;
import py.com.jmbr.java.commons.beans.mcs.user.UserPostReqData;
import py.com.jmbr.java.commons.beans.mcs.user.UserPostResData;
import py.com.jmbr.java.commons.exception.JMBRException;
import py.com.jmbr.java.commons.exception.JMBRExceptionType;
import py.com.jmbr.java.commons.logger.RequestUtil;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationServiceImpl.class);
    @Value("${uri.auth}")
    private  String AUTH_URI  ;
    @Value("${uri.user}")
    private  String USER_URI ;
    @Autowired
    private RestTemplate apiRestTemplate;
    @Override
    public AuthPostResData login(AuthPostReqData req) {
        String logId = RequestUtil.getLogId();
        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<AuthPostResData> response = null;
        HttpEntity<AuthPostReqData> entity = new HttpEntity<>(req,headers);
        String uri = UriComponentsBuilder.fromUriString(AUTH_URI.concat("/login")).toUriString();

        try {
            logger.info(RequestUtil.LOG_FORMATT,logId,"login:request",entity);
            response = apiRestTemplate.exchange(uri, HttpMethod.POST,entity,AuthPostResData.class);
            logger.info(RequestUtil.LOG_FORMATT,logId,"login:response",response.getBody());
            if(response.getBody() != null)
                return response.getBody();
            else
                return null;
        }catch (JMBRException e){
            logger.warn(RequestUtil.LOG_FORMATT,logId,"login:Unexpected error getting user",e.getMessage());
            throw new JMBRException("Ocurrio un error al intentar loguearse", JMBRExceptionType.WARNING, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public UserPostResData addUser(UserPostReqData req) {
        String logId = RequestUtil.getLogId();
        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<UserPostResData> response = null;
        HttpEntity<UserPostReqData> entity = new HttpEntity<>(req,headers);
        String uri = UriComponentsBuilder.fromUriString(AUTH_URI.concat("/login")).toUriString();

        try {
            logger.info(RequestUtil.LOG_FORMATT,logId,"addUser:request",entity);
            response = apiRestTemplate.exchange(uri, HttpMethod.POST,entity,UserPostResData.class);
            logger.info(RequestUtil.LOG_FORMATT,logId,"addUser:response",response.getBody());
            if(response.getBody() != null)
                return response.getBody();
            else
                return null;
        }catch (JMBRException e){
            logger.warn(RequestUtil.LOG_FORMATT,logId,"addUser:Unexpected error adding user",e.getMessage());
            throw new JMBRException("Ocurrio un error al agregar el usuario", JMBRExceptionType.WARNING, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
