package camp.codelab.movieapp.models

import com.google.gson.annotations.SerializedName

class Movie {
    @SerializedName("imdbID")
    var id: Int = 0
    var Title: String = ""
    var Year: Int = 0
    var Runtime: String = ""
    var Genre: String = ""
    var Poster: String = ""
    var imdbRating: Float = 0f

}