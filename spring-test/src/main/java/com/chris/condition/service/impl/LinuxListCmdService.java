package com.chris.condition.service.impl;

import com.chris.condition.service.ListCmdService;

public class LinuxListCmdService implements ListCmdService {

	@Override
	public String showListCmd() {
		return "ls";
	}

}
