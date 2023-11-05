package com.example.gipolananimalmidterm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView

class ManageBlockActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manage_block)

        // Get a reference to the ListView
        val animalListView: ListView = findViewById(R.id.animalListView)

        // Define a list of blocked animal names
        val blockedAnimalNames = mutableListOf("Antilope")

        // Create a custom adapter to display the blocked animal names with an "Unblock" button
        val adapter = BlockedAnimalAdapter(this, blockedAnimalNames)

        // Set the adapter for the ListView
        animalListView.adapter = adapter
    }
}

class BlockedAnimalAdapter(
    private val context: AppCompatActivity,
    private val blockedAnimalNames: MutableList<String>
) : ArrayAdapter<String>(context, 0, blockedAnimalNames) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val blockedAnimalName = getItem(position)

        // Check if an existing view is being reused, otherwise inflate a new view
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.blocked_animal_item, parent, false)

        // Set the blocked animal name
        val blockedAnimalTextView: TextView = view.findViewById(R.id.blockedAnimalName)
        blockedAnimalTextView.text = blockedAnimalName

        // Set a click listener for the "Unblock" button
        val unblockButton: Button = view.findViewById(R.id.unblockButton)
        unblockButton.setOnClickListener {
            try {
                // Handle unblocking the animal by removing it from the list
                blockedAnimalNames.removeAt(position)
                notifyDataSetChanged() // Notify the adapter that the data set has changed
            } catch (e: IndexOutOfBoundsException) {
                // Handle the case where the position is out of bounds
                e.printStackTrace()
            }
        }

        return view
    }
}







