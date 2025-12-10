package com.devsphere.assingment2

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabsAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = 3 // Four tabs

    override fun createFragment(position: Int): Fragment {
        return when (position) {

            0 -> HomeFragment()

            1 -> ExploreFragment()

            2 -> ProfileFragment()

            else -> HomeFragment()
        }
    }
}
