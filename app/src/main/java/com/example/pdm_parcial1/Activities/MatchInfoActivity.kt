package com.example.pdm_parcial1.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.pdm_parcial1.Fragments.ContentFragment
import com.example.pdm_parcial1.R
import com.example.pdm_parcial1.Utils.Constants
import com.example.pdm_parcial1.ViewModel.MatchViewModel
import kotlinx.android.synthetic.main.activity_match_info.*

class MatchInfoActivity : AppCompatActivity() {

    private lateinit var matchViewModel: MatchViewModel
    var twoPane = false
    private lateinit var mainContentFragment: ContentFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_match_info)

        matchViewModel = ViewModelProviders.of(this).get(MatchViewModel::class.java)

        val intento = intent
        if(intento != null){
            matchViewModel.getMatchByName(intento.getStringExtra(Constants.TEXT_KEY_MATCH)).observe(this, Observer { match ->
                tv_name_team_A_info.text = match.TeamA
                tv_name_team_B_info.text = match.TeamB
                tv_score_team_a_info.text = match.ScoreTeamA.toString()
                tv_score_team_b_info.text = match.ScoreTeamB.toString()
                if(match.ScoreTeamA < match.ScoreTeamB){
                    tv_team_winner.text = match.TeamB
                }else{
                    tv_team_winner.text = match.TeamA
                }
            })
        }
        else{
            var toast: Toast = Toast.makeText(applicationContext,"Hubo un problema", Toast.LENGTH_SHORT)
        }
    }


}
