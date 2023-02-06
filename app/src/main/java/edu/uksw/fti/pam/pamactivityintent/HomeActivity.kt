package edu.uksw.fti.pam.pamactivityintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.uksw.fti.pam.pamactivityintent.Adapter.Horizontal_RecyclerView
import edu.uksw.fti.pam.pamactivityintent.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerView2: RecyclerView
    private lateinit var adaptera: Horizontal_RecyclerView
    private lateinit var binding: ActivityHomeBinding
    private lateinit var adapter: ImageSliderAdapter
    private val list = ArrayList<ImageData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = findViewById(R.id.recyclerView)
        adaptera = Horizontal_RecyclerView()

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = adaptera

        recyclerView2 = findViewById(R.id.recyclerView2)
        adaptera = Horizontal_RecyclerView()

        recyclerView2.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView2.adapter = adaptera


        list.add(
            ImageData(
                "https://ik.trn.asia/uploads/2022/08/1659754545976.jpeg"
            )
        )
        list.add(
            ImageData(
                "https://i0.wp.com/batman-news.com/wp-content/uploads/2019/09/Joker-Official-Images-Imax-Poster-Featured-01.jpg"
            )
        )
        list.add(
            ImageData(
                "https://cdn.telanganatoday.com/wp-content/uploads/2022/04/IMAX-unveils-Yashs-dhamakedaar-fierce-look-in-K.G.F.-Chapter-2-poster.jpg"
            )
        )

        adapter = ImageSliderAdapter(list)
        binding.viewPager.adapter = adapter

        binding.bottomNavigationView.setOnItemSelectedListener {

            when (it.itemId) {

                R.id.home -> HomeActivity()
                R.id.search -> replaceFragment(Search())
                R.id.purchase -> replaceFragment(Purchase())

                else -> {

                }
            }
            true
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_dr -> Toast.makeText(this,"Anda Menekan Menu", Toast.LENGTH_LONG).show()
            R.id.person -> Toast.makeText(this,"Anda Menekan Akun", Toast.LENGTH_LONG).show()
            R.id.logout -> Toast.makeText(this,"Anda Menekan Logout", Toast.LENGTH_LONG).show()
            R.id.feedback -> Toast.makeText(this,"Anda Menekan Feedback", Toast.LENGTH_LONG).show()
            R.id.metu -> finish()
        }
        return true
    }

    private fun replaceFragment(fragment: Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
}