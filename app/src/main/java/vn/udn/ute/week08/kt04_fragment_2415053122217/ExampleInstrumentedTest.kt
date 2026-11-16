package vn.udn.ute.kt04_fragment_2415053122217

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import vn.udn.ute.kt04_fragment_2415053122217.ui.NhapVeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentHost, NhapVeFragment())
                .commit()
        }
    }
}