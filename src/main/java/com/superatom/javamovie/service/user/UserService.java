package com.superatom.javamovie.service.user;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public String getUuid(){
        /*String url = "https://webapi2.qingbh.com/manman/index.php/api/v1/user/user_temp_login";
        List<RequestParam> paramList = new ArrayList<>();
        String sign = Md5Util.getMd5(paramList);
        paramList.add(new RequestParam("sign", sign));
        return RestUtil.post(url, paramList);*/

        return "16486373";
    }
}
