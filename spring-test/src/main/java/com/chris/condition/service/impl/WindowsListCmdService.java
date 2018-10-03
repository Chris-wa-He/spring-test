package com.chris.condition.service.impl;

import com.chris.condition.service.ListCmdService;

public class WindowsListCmdService implements ListCmdService {

	@Override
	public String showListCmd() {
		return "dir";
	}

}
