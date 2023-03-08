package com.yan.downloadmanager

interface Downloader {
    fun downloadFile(url: String): Long
}