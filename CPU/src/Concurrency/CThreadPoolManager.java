/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Bryden
 */
public class CThreadPoolManager {

    private static final ExecutorService objES = Executors.newCachedThreadPool();

    private CThreadPoolManager() {
    }

    public static void runTask(Runnable pObjRunnable) {
        objES.execute(pObjRunnable);
    }

    public static void shutdown() {
        objES.shutdown();
    }

}
