package com.mochou123.app.nowarry.base;

import android.support.v4.app.Fragment;

public abstract class BaseFragment extends Fragment implements ITitle {

	@Override
	public abstract String getTitle();

}
