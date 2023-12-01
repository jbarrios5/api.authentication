package py.com.jmbr.api.auth.service;

import py.com.jmbr.java.commons.beans.mcs.auth.AuthPostReqData;
import py.com.jmbr.java.commons.beans.mcs.auth.AuthPostResData;

public interface AuthenticationService {
    AuthPostResData login( AuthPostReqData req);
}
