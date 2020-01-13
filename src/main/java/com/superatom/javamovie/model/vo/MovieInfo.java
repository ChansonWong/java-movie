package com.superatom.javamovie.model.vo;

import java.util.List;

public class MovieInfo {
    private String cinemaddress;
    private String commentcount;
    private List<List<Object>> days;
    private String grade;
    private String lowest_minprice;
    private String maoyanusergrade;
    private String movieinfo;
    private String moviename;
    private String movietype;
    private String movietype2;
    private String msg;
    private String mtime;
    private String pic;
    private String sign;
    private String starring;
    private List<Play> plays;

    public class Play {
        private String cinemanid;
        private String cityid;
        private String datetime;
        private String dayindex;
        private List<Channel> diffchannels;
        private String endtime;
        private String hallname;
        private String halltype;
        private String hourindex;
        private String maxprice;
        private String movieid;
        private String moviename;
        private String mtime;
        private String playtime;
        private String price;
        private String weekindex;

        public String getCinemanid() {
            return cinemanid;
        }

        public void setCinemanid(String cinemanid) {
            this.cinemanid = cinemanid;
        }

        public String getCityid() {
            return cityid;
        }

        public void setCityid(String cityid) {
            this.cityid = cityid;
        }

        public String getDatetime() {
            return datetime;
        }

        public void setDatetime(String datetime) {
            this.datetime = datetime;
        }

        public String getDayindex() {
            return dayindex;
        }

        public void setDayindex(String dayindex) {
            this.dayindex = dayindex;
        }

        public List<Channel> getDiffchannels() {
            return diffchannels;
        }

        public void setDiffchannels(List<Channel> diffchannels) {
            this.diffchannels = diffchannels;
        }

        public String getEndtime() {
            return endtime;
        }

        public void setEndtime(String endtime) {
            this.endtime = endtime;
        }

        public String getHallname() {
            return hallname;
        }

        public void setHallname(String hallname) {
            this.hallname = hallname;
        }

        public String getHalltype() {
            return halltype;
        }

        public void setHalltype(String halltype) {
            this.halltype = halltype;
        }

        public String getHourindex() {
            return hourindex;
        }

        public void setHourindex(String hourindex) {
            this.hourindex = hourindex;
        }

        public String getMaxprice() {
            return maxprice;
        }

        public void setMaxprice(String maxprice) {
            this.maxprice = maxprice;
        }

        public String getMovieid() {
            return movieid;
        }

        public void setMovieid(String movieid) {
            this.movieid = movieid;
        }

        public String getMoviename() {
            return moviename;
        }

        public void setMoviename(String moviename) {
            this.moviename = moviename;
        }

        public String getMtime() {
            return mtime;
        }

        public void setMtime(String mtime) {
            this.mtime = mtime;
        }

        public String getPlaytime() {
            return playtime;
        }

        public void setPlaytime(String playtime) {
            this.playtime = playtime;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getWeekindex() {
            return weekindex;
        }

        public void setWeekindex(String weekindex) {
            this.weekindex = weekindex;
        }
    }

    public class Channel{
        private String extid;
        private String icon;
        private String maxprice;
        private String price;
        private String typename;

        public String getExtid() {
            return extid;
        }

        public void setExtid(String extid) {
            this.extid = extid;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getMaxprice() {
            return maxprice;
        }

        public void setMaxprice(String maxprice) {
            this.maxprice = maxprice;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getTypename() {
            return typename;
        }

        public void setTypename(String typename) {
            this.typename = typename;
        }
    }

    public String getCinemaddress() {
        return cinemaddress;
    }

    public void setCinemaddress(String cinemaddress) {
        this.cinemaddress = cinemaddress;
    }

    public String getCommentcount() {
        return commentcount;
    }

    public void setCommentcount(String commentcount) {
        this.commentcount = commentcount;
    }

    public List<List<Object>> getDays() {
        return days;
    }

    public void setDays(List<List<Object>> days) {
        this.days = days;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getLowest_minprice() {
        return lowest_minprice;
    }

    public void setLowest_minprice(String lowest_minprice) {
        this.lowest_minprice = lowest_minprice;
    }

    public String getMaoyanusergrade() {
        return maoyanusergrade;
    }

    public void setMaoyanusergrade(String maoyanusergrade) {
        this.maoyanusergrade = maoyanusergrade;
    }

    public String getMovieinfo() {
        return movieinfo;
    }

    public void setMovieinfo(String movieinfo) {
        this.movieinfo = movieinfo;
    }

    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }

    public String getMovietype() {
        return movietype;
    }

    public void setMovietype(String movietype) {
        this.movietype = movietype;
    }

    public String getMovietype2() {
        return movietype2;
    }

    public void setMovietype2(String movietype2) {
        this.movietype2 = movietype2;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMtime() {
        return mtime;
    }

    public void setMtime(String mtime) {
        this.mtime = mtime;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getStarring() {
        return starring;
    }

    public void setStarring(String starring) {
        this.starring = starring;
    }

    public List<Play> getPlays() {
        return plays;
    }

    public void setPlays(List<Play> plays) {
        this.plays = plays;
    }
}
