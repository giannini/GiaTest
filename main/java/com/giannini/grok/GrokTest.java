package com.giannini.grok;

import io.thekraken.grok.api.Grok;
import io.thekraken.grok.api.Match;
import io.thekraken.grok.api.exception.GrokException;

/**
 * Created by Fenglin on 2017/6/28.
 */
public class GrokTest {

    public static void main(String[] args) throws GrokException {
        /** Create a new grok instance */
        Grok grok = Grok.create("/Users/jiangningyu/IdeaProjects/GiaTest/main/resources/patterns");

        /** Grok pattern to compile, here httpd logs */
        grok.compile("%{COMBINEDAPACHELOG}");

        /** Line of log to match */
        String log =
                "112.169.19.192 - - [06/Mar/2013:01:36:30 +0900] \"GET / HTTP/1.1\" 200 44346 \"-\" \"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_2) AppleWebKit/537.22 (KHTML, like Gecko) Chrome/25.0.1364.152 Safari/537.22\"";

        Match gm = grok.match(log);
        gm.captures();

        /** Get the output */
        System.out.println(gm.toJson());
    }
}
