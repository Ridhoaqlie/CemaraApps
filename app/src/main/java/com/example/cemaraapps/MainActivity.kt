package com.example.cemaraapps

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cemaraapps.IntroActivity.Companion.EXTRA_NAME2
import com.example.cemaraapps.QfamilyActivity.Companion.EXTRA_CODE
import com.example.cemaraapps.databinding.ActivityMainBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.OnCompleteListener


class MainActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_CODE2 = "EXTRA_CODE2"
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val tokenFam = intent.getStringExtra(EXTRA_CODE)
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()

        // Build a GoogleSignInClient with the options specified by gso.
        val mGoogleSignInClient = GoogleSignIn.getClient(this, gso)


        binding.apply {
            ibCalendar.setOnClickListener{
             startActivity(Intent(this@MainActivity, CalendarActivity::class.java))
            }
            ibDetail.setOnClickListener{
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra(EXTRA_CODE2, tokenFam)
                startActivity(intent)

            }
            ibMember.setOnClickListener {
                startActivity(Intent(this@MainActivity, RolefixActivity::class.java))
            }
            btnLogout.setOnClickListener {
                mGoogleSignInClient.signOut()
                Toast.makeText(applicationContext, "Berhasil logout", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this@MainActivity, LoginActivity::class.java))
                finish()
            }
            ibChart.setOnClickListener{
                startActivity(Intent(this@MainActivity, ChartActivity::class.java))
            }

            var nama = intent.getStringExtra(EXTRA_NAME2).toString()
            nama+="  "
            var index = 0
            var index2 = 0
            for(huruf in nama){
                index+=1
                if(huruf==' '){
                    index2+=1
                    if(index2==2){
                    tvName.text = nama.substring(0,index-1)
                    return
                    }
                }
            }
        }

    }


}