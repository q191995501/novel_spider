package com.wwx.spider.parse;

/**
 * @Author: Wyndem
 * @Description: 解析工厂类
 * @Date: Created in  2018-08-12 17:02
 * @Modified By:
 */
public class ParseFactory {

    public static NovelParse getParse(StyleParse styleParse){

        switch (styleParse){
            case SILUKE:
            case X23SU:
                return new BiqugeStyleParse();
       }

       throw new RuntimeException("暂时不支持解析该站点");
    }
}
