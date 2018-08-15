package com.wwx.spider.parse;

import com.wwx.spider.parse.biquge.BiqugeStyleParse;

/**
 * @Author: Wyndem
 * @Description: 解析工厂类
 * @Date: Created in  2018-08-12 17:02
 * @Modified By:
 */
public class ParseFactory {

    public static NovelParse getParse(BookParse styleParse){

        switch (styleParse){
            case SILUKE:
            case X23SU:
            case BIQUGE:
            case BOOKTEXT:
                return new BiqugeStyleParse();
       }

       throw new RuntimeException("暂时不支持解析该站点");
    }
}
