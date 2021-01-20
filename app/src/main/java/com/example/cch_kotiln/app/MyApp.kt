package com.example.cch_kotiln.app
import android.app.Application
import android.content.Context
import com.example.cch_kotiln.utils.MyMmkv


class MyApp:Application() {

    companion object{
        var instance:MyApp? = null
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        MyMmkv.initMMKV()
    }

}