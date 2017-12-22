package com.lx.kotlin.reader.activity

import android.os.Bundle
import com.lx.kotlin.reader.R
import com.lx.kotlin.reader.adapter.FragmentAdapter
import com.lx.kotlin.reader.fragment.BaseFragment
import com.lx.kotlin.reader.fragment.DoubanFragment
import com.lx.kotlin.reader.fragment.ImageFragment
import com.lx.kotlin.reader.fragment.ZhihuFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    var pageList: MutableList<BaseFragment> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    fun initView() {
        toolbar.setTitle(R.string.app_name)
        pageList.clear()

        var zhihu = ZhihuFragment()
        var zhihuBundle = Bundle()
        zhihuBundle.putString("title", "知乎日报")
        zhihu.arguments = zhihuBundle
        pageList.add(zhihu)

        var one = DoubanFragment()
        var oneBundle = Bundle()
        oneBundle.putString("title", "豆瓣")
        one.arguments = oneBundle
        pageList.add(one)

        var image = ImageFragment()
        var imageBundle = Bundle()
        imageBundle.putString("title", "美图")
        image.arguments = imageBundle
        pageList.add(image)
        viewPager.adapter = FragmentAdapter(pageList, supportFragmentManager)
        tabLayout.setupWithViewPager(viewPager)
    }

}
