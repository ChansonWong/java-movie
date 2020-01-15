package com.superatom.javamovie.service.cinema;

import com.superatom.javamovie.model.RequestParam;
import com.superatom.javamovie.service.user.UserService;
import com.superatom.javamovie.utils.Md5Util;
import com.superatom.javamovie.utils.RestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class CinemaService {
    @Autowired
    UserService userService;
    /**
     * 查询电影院安排这场电影的时间表
     * @param cinemaid
     * @param movieid
     * @param hasday
     * @param day
     * @return
     */
    public String SelectCinemaMoviesTime(String cinemaid, String movieid, String hasday, String day, String uuid){
        String url = "https://webapi2.qingbh.com/manman/index.php/api/v2/movies/plays";

        List<RequestParam> paramList = new ArrayList<>();
        paramList.add(new RequestParam("cinemanid", cinemaid));
        if(!StringUtils.isEmpty(hasday)){
            paramList.add(new RequestParam("hasday", hasday));
        } else if (!StringUtils.isEmpty(day)){
            paramList.add(new RequestParam("day", day));
        }
        paramList.add(new RequestParam("movieid", movieid));
        paramList.add(new RequestParam("uid", uuid));
        String sign = Md5Util.getMd5(paramList);
        paramList.add(new RequestParam("sign", sign));

        return RestUtil.post(url, paramList);
    }

    /**
     * 查询电影院
     * @param cityid
     * @param movieid
     * @param order
     * @param pos
     * @param regionname
     * @param page
     * @param step
     * @return
     */
    public String selectCinemaList(String cityid, String movieid,
                                    String order, String pos, String regionname,
                                    String uid, String page, String step){
        String url = "https://webapi2.qingbh.com/manman/index.php/api/v2/recommend/cinemas";

        List<RequestParam> paramList = new ArrayList<>();
        paramList.add(new RequestParam("cityid", cityid));
        paramList.add(new RequestParam("movieid", movieid));
        paramList.add(new RequestParam("order", order));
        paramList.add(new RequestParam("page", page));
        paramList.add(new RequestParam("pos", pos));
        paramList.add(new RequestParam("regionname", regionname));
        paramList.add(new RequestParam("step", step));
        paramList.add(new RequestParam("uid", uid));
        String sign = Md5Util.getMd5(paramList);
        paramList.add(new RequestParam("sign", sign));
        return RestUtil.post(url, paramList);
    }

    public String getSeat(){
        String url = "https://webapi2.qingbh.com/manman/index.php/api/v2/seat/map";

        List<RequestParam> paramList = new ArrayList<>();
        paramList.add(new RequestParam("typeid", cityid));
        paramList.add(new RequestParam("typeseat", cityid));
        paramList.add(new RequestParam("cinemaid", cityid));
        paramList.add(new RequestParam("movieid", cityid));
        paramList.add(new RequestParam("playid", cityid));
        paramList.add(new RequestParam("type", cityid));
        paramList.add(new RequestParam("cityid", cityid));
        paramList.add(new RequestParam("uid", cityid));
        String sign = Md5Util.getMd5(paramList);
        paramList.add(new RequestParam("sign", sign));
        return RestUtil.post(url, paramList);
    }
}
