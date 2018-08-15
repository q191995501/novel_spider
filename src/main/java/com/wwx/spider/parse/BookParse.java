package com.wwx.spider.parse;

/**
 * 如果已经支持该站点，请在这里添加枚举，然后在 ParseFactory 工厂类中，添加你的解析类哦。
 */
public enum BookParse {

    BIQUGE5200("biquge5200"),

    //以下枚举并不支持，只是用来测试

    SILUKE("siluke"),
    X23SU("x23su"),
    BIQUGE("biquge"),
    BOOKTEXT("booktxt"),
    QU("qu.la"),
    QB5200("qb5200"),
    ZXZW("zxzw"),
    Xs33("33xs"),
    DULDU("du1du"),
    ZW("8jzw");


    private String url;
    BookParse(String url) {
        this.url=url;
    }


    public static BookParse getEnum(String url){

        for (BookParse e : BookParse.values()) {
            if(url.indexOf(e.url)!=-1){
                return e;
            }
        }

        throw  new RuntimeException(url+"暂时还不支持哦");
    }
}
