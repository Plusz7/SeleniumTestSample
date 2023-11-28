package com.gitlab.rmarzec.task;

import com.gitlab.rmarzec.framework.utils.selenium.ApiRunner;
import org.testng.annotations.Test;


public class Task1Test extends ApiRunner {

    private static final String ONET_URL = "https://www.onet.pl/";

    //The solution for this task was installing Firefox on the PC so WebDriverManager can solve the missing driver issue.
    @Test
    public void Task1Test(){
        start(ONET_URL);
    }
}
