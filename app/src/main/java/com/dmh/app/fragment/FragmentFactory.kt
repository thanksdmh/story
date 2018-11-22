package com.dmh.app.fragment

import android.support.v4.app.Fragment

/**
 *@name deng
 *@date 2018/10/30 0030.
 */
class FragmentFactory {
    companion object {
        fun getHomeFragments(): ArrayList<Fragment> {
            var fragments = ArrayList<Fragment>()
            //幽默
            fragments.add(StoryListFragment())
            var storyListFragment = StoryListFragment()
            storyListFragment.mtype = 1
            //冷笑话
            fragments.add(storyListFragment)
            return fragments
        }

        fun getAuthorFragments(): ArrayList<Fragment> {
            var fragments = ArrayList<Fragment>()
            //幽默
            fragments.add(AuthorListFragment())
            var fragment = AuthorListFragment()
            fragment.mtype = 1
            //冷笑话
            fragments.add(fragment)
            return fragments
        }
    }
}