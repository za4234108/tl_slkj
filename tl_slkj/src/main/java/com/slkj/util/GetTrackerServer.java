package com.slkj.util;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * @author liman
 * @version 1.0.0
 * @ClassName GetTrackerServer
 * @Description TODO
 * @createTime 2020年02月12日 18:01:00
 */
@Configuration
public class GetTrackerServer {

    @Bean(name = "trackerServer")
    public TrackerServer getTrackerServer() throws IOException, MyException {
        //tracker.conf
        ClientGlobal.init("tracker.conf");
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getTrackerServer();
        return trackerServer;
    }
}
