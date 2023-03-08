package com.yan.downloadmanager

import android.app.DownloadManager
import android.content.Context
import android.os.Environment
import android.util.Log
import androidx.core.net.toUri

class AndroidDownloader(context: Context) : Downloader {
    private val downloadManager = context.getSystemService(DownloadManager::class.java)
    override fun downloadFile(url: String): Long {
        Log.d("AndroidDownloader", "Environment.DIRECTORY_DOWNLOADS:${Environment.DIRECTORY_DOWNLOADS}")
        val request = DownloadManager.Request(url.toUri())
            .setMimeType("image/jpg")
            .setTitle("image.jpg")
            .setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI)
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            .addRequestHeader("Authorization", "Bearer <Token>")
            .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "image.jpg")
        return downloadManager.enqueue(request)
    }
}