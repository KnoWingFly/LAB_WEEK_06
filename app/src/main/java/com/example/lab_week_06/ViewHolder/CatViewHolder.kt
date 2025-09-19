package com.example.lab_week_06.ViewHolder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.Adapter.CatAdapter
import com.example.lab_week_06.Interface.ImageLoader
import com.example.lab_week_06.R
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.Gender

private const val FEMALE_SYMBOL = "\u2640"
private const val MALE_SYMBOL = "\u2642"
private const val UNKNOWN_SYMBOL ="?"

class CatViewHolder(
    private val containerView: View,
    private val imageLoader: ImageLoader,
    private val onClickListener: CatAdapter.OnClickListener
    ) : RecyclerView.ViewHolder(containerView) {

    private val catBiographyView: TextView by lazy {
        containerView.findViewById(R.id.cat_biography)
    }
    private val catBreedView: TextView by lazy {
        containerView.findViewById(R.id.cat_breed)
    }
    private val catGenderView: TextView by lazy {
        containerView.findViewById(R.id.cat_gender)
    }
    private val catNameView: TextView by lazy {
        containerView.findViewById(R.id.cat_name)
    }
    private val catPhotoView: ImageView by lazy {
        containerView.findViewById(R.id.cat_photo)
    }

    fun bindData(cat: CatModel){
        containerView.setOnClickListener {
            onClickListener.onItemClick(cat)
        }

        imageLoader.loadImage(cat.imageUrl, catPhotoView)
        catNameView.text = cat.name
        catBreedView.text = when (cat.breed){
            CatBreed.AmericanCurl -> "Amreican Curl"
            CatBreed.BalineseJavanese -> "Balinese-Javanese"
            CatBreed.ExoticShorthair -> "Exotic Shorthair"
            CatBreed.Aegean -> "Aegean"
            CatBreed.BritishLonghair -> "British Longhair"
            CatBreed.Sphynx -> "Sphynx"
            CatBreed.DragonLi -> "Dragon Li"
            CatBreed.TurkishAngora -> "Turkish Angora"
            CatBreed.JapaneseBobtail -> "Japanese Bobtail"
            CatBreed.Mainecoon -> "Maine Coon"
            CatBreed.KhaoManee -> "Khao Manee"
            CatBreed.ScotishFold -> "Scotish Fold"
        }
        catBiographyView.text = cat.biography
        catGenderView.text = when (cat.gender){
            Gender.Female -> FEMALE_SYMBOL
            Gender.Male -> MALE_SYMBOL
            Gender.Unknown -> UNKNOWN_SYMBOL
        }
    }
}