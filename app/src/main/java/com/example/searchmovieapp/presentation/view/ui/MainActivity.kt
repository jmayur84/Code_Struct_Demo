package com.example.searchmovieapp.presentation.view.ui

import android.content.res.Resources
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.example.searchmovieapp.R
import com.example.searchmovieapp.databinding.ActivityMainBinding
import com.example.searchmovieapp.domain.model.MovieUseCaseRequest
import com.example.searchmovieapp.presentation.view.adapters.HomeSliderAdapter
import com.example.searchmovieapp.presentation.view.adapters.MovieListAdapter
import com.example.searchmovieapp.presentation.view.base.BaseViewModel
import com.example.searchmovieapp.presentation.view.base.BaseViewModelActivity
import com.example.searchmovieapp.domain.model.CarouselItemBM
import com.example.searchmovieapp.domain.model.MovieItemBM
import com.example.searchmovieapp.presentation.view.viewModel.MovieViewModel
import kotlin.math.abs
import kotlin.math.roundToInt


class MainActivity : BaseViewModelActivity<ActivityMainBinding, MovieViewModel>() {

    private lateinit var homeSliderAdapter: HomeSliderAdapter
    private lateinit var movieListAdapter: MovieListAdapter

    override fun getViewModelClass(): Class<BaseViewModel> {
        return MovieViewModel().javaClass
    }

    override fun inflateLayout(layoutInflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun initView() {
        super.initView()
        setObservers()
        getMovieGenre()
        setupSearchView()
    }

    private fun setupSearchView() {
        getBinding().svMovieList.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                movieListAdapter.filter.filter(query)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                movieListAdapter.filter.filter(newText)
                return false
            }
        })
    }

    private fun setObservers() {
        getViewModel().mLiveMovieGenreData.observe(this) {
            it?.let {
                setupCarousal(it)
            }
        }

        getViewModel().mLiveMovieListData.observe(this) {
            it?.let {
                setupMovieListRv(it as ArrayList<MovieItemBM>)
            }
        }
    }

    private fun setupMovieListRv(list: ArrayList<MovieItemBM>) {
        movieListAdapter = MovieListAdapter(list) { movieItemBM ->
            showBottomToastMessage(movieItemBM.movieName!!, getBinding().root)
        }
        getBinding().rvMovieList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
            adapter = movieListAdapter
        }
    }

    private fun getMovieGenre() {
        getViewModel().getMovieGenre(MovieUseCaseRequest(null))
    }

    private fun setupCarousal(list: List<CarouselItemBM>) {
        homeSliderAdapter = HomeSliderAdapter(list) { carousalItem ->
            showBottomToastMessage(carousalItem.movieGenre!!, getBinding().root)
        }
        getBinding().vpCarousal.apply {
            adapter = homeSliderAdapter
            clipToPadding = false
            clipChildren = false
            offscreenPageLimit = 3
            getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        }

        setupPagerIndicatorDots(0, list.size)
        onPageChangeCallback(getBinding().vpCarousal)
        onViewpagerTransformer(getBinding().vpCarousal)

        getMovieListForGenre()


    }

    private fun onViewpagerTransformer(vpCarousel: ViewPager2) {
        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer((40 * Resources.getSystem().displayMetrics.density).toInt()))
        compositePageTransformer.addTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = 0.85f + r * 0.15f
        }

        vpCarousel.setPageTransformer(compositePageTransformer)
    }

    private fun onPageChangeCallback(
        vpCarousel: ViewPager2
    ) {
        vpCarousel.registerOnPageChangeCallback(object : OnPageChangeCallback() {

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                getMovieListForGenre()
                setupPagerIndicatorDots(position, homeSliderAdapter.getCarouselList().size)
            }

        })
    }

    private fun getMovieListForGenre() {
        getViewModel().getMovieListByGenre(MovieUseCaseRequest(getBinding().vpCarousal.currentItem))
    }

    private lateinit var dots: Array<ImageView?>
    private fun setupPagerIndicatorDots(mPosition: Int, dotsCount: Int) {
        dots = arrayOfNulls(dotsCount)
        if (dots.isNotEmpty()) {
            getBinding().lyPageIndicator.removeAllViews()
        }
        for (i in 0 until dotsCount) {
            dots[i] = ImageView(this)
            if (i == mPosition) {
                dots[i]?.setImageDrawable(
                    ContextCompat.getDrawable(
                        this,
                        R.drawable.item_selected
                    )
                )
            } else {
                dots[i]?.setImageDrawable(
                    ContextCompat.getDrawable(
                        this,
                        R.drawable.item_unselected
                    )
                )
            }

            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(
                resources.getDimension(R.dimen.padding_5dp).roundToInt(),
                resources.getDimension(R.dimen.zero_dp).toInt(),
                resources.getDimension(R.dimen.padding_5dp).roundToInt(),
                resources.getDimension(R.dimen.zero_dp).toInt()
            )
            dots[i]?.layoutParams = params
            getBinding().lyPageIndicator.addView(dots[i])
        }
    }

}