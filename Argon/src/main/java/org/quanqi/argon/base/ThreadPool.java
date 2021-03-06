package org.quanqi.argon.base;

/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


        import android.os.Handler;

        import java.util.concurrent.LinkedBlockingQueue;
        import java.util.concurrent.ThreadPoolExecutor;
        import java.util.concurrent.TimeUnit;

/**
 * This class creates pools of background threads for downloading
 * Picasa images from the web, based on URLs retrieved from Picasa's featured images RSS feed.
 * The class is implemented as a singleton; the only way to get an PhotoManager instance is to
 * call {@link #getInstance}.
 * <p>
 * The class sets the pool size and cache size based on the particular operation it's performing.
 * The algorithm doesn't apply to all situations, so if you re-use the code to implement a pool
 * of threads for your own app, you will have to come up with your choices for pool size, cache
 * size, and so forth. In many cases, you'll have to set some numbers arbitrarily and then
 * measure the impact on performance.
 * <p>
 * This class actually uses two threadpools in order to limit the number of
 * simultaneous image decoding threads to the number of available processor
 * cores.
 * <p>
 * Finally, this class defines a handler that communicates back to the UI
 * thread to change the bitmap to reflect the state.
 */
@SuppressWarnings("unused")
public class ThreadPool {
    /*
     * Status indicators
     */
    static final int DOWNLOAD_FAILED = -1;
    static final int DOWNLOAD_STARTED = 1;
    static final int DOWNLOAD_COMPLETE = 2;
    static final int DECODE_STARTED = 3;
    static final int TASK_COMPLETE = 4;

    // Sets the size of the storage that's used to cache images
    private static final int IMAGE_CACHE_SIZE = 1024 * 1024 * 4;

    // Sets the amount of time an idle thread will wait for a task before terminating
    private static final int KEEP_ALIVE_TIME = 1;

    // Sets the Time Unit to seconds
    private static final TimeUnit KEEP_ALIVE_TIME_UNIT;

    // Sets the initial threadpool size to 8
    private static final int CORE_POOL_SIZE = 8;

    // Sets the maximum threadpool size to 8
    private static final int MAXIMUM_POOL_SIZE = 8;

    /**
     * NOTE: This is the number of total available cores. On current versions of
     * Android, with devices that use plug-and-play cores, this will return less
     * than the total number of cores. The total number of cores is not
     * available in current Android implementations.
     */
    private static int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();

    // A managed pool of background decoder threads
    private final ThreadPoolExecutor mThreadPool;
    private final LinkedBlockingQueue<Runnable> mWorkQueue;


    // An object that manages Messages in a Thread
    private Handler mHandler;

    // A single instance of PhotoManager, used to implement the singleton pattern
    private static ThreadPool sInstance = null;

    // A static block that sets class fields
    static {

        // The time unit for "keep alive" is in seconds
        KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS;

        // Creates a single static instance of PhotoManager
        sInstance = new ThreadPool();
    }
    /**
     * Constructs the work queues and thread pools used to download and decode images.
     */
    private ThreadPool() {

        /*
         * Creates a work queue for the pool of Thread objects used for downloading, using a linked
         * list queue that blocks when the queue is empty.
         */
        mWorkQueue = new LinkedBlockingQueue<Runnable>();

        mThreadPool = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE,
                KEEP_ALIVE_TIME, KEEP_ALIVE_TIME_UNIT, mWorkQueue);

    }

    /**
     * Returns the PhotoManager object
     * @return The global PhotoManager object
     */
    public static ThreadPool getInstance() {

        return sInstance;
    }

    public void execute(Runnable runnable) {
        mWorkQueue.add(runnable);
    }

}