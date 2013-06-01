package com.sky.dis.control;

import java.util.concurrent.ArrayBlockingQueue;

@SuppressWarnings("serial")
class DisPduEventQueue extends ArrayBlockingQueue<DisPduEvent> {

    private static int DEFAULT_MAX_QUEUE_SIZE = 6000;

    DisPduEventQueue() {
        super(DEFAULT_MAX_QUEUE_SIZE);
    }

}
