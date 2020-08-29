package org.fooshtech.musicapplication.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import org.fooshtech.musicapplication.fragments.ClassicFragment
import org.fooshtech.musicapplication.fragments.PopFragment
import org.fooshtech.musicapplication.fragments.RockFragment

 class MyPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getCount(): Int {
        return 3
    }


    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 ->
                RockFragment()

            1 ->
                ClassicFragment()

            else -> PopFragment()
        }

    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position){
            0-> "Rock"
            1-> "Classic"
            else -> "Pop"
        }
    }
}
