package camp.codelab.movieapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import camp.codelab.movieapp.models.Movie
import camp.codelab.movieapp.models.SearchResponse
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun searchMovie(searchQuery: String) {
        val retrofit = Retrofit.Builder()
                .baseUrl(Consts.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val movieInterface = retrofit.create(MovieInterface::class.java)
        movieInterface.searchMovie(searchQuery)
                .enqueue(object : Callback<SearchResponse> {
                    override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
                        Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_LONG).show()
                    }

                    override fun onResponse(call: Call<SearchResponse>, response: Response<SearchResponse>) {


//
//                    Log.i("","response is message = ${response.message()}")
//                    Log.i("","response is raw = ${response.raw()}")
//                    Log.i("","response is error body = ${response.errorBody()}")
//                    Log.i("","response is null = ${response.body()==null}")
                        response.body()?.let {
                            prepareRecycleView(it.results)
                        }
                    }


                })
    }

    fun prepareRecycleView(movieList: List<Movie>) {

        recycleView.layoutManager = LinearLayoutManager(this)
        recycleView.adapter = MovieAdapter(movieList)
    }
}
