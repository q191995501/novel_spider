package com.wwx.tool;

import com.wwx.spider.tool.UA;
import org.junit.Test;

public class UATest {

    @Test
    public void getUa(){
        for (int i=0;i<1000;i++){
            String computerUA = UA.getComputerUA();
            String phoneUA = UA.getPhoneUA();
            System.out.println(computerUA);
            System.out.println(phoneUA);
        }
    }
}
