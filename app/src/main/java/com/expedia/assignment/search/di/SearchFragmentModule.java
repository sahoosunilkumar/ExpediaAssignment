package com.expedia.assignment.search.di;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.expedia.assignment.BR;
import com.expedia.assignment.R;
import com.expedia.assignment.common.adapter.DatabindingAdapter;
import com.expedia.assignment.common.adapter.impl.AdapterDelegate;
import com.expedia.assignment.search.model.Venue;
import com.expedia.assignment.search.view.SearchFragment;
import com.expedia.assignment.search.viewmodel.SearchViewModel;

import dagger.Module;
import dagger.Provides;

import static android.support.v7.widget.DividerItemDecoration.VERTICAL;


@Module
public class SearchFragmentModule {

    @Provides
    AdapterDelegate<Venue> providesAdapterDelegate() {
        return new AdapterDelegate<>(Venue.class, R.layout.item_search_list, BR.forecastItem);
    }


    @Provides
    DatabindingAdapter<Venue> providesAdpter(AdapterDelegate<Venue> delegate, SearchViewModel viewModel) {
        delegate.addVariable(BR.viewModel, viewModel);
        return new DatabindingAdapter<>(delegate);
    }

    @Provides
    Context providesContext(SearchFragment context) {
        return context.getContext();
    }

    @Provides
    DividerItemDecoration providesDivider(Context context) {
        DividerItemDecoration divider = new DividerItemDecoration(context, VERTICAL);
        Drawable drawable = ContextCompat.getDrawable(context, R.drawable.divider);
        if (drawable != null) {
            divider.setDrawable(drawable);
        }
        return divider;
    }

    @Provides
    Animation providesSlideUpAnimation(Context context) {
        return AnimationUtils.loadAnimation(context, R.anim.slide_up);
    }

}
