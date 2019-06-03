package com.example.pdm_parcial1.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.accessibility.AccessibilityNodeInfo
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.pdm_parcial1.Fragments.ContentFragment
import com.example.pdm_parcial1.R
import com.example.pdm_parcial1.Room.Entities.MatchEntity
import com.example.pdm_parcial1.Utils.Constants
import com.example.pdm_parcial1.ViewModel.MatchViewModel
import kotlinx.android.synthetic.main.activity_match.*

class MatchActivity : AppCompatActivity(), LifecycleOwner {

    private lateinit var matchViewModel: MatchViewModel
    var twoPane = false
    private lateinit var mainContentFragment: ContentFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_match)

        matchViewModel = ViewModelProviders.of(this).get(MatchViewModel::class.java)

        val intento = intent
        if(intento != null){
            matchViewModel.getMatchByName(intento.getStringExtra(Constants.TEXT_KEY_MATCH)).observe(this, Observer { match ->
                tv_name_team_A.text = match.TeamA
                tv_name_team_B.text = match.TeamB
                tv_score_team_a.text = match.ScoreTeamA.toString()
                tv_score_team_b.text = match.ScoreTeamB.toString()
                if(match.Finished){
                    disableButtons(match)
                }else{
                    buttonsWorking(match)
                }
            })

            Log.d("match comming", Constants.TEXT_KEY_MATCH)

        }
        else{
            var toast: Toast = Toast.makeText(applicationContext,"Hubo un problema", Toast.LENGTH_SHORT)
        }
    }

    fun disableButtons(item: MatchEntity){
        bt_reset_a.isClickable = false
        bt_reset_b.isClickable = false
        bt_team_a_2_p.isClickable = false
        bt_team_a_3_p.isClickable = false
        bt_team_a_free_throw.isClickable = false
        bt_team_b_2_p.isClickable = false
        bt_team_b_3_p.isClickable = false
        bt_team_b_free_throw.isClickable = false
        bt_finish.isClickable = false

        bt_final_results.setOnClickListener {
            val extras = Bundle()
            extras.putString(Constants.TEXT_KEY_MATCH,item.MatchName)
            startActivity(Intent(this, MatchInfoActivity::class.java).putExtras(extras))
        }
    }

    fun buttonsWorking(match : MatchEntity){
        bt_team_a_2_p.setOnClickListener {
            match.ScoreTeamA += 2
            matchViewModel.insertMatch(match)
        }
        bt_team_b_2_p.setOnClickListener {
            match.ScoreTeamB += 2
            matchViewModel.insertMatch(match)
        }
        bt_team_a_3_p.setOnClickListener {
            match.ScoreTeamA += 3
            matchViewModel.insertMatch(match)
        }
        bt_team_b_3_p.setOnClickListener {
            match.ScoreTeamB += 3
            matchViewModel.insertMatch(match)
        }
        bt_team_a_free_throw.setOnClickListener {
            match.ScoreTeamA += 1
            matchViewModel.insertMatch(match)
        }
        bt_team_b_free_throw.setOnClickListener {
            match.ScoreTeamB += 1
            matchViewModel.insertMatch(match)
        }
        bt_finish.setOnClickListener {
            match.Finished = true
            matchViewModel.insertMatch(match)
        }
    }

}
