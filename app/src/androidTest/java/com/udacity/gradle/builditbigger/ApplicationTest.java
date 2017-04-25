package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.support.test.runner.AndroidJUnit4;
import android.test.ApplicationTestCase;
import android.text.TextUtils;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;

/**
 * Created by manvi on 24/4/17.
 */
public class ApplicationTest extends ApplicationTestCase<Application>{

    String mResult = "";
    CountDownLatch signal = null;

    public ApplicationTest() {
        super(Application.class);
    }

//    @Override
//    protected void setUp() throws Exception {
//        signal = new CountDownLatch(1);
//    }
//
//    @Override
//    protected void tearDown() throws Exception {
//        signal.countDown();
//    }

    public void testAlbumGetTask() throws InterruptedException {

        EndpointsAsyncTask task = new EndpointsAsyncTask();
        try {
            mResult = task.execute(this.getContext()).get();
        }catch (ExecutionException e)
        {
            e.printStackTrace();
        }
        Log.i("AppTest",mResult);
        assertNotNull("Joke Not Found", mResult);
        assertFalse(TextUtils.isEmpty(mResult));
    }
}