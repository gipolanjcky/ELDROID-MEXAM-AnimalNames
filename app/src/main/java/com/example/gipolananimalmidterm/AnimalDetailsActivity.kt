package com.example.gipolananimalmidterm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.content.Intent

class AnimalDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_details)

        val animalTitle: TextView = findViewById(R.id.animalTitle)
        val animalDescription: TextView = findViewById(R.id.animalDescription)
        val blockAnimalButton: Button = findViewById(R.id.blockAnimalButton)

        // Set the animal details
        val animalName = "Lion" // Replace with the name of the selected animal
        val description = "The lion is a large carnivorous feline known for its majestic mane." // Replace with the animal's description

        animalTitle.text = animalName
        animalDescription.text = description

        // Set a click listener for the "Block Animal" button
        blockAnimalButton.setOnClickListener(View.OnClickListener {
            // Save the blocked animal (you can implement this logic)
            // For example, you can store the blocked animals in SharedPreferences or a database
            // Here, we'll just display a toast message
            // Toast.makeText(this, "Animal '$animalName' blocked!", Toast.LENGTH_SHORT).show()

            // Redirect to the ActivityManageBlock
            val intent = Intent(this, ManageBlockActivity::class.java)
            startActivity(intent)
        })
    }
}