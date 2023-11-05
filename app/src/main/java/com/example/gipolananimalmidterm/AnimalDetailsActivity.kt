package com.example.gipolananimalmidterm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.content.Intent
import android.widget.ImageButton

class AnimalDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_details)

        val nameTextView: TextView = findViewById(R.id.nameTextView)
        val animalDescription: TextView = findViewById(R.id.animalDescription)
        val blockAnimalButton: Button = findViewById(R.id.blockAnimalButton)

        // Set the animal details
        val animalName = "Antilope"
        val description = "An antelope is a group of herbivorous mammals belonging to the family Bovidae."

        nameTextView.text = animalName
        animalDescription.text = description

        // Set a click listener for the "Block Animal" button
        blockAnimalButton.setOnClickListener(View.OnClickListener {

            // Redirect to the ActivityManageBlock
            val intent = Intent(this, ManageBlockActivity::class.java)
            startActivity(intent)
        })

        // Get a reference to the ImageButton
        val backButton: ImageButton = findViewById(R.id.backButton)

        // Set a click listener for the ImageButton
        backButton.setOnClickListener {
            // Redirect to the AnimalNamesActivity when the ImageButton is clicked
            val intent = Intent(this, AnimalNamesActivity::class.java)
            startActivity(intent)
        }
    }
}