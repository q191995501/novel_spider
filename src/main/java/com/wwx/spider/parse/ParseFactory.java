package com.wwx.spider.parse;

import com.wwx.spider.parse.biquge.Biquge5200Parse;

/**
 * @Author: Wyndem
 * @Description: 解析工厂类
 * @Date: Created in  2018-08-12 17:02
 * @Modified By:
 */
public class ParseFactory {

    public static AbstractBookParse getParse(BookParse styleParse){

        switch (styleParse){
            case BIQUGE:
                return new Biquge5200Parse();
       }

       throw new RuntimeException("暂时不支持解析该站点");
    }
}
