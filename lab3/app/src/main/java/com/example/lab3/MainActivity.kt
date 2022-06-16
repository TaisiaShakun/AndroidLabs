package com.example.lab3

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import com.example.lab3.databinding.ActivityMainBinding
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {
    var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val imageBitmap = result.data?.extras?.get("data") as Bitmap
            val uriSavedImage : Uri = saveImage(imageBitmap);
            val intent = Intent(Intent.ACTION_SEND);
            intent.type = "image/*";
            intent.putExtra(Intent.EXTRA_STREAM, uriSavedImage);
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
   }

    fun onTakePhotoClicked(view: View) {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        resultLauncher.launch(takePictureIntent)
    }

    fun saveImage(bitmap : Bitmap) : Uri {
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val imagesFolder = File(filesDir, "pictures");
        imagesFolder.mkdir();
        val file = File(imagesFolder, "$timeStamp.png");
        file.createNewFile();
        val stream = FileOutputStream(file);
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        stream.flush();
        stream.close();

        val uriSavedImage : Uri = FileProvider.getUriForFile(this,
            BuildConfig.APPLICATION_ID +".provider", file)
        return uriSavedImage
    }
}