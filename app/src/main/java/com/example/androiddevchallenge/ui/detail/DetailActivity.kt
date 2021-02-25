package com.example.androiddevchallenge.ui.detail

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.ui.theme.MyTheme

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_PUPPY: String = "EXTRA_PUPPY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                Surface(color = MaterialTheme.colors.background) {
                    intent.getParcelableExtra<Puppy>(EXTRA_PUPPY)?.let {
                        DetailScreen(it) { puppy ->
                            createAdoptionApplication(puppy.name)
                        }
                    }
                }
            }
        }
    }

    private fun createAdoptionApplication(name: String) {
        val intent = Intent(Intent.ACTION_SEND)
            .setType("text/plain")
            .putExtra(Intent.EXTRA_EMAIL, arrayOf(getString(R.string.adoption_instructions_email)))
            .putExtra(Intent.EXTRA_SUBJECT, getString(R.string.new_adoption_application, name))
            .putExtra(Intent.EXTRA_TEXT, getString(R.string.adoption_application, name))

        if (packageManager?.resolveActivity(intent, 0) != null) {
            startActivity(intent)
        }
    }
}