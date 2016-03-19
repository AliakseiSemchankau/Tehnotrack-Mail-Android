package com.example.aliakseisemchankau.tehnotrackdz1;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    SleepTask sleepTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sleepTask = new SleepTask();
        sleepTask.setStartActivity(this);
        sleepTask.setFinishActivity(ListViewBaseAdapterActivity.class);
        sleepTask.execute();

    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
        sleepTask.cancel(true);

    }

    private class SleepTask extends AsyncTask<Void, Void, Void> {

        AppCompatActivity startActivity;
        Class finishActivityClass;

        protected void setStartActivity(AppCompatActivity startActivity) {
            this.startActivity = startActivity;
        }

        protected void setFinishActivity(Class finishActivityClass) {
            this.finishActivityClass = finishActivityClass;
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Thread.sleep(2000);

                if (this.isCancelled()) {
                    return null;
                }

                startActivity.finish();

                Intent intentFinishActivity = new Intent(startActivity, finishActivityClass);

                startActivity(intentFinishActivity);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }


    }

}
