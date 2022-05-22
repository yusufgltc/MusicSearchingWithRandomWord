package com.example.android.musicsearchingwithrandomword

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.musicsearchingwithrandomword.network.models.RandomWord
import com.example.android.musicsearchingwithrandomword.presenter.overview.OverviewViewModel
import com.example.android.musicsearchingwithrandomword.presenter.overview.RandomWordLinearAdapter

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView,
                     data: List<RandomWord>?) {
    val adapter = recyclerView.adapter as RandomWordLinearAdapter
    adapter.submitList(data)
}

/**
 * This binding adapter displays the [RandomWordApiStatus] of the network request in an image view.  When
 * the request is loading, it displays a loading_animation.  If the request has an error, it
 * displays a broken image to reflect the connection error.  When the request is finished, it
 * hides the image view.
 */
@BindingAdapter("randomWordApiStatus")
fun bindStatus(statusImageView: ImageView,
               status: OverviewViewModel.RandomWordApiStatus?) {

    when (status) {
        OverviewViewModel.RandomWordApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }

        OverviewViewModel.RandomWordApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }

        OverviewViewModel.RandomWordApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}