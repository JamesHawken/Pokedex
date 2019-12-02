package com.benjaminledet.pokedex.ui.pokemon.detail

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.benjaminledet.pokedex.R
import com.benjaminledet.pokedex.data.repository.utils.Status
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_pokemon_detail.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class PokemonDetailActivity: AppCompatActivity() {

    private val viewModel by viewModel<PokemonDetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_detail)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        viewModel.pokemonId.postValue(intent.getIntExtra("pokemonId", 0))

        viewModel.refreshState.observe(this, Observer { refreshState ->
            progressBar.isVisible = refreshState.status == Status.RUNNING
            content.isVisible = refreshState.status != Status.RUNNING
        })

        viewModel.pokemon.observe(this, Observer { pokemon ->
            title = pokemon?.name
            moves.text= getString(R.string.pokemon_moves, pokemon?.detail?.moves.toString())
            weight.text = getString(R.string.pokemon_weight, pokemon?.detail?.weight.toString())
            height.text = getString(R.string.pokemon_height, pokemon?.detail?.height.toString())
            base_experience.text = getString(R.string.pokemon_base_experience, pokemon?.detail?.base_experience.toString())
            Picasso.get().load(pokemon?.iconUrl).into(icon)
            var typePrincipal= pokemon?.detail?.types?.get(0)
            val cl: ConstraintLayout = findViewById(R.id.detail_constraintLayout)
            when (typePrincipal) {

                "poison" -> cl.setBackgroundColor(ContextCompat.getColor(this, R.color.poison))
                "normal" -> cl.setBackgroundColor(ContextCompat.getColor(this, R.color.normal))
                "fire" -> cl.setBackgroundColor(ContextCompat.getColor(this, R.color.fire))
                "water" -> cl.setBackgroundColor(ContextCompat.getColor(this, R.color.water))
                "electric" -> cl.setBackgroundColor(ContextCompat.getColor(this, R.color.electric))
                "grass" -> cl.setBackgroundColor(ContextCompat.getColor(this, R.color.grass))
                "ice" -> cl.setBackgroundColor(ContextCompat.getColor(this, R.color.ice))
                "fighting" -> cl.setBackgroundColor(ContextCompat.getColor(this, R.color.fighting))
                "ground" -> cl.setBackgroundColor(ContextCompat.getColor(this, R.color.ground))
                "flying" -> cl.setBackgroundColor(ContextCompat.getColor(this, R.color.flying))
                "psychic" -> cl.setBackgroundColor(ContextCompat.getColor(this, R.color.psychic))
                "bug" -> cl.setBackgroundColor(ContextCompat.getColor(this, R.color.bug))
                "rock" -> cl.setBackgroundColor(ContextCompat.getColor(this, R.color.rock))
                "ghost" -> cl.setBackgroundColor(ContextCompat.getColor(this, R.color.ghost))
                "dragon" -> cl.setBackgroundColor(ContextCompat.getColor(this, R.color.dragon))
                "dark" -> cl.setBackgroundColor(ContextCompat.getColor(this, R.color.dark))
                "steel" -> cl.setBackgroundColor(ContextCompat.getColor(this, R.color.steel))
                "fairy" -> cl.setBackgroundColor(ContextCompat.getColor(this, R.color.fairy))
                else -> print("helo")
            }



        })

        viewModel.moves.observe(this, Observer { moves ->
                Log.d("PokemonDetailActivity", "moves:$moves")

        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        android.R.id.home -> {
            finish()
            true
        }
        else -> true
    }

}