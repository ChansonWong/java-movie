package com.superatom.javamovie.controller;

import com.google.gson.Gson;
import com.superatom.javamovie.model.vo.CinemaInfo;
import com.superatom.javamovie.model.vo.MovieDetail;
import com.superatom.javamovie.model.vo.MovieInfo;
import com.superatom.javamovie.model.vo.SearchResult;
import com.superatom.javamovie.service.cinema.CinemaService;
import com.superatom.javamovie.service.search.SearchService;
import com.superatom.javamovie.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;

@RestController
public class MovieController {
    @Autowired
    CinemaService cinemaService;
    @Autowired
    SearchService searchService;
    @Autowired
    UserService userService;

    @RequestMapping("/api/getUuid")
    public String getUuid(){
        return userService.getUuid();
    }

    @RequestMapping("/api/selectCinemaMoviesTime")
    public MovieInfo selectCinemaMoviesTime(@RequestParam("cinemaid") String cinemaid,
                                           @RequestParam("movieid") String movieid,
                                           @RequestParam(value = "hasday",required = false) String hasday,
                                           @RequestParam(value = "day", required = false) String day) {
        String scheduleResultJson = cinemaService.SelectCinemaMoviesTime(cinemaid, movieid, hasday, day);
        Gson gson = new Gson();
        MovieInfo movieInfo = gson.fromJson(scheduleResultJson, MovieInfo.class);
        priceFilter(movieInfo);

        return movieInfo;
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
    @RequestMapping("/api/selectCinemaList")
    public MovieDetail selectCinemaList(@RequestParam("cityid") String cityid, @RequestParam("movieid") String movieid,
                                        @RequestParam("order") String order, @RequestParam("pos") String pos,
                                        @RequestParam("regionname") String regionname, @RequestParam("page") String page,
                                        @RequestParam("step") String step){
        String cinameResultJson = cinemaService.selectCinemaList(cityid, movieid, order, pos, regionname, page, step);
        Gson gson = new Gson();
        MovieDetail movieDetail = gson.fromJson(cinameResultJson, MovieDetail.class);
        movieDetailFilter(movieDetail.getCinemas());
        return movieDetail;
    }

    /**
     * 查询功能
     * @param cityid
     * @param page
     * @param pos
     * @param scene
     * @param search
     * @return
     */
    @RequestMapping("/api/search")
    public SearchResult search(@RequestParam(value = "cityid", required = false) String cityid,
                               @RequestParam(value = "page", required = false) String page,
                               @RequestParam(value = "pos", required = false) String pos,
                               @RequestParam(value = "scene", required = false) String scene,
                               @RequestParam(value = "search", required = false) String search) {
        String searchJson = searchService.search(cityid, page, pos, scene, search);
        Gson gson = new Gson();
        SearchResult searchResult = gson.fromJson(searchJson, SearchResult.class);
        if (searchResult.getCinemas().size() > 0){
            movieDetailFilter(searchResult.getCinemas());
        }

        return searchResult;
    }

    private void movieDetailFilter(List<CinemaInfo> cinemas) {
        for (CinemaInfo cinemaInfo : cinemas) {
            List<String> iconList = cinemaInfo.getChannelicon();
            Iterator<String> iconIterator = iconList.iterator();
            while (iconIterator.hasNext()){
                String icon = iconIterator.next();
                if (icon.equals("https://p1.qingbh.com/image/app/movies/type_14_3330000.png?10001")){
                    iconIterator.remove();
                }
            }
        }
    }

    private void priceFilter(MovieInfo movieInfo) {
        if (movieInfo == null) {
            return;
        }

        Iterator<MovieInfo.Play> playIterator = movieInfo.getPlays().iterator();
        while (playIterator.hasNext()) {
            MovieInfo.Play play = playIterator.next();

            String miniPrice = "-1";
            Iterator<MovieInfo.Channel> channelIterator = play.getDiffchannels().iterator();
            while (channelIterator.hasNext()){
                MovieInfo.Channel channel = channelIterator.next();
                String name = channel.getTypename();
                if (name.contains("趣满满")) {
                    channelIterator.remove();
                }else{
                    miniPrice = getMinPrice(miniPrice, channel.getPrice());
                }
            }

            if (play.getDiffchannels() == null || play.getDiffchannels().size() == 0) {
                playIterator.remove();
            }
            play.setPrice(miniPrice);
        }

    }

    private String getMinPrice(String miniPriceStr, String priceStr) {
        if ("-1".equals(miniPriceStr)){
            return priceStr;
        }

        Double miniPrice = Double.valueOf(miniPriceStr);
        Double price = Double.valueOf(priceStr);

        if (price < miniPrice){
            return priceStr;
        }

        return miniPriceStr;
    }

}
