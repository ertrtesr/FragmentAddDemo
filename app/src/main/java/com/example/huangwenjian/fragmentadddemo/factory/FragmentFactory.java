package com.example.huangwenjian.fragmentadddemo.factory;

import android.support.v4.app.Fragment;
import android.support.v4.util.SparseArrayCompat;

import com.example.huangwenjian.fragmentadddemo.fragments.FirstFragment;
import com.example.huangwenjian.fragmentadddemo.fragments.SecondFragment;
import com.example.huangwenjian.fragmentadddemo.fragments.ThirdFragment;

/**
 * @author  Administrator
 * @time 	2015-7-15 下午3:07:05
 * @des	Fragment工厂类
 *
 * @version $Rev: 9 $
 * @updateAuthor $Author: admin $
 * @updateDate $Date: 2015-07-15 17:31:13 +0800 (星期三, 15 七月 2015) $
 * @updateDes TODO
 */
public class FragmentFactory {
	static SparseArrayCompat<Fragment>	cachesFragment		= new SparseArrayCompat<Fragment>();

	public static Fragment getFragment(int position) {

		Fragment fragment = null;
		// 如果缓存里面有对应的fragment,就直接取出返回

		Fragment tmpFragment = cachesFragment.get(position);
		if (tmpFragment != null) {
			fragment = tmpFragment;
			return fragment;
		}
		switch (position) {
		case 0:
			fragment = new FirstFragment();
			break;
		case 1:
			fragment = new SecondFragment();
			break;
		case 2:
			fragment = new ThirdFragment();
			break;
		default:
			break;
		}
		// 保存对应的fragment
		cachesFragment.put(position, fragment);
		return fragment;
	}


}
