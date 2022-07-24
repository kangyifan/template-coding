package com.evan.lang;

import com.evan.util.Timer;

/**
 * @version 1.0
 * @author: kang Yifan
 * @date 7/4/2022 10:09 AM
 */
public class StringTest {

    public static final String getHtml(){
        return """
                <html>
                    <body>
                        <p>hello, world!!!</p>
                    </body>
                </html>
                """;
    }



    public static void main(String[] args) {
        Timer.timing(StringTest::getHtml);
    }
}
