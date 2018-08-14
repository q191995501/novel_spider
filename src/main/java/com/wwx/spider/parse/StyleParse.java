package com.wwx.spider.parse;

/**
 * 如果已经支持该站点，请在这里添加枚举，然后在 ParseFactory 工厂类中，添加你的解析类哦。
 */
public enum StyleParse {

    SILUKE("siluke"),

    X23SU("x23su"),

    BIQUGE("biquge"),

    //以下枚举并不支持，只是用来测试
    QU("qu.la"),
    QB5200("qb5200"),
    ZXZW("zxzw"),
    Xs33("33xs"),
    DULDU("du1du"),
    ZW("8jzw");


    private String url;
    StyleParse(String url) {
        this.url=url;
    }


    public static StyleParse getEnum(String url){

        for (StyleParse e : StyleParse.values()) {
            if(url.indexOf(e.url)!=-1){
                return e;
            }
        }

        throw  new RuntimeException(url+"暂时还不支持哦");
    }
}
