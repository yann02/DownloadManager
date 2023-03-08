package com.yan.downloadmanager

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.yan.downloadmanager.ui.theme.DownloadManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DownloadManagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    val context = LocalContext.current
    Row {
        Text(text = "Hello $name!")
        Button(onClick = { startDownload(context) }) {
            Text(text = "Start Download")
        }
    }
}

fun startDownload(context: Context) {
    val downloader = AndroidDownloader(context)
    downloader.downloadFile("https://img2.baidu.com/it/u=355673106,1614830790&fm=253&fmt=auto&app=138&f=JPEG?w=800&h=500")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DownloadManagerTheme {
        Greeting("Android")
    }
}