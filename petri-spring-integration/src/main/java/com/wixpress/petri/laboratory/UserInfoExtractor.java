package com.wixpress.petri.laboratory;

import com.wixpress.petri.experiments.domain.HostResolver;
import org.joda.time.DateTime;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * User: Dalias
 * Date: 8/14/14
 * Time: 3:44 PM
 */
public class UserInfoExtractor {

    private final HttpServletRequest request;
    private final HostResolver hostResolver;

    public UserInfoExtractor(HttpServletRequest request, HostResolver hostResolver) {
        this.request = request;

        this.hostResolver = hostResolver;
    }

    public UserInfo extract() {

        String host = hostResolver.resolve();
        if (request == null) {
            return UserInfo.userInfoFromNullRequest(host);
        }

        String experimentsLog = null; //todo
        UUID userId = null; //todo
        UUID clientId = null; //todo
        String ip = null;   //todo
        String url = null;   //todo
        String userAgent = null; //todo
        UserInfoType userInfoType = null; //todo
        String language = null;  //todo
        String country = null; //todo
        DateTime userCreationDate = null; //todo
        String email = null; //todo
        String anonymousExperimentsLog = null; //todo
        boolean isRecurring = false;  //todo
        Map<String, String> experimentOverrides = null; //todo
        boolean isRobot = false; //todo
        return new UserInfo(experimentsLog, userId, clientId, ip, url, userAgent, userInfoType, language, country,
                userCreationDate, email, anonymousExperimentsLog, isRecurring, experimentOverrides, isRobot, host);

}
}
