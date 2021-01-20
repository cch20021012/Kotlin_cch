package com.example.cch_kotiln.net

import android.util.Log
import com.example.cch_kotiln.net.repository.SystemRepository


/**
 * 数据仓库的代理类
 */
object Injection {
    // 创建数据仓库
    var repository: SystemRepository = SystemRepository()

    val myRepository by lazy {
        Log.i("TAG","init")
        SystemRepository()
    }
}