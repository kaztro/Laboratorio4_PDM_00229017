package com.example.laboratorio4_pdm_00229017.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.laboratorio4_pdm_00229017.R
import com.example.laboratorio4_pdm_00229017.adapters.MovieAdapter
import com.example.laboratorio4_pdm_00229017.pojos.Movie
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var movieAdapter: MovieAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager

    private var movieList: ArrayList<Movie> = ArrayList<>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        initSearchButton()
    }

    fun initRecyclerView() {
        //Crear un LinearLayoutManager que recibira el contexto, es un linear layout con orientacion vertical
        viewManager = LinearLayoutManager(this)

        //Es un OnClickListener...
        movieAdapter = MovieAdapter(movieList, {movieItem: Movie -> movieItemClicked(movieItem)})

        movie_list_rv.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = movieAdapter
        }
    }

    private fun initSearchButton() = add_movie_btn.setOnClickListener {
        if(!movie_name_et.text.toString().isEmpty()) {
            FetchMovie().execute(movie_name_et.text.toString())
        }
    }

    fun addMovieToList(movie: Movie) {
        movieList.add(movie)
    }


}
