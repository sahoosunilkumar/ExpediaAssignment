package com.expedia.assignment.search.view

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.view.View
import android.view.animation.Animation
import com.expedia.assignment.R
import com.expedia.assignment.common.BaseFragment
import com.expedia.assignment.common.adapter.DatabindingAdapter
import com.expedia.assignment.common.utils.ResponseUtils
import com.expedia.assignment.databinding.FragmentSearchBinding
import com.expedia.assignment.networking.model.IResponse
import com.expedia.assignment.search.model.SearchResponse
import com.expedia.assignment.search.model.Venue
import com.expedia.assignment.search.viewmodel.SearchViewModel
import javax.inject.Inject


class SearchFragment : BaseFragment<SearchViewModel, FragmentSearchBinding>(), Observer<IResponse<SearchResponse>>, View.OnClickListener {
    override fun onClick(v: View?) {
        viewModel.execute(dataBinding.searchET.text.toString())
    }

    override fun getViewModel(): Class<SearchViewModel> {
        return SearchViewModel::class.java
    }

    override fun getLayoutRes(): Int {
        return R.layout.fragment_search
    }

    @Inject
    lateinit var adapter: DatabindingAdapter<Venue>
    @Inject
    lateinit var divider: DividerItemDecoration

    @Inject
    lateinit var slideUpAnimation: Animation

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(savedInstanceState)
    }

    private fun init(savedInstanceState: Bundle?) {
        dataBinding.successLayout.recyclerView.adapter = adapter
        dataBinding.errorLayout.retryBtn.setOnClickListener(this)
        viewModel.apiResponse.observe(this, this)
        dataBinding.successLayout.recyclerView.addItemDecoration(divider)
        dataBinding.searchBtn.setOnClickListener (this)

    }

    override fun onChanged(response: IResponse<SearchResponse>?) {
        dataBinding.viewModel = viewModel
        if (ResponseUtils.isSuccess(response)) {
            response?.data?.response?.venues?.let {
                adapter.addItems(it)
                dataBinding.successLayout.recyclerView.startAnimation(slideUpAnimation)
            }
        }
    }
}
