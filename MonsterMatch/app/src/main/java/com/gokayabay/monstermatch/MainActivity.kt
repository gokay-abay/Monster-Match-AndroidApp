package com.gokayabay.monstermatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gokayabay.monstermatch.databinding.ActivityMainBinding


// entry point to the application
class MainActivity : AppCompatActivity() {
    // lateinit: like lazy var
    private lateinit var binding: ActivityMainBinding

    private val monsters: List<Monster> = listOf(
        Monster(R.drawable.monster1_head, R.drawable.monster1_body, R.drawable.monster1_feet),
        Monster(R.drawable.monster2_head, R.drawable.monster2_body, R.drawable.monster2_feet),
        Monster(R.drawable.monster3_head, R.drawable.monster3_body, R.drawable.monster3_feet)
    )

    private val heads: List<Int> = listOf(
        R.drawable.monster1_head,
        R.drawable.monster2_head,
        R.drawable.monster3_head
    )

    private val bodies: List<Int> = listOf(
        R.drawable.monster1_body,
        R.drawable.monster2_body,
        R.drawable.monster3_body
    )

    private val feet: List<Int> = listOf(
        R.drawable.monster1_feet,
        R.drawable.monster2_feet,
        R.drawable.monster3_feet
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // every view had a layout inflater
        binding = ActivityMainBinding.inflate(layoutInflater)

        // setting the connect view to the root which is activity main xml
        setContentView(binding.root)
        shuffleMonsters()
        binding.shuffleButton.setOnClickListener{
            shuffleMonsters()
        }
    }
    private fun shuffleMonsters() {
        // randomize the image being displayed in there
        val randoMonster1 = monsters.random()
        val randoMonster2 = monsters.random()
        val randoMonster3 = monsters.random()

        binding.headImageView.setImageResource(randoMonster1.head)
        binding.bodyImageView.setImageResource(randoMonster2.body)
        binding.feetImageView.setImageResource(randoMonster3.feet)

        if(monsters.indexOf(randoMonster1) == monsters.indexOf(randoMonster2) &&
            monsters.indexOf(randoMonster2) == monsters.indexOf(randoMonster3)) {
            binding.matchLabel.setText("You matched the monster!")
        } else {
            binding.matchLabel.setText("")
        }

    }
}

data class Monster(val head: Int, val body: Int, val feet: Int)