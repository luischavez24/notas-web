package org.guis.notas.web.services;

import org.guis.notas.web.models.UserInfo;

public interface UserInfoService {

    UserInfo findUserInfoByUsername(String username);

}
