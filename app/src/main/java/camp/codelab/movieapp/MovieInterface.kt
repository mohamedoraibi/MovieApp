package camp.codelab.movieapp

import camp.codelab.movieapp.models.SearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieInterface {
    @GET("http://www.omdbapi.com/")
    fun searchMovie(@Query("apikey") searchQuery: String, @Query("q") searchQuery2: String): Call<SearchResponse>
}