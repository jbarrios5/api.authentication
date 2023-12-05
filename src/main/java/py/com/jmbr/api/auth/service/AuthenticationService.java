package py.com.jmbr.api.auth.service;

import py.com.jmbr.java.commons.beans.mcs.auth.AuthPostReqData;
import py.com.jmbr.java.commons.beans.mcs.auth.AuthPostResData;
import py.com.jmbr.java.commons.beans.mcs.user.UserPostReqData;
import py.com.jmbr.java.commons.beans.mcs.user.UserPostResData;

public interface AuthenticationService {
    AuthPostResData login( AuthPostReqData req);

    UserPostResData addUser(UserPostReqData data);
}
