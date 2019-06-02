package by.gomel.marseille.feature.about.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import by.gomel.marseille.core.base.view.BaseFragment
import by.gomel.marseille.feature.about.R
import by.gomel.marseille.feature.about.presentation.contacts.ContactsFragment
import by.gomel.marseille.feature.about.presentation.history.HistoryFragment
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedState: Bundle?): View?
        = inflater.inflate(R.layout.fragment_detail, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        detail_view_pager.adapter = TabAdapter(childFragmentManager)
        detail_tab_layout.setupWithViewPager(detail_view_pager)
    }

}

private class TabAdapter(
        fragmentManager: FragmentManager
) : FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment
        = if (position == 0) ContactsFragment.newInstance() else HistoryFragment.newInstance()

    override fun getPageTitle(position: Int): CharSequence?
        = if (position == 0) "Контакты" else "История"

    override fun getCount(): Int = 2

}