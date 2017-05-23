package com.example.tzj.copy_baisibudejie.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by psj on 2017/5/22.
 */

public class Bean1 {

    /**
     * info : {"count":1,"when":"2017-05-22 16:02:19","host":"db2","pid":170178}
     * result : {"zuixin":{},"jingxuan":{"1":[{"osrule":{"ipad":["0","1"],"android":["6.5.4","6.7,9"],"iphone":["0","1"]},"weight":15,"title":null,"url":"mod://BDJ_Pop_Note@id=23132934","image":"http://wimg.spriteapp.cn//ugc/2017/05/21/20170521171642613988.jpg","appname":"baisibudejie,budejie","number":1,"visible":1,"green":1,"mtime":"2017-04-28 11:45:48","type":1,"id":13}]}}
     */

    private InfoBean info;
    private ResultBean result;

    public InfoBean getInfo() {
        return info;
    }

    public void setInfo(InfoBean info) {
        this.info = info;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class InfoBean {
        /**
         * count : 1
         * when : 2017-05-22 16:02:19
         * host : db2
         * pid : 170178
         */

        private int count;
        private String when;
        private String host;
        private int pid;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getWhen() {
            return when;
        }

        public void setWhen(String when) {
            this.when = when;
        }

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public int getPid() {
            return pid;
        }

        public void setPid(int pid) {
            this.pid = pid;
        }
    }

    public static class ResultBean {
        /**
         * zuixin : {}
         * jingxuan : {"1":[{"osrule":{"ipad":["0","1"],"android":["6.5.4","6.7,9"],"iphone":["0","1"]},"weight":15,"title":null,"url":"mod://BDJ_Pop_Note@id=23132934","image":"http://wimg.spriteapp.cn//ugc/2017/05/21/20170521171642613988.jpg","appname":"baisibudejie,budejie","number":1,"visible":1,"green":1,"mtime":"2017-04-28 11:45:48","type":1,"id":13}]}
         */

        private ZuixinBean zuixin;
        private JingxuanBean jingxuan;

        public ZuixinBean getZuixin() {
            return zuixin;
        }

        public void setZuixin(ZuixinBean zuixin) {
            this.zuixin = zuixin;
        }

        public JingxuanBean getJingxuan() {
            return jingxuan;
        }

        public void setJingxuan(JingxuanBean jingxuan) {
            this.jingxuan = jingxuan;
        }

        public static class ZuixinBean {
        }

        public static class JingxuanBean {
            @SerializedName("1")
            private List<_$1Bean> _$1;

            public List<_$1Bean> get_$1() {
                return _$1;
            }

            public void set_$1(List<_$1Bean> _$1) {
                this._$1 = _$1;
            }

            public static class _$1Bean {
                /**
                 * osrule : {"ipad":["0","1"],"android":["6.5.4","6.7,9"],"iphone":["0","1"]}
                 * weight : 15
                 * title : null
                 * url : mod://BDJ_Pop_Note@id=23132934
                 * image : http://wimg.spriteapp.cn//ugc/2017/05/21/20170521171642613988.jpg
                 * appname : baisibudejie,budejie
                 * number : 1
                 * visible : 1
                 * green : 1
                 * mtime : 2017-04-28 11:45:48
                 * type : 1
                 * id : 13
                 */

                private OsruleBean osrule;
                private int weight;
                private Object title;
                private String url;
                private String image;
                private String appname;
                private int number;
                private int visible;
                private int green;
                private String mtime;
                private int type;
                private int id;

                public OsruleBean getOsrule() {
                    return osrule;
                }

                public void setOsrule(OsruleBean osrule) {
                    this.osrule = osrule;
                }

                public int getWeight() {
                    return weight;
                }

                public void setWeight(int weight) {
                    this.weight = weight;
                }

                public Object getTitle() {
                    return title;
                }

                public void setTitle(Object title) {
                    this.title = title;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getImage() {
                    return image;
                }

                public void setImage(String image) {
                    this.image = image;
                }

                public String getAppname() {
                    return appname;
                }

                public void setAppname(String appname) {
                    this.appname = appname;
                }

                public int getNumber() {
                    return number;
                }

                public void setNumber(int number) {
                    this.number = number;
                }

                public int getVisible() {
                    return visible;
                }

                public void setVisible(int visible) {
                    this.visible = visible;
                }

                public int getGreen() {
                    return green;
                }

                public void setGreen(int green) {
                    this.green = green;
                }

                public String getMtime() {
                    return mtime;
                }

                public void setMtime(String mtime) {
                    this.mtime = mtime;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public static class OsruleBean {
                    private List<String> ipad;
                    private List<String> android;
                    private List<String> iphone;

                    public List<String> getIpad() {
                        return ipad;
                    }

                    public void setIpad(List<String> ipad) {
                        this.ipad = ipad;
                    }

                    public List<String> getAndroid() {
                        return android;
                    }

                    public void setAndroid(List<String> android) {
                        this.android = android;
                    }

                    public List<String> getIphone() {
                        return iphone;
                    }

                    public void setIphone(List<String> iphone) {
                        this.iphone = iphone;
                    }
                }
            }
        }
    }
}