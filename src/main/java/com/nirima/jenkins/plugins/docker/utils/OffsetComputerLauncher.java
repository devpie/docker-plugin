package com.nirima.jenkins.plugins.docker.utils;

import hudson.model.TaskListener;
import hudson.slaves.ComputerLauncher;
import hudson.slaves.DelegatingComputerLauncher;
import hudson.slaves.SlaveComputer;

import java.io.IOException;

public class OffsetComputerLauncher extends DelegatingComputerLauncher {

	/**
	 * time (ms) to back off before launching
	 */
	private final int pause;

	public OffsetComputerLauncher(ComputerLauncher delegate, final int pause) {
		super(delegate);
		this.pause = pause;
	}

	@Override
	public void launch(SlaveComputer computer, TaskListener listener)
			throws IOException, InterruptedException {
		Thread.sleep(pause * 1000);
		super.launch(computer, listener);
	}
}
