// MainActivity.kt
package com.example.plantdiseaseapp

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.tensorflow.lite.support.image.TensorImage
import org.tensorflow.lite.task.vision.classifier.ImageClassifier

class MainActivity : AppCompatActivity() {
    private val CAMERA_REQUEST_CODE = 100
    private lateinit var classifier: ImageClassifier
    private lateinit var imageView: ImageView
    private lateinit var chatTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.imageView)
        chatTextView = findViewById(R.id.chatTextView)
        val buttonTakePhoto = findViewById<Button>(R.id.buttonTakePhoto)

        // Load TFLite model
        classifier = ImageClassifier.createFromFileAndOptions(
            this,
            "plant_disease_model.tflite",
            ImageClassifier.ImageClassifierOptions.builder()
                .setMaxResults(1)
                .setScoreThreshold(0.5f)
                .build()
        )

        buttonTakePhoto.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, CAMERA_REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CAMERA_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val photo = data?.extras?.get("data") as Bitmap
            imageView.setImageBitmap(photo)

            // Run prediction
            val image = TensorImage.fromBitmap(photo)
            val results = classifier.classify(image)
            val label = results[0].categories[0].label

            // Get response from chatbot
            val response = Chatbot.getResponse(label)
            chatTextView.text = response
        }
    }
}
