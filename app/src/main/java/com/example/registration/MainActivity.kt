package com.example.registration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener{
            val email = emailAddress.text.toString()
            val password = textPassword.text.toString()

            if (email.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "შეიყვანეთ მონაცემები!", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance()
                .createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful){
                        Toast.makeText(this, "წარმატებით შეიქმნა!", Toast.LENGTH_LONG).show()
                        emailAddress.text.clear()
                        textPassword.text.clear()
                    }else {
                        Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show()
                    }

                }


        }

    }
}