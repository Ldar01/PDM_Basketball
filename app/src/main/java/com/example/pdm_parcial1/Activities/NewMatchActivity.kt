package com.example.pdm_parcial1.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.pdm_parcial1.R
import com.example.pdm_parcial1.Room.Entities.MatchEntity
import com.example.pdm_parcial1.Utils.Constants
import com.example.pdm_parcial1.ViewModel.MatchViewModel
import kotlinx.android.synthetic.main.activity_new_match.*

class NewMatchActivity : AppCompatActivity() {

    private lateinit var matchViewModel: MatchViewModel
    private lateinit var match : MatchEntity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_match)

        matchViewModel = ViewModelProviders.of(this).get(MatchViewModel::class.java)

        bt_start_match.setOnClickListener {
            match = MatchEntity(
                    et_match_name.text.toString(),
                    et_team_a_name.text.toString(),
                    0,
                    et_team_b_name.text.toString(),
                    0,
                    false
            )

            matchViewModel.insertMatch(match)

            val extras = Bundle()
            extras.putString(Constants.TEXT_KEY_MATCH,et_match_name.toString())
            startActivity(Intent(this, MatchActivity::class.java).putExtras(extras))


        }
    }
}
