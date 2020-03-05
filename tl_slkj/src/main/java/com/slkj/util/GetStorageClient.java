package com.slkj.util;

import org.csource.common.MyException;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author liman
 * @version 1.0.0
 * @ClassName GetStorageClient
 * @Description TODO
 * @createTime 2020年02月12日 16:48:00
 */
@Component
public class GetStorageClient {
    public static ThreadLocal<StorageClient> storageClientThreadLocal = new ThreadLocal<>();


    private static TrackerServer trackerServer;

    public TrackerServer getTrackerServer() {
        return trackerServer;
    }

    @Autowired
    @Qualifier("trackerServer")
    public void setTrackerServer(TrackerServer trackerServer) {
        GetStorageClient.trackerServer = trackerServer;
    }

    public static StorageClient getStorageClient() throws IOException, MyException {
        StorageClient storageClient = storageClientThreadLocal.get();
        if (storageClient == null) {
            storageClient = new StorageClient(trackerServer, null);
            storageClientThreadLocal.set(storageClient);
        }
        return storageClient;
    }

}
