package com.tarasov_denis.rick_and_morty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper


/*
1) создать splashActivity
2) заполнить splashActivity картинкой
3) прописать запуск splashActivity в манифесте
4) создать интент в splashActivity
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
      //  setTheme(R.style.Theme_Rick_and_morty)
        /*
        Handler(Looper.getMainLooper()).postDelayed({
            setTheme(R.style.Theme_Rick_and_morty);
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main) }, 3000)
            
         */

        super.onCreate(savedInstanceState)
       // setTheme(R.style.Theme.Rick_and_morty)  Handler(Looper.getMainLooper()).postDelayed(Runnable { navigator().goToMainFragment() }, 3000)
     //   Handler(Looper.getMainLooper()).postDelayed({ setTheme(R.style.Theme_Rick_and_morty) }, 2000)
     //   Handler(Looper.getMainLooper()).postDelayed({  setContentView(R.layout.activity_main) }, 5000)
        // setTheme(R.style.Theme_Rick_and_morty)  //Theme.Rick_and_morty)

         setContentView(R.layout.activity_main)

    }
}

/*
 Handler(Looper.getMainLooper()).postDelayed(Runnable { navigator().goToMainFragment() }, 3000)
 */