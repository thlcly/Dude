package com.aaront.telegram.bot;

import com.aaront.telegram.bot.services.ExpressQueryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author tonyhui
 * @since 2017/8/11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DudeApplication.class)
@WebAppConfiguration
public class ExpressQueryServiceTest {

    @Autowired
    private ExpressQueryService expressQueryService;

    @Test
    public void testGetExpressTracks() {
        String expressTracks = expressQueryService.getExpressTracks("天天快递,667580487066");
        System.out.println(expressTracks);
    }
}
