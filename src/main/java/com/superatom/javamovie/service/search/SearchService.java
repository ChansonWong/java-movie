package com.superatom.javamovie.service.search;

import com.superatom.javamovie.model.RequestParam;
import com.superatom.javamovie.service.user.UserService;
import com.superatom.javamovie.utils.Md5Util;
import com.superatom.javamovie.utils.RestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {
    @Autowired
    UserService userService;

    public String search(String cityid, String page, String pos, String scene, String search){
        String url = "https://webapi2.qingbh.com/manman/index.php/api/v2/search/index";

        List<RequestParam> paramList = new ArrayList<>();
        paramList.add(new RequestParam("cityid", cityid));
        paramList.add(new RequestParam("page", page));
        paramList.add(new RequestParam("pos", pos));
        paramList.add(new RequestParam("scene", scene));
        paramList.add(new RequestParam("search", search));
        paramList.add(new RequestParam("uid", userService.getUuid()));
        String sign = Md5Util.getMd5(paramList);
        paramList.add(new RequestParam("sign", sign));
        return RestUtil.post(url, paramList);
    }
}
