package com.example.pdm_parcial1.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pdm_parcial1.Adapters.MatchAdapter
import com.example.pdm_parcial1.R
import com.example.pdm_parcial1.Room.Entities.MatchEntity
import com.example.pdm_parcial1.Utils.Constants
import com.example.pdm_parcial1.ViewModel.MatchViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), LifecycleOwner {


    private lateinit var matchViewModel: MatchViewModel
    var twoPane = false
    private lateinit var viewAdapter: MatchAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
   // private lateinit var mainContentFragment: ContentFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*if(fragment_content != null){
            twoPane = true
            mainContentFragment = ContentFragment.newInstance(BookEntity())
            supportFragmentManager.beginTransaction().replace(R.id.fragment_content, ContentFragment()).commit()
        }else{
            twoPane = false
        }*/

        fab.setOnClickListener {
            val intent = Intent(this@MainActivity, NewMatchActivity::class.java)
            startActivity(intent)
        }

        initRecycle(emptyList())



        matchViewModel = ViewModelProviders.of(this).get(MatchViewModel::class.java)

        matchViewModel.allMatches().observe(this, Observer {
            viewAdapter.dataChange(it)
        })
    }

    fun initRecycle(books : List<MatchEntity>){
        viewManager = LinearLayoutManager(this)


        viewAdapter = MatchAdapter(books,{ bookitem: MatchEntity-> bookItemClicked(bookitem)})

        matches_list.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

    private fun bookItemClicked(item: MatchEntity){
        /*if(twoPane){
            mainContentFragment = ContentFragment.newInstance(item)
            supportFragmentManager.beginTransaction().replace(R.id.fragment_content,mainContentFragment).commit()
            Log.d("Click", "Esta haciendo click en: "+ item.Titulo)
        }else{
            val extras = Bundle()
            extras.putString(Constants.TEXT_KEY_TITULO,item.Titulo)
            startActivity(Intent(this, Activity_Book::class.java).putExtras(extras)
        }*/

        val extras = Bundle()
        extras.putString(Constants.TEXT_KEY_MATCH,item.MatchName)
        startActivity(Intent(this, MatchActivity::class.java).putExtras(extras))
    }
}
