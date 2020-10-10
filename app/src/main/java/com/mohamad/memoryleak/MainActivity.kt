package com.mohamad.memoryleak

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    /*
    * memory leak happends when gurbage collection wont be able to back memory block from resources into Heap
    * EX: having a view (or resource of it like context) running on background thread and the view destroy so GC cannot back the resource into heap
    *
    * */
     var myAsyncTask: MyAsyntask? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_submit.setOnClickListener {


            //finish the activity after click the btn (for second time)
            if (myAsyncTask != null) {
                finish()
            }

            //running asyntask
            myAsyncTask = MyAsyntask(this)
            myAsyncTask!!.execute()
        }
    }

    class MyAsyntask constructor(myContext: Context) : AsyncTask<Void, Void, Void>() {

        var context = myContext

        override fun doInBackground(vararg p0: Void?): Void? {

            //make a recouese using memory but relative to view(its context)
            var bitMap: Bitmap =
                BitmapFactory.decodeResource(context.resources, R.drawable.god)
            Thread.sleep(
                5000
            )
            return null
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        println("debug : activity destory")
    }
}
